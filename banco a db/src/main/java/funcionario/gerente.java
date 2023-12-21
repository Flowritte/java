package funcionario;

import java.util.Objects;

public class gerente extends funcionario{

    private String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getBonificacion(){
        //lama al metodo padre para añadir la bonificacion con el salario
        return super.getBonificacion() +super.getSalario();

    }

    public boolean iniciarsesion(String clave){
        if(this.clave.equals(clave)){
            return true;
        }else {
            return false;
        }
    }
}
