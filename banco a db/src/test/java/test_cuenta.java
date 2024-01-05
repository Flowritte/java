import funcionario.*;
import  bd.conectar;

import java.sql.SQLException;

public class test_cuenta {
    public static void main(String[] args) throws SQLException {

       // Cuenta hector_cuenta = new Cuenta(001,"Hector Fanez",
                         //   "5598945605",0001,100000);

       // cuenta_ahorro hector_cc = new cuenta_ahorro("Alfonso wenster");
        Cuenta hector = new Cuenta();
        hector.getSaldo(8653);
        //hector.transfiere();



   }


}
