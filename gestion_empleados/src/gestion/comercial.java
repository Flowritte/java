package gestion;
/*
comercial si tiene mas de 30 años y si cobra una comision de mas de
cobra un plus de 200

 */
public class comercial extends empleado{
    private double comision;
    //constructor
    public comercial(double comision,String nombre, int edad, double salario) {
        super(nombre, edad, salario);
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Comision: " +comision;
    }

    @Override
    public boolean plus() {
    /*
    comercial si tiene mas de 30 años y si cobra una comision de mas de 300
    cobra un plus de 200
    */
        if (super.getEdad() > 30 && this.comision > 200){
            double nuevosalario = super.getSalario() +super.plus;
            super.setSalario(nuevosalario);
            System.out.println("\nSe añadio el plus al empleado: "+ super.getNombre()+
            "\n"+
            "su salario actual es: " +nuevosalario);
            return true;
        }else {
            System.out.println("\nEl emplado no cumple con los requisitos para el plus.");
            return false;
        }
    }
}
