package funcionario;
import bd.*;

import java.sql.SQLException;

public class cuenta_ahorro extends Cuenta{

     public cuenta_ahorro(String nombre_completo) throws SQLException{
         System.out.println("Se ha creado una cuenta ahorro!, a nombre de: " + nombre_completo);
         conectar cc_conexion = new conectar();

         try {
             cc_conexion.conecta();
             cc_conexion.consulta_inserta_unica(nombre_completo,0);
             cc_conexion.cerra();

         }catch (SQLException e){
             e.printStackTrace();
         }




    }

    public void depocita(double valor){
        this.saldo= valor+this.saldo;
    }



}
