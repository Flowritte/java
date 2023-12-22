package bd;
import java.sql.*;

public class conectar {
    private Connection conexion = null;

    public void badatabase() throws SQLException {

        try {
            conecta();
        } finally {
            cerra();
        }
    }

    public void conecta() throws SQLException{
        String jdbc = "jdbc:mysql://localhost:3306/banco";
        conexion = DriverManager.getConnection(jdbc,"root","1234");
        System.out.println("conexion abierta");

    }

    public void insertar_cuenta(String numero_cuenta_creado, String nombre, String telefono, String no_documento
    , String agencia,double saldo) throws SQLException {

        String insert_cuenta = "INSERT INTO cuentas(id_cuenta,Nombre,telefono,No_documento,Agencia,Saldo) " +
                "VALUES (?,?,?,?,?,?)";
        PreparedStatement st = conexion.prepareStatement(insert_cuenta);
        st.setString(1,numero_cuenta_creado);
        st.setString(2,nombre);
        st.setString(3,telefono);
        st.setString(4,no_documento);
        st.setInt(5, Integer.parseInt(agencia));
        st.setDouble(6,saldo);
        st.executeUpdate();
        st.close();


    }
    public void consulta(String idcuenta) throws SQLException{
        String consuta = "SELECT id_cuenta,nombre,agencia,saldo from cuenta where id_cuenta = ?";
        PreparedStatement bd = conexion.prepareStatement(consuta);
        bd.setString(1,idcuenta);
        ResultSet set = bd.executeQuery(consuta);


    }
    public void cerra() throws SQLException{
        if(conexion != null){
            conexion.close();
            System.out.println("Conecxion cerrada");

        }
    }
}

