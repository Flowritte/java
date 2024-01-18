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

    public void depocita(int id_cuenta,double valor){
        this.saldo= valor+this.saldo;
        double valor_total =0;
        if(valor > 0){
            try {
                conectar consulta = new conectar();
                consulta.conecta();
                double saldo = consulta.consulta_saldo(id_cuenta);
                valor_total = saldo +valor;
                boolean tranfiere = consulta.consulta_inserta_depocita(id_cuenta,valor_total);
                consulta.cerra();
                if(tranfiere != false){

                    conectar revision = new conectar();
                    revision.conecta();
                    revision.consulta_id(id_cuenta);
                    System.out.println("El depocito se ha realizado con exito");
                    revision.cerra();
                }else {
                    System.out.println("El depocito no se ha podido realizar con exito revise sus datos");
                }
            }catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }else {
            System.out.println("Digite un valor superior a 0");
        }
    }



}
