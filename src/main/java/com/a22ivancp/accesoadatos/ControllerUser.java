package com.a22ivancp.accesoadatos;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUser implements Initializable {
    @FXML
    private ImageView pictureUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(getClass().getResourceAsStream("/images/user.png"));
        pictureUser.setImage(image);
    }
}