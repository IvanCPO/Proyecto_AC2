## PROYECTO AC

Este proyecto fue pensado con la idea de almacenar el curriculum estudiantil de un grupos de alumnos. Cada alumno habria hecho x titulos en y centros y los tendria todo registrado en un bbdd.

Para ello genere una propia bbdd, en la que tuve que generar los datos, y la estructura y tablas. Use una base de datos h2 version 2.2.224 y para la vista use javafx.

Tengo almacenado en carpetas diferentes todos los elementos que necesito dentro de modelo, como son las entidades, los dto y los dao. A parte uso los archivo fxml para la preparacion de la pagina.

El proyecto en si para ejecutarlo solo se necesita ejecutar el main de App y todo tomara su curso. Todos los datos que utilizo estan metidos en el proyecto y se acceden a ellos desde rutas relativas.

Lo que se podra ver el programa es una interfaz para acceder a diferentes entidades de la bbdd: Estudiantes, Escuelas y titulos. En cada una se puede realizar lo mismo. Añadir, editar o eliminar uno de estos objetos y en el momento de editar nos saltara otra ventana distinta para generar ese objeto. No tiene mucho mas. Se muestra toda la informacion necesaria.

Los datos si se requieren recargar de nuevo, estan colocados en una carpeta con scripts de inserciones (SQL/...). La bb de datos esta en (DB/...).

## USO

Su uso es bastante intuitivo. Tu te deslizas entre los tres tabs y cuando quieras editar una de las opciones solo hacemos chick en el y le damos al boton de editar, y lo mismo si queremos eliminar. En todos los tab los botones hacen lo mismo.

Si le das a nuevo se generara un nuevo registro en el momento en el que tu generes los datos y que le des a aceptar y se editaran de la misma manera, cuando le des a aceptar. En caso de no darle todos esos cambios que intentaste poner serán olvidados.

## URL PROYECTO GITHUB
https://github.com/IvanCPO/Proyecto_AC2