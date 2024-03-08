package com.a22ivancp.accesoadatos;

import com.a22ivancp.accesoadatos.model.dto.DTOSchool;
import com.a22ivancp.accesoadatos.model.dto.DTOStudent;
import com.a22ivancp.accesoadatos.model.entities.Gender;
import com.a22ivancp.accesoadatos.model.entities.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView tableStudent;
    @FXML
    private ListView listTitle;
    @FXML
    private TableView tableSchool;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateModelTStudent();
        generateModelTSchool();
    }

    private void generateModelTStudent() {
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
    }
    private void generateModelTSchool() {
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
    }
}