package com.a22ivancp.accesoadatos;

import com.a22ivancp.accesoadatos.model.JPAUtils;
import com.a22ivancp.accesoadatos.model.dao.DAO;
import com.a22ivancp.accesoadatos.model.dao.DAOStudent;
import com.a22ivancp.accesoadatos.model.entities.School;
import com.a22ivancp.accesoadatos.model.entities.Student;
import com.a22ivancp.accesoadatos.model.entities.Title;
import jakarta.persistence.EntityManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("user_info.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
//        stage.setTitle("USER_INFO");
//        stage.setScene(scene);
//        stage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("start_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 300);
        stage.setTitle("INICIO");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        EntityManager em = JPAUtils.getEntityManager();
//        List<School> schools = em.createQuery("select s from School s",School.class).getResultList();
//        for ( School school : schools){
//            System.out.println("\n"+school.getName());
//            for(Title title : school.getTitles())
//                System.out.println(title.getName());
//        }

        launch();
    }
}