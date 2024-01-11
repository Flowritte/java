package bd;
import java.sql.*;

public class conectar {
    private Connection conexion = null;
    private Connection conexion_transaccion = null;


    public void conecta() throws SQLException{
        //apertuda de conexion a bd
        String jdbc = "jdbc:mysql://localhost:3306/banco";
        conexion = DriverManager.getConnection(jdbc,"root","1234");
        System.out.println("conexion abierta");

    }

    public void insertar_cuenta(String numero_cuenta_creado, String Nombre, String telefono, int No_documento
    , String agencia,double Saldo) throws SQLException {
        //Creacion de cuentas

        String insert_cuenta = "INSERT INTO cuentas(id_cuenta,Nombre,telefono,No_documento,Agencia,Saldo) VALUES (?,?,?,?,?,?)";
        PreparedStatement st = conexion.prepareStatement(insert_cuenta);
        st.setString(1,numero_cuenta_creado);
        st.setString(2,Nombre);
        st.setString(3,telefono);
        st.setInt(4,No_documento);
        st.setInt(5, Integer.parseInt(agencia));
        st.setDouble(6,Saldo);
        st.executeUpdate();
        st.close();

    }

    public void consulta(int idcuenta) throws SQLException{
        //consulta para obtencio de datos
        String consuta = "SELECT * from cuentas where id_cuenta = ?";
        PreparedStatement bd = conexion.prepareStatement(consuta);
        bd.setInt(1,idcuenta);
        ResultSet set = bd.executeQuery();
        set.next();
        int id_cuenta = set.getInt("id_cuenta");
        String nombre = set.getString("Nombre");
        String agencia = set.getString("Agencia");
        double saldo = set.getDouble("Saldo");
        String telefono = set.getString("telefono");
        int doc = set.getInt("No_documento");

        System.out.println("La cuenta Tiene los datos:");
        System.out.println("Id Cuenta unico: " + id_cuenta);
        System.out.println("Nombre completo: " + nombre);
        System.out.println("El telefono asociado es: " +telefono);
        System.out.println("Fue Creada en la agencia no: " + agencia);
        System.out.println("El cliente "+ nombre + ",llevo el documento registrado internamente con el numero : "+ doc);
        System.out.println("La cuenta tiene un saldo de: " +saldo);

    }

    public double consulta_id(int idcuenta) throws SQLException {
        //obtencion de saldo por busqueda de idcuenta
        String consuta = "SELECT Nombre,Saldo from cuentas where id_cuenta = ?";
        PreparedStatement bd = conexion.prepareStatement(consuta);
        bd.setInt(1, idcuenta);
        ResultSet set = bd.executeQuery();
        set.next();
        double saldo = set.getDouble("Saldo");
        System.out.println("El saldo es de: " +saldo);
        return saldo;
    }

    public  void consulta_inserta_unica(String nombre ,double saldo) throws SQLException{
        //busqueda por nombre completo
        //usado para metodo de creacion de cuenta ahorro
        String uniqe = "select id_cuenta from cuentas where Nombre = ? ";
        PreparedStatement st = conexion.prepareStatement(uniqe);
        st.setString(1,nombre);
        ResultSet rs = st.executeQuery();
        //next lee los datos de las columnas a buscar
        rs.next();
        //rescata y obtiene el o los datos a obtener
        int idcuenta = rs.getInt("id_cuenta");
        System.out.println("Su cuenta esta vinclulada al numero de cuenta: " +idcuenta);
        //mover los datos

        String insert_uniqe = "insert into cuenta_ahorro (id_cuenta,nombre,Saldo) values (?,?,?)";
        PreparedStatement sts = conexion.prepareStatement(insert_uniqe);
        sts.setInt(1,idcuenta);
        sts.setString(2,nombre);
        sts.setDouble(3,saldo);
        sts.executeUpdate();

        rs.close();
        System.out.println("Conexion cerrada!");
    }

