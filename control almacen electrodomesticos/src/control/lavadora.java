package control;

public class lavadora extends electrodomesticos{

    private int cargalavadora;

    public int getCarga() {
        return cargalavadora;
    }

    public void setCarga(int carga) {
        this.cargalavadora = cargalavadora;
    }

    @Override
    public double obtener_preciofinal() {
        Double plus = super.obtener_preciofinal();
        if(cargalavadora > 30){
            plus += 50;
        }
        return plus;
    }

    //constructor
    public lavadora(int cargalavadora,String colorlavadora, char consumoenergeticolavadora, double preciobaselavadora, double pesolavadora) {
        super(colorlavadora, consumoenergeticolavadora, preciobaselavadora
                , pesolavadora);
        this.cargalavadora = cargalavadora;
    }



}
