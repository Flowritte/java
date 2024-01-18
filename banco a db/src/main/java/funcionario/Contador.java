package funcionario;

import java.sql.SQLException;

public class Contador extends funcionario{
    public Contador(String nombre, String puesto, int agencia, double salario, int doc) throws SQLException {
        super(nombre, puesto, agencia, salario, doc);
    }

    public double getBonificacion(){
        //return super.getBonificacion();
        return 0;
    }
}
