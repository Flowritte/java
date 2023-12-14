package control;

public class televisor extends electrodomesticos{

    private int resolucion;
    private  boolean sincronizadorTDT;


    @Override
    public double obtener_preciofinal() {
        double plus = super.obtener_preciofinal();
        if(resolucion <= 40){
            plus += preciobaseelectrodomestico * 0.3;

        }
        if(sincronizadorTDT){
            plus += 50;

        }
        return plus;
    }

    public televisor(String color, char consumoenergetico, double preciobase, double peso, int resolucion, boolean sincronizadorTDT) {
        super(color, consumoenergetico, preciobase, peso);
        this.resolucion = resolucion;
        this.sincronizadorTDT = sincronizadorTDT;

    }




}
