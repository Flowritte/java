package funcionario;
import bd.*;

import java.sql.SQLException;

public class Cuenta {
    protected double saldo;
    private int agencia;
    private  String titular;

       private static int total;

    public Cuenta(){
    //cuenta vacia
    }

    public Cuenta(int agencia,String nombre,String telefono,int Documento
                    ,double saldo)  throws SQLException{

        //metodo de cracion de cuenta

        no_cuenta cuenta_nueva = new no_cuenta();
        conectar nueva_conexion = new conectar();

        this.agencia = agencia;
        System.out.println("se ha creado una cuenta");
        System.out.println("El numero de cuenta es: " + cuenta_nueva.numero_cuenta);

        try {
            nueva_conexion.conecta();
            nueva_conexion.insertar_cuenta(cuenta_nueva.numero_cuenta,nombre,telefono,Documento,
                    String.valueOf(agencia),saldo);
            nueva_conexion.cerra();

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("introduzca todo los datos por favor");
        }
        Cuenta.total++;
    }


   public void depocita(double valor,int id_cuenta) throws SQLException {

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

    public void retira(double valor,int idcuenta) throws SQLException {

        double valor_total = 0;
        try {
            conectar consulta = new conectar();
            consulta.conecta();
            double saldo = consulta.consulta_id(idcuenta);
            if (valor <= saldo && valor > 0) {
                valor_total = saldo - valor;
                consulta.retira_saldo(valor_total, idcuenta);
                consulta.consulta_saldo(idcuenta);
                consulta.cerra();
            }else {
                System.out.println("No cuenta con suficiente saldo y verifique que el retiro sea mayor a 0");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public boolean transfiere(double valor_restado,int cuenta_origen,int cuenta_destino) throws SQLException {

        //consulta saldo
        conectar consulta = new conectar();
        consulta.conecta();
        double saldo_origen = consulta.consulta_saldo(cuenta_origen);
        double valor_transfiere = valor_restado;

        //metodo transaccion
       if (valor_transfiere <= saldo_origen){
            consulta.transacion(cuenta_origen,cuenta_destino,valor_transfiere,valor_restado);
            consulta.cerra();

            return true;
        }else {
            return false;
        }
    }

    public void getSaldo(int id_cuenta) throws SQLException {
        conectar consulta = new conectar();
        consulta.conecta();
        consulta.consulta_saldo(id_cuenta);
        consulta.cerra();
    }

public void eliminar_cuenta (int id_cuenta) throws SQLException{
    System.out.println("La cuenta a eliminar :");
        conectar eliminar = new conectar();
        eliminar.conecta();
        eliminar.consulta(id_cuenta);
        eliminar.eliminar(id_cuenta);
        eliminar.cerra();


}
    public static int getTotal(){
        //aumenta en 1 el nuemro de cuentas creadas
        System.out.println("Cuentas creadas: " + total);
        return total;
    }


}
