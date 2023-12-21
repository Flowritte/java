package funcionario;

public class cuenta_ahorro extends Cuenta{
    public cuenta_ahorro(int agencia,String numero_cuenta_creado){
        super(agencia);
    }

    public void depocita(double valor){
        this.saldo= valor+this.saldo;
    }



}
