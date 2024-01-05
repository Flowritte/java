package bd;
import java.sql.*;

public class conectar {
    private Connection conexion = null;


    public void conecta() throws SQLException{
        String jdbc = "jdbc:mysql://localhost:3306/banco";
        conexion = DriverManager.getConnection(jdbc,"root","1234");
        System.out.println("conexion abierta");

    }

    public void insertar_cuenta(String numero_cuenta_creado, String Nombre, String telefono, int No_documento
    , String agencia,double Saldo) throws SQLException {

        String insert_cuenta = "INSERT INTO cuentas(id_cuenta,Nombre,telefono,No_documento,Agencia,Saldo) VALUES (?,?,?,?,?,?)";
        PreparedStatement st = conexion.prepareStatement(insert_cuenta);
        st.setString(1,numero_cuenta_creado);
        st.setString(2,Nombre);
        st.setString(3,telefono);
        st.setInt(4,No_documento);
        st.setInt(5, Integer.parseInt(agencia));
        st.setDouble(6,Saldo);
        st.executeUpdate();

    }


    public void consulta(String idcuenta) throws SQLException{
        String consuta = "SELECT id_cuenta,Nombre,Agencia,Saldo from cuentas where id_cuenta = ?";
        PreparedStatement bd = conexion.prepareStatement(consuta);
        bd.setString(1,idcuenta);
        ResultSet set = bd.executeQuery();

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
    public double consulta_saldo(int idcuenta) throws SQLException{
        //consulta simple para obtener el saldo mediante el id de la cuenta
        String consulta = "select Saldo from cuentas where id_cuenta = ?";
        PreparedStatement ps = conexion.prepareStatement(consulta);
        ps.setInt(1,idcuenta);
        ResultSet set = ps.executeQuery();

        if(set.next()){
            double saldo_origen = set.getDouble("Saldo");
            System.out.println("Su saldo es de: " +saldo_origen);
            //retrun para retornar una variable a algo u otro metodo que para que pueda ser utilizada
            return  saldo_origen;
        }

        return 0;
    }




    public void transacion(int id_origen,int id_destino,double saldo_destino,double saldo_origen) throws  SQLException{
        //metodo para transsacciones mediante el id de ambas cuentas
        conexion.setAutoCommit(false);
        final String CUENTA_ORIGEN = "UPDATE cuentas SET Saldo = Saldo - ? WHERE id_cuenta = ?";
        final String CUENTA_DEDSTINO = "UPDATE cuentas set Saldo = Saldo + ? WHERE id_cuenta = ?";
        PreparedStatement cuenta_origen = null;
        PreparedStatement cuenta_destino = null;

        try {
            cuenta_origen = conexion.prepareStatement(CUENTA_ORIGEN);
            cuenta_origen.setDouble(1,saldo_origen);
            cuenta_origen.setInt(2,id_origen);
            cuenta_origen.executeUpdate();

            cuenta_destino = conexion.prepareStatement(CUENTA_DEDSTINO);
            cuenta_destino.setDouble(1,saldo_destino);
            cuenta_destino.setInt(2,id_destino);
            cuenta_destino.executeUpdate();
            conexion.commit();


        }catch (SQLException e){
            conexion.rollback();
            e.printStackTrace();
        }finally {
            if(cuenta_origen != null){
                cuenta_origen.close();
            }
            if(cuenta_destino != null){
                cuenta_destino.close();
            }

        }

    }


    public void cerra() throws SQLException{
        if(conexion != null){
            conexion.close();
            System.out.println("Conecxion cerrada");

        }
    }
}

