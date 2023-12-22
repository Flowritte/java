package funcionario;
import bd.*;

import java.sql.SQLException;
import java.sql.SQLWarning;

public class Cuenta extends Cliente{
    protected double saldo;
    private int agencia;


    private Cliente titular = new Cliente();
    //contador de cuentas creadas
    private static int total;



    public Cuenta(){

    //cuenta vacia
    }

    public Cuenta(int agencia)  throws SQLException{
        no_cuenta cuenta_nueva = new no_cuenta();
        conectar nueva_conexion = new conectar();
        //metodo de cracion de cuenta
        this.agencia = agencia;
        System.out.println("se ha creado una cuenta");
        System.out.println("El numero de cuenta es: " + cuenta_nueva.numero_cuenta);
        try {
            nueva_conexion.conecta();
            nueva_conexion.insertar_cuenta(cuenta_nueva.numero_cuenta,getNombre(),getTelefono(),getNo_documento(),
                    String.valueOf(getAgencia()),getSaldo());


        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("introduzca todo los datos por favor");
        }
        Cuenta.total++;

    }




    public void depocita(double valor){
        //metodo para depocitar
    this.saldo+=valor;
    }
    public void retira(double valor){
        //metodo para retiro en cuenta
        if (this.saldo >= valor){
            this.saldo -= valor;
        }else{
            System.out.println("No cuentas con saldo suficiente");
        }
    }

    public boolean transfiere(double valor,Cuenta cuenta_destino){
        //metodo para transerir
        if (this.saldo >= valor){
            this.retira(valor);
            cuenta_destino.depocita(valor);
            return true;
        }else {
            return false;
        }
    }

    public double getSaldo(){
        //metodo para obtener saldo
        return saldo;
    }
    public  int getAgencia(){
        //metodo para obtener no de agencia
        return agencia;
    }
    public void  setAgencia(int agencia){
        //metodo para establecer agencia a cuenta
        this.agencia = agencia;
    }

    public Cliente getTitular(){
        return titular;
    }
    public void setTitular(Cliente nombre){
        this.titular = titular;
    }
    public static int getTotal(){
        //aumenta en 1 el nuemro de cuentas creadas
        return total;
    }



}
