package gestion;

public class repartidor extends empleado {
    private String zona;


    public repartidor(String zona,String nombre, int edad, double salario) {
        super(nombre, edad, salario);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "La zona: "+zona;
    }

    @Override
    public boolean plus() {
        //si el repartidor tiene menos de 25 y reparte en zona cdmx
        if(super.getEdad()< 25 && this.zona.equalsIgnoreCase("CDMX")){

            double nuevosalario = super.getSalario() + super.plus;
            super.setSalario(nuevosalario);
            System.out.println("se ha añadido el plus al empleado: "+super.getNombre());
            System.out.println("su salario actual es de: " +nuevosalario);
            return true;
        }else {
            System.out.println("El emplado no cumple con los requisitos par el plus");
            return false;
        }

    }
}
