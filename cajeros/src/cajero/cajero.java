package cajero;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

public class cajero {

    public int saldo = 1000000;
    public String nip = "2502";

    //menu principal
    public void menu(){
        int opccion = 0;
        do{
            String comando = JOptionPane.showInputDialog(null,"\n" +
                    "1. Consulta saldo\n" +
                    "2. Depocitar\n" +
                    "3. Retiro\n" +
                    "4. Cambio NIP\n" +
                    "5.salir\n");

            if (comando != null && Validacion.isnum(comando)) {
                opccion = Integer.parseInt(comando);

                switch (opccion){
                    case 1:
                        //metodo para consulta
                        consulta();
                        break;
                    case 2:
                        //metodo para depocitar
                        depocitar();
                        break;
                    case 3:
                        //metodo para retiro
                        retiro();
                        break;
                    case 4:
                        //metodo de cambio de nip
                        cambionip();
                        break;
                    case 5:
                        //salir
                        opccion = 5;
                    default:

                        break;

                }
            }
        }while (opccion != 5);
    }

    public void depocitar(){
        String cadena;
        int depocito;

        //guarda el depocito
        cadena = JOptionPane.showInputDialog(null,"" +
                "Cuando desea depocitar a la cuenta?");
        if(cadena != null && !cadena.equals("") && Validacion.isnum(cadena)){
            //convertir el dato igresado a entero
            depocito = Integer.parseInt(cadena);
            if (depocito > 0){
                saldo += depocito;
                JOptionPane.showMessageDialog(null,"" +
                        "Tu saldo actual es: " +saldo);
            }else{
                JOptionPane.showMessageDialog(null,"" +
                        "Por favor ingrese una catidad mayor a 1$");
            }

        }

    }

    //metodo para el retiro
    public void retiro(){
        String cadena;
        cadena = JOptionPane.showInputDialog(null,"" +
                "Por razones de seguridad digite su nip");
        if(cadena ==null || cadena.isEmpty()){
            // si no ingresa nada regresa al menu principal
        }else{
            if(cadena.equals(nip)){
                cadena = JOptionPane.showInputDialog(null,"" +
                        "Cuanto desea retirar?\n" +
                        "a.500\n" +
                        "b.1000\n" +
                        "c.10000\n" +
                        "d.100000\n" +
                        "e.otra cantidad");

                if(cadena != null && !cadena.equals("")){
                    switch (cadena){
                        case "a":
                            if((saldo-500)>= 10000){
                                saldo-=500;
                                JOptionPane.showMessageDialog(null,"" +
                                        "Su saldo es: " +saldo);
                            }
                            break;
                        case "b":
                            if((saldo-1000)>= 10000){
                                saldo-=1000;
                                JOptionPane.showMessageDialog(null,"" +
                                        "Su saldo es: " +saldo);
                            }
                            break;
                        case "c":
                            if((saldo-10000)>= 10000){
                                saldo-=10000;
                                JOptionPane.showMessageDialog(null,"" +
                                        "Su saldo es: " +saldo);
                            }
                            break;
                        case "d":
                            if((saldo-100000)>= 10000){
                                saldo-=100000;
                                JOptionPane.showMessageDialog(null,"" +
                                        "Su saldo es: " +saldo);
                            }
                            break;
                        case "e":

                            if((cadena != null && !cadena.equals("") && Validacion.isnum(cadena)) && (saldo- Integer.parseInt(cadena) >- 10000) && (Integer.parseInt(cadena)) >0 ){
                                saldo -= Integer.parseInt(cadena);
                                JOptionPane.showMessageDialog(null,"" +
                                        "Su saldo es: " + saldo);
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null,"" +
                                    "La opcion no existe");
                            break;

                    }


                }else{
                    JOptionPane.showMessageDialog(null,"" +
                            "El nip es incorrecto");
                }
            }
        }
    }

    public void cambionip(){
        String auxiliar;
        String nipnuevo;

        auxiliar = JOptionPane.showInputDialog(null,"" +
                "Digite su nip");

        if(auxiliar !=null && !auxiliar.isEmpty() && auxiliar.equals(nip)){
            nipnuevo = JOptionPane.showInputDialog(null,"" +
                    "Digite su nievo nip de 4 numeros diferentes");

            if (nipnuevo != null && !nipnuevo.isEmpty() && nipnuevo.length() == 4) {
                auxiliar = null;
                auxiliar = nip;
                JOptionPane.showMessageDialog(null,"" +
                        "Su Antiguo nip fue cambiado" + auxiliar);
                JOptionPane.showMessageDialog(null,"" +
                        "Su nuevo nip es: " +nipnuevo);
                nip = nipnuevo;


            }else{
                JOptionPane.showMessageDialog(null,"" +
                        "Por favor digite su nip\n" +
                        "debe ser de 4 numeros");
            }
        }else{
            JOptionPane.showMessageDialog(null,"" +
                    "Su nip no coincide");
        }
    }
    //metodo para consultar
    public void consulta(){
        JOptionPane.showMessageDialog(null,"" +
                "Su saldo es: " + saldo);
    }
}

