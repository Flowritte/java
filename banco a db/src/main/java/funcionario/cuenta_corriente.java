package funcionario;

public class cuenta_corriente extends Cuenta{
    public  cuenta_corriente(int agencia,String numero_cuenta_creado){

        //llama y recibe los numeros de cuenta
       // super(agencia);
    }
    @Override
    public void retira(double valor){
        double comision = 0.2;
        super.retira(valor+comision);
    }

    @Override
    public void depocita(double valor){

    }
}
