package com.a22ivancp.accesoadatos;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import jakarta.persistence.EntityManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("user_info.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
//        stage.setTitle("USER_INFO");
//        stage.setScene(scene);
//        stage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("start_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 300);
        stage.setTitle("INICIO");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //EntityManager em = JPAUtils.getEntityManager();
        launch();
    }
}