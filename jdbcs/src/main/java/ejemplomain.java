import  java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ejemplomain {
    //ejemplo de coencion a base de datos
    /*
    public static void main(String[] args) {
        Connection conexion = null;
        String jdbc ="jdbc:mysql://localhost:3306/alumnos";
        try {
            //logica de base de datos
            conexion = DriverManager.getConnection(jdbc,"root","1234");
            System.out.println("coneccion a base de datos");

        }catch (SQLException e){
            //trata la exepcion
            e.printStackTrace();
        }
    }


     */

    private Connection conexion = null;
    public ejemplomain() throws SQLException{
        try{
            conecta();
            consulta();
        }finally {
            {
                cerrar();

            }
        }
    }
    public void conecta() throws SQLException{
        String jdbc ="jdbc:mysql://localhost:3306/alumnos";
        conexion = DriverManager.getConnection(jdbc,"root","1234");

    }
    public void consulta() throws SQLException{
        //objeto stantement crea sentencias para sql  y devuleve un objeto statemt ese se usa para usar sentencias
        Statement statement = conexion.createStatement();
        //sentencia sql
        ResultSet set = statement.executeQuery("select id_alumno,nombre,apellido from alumno");
        //hay que iterar todas las lineas en las que se hacen la consulta
        //set.next es un objeto como todo objeto se puede interar
        while (set.next()){
            //hay que decirle a java que cada objeto y tipo de dato de que tipo y convertir de una u otra forma
            int id_alumno = set.getInt("id_alumno");
            String nombre = set.getString("nombre");
            String apellidos = set.getString("apellido");
            System.out.println("Alumno: "+id_alumno+" Nombre: "+nombre+" Apellido: "+apellidos);
        //siempre hay que cerrar la consulta o la conecion a base de datos tambien de la conexion creada por el bojeto
            //statement para liberar memoria y acelerar la siguiente coneccion
        }set.close();
        statement.close();
    }
    public void cerrar() throws SQLException{
        if(conexion != null){
            conexion.close();
        }
    }
    private static final Logger log = Logger.getLogger(String.valueOf(ejemplomain.class));

    public static void main(String[] args) {
        try {
                new ejemplomain();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    }
