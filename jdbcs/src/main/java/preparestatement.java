import java.sql.*;
import java.util.logging.Logger;

public class preparestatement {
    private Connection conexion = null;
    public preparestatement() throws SQLException {
        try{
            conecta();
            consulta("Lopez" );
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
    public void consulta(String apellido) throws SQLException{
        String query = "select id_alumno, nombre, apellido from alumno where apellido = ?" ;
        //para consultas mas personalizadas se tiene que preaprar statatement con preaparedstatement y se le tiene
        //que dar como parametrouna instruccion sql,para la consulta personalizada se tine que cambiar el ?
        //por algun metodo de java ya definido con la instruccion "set" Setstring,setint etc
       PreparedStatement statement = conexion.prepareStatement(query);
       //el parameter index representa el numero de instruccion por procesar se puede agregar mas instrucciones representado por el ?
        //y se pondra dela misma manera pero el nidex sera '2'
       statement.setString(1,apellido);
        //sentencia sql a ejecutar sin dar parametro
        ResultSet set = statement.executeQuery();
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
            new preparestatement();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}


