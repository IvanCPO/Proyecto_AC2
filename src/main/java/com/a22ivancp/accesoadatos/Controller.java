package com.a22ivancp.accesoadatos;

import com.a22ivancp.accesoadatos.model.dao.DAO;
import com.a22ivancp.accesoadatos.model.dao.DAOSchool;
import com.a22ivancp.accesoadatos.model.dao.DAOStudent;
import com.a22ivancp.accesoadatos.model.dao.DAOTitle;
import com.a22ivancp.accesoadatos.model.dto.DTO;
import com.a22ivancp.accesoadatos.model.dto.DTOSchool;
import com.a22ivancp.accesoadatos.model.dto.DTOStudent;
import com.a22ivancp.accesoadatos.model.dto.DTOTitle;
import com.a22ivancp.accesoadatos.model.entities.Gender;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private TableView tableStudent;
    @FXML
    private BorderPane mainPanel;
    @FXML
    private ListView listTitle;
    @FXML
    private TableView tableSchool;
    @FXML
    private TabPane tabObjects;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateTStudent();
        generateTSchool();
        generateListTitles();

    }
    private void generateTStudent() {
        TableColumn<DTOStudent,String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<DTOStudent,String> surname = new TableColumn<>("Surname");
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<DTOStudent, Gender> gender = new TableColumn<>("Gender");
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<DTOStudent,String> dni = new TableColumn<>("DNI");
        dni.setCellValueFactory(new PropertyValueFactory<>("dni"));

        TableColumn<DTOStudent, String> gmail = new TableColumn<>("Mail");
        gmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));

        TableColumn<DTOStudent, Integer> number = new TableColumn<>("Number");
        number.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<DTOStudent, LocalDate> date = new TableColumn<>("Fech Nac");
        date.setCellValueFactory(new PropertyValueFactory<>("dateNac"));

        tableStudent.getColumns().add(name);
        tableStudent.getColumns().add(surname);
        tableStudent.getColumns().add(gender);
        tableStudent.getColumns().add(dni);
        tableStudent.getColumns().add(gmail);
        tableStudent.getColumns().add(number);
        tableStudent.getColumns().add(date);

        DAOStudent daoStudent = new DAOStudent();
        tableStudent.setItems(daoStudent.getAllDTOStudents());
        tableStudent.getSelectionModel().selectFirst();
    }
    private void generateTSchool() {
        TableColumn<DTOSchool,String> name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<DTOSchool,String> director = new TableColumn<>("Director");
        director.setCellValueFactory(new PropertyValueFactory<>("director"));

        TableColumn<DTOSchool, String> url = new TableColumn<>("URL");
        url.setCellValueFactory(new PropertyValueFactory<>("urlSchool"));

        TableColumn<DTOSchool, String> gmail = new TableColumn<>("Mail");
        gmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));

        TableColumn<DTOSchool, Integer> number = new TableColumn<>("Number");
        number.setCellValueFactory(new PropertyValueFactory<>("mobilePhoneNumber"));

        tableSchool.getColumns().add(name);
        tableSchool.getColumns().add(director);
        tableSchool.getColumns().add(url);
        tableSchool.getColumns().add(gmail);
        tableSchool.getColumns().add(number);


        DAOSchool daoSchool = new DAOSchool();
        tableSchool.setItems(daoSchool.getAllDTOSchool());
        tableSchool.getSelectionModel().selectFirst();
    }
    private void generateListTitles(){
        DAOTitle dao = new DAOTitle();
        ObservableList<DTOTitle> titles = dao.getAllDTOTitles();
        listTitle.setItems(titles);
        listTitle.getSelectionModel().selectFirst();
    }
    @FXML
    public void buttonPress(ActionEvent actionEvent){
        Button button= (Button) actionEvent.getSource();
        DAO dao;
        DTO dto;
        switch (button.getText()){
            case "Add":
                System.out.println("Has pulsado ADD");
                dto = generateEmptyDTO();
                mostrarDialog("Añadir",dto);
                break;
            case "Edit":
                System.out.println("Has pulsado EDIT");
                dto = getChangeValue();
                System.out.println(dto);
                mostrarDialog("Editar",dto);
                break;
            case "Remove":
                System.out.println("Has pulsado REMOVE");
                dto = getChangeValue();
                Alert alert = new Alert(Alert.AlertType.WARNING,"Estas seguro que quieres eliminarlo?",ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> res = alert.showAndWait();
                dao= getDao(dto);
                if (res.isPresent() && res.get()==ButtonType.YES)
                    dao.removeByID(dto.getId());
                break;
        }
    }
    private DTO generateEmptyDTO() {
        return switch (tabObjects.getSelectionModel().getSelectedItem().getText()) {
            case "Estudiantes" -> new DTOStudent();
            case "Escuelas" -> new DTOSchool();
            case "Titulos" -> new DTOTitle();
            default -> null;
        };
    }
    private DTO getChangeValue() {
        switch (tabObjects.getSelectionModel().getSelectedItem().getText()){
            case "Estudiantes":
                System.out.println("Funciona Soldados");
                return (DTOStudent) tableStudent.getSelectionModel().getSelectedItem();
            case "Escuelas":
                System.out.println("Funciona carcel");
                return (DTOSchool) tableSchool.getSelectionModel().getSelectedItem();
            case "Titulos":
                System.out.println("Funciona tttt");
                return (DTOTitle) listTitle.getSelectionModel().getSelectedItem();
            default: return null;
        }
    }

    private DAO getDao(DTO dto) {
        if (dto.getClass() == DTOSchool.class)
            return new DAOSchool();
        if (dto.getClass() == DTOStudent.class)
            return new DAOStudent();
        else
            return new DAOTitle();
    }

    private void mostrarDialog(String title, DTO dto) {
        Dialog<ButtonType> dialog = new Dialog<>();


        // por defecto, un diálogo é modal
        // polo que non permitirá interaccionar con outras ventá
        dialog.initOwner(mainPanel.getScene().getWindow());

        // engade o código para establecer o título “Engadir nova tarefa” ao diálogo
        dialog.setTitle(title);
        FXMLLoader fxmlLoader = new FXMLLoader();
        if (dto.getClass().equals(DTOStudent.class))
            fxmlLoader.setLocation(getClass().getResource("user_info.fxml"));
        if (dto.getClass().equals(DTOSchool.class))
            fxmlLoader.setLocation(getClass().getResource("school_info.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Non se puido cargar o diálogo");
            e.printStackTrace();
            return;
        }

        // engadir os botóns
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        IControllerObjects controller = fxmlLoader.getController();
        if (dto!=null){
            controller.setData(dto);
        }

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("OKAY pressed");
//            DTO object = controller.procesarResultado();
//            if (object!=null)
//            listViewTarea.getSelectionModel().select(tarefa);
        } else {
            System.out.println("Cancel pressed");
        }
    }

    @FXML
    public void closeApp(ActionEvent actionEvent) {
        System.exit(0);
    }
}