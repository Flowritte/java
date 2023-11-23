package gestion;

public abstract class empleado {
    //atributos
    private String nombre;
    private int edad;
    private double salario;
    //constate plus que no cambia
    public final double plus = 300;

    public empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getPlus() {
        return plus;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nEdad: " + edad
                + "\nSalario: " +salario;
    }

    //metodo abstracto
    public abstract boolean plus();

}
