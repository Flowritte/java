package funcionario;

import java.util.Random;

public class no_cuenta {
    int longitud = 4;

    String numero_cuenta = numero_cuenta_creado(longitud); //longitud de cuenta

    public static String numero_cuenta_creado(int longitud) {


        StringBuilder numero_cuenta = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int digito = random.nextInt(10); // Genera un número aleatorio entre 0 y 9
            numero_cuenta.append(digito);
        }
        //convierte el numero a String
        return numero_cuenta.toString();
    }

}

