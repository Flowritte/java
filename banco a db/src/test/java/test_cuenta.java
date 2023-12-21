import funcionario.*;
public class test_cuenta {
    public static void main(String[] args) {

        Cliente clientediego = new Cliente();
        clientediego.setNombre("diego rivera");
        clientediego.setNo_documento("acta e ine");

        Cuenta cuentadiego = new Cuenta(123);
        cuentadiego.depocita(5600);

        System.out.println(cuentadiego.getSaldo());
        System.out.println(clientediego.getNombre()+" " + clientediego.getNo_documento());


    }
}
