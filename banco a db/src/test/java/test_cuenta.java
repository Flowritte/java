import funcionario.*;


import java.sql.SQLException;

public class test_cuenta {
    public static void main(String[] args) throws SQLException {

       Cuenta hector_cuenta = new Cuenta(001,"Hector Fanez",
                            "5598945605",0001,100000);
        //Cuenta jonh =new Cuenta(332,"john alvares","5555678946",654,200);

       // cuenta_ahorro hector_cc = new cuenta_ahorro("Alfonso wenster");
        Cuenta hector = new Cuenta(); //cuenta vacia para test
      //  hector.getSaldo(8653);
      //  hector.transfiere(5000,8653,6362);
       // hector.depocita(100,8653);
        //hector.retira(5000,8653);
        hector.eliminar_cuenta(1116);




   }


}
