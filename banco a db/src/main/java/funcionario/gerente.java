package funcionario;

import java.sql.SQLException;
import java.util.Objects;

public class gerente extends funcionario{

    private String clave;

    public gerente(String nombre, String puesto, int agencia, double salario, int doc) throws SQLException {
        super(nombre, puesto, agencia, salario, doc);
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getBonificacion(){
        //lama al metodo padre para añadir la bonificacion con el salario
        //return super.getBonificacion() +super.getSalario();

        return 0;
    }

    public boolean iniciarsesion(String clave){
        if(this.clave.equals(clave)){
            return true;
        }else {
            return false;
        }
    }
}
