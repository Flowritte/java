package funcionario;
import bd.*;

import java.sql.SQLException;

public class Cuenta {
    protected double saldo;
    private int agencia;
    private  String titular;

    //contador de cuentas creadas
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


   /* public void depocita(double valor){
        //metodo para depocitar
    this.saldo+=valor;
    }

    */
    public void retira(double valor){
        //metodo para retiro en cuenta
        if (this.saldo >= valor){
            this.saldo -= valor;
        }else{
            System.out.println("No cuentas con saldo suficiente");
        }
    }

    public boolean transfiere(double valor, int cuenta_origen,int cuenta_destino) throws SQLException {

        //metodo para transerir
        conectar consulta = new conectar();
        double saldo_origen = consulta.consulta_saldo(cuenta_origen);
        consulta.cerra();

       if (valor <= saldo_origen){
           conectar transferencia = new conectar();
           transferencia.transacion(cuenta_origen,cuenta_destino,valor,saldo_origen);
           transferencia.cerra();


            return true;
        }else {
            return false;
        }


    }

    public void getSaldo(int id_cuenta) throws SQLException {
        conectar consulta = new conectar();
        consulta.consulta_saldo(id_cuenta);
        consulta.cerra();
    }
    public  int getAgencia(){
        //metodo para obtener no de agencia
        return agencia;
    }
    public void  setAgencia(int agencia){
        //metodo para establecer agencia a cuenta
        this.agencia = agencia;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public static int getTotal(){
        //aumenta en 1 el nuemro de cuentas creadas
        System.out.println("Cuentas creadas: " + total);
        return total;
    }



}
