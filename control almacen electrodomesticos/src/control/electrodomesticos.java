package control;

public class electrodomesticos {

    //asignacion de valores por defecto
    protected final  static String color_defecto = "blanco";
    protected final static char consumo_energetico = 'F';
    protected final static double precio_base = 100;
    protected final static double peso_defcto = 5;

    //atributos

    protected String colorelectrodomestico;
    protected char  consumoenergeticoelectrodomestico;
    protected  double preciobaseelectrodomestico;
    protected double pesoelectrodomestico;

    //metodo para comprobar el color
    protected void comprobarcolor(String color){
        String colores[] = {"blanco","azul","negro","rojo","gris"};
        boolean encontrado = false;

        for(int i=0;i< colores.length && !encontrado;i++){

            if(colores[i].equals(color)){
                encontrado = true;

            }

        }if(encontrado){
            this.colorelectrodomestico = color;

        }else{
            this.colorelectrodomestico = color_defecto;
        }
    }
    //metodo par coprobar el onsumo energetico
    public final  void comprobarconsumo(char consumoenergetico){
        if(consumoenergetico >= 65 && consumoenergetico <= 70){
            this.consumoenergeticoelectrodomestico = consumoenergetico;

        }else{
            this.consumoenergeticoelectrodomestico = consumo_energetico;
        }
    }

    public String getColor() {
        return colorelectrodomestico;
    }

    public char getConsumoenergetico() {
        return consumoenergeticoelectrodomestico;
    }

    public double getPreciobase() {
        return preciobaseelectrodomestico;
    }

    public double getPeso() {
        return pesoelectrodomestico;
    }

    public double obtener_preciofinal(){
        double plus = 0;
        switch (consumoenergeticoelectrodomestico){
            case 'A':
                plus += 100;
                break;
            case 'B':
                plus+=80;
                break;
            case 'C':
                plus+=60;

                break;
            case 'D':
                plus+=50;
                break;
            case 'E':
                plus+=30;
                break;
            case 'F':
                plus+=10;
                break;

        }
        if(pesoelectrodomestico>=0 && pesoelectrodomestico <=19){
            plus+=10;

        } else if (pesoelectrodomestico >= 20 && pesoelectrodomestico <=49) {
            plus+=50;

        } else if (pesoelectrodomestico>=50 && pesoelectrodomestico <=79) {
            plus+=80;

        } else if (pesoelectrodomestico>=80) {
            plus+=100;

        }
        return preciobaseelectrodomestico+plus;
    }

    public electrodomesticos(String colorelectrodomestico, char consumoenergeticoelectrodomestico, double preciobaseelectrodomestico,
                             double pesoelectrodomestico) {
        comprobarcolor(colorelectrodomestico);
        comprobarconsumo(consumoenergeticoelectrodomestico);
        this.preciobaseelectrodomestico = preciobaseelectrodomestico;
        this.pesoelectrodomestico = pesoelectrodomestico;
    }
}
