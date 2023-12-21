package funcionario;

public class ControlBonificacion {
    private double suma;

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }
    public double registro_salario(funcionario funcionario){
        this.suma = funcionario.getBonificacion() + this.suma;
        System.out.println("La Bonificacion es de: "+ this.suma);
        return this.suma;
    }
}
