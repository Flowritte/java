package bd;
import java.sql.*;
public class conecta_funcionario {

    Connection conexion = null;

    public void conectar_fun() throws SQLException {
        //apertura a bd
        String jdbc = "jdbc:mysql://localhost:3306/banco";
        conexion = DriverManager.getConnection(jdbc,"root","1234");
        System.out.println("conexion abierta");
    }
    public void crea_fun(String nombre,String puesto,int agencia, double salario,
                        String clave,int doc) throws SQLException{
        //dada de alta de funcionario a bd
        String insert_cuenta = "INSERT INTO funcionario(Nombre,Puesto,Agencia,Salario,clave,No_documento) VALUES (?,?,?,?,?,?)";
        PreparedStatement st = conexion.prepareStatement(insert_cuenta);
        st.setString(1,nombre);
        st.setString(2,puesto);
        st.setString(3, String.valueOf(agencia));
        st.setDouble(4,salario);
        st.setString(5, clave);
        st.setInt(6,doc);
        st.executeUpdate();
        st.close();
    }

    public String busqueda_fun(String busqeda,String busqeda_where) throws SQLException{
        //metodo para busqueda por criterio
        String resultado = "";
        String str = busqeda;
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        String consulta = "SELECT ? FROM funcionario where id_funcionario = ?";

        PreparedStatement bd = conexion.prepareStatement(consulta);
        bd.setString(1,str);
        bd.setString(2,busqeda_where);

        ResultSet set = bd.executeQuery();
        String busqedaif = busqeda.toLowerCase();

        if(busqeda == busqedaif && busqedaif == "Nombre"){
            //por nombre
            //imprime agncia y nombre y solo devuelve el nombe
            set.next();
            String rs_nombre = set.getString("Nombre");
            String rs_agencia = set.getString("Agencia");
            System.out.println("El nombre del funcionario es: " + rs_nombre + " y es de la agencia " + rs_agencia);
            return  rs_nombre;

        } else if (busqeda == busqedaif && busqedaif == "Puesto") {
            //por puesto
            set.next();
            String rs_nombre = set.getString("Nombre");
            String rs_puesto = set.getString("Puesto");
            System.out.println("El nombre del funcionario es: " +rs_nombre+" y Tiene el pueto de: " + rs_puesto);
            return rs_puesto;

        } else if (busqeda == busqedaif && busqedaif == "Agencia") {
            //busqueda por agencia e imprimeo todos en la gancia
            //no devuleve nada
            set.next();
            while (set.next()){
                String rs_nombre = set.getString("Nombre");
                int rs_agencia = set.getInt("Agencia");
                System.out.println("El nombre del funcionario es: " + rs_nombre + " y es de la agencia " + rs_agencia);
            }

            bd.close();
            set.close();
        }


        return resultado;
    }

    public double getSaldo(int id) throws SQLException {
        String consuta = "SELECT Ssalario from funcionario where id_funcionario = ?";
        PreparedStatement bd = conexion.prepareStatement(consuta);
        bd.setInt(1,id);
        ResultSet set = bd.executeQuery();
        set.next();
        double saldo = set.getDouble("Salario");
        String nombre = set.getString("Nombre");
        System.out.println("El salario del funcionario es" +nombre + "es de: " +saldo);
        return saldo;
    }

     public boolean cierra_fun() throws SQLException {
        if(conexion != null){
            conexion.close();
            System.out.println("La conexion al servidor se ha cerrado!");
            return true;
        }
         return false;
     }
}