    public boolean consulta_inserta_depocita( int idcuenta,double saldo) throws  SQLException{
        //busqueda por id cuenta
        //metodo para depocitar
        try {
           String uniqe = "select Nombre from cuentas where id_cuenta = ? ";
           PreparedStatement st = conexion.prepareStatement(uniqe);
           st.setInt(1, idcuenta);
           ResultSet rs = st.executeQuery();
           rs.next();
           String id_nombre = rs.getString("Nombre");
           System.out.println("La Cuenta a depocitar es de: " + id_nombre);
           //revision de datos
           String insert_uniqe = "UPDATE cuentas SET Saldo = ? WHERE id_cuenta = ?";
           PreparedStatement sts = conexion.prepareStatement(insert_uniqe);
           sts.setDouble(1, saldo);
           sts.setInt(2, idcuenta);
           sts.executeUpdate();

           rs.close();
           System.out.println("Conexion RS cerrada!");
       } catch (SQLException e) {
           e.printStackTrace(System.out);
           if(conexion != null){
               conexion.rollback();
               conexion.close();
           }
       }
        return true;
    }

    public double consulta_saldo(int idcuenta) throws SQLException{
        //consulta simple para obtener el saldo mediante el id de la cuenta

        String consulta = "select Saldo from cuentas where id_cuenta = ?";
        PreparedStatement st = conexion.prepareStatement(consulta);
        st.setInt(1,idcuenta);
        ResultSet rs = st.executeQuery();

        if(rs.next()){
            double saldo_origen = rs.getDouble("Saldo");
            System.out.println("Su saldo es de: " +saldo_origen);
            //retrun para retornar una variable a algo u otro metodo que para que pueda ser utilizada
            return  saldo_origen;
        }
        return 0;
    }

    public void transacion(int id_origen,int id_destino,double saldo_destino,double saldo_origen) throws  SQLException{
        //metodo para transsacciones mediante el id de ambas cuentas
        final String CUENTA_ORIGEN = "UPDATE cuentas SET Saldo = Saldo - ? WHERE id_cuenta = ?";
        final String CUENTA_DEDSTINO = "UPDATE cuentas SET Saldo = Saldo + ? WHERE id_cuenta = ?";
        PreparedStatement cuenta_origen = null;
        PreparedStatement cuenta_destino = null;

        try {
            String jdbc = "jdbc:mysql://localhost:3306/banco";
            conexion_transaccion = DriverManager.getConnection(jdbc,"root","1234");
            System.out.println("conexion abierta");
            conexion_transaccion.setAutoCommit(false);

            cuenta_origen = conexion_transaccion.prepareStatement(CUENTA_ORIGEN);
            cuenta_origen.setDouble(1,saldo_origen);
            cuenta_origen.setInt(2,id_origen);
            cuenta_origen.executeUpdate();

            cuenta_destino = conexion_transaccion.prepareStatement(CUENTA_DEDSTINO);
            cuenta_destino.setDouble(1,saldo_destino);
            cuenta_destino.setInt(2,id_destino);
            cuenta_destino.executeUpdate();
            conexion_transaccion.commit();
            conexion_transaccion.close();

        }catch (SQLException e){
            try {
                conexion_transaccion.rollback();
            }catch (SQLException p){
                p.printStackTrace();
            }
        }finally {
            System.out.println("Transaccion realizada!");
            if(cuenta_origen != null){
                cuenta_origen.close();
            }
            if(cuenta_destino != null){
                cuenta_destino.close();
            }

        }

    }

    public void retira_saldo(double valor, int id_origen) throws SQLException{

        String consulta = "UPDATE cuentas SET Saldo = ? WHERE id_cuenta = ?";
        PreparedStatement ps = conexion.prepareStatement(consulta);
        ps.setDouble(1,valor);
        ps.setInt(2,id_origen);
        ps.executeUpdate();
        ps.close();

    }

    public void eliminar(int id_cuenta) throws SQLException{
        String eliminar = "DELETE FROM cuentas WHERE id_cuenta = ?";
        PreparedStatement ps = conexion.prepareStatement(eliminar);
        ps.setInt(1,id_cuenta);
        ps.executeUpdate();
        ps.close();
    }
    public void cerra() throws SQLException{
        if(conexion != null){
            conexion.close();
            System.out.println("Conexion cerrada!");

        }
    }
}

