package gestion;

import java.util.Scanner;

public class testempleado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        comercial comercial;
        repartidor repartidor;
        int opcion;
        do {
            System.out.println("\n\tPLUS empleados");
            System.out.println("1.PLUS de comercial");
            System.out.println("2. PLUS de reaprtidor");
            System.out.println("3.Salir");
            System.out.println("Digite una opcion: ");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    String nombrecomecial;
                    double salariocomercial,comission;
                    int edadcomercial;

                    System.out.println("\nDigite el nombre del comercial: ");
                    nombrecomecial=teclado.next();
                    System.out.println("Digite el salario del comercial: ");
                    salariocomercial = teclado.nextDouble();
                    System.out.print("digite la comison del comercial: ");
                    comission = teclado.nextDouble();
                    System.out.println("Digite la edad del comercial: ");
                    edadcomercial = teclado.nextInt();
                    comercial = new comercial(comission,nombrecomecial,edadcomercial,salariocomercial);
                    System.out.println(comercial.toString());
                    comercial.plus();

                    break;
                case 2:
                    String nombrereaprtidor,zona;
                    double salariorepartior;
                    int edadreaprtidor;


                    System.out.println("\nDigite el nombre del comercial: ");
                    nombrereaprtidor=teclado.next();
                    System.out.println("Digite el salario del comercial: ");
                    salariorepartior = teclado.nextDouble();

                    System.out.println("Digite la edad del comercial: ");
                    edadreaprtidor = teclado.nextInt();
                    System.out.println("digite la ona del repartidor: ");
                    zona = teclado.next();
                    repartidor = new repartidor(zona,nombrereaprtidor,edadreaprtidor,salariorepartior);
                    System.out.println(repartidor.toString());
                    repartidor.plus();

                    break;
                case 3:
                    System.out.println("Gracias por participar");
                    break;
                default:
                    System.out.println("Opcion no disponible!");
                    break;
            }

        }while (opcion !=3);
    }
}
