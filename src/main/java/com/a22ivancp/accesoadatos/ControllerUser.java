package com.a22ivancp.accesoadatos;

import com.a22ivancp.accesoadatos.model.dao.DAOStudent;
import com.a22ivancp.accesoadatos.model.dto.DTO;
import com.a22ivancp.accesoadatos.model.dto.DTOUserTitle;
import com.a22ivancp.accesoadatos.model.entities.Gender;
import com.a22ivancp.accesoadatos.model.entities.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ControllerUser implements Initializable , IControllerObjects{

    @FXML
    private ImageView pictureUser;
    @FXML
    private TextField textName;
    @FXML
    private TextField textSurname;
    @FXML
    private DatePicker dateBirth;
    @FXML
    private ComboBox<Gender> genderOption;
    @FXML
    private TextField textDNI;
    @FXML
    private TextField textGmail;
    @FXML
    private TextField textPhone;
    @FXML
    private TextField country;
    @FXML
    private TextField province;
    @FXML
    private TextField city;
    @FXML
    private TextField street;
    @FXML
    private TextField door;
    @FXML
    private ListView<DTOUserTitle> listTitles;

    private Student student;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(getClass().getResourceAsStream("/images/user.png"));
        pictureUser.setImage(image);
    }

    @Override
    public void setData(DTO dto) {
        if (dto.getId()==null) {
            student= new Student();
        } else {
            DAOStudent dao = new DAOStudent();
            student = dao.getByID(dto.getId());
            Image image;
            if (student.getPicture() == null)
                image = new Image(getClass().getResourceAsStream("/images/user.png"));
            else
                image = new Image(new ByteArrayInputStream(student.getPicture()));
            pictureUser.setImage(image);
            textName.setText(student.getName());
            textSurname.setText(student.getSurname());
            dateBirth.editorProperty().getValue().setText(student.getDateNac().format(DateTimeFormatter.ofPattern("d/M/yyyy")));
            genderOption.getItems().addAll(Gender.FEMALE, Gender.MALE, Gender.NO_BINARY);
            genderOption.getSelectionModel().select(student.getGender());
            textDNI.setText(student.getDni());
            textGmail.setText(student.getGmail());
            textPhone.setText(student.getNumber().toString());
            if (student.getDirection() != null) {
                country.setText(student.getDirection().getCountry());
                province.setText(student.getDirection().getProvince());
                city.setText(student.getDirection().getCity());
                street.setText(student.getDirection().getStreet());
                door.setText(student.getDirection().getDoor());
            }

            listTitles.setItems(dao.getAllDTOUserTitles(student));
        }
    }
}