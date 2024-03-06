module com.a22ivancp.accesoadatos {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;

    requires org.hibernate.orm.core;

    opens com.a22ivancp.accesoadatos.model.entities to org.hibernate.orm.core;


    opens com.a22ivancp.accesoadatos to javafx.fxml;
    exports com.a22ivancp.accesoadatos;
}