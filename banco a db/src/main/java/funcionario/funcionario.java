package funcionario;

import bd.conecta_funcionario;
import java.sql.SQLException;

//atributos
public class funcionario {
    private String nombre;
    private String no_documento;
    private double salario;
    private int tipo;
    private String puesto;
    private  int agencia;

    public funcionario(){
        //funcionario vacio
    }

    public funcionario(String nombre,String puesto,int agencia,double salario,
                            int doc) throws SQLException {
        //metodo para dado de alta de funcionario
        conecta_funcionario alta = new conecta_funcionario();
        alta.conectar_fun();
        //no_cuenta funciona tambien para dar un pin de clave al nuevo funcionario al ser un numero aleatorio de 4 digitos
        no_cuenta nuevo_pin = new no_cuenta();

        try {
            System.out.println("El pin del funcionario es: " + nuevo_pin.numero_cuenta);
            System.out.println("no pierda este pin es su nueva clave");
            alta.crea_fun(nombre,puesto,agencia,salario, nuevo_pin.numero_cuenta,doc);
            System.out.println("Se ha dado de alta al nuevo funcionario!");
            alta.cierra_fun();
        }catch (SQLException e){
            e.printStackTrace(System.out);
            System.out.println("no se ha podido dar de alta al nuevo funcionario");
        }
    }

    public double getBonificacion() {

        return 0;
    }

    public void getNombre(String nombre,String id_funcionario) throws SQLException {
        conecta_funcionario busqueda = new conecta_funcionario();

        busqueda.busqueda_fun(nombre,id_funcionario);
        busqueda.cierra_fun();

    }

     public void getPuesto(String puesto,String id_funcionario) throws SQLException {
         conecta_funcionario busqueda = new conecta_funcionario();

         busqueda.busqueda_fun(nombre,id_funcionario);
         busqueda.cierra_fun();

    }

    public void getAgencia(int agencia,String id_funcionario) throws SQLException {
        conecta_funcionario busqueda = new conecta_funcionario();

        busqueda.busqueda_fun(nombre,id_funcionario);
        busqueda.cierra_fun();

    }
    public void getSalario(int id) throws SQLException {

        conecta_funcionario salario = new conecta_funcionario();
        salario.conectar_fun();
        salario.getSaldo(id);

    }

    public void getBonificacion(int id,int cuentas_abiertas) throws SQLException {

        conecta_funcionario salario = new conecta_funcionario();
        salario.conectar_fun();
        double salario_parcial = salario.getSaldo(id);
        if(cuentas_abiertas >= 5){

            double salario_total = salario_parcial * 0.2;
            System.out.println("El funcionario ha superado la meta y su salario es de: " + salario_total);
            System.out.println("el funcionario ha tenido un aumento del 20%");
        }else {

            System.out.println("El funcionario no ha alcanzado la meta y ha obtenido un bono del 10%");
            double salario_total = salario_parcial *0.1;
            System.out.println("El funcionario ha superado la meta y su salario es de: " + salario_total);
        }

    }

}
