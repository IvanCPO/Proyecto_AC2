package com.a22ivancp.accesoadatos;

import com.a22ivancp.accesoadatos.model.dao.DAOSchool;
import com.a22ivancp.accesoadatos.model.dao.DAOTitle;
import com.a22ivancp.accesoadatos.model.dto.DTO;
import com.a22ivancp.accesoadatos.model.entities.School;
import com.a22ivancp.accesoadatos.model.entities.Title;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTitle implements Initializable, IControllerObjects {

    @FXML
    private TextField name;
    @FXML
    private TextField abbreviation;
    @FXML
    private TextField duration;
    @FXML
    private ListView listSubject;
    private Title title;
    private DAOTitle dao = new DAOTitle();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void setData(DTO dto) {

        if (dto.getId()==null) {
            title = new Title();
        } else {
            title = dao.getByID(dto.getId());

            name.setText(title.getName());
            abbreviation.setText(title.getAbbreviation());
            duration.setText(title.getDuration().toString());


            listSubject.setItems(dao.getAllCourses(title));
        }
    }

    @Override
    public void procesarResultado() {
        Title t = title;
        t.setName(name.getText());
        t.setAbbreviation(abbreviation.getText());
        t.setDuration(Integer.parseInt(duration.getText()));
        if (title.getIdTitle() == null)
            dao.addElement(t);
        else
            dao.updateElement(t);

    }
}