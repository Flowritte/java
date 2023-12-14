package control;

import java.util.Scanner;

public class app_electrodomesticos {
    public static void main(String[] args) {

        Scanner tecaldo = new Scanner(System.in);
        electrodomesticos [] listaelectrodomesticos = new electrodomesticos[3];
        int opcion;
        //registro de los elementos electrodomesticos
        for(int i = 0;i < listaelectrodomesticos.length;){
            System.out.println("\nDigite una opcion");
            System.out.println("1.Agregar electrodomesticos");
            System.out.println("2.Agregar lavadora");
            System.out.println("3.Agregar television");
            System.out.print("Digite una opcion: ");
            opcion = tecaldo.nextInt();
            if(opcion == 1 ||opcion == 2 || opcion ==3){
                switch (opcion){
                    case 1:
                        String colorelectrodomestico;
                        char consumoenergeticoelectrodomestico;
                        double preciobaseelectrodomestico;
                        double pesoelectrodomestico;
                        System.out.print("Digite in color: ");
                        colorelectrodomestico = tecaldo.next();
                        System.out.print("Digite el consumo energetico: ");
                        consumoenergeticoelectrodomestico =tecaldo.next().charAt(0);
                        System.out.print("Precio base: ");
                        preciobaseelectrodomestico = tecaldo.nextDouble();
                        System.out.print("Digite el peso: ");
                        pesoelectrodomestico = tecaldo.nextDouble();
                        listaelectrodomesticos [i] = new electrodomesticos(colorelectrodomestico,consumoenergeticoelectrodomestico
                                ,preciobaseelectrodomestico,pesoelectrodomestico);
                        System.out.println("\nElectrodomestico agregado!");
                        i++;

                         break;

                    case 2:
                        int cargalavadora;
                        String colorlavadora;
                        char consumoenergeticolavadora;
                        double preciobaselavadora,pesolavadora;
                        System.out.print("Digite in color: ");
                        colorlavadora = tecaldo.next();
                        System.out.print("Digite el consumo energetico: ");
                        consumoenergeticolavadora =tecaldo.next().charAt(0);
                        System.out.print("Precio base: ");
                        preciobaselavadora = tecaldo.nextDouble();
                        System.out.print("Digite el peso: ");
                        pesolavadora = tecaldo.nextDouble();
                        System.out.println("Digitel acarga de la lavadora: ");
                        cargalavadora = tecaldo.nextInt();
                        listaelectrodomesticos [i] = new lavadora(cargalavadora, colorlavadora
                                                        , consumoenergeticolavadora, preciobaselavadora, pesolavadora);
                        System.out.println("\nLavadora Agregada!");
                        i++;
                        break;

                    case 3:

                        int resolucion;
                        boolean sincronizadorTDT;
                        String colortelevision;
                        char consumoenergeticotelevision;
                        double preciobasetelevision,pesotelevision;
                        System.out.print("Digite in color: ");
                        colortelevision = tecaldo.next();
                        System.out.print("Digite el consumo energetico: ");
                        consumoenergeticotelevision =tecaldo.next().charAt(0);
                        System.out.print("Precio base: ");
                        preciobasetelevision = tecaldo.nextDouble();
                        System.out.print("Digite el peso: ");
                        pesotelevision = tecaldo.nextDouble();
                        System.out.println("digite la resolucion");
                        resolucion = tecaldo.nextInt();
                        System.out.println("tiene sincronizador TDT?: ");
                        sincronizadorTDT = tecaldo.nextBoolean();
                        listaelectrodomesticos [i] = new televisor(colortelevision
                                , consumoenergeticotelevision, preciobasetelevision , pesotelevision,
                        resolucion,sincronizadorTDT);
                        System.out.println("\nTelevisor Agregado!");
                        i++;


                        break;

                    default:
                        System.out.println("opcion no disponible, vuelva a intertarlo!.");
                        break;

                }

            }
        }
        //calcula la siuma de todos los electrodomesticos

        double sumaelectrodomesticos =0;
        double sumatelevisor =0;
        double sumalvadora =0;
        //recorrer la lista
        for(int i =0; i<listaelectrodomesticos.length;i++){
            if(listaelectrodomesticos[i] instanceof electrodomesticos){
                //preguta si pregnta si la clase es instancia deuna clase en epecifico
                sumaelectrodomesticos +=listaelectrodomesticos[i].obtener_preciofinal();
            }
            if(listaelectrodomesticos[i] instanceof lavadora){
                sumalvadora +=listaelectrodomesticos[i].obtener_preciofinal();
            }
            if(listaelectrodomesticos[i] instanceof televisor){
                sumatelevisor += listaelectrodomesticos[i].obtener_preciofinal();


            }

        }
        System.out.println("La suma de electrodomesticos es de: "+ sumaelectrodomesticos);
        System.out.println("La suma de las lavadoras es de: "+ sumalvadora);
        System.out.println("La suma de los televisores es de: "+ sumatelevisor);
    }
}
