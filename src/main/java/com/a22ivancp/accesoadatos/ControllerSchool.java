package com.a22ivancp.accesoadatos;

import com.a22ivancp.accesoadatos.model.dao.DAODirection;
import com.a22ivancp.accesoadatos.model.dao.DAOSchool;
import com.a22ivancp.accesoadatos.model.dao.DAOStudent;
import com.a22ivancp.accesoadatos.model.dto.DTO;
import com.a22ivancp.accesoadatos.model.entities.Direction;
import com.a22ivancp.accesoadatos.model.entities.Gender;
import com.a22ivancp.accesoadatos.model.entities.School;
import com.a22ivancp.accesoadatos.model.entities.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ControllerSchool implements Initializable, IControllerObjects {

    @FXML
    private TextField name;
    @FXML
    private TextField director;
    @FXML
    private TextField url;
    @FXML
    private TextField gmail;
    @FXML
    private TextField phone;
    @FXML
    private TextField country;
    @FXML
    private TextField province;
    @FXML
    private TextField city;
    @FXML
    private TextField street;
    @FXML
    private TextField cp;
    @FXML
    private ListView listTitles;
    @FXML
    private ListView listStudents;
    private School school;
    private DAOSchool dao = new DAOSchool();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void setData(DTO dto) {

        if (dto.getId()==null) {
            school= new School();
        } else {

            school = dao.getByID(dto.getId());

            name.setText(school.getName());
            director.setText(school.getDirector());
            url.setText(school.getUrlSchool());
            gmail.setText(school.getGmail());
            phone.setText(school.getMobilePhoneNumber().toString());
            if (school.getDirection() != null) {
                country.setText(school.getDirection().getCountry());
                province.setText(school.getDirection().getProvince());
                city.setText(school.getDirection().getCity());
                street.setText(school.getDirection().getStreet());
                cp.setText(school.getDirection().getDoor());
            }

            listTitles.setItems(dao.getAllTitles(school));
            listStudents.setItems(dao.getAllStudents(school));
        }
    }
    public void procesarResultado(){
        School sc = school;
        sc.setName(name.getText());
        sc.setDirector(director.getText());
        sc.setUrlSchool(url.getText());
        sc.setGmail(gmail.getText());
        sc.setMobilePhoneNumber(Integer.parseInt(phone.getText()));
        if (sc.getDirection()==null) {
            Direction d = new Direction();
            DAODirection daoDirection = new DAODirection();
            daoDirection.addElement(d);
            for (Direction direction : daoDirection.getAll())
                if (direction.getCountry()==null){
                    d = direction;
                    break;
                }
            sc.setDirection(d);
        }
        sc.getDirection().setCountry(country.getText());
        sc.getDirection().setProvince(province.getText());
        sc.getDirection().setCity(city.getText());
        sc.getDirection().setStreet(street.getText());
        sc.getDirection().setCp(Integer.parseInt(cp.getText()));
        if (school.getIdSchool()==null)
            dao.addElement(sc);
        else
            dao.updateElement(sc);
    }
}