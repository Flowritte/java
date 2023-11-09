package cajero;

public class Validacion {
    public static  boolean isnum(String comando){
        try{
            int numero = Integer.parseInt(comando);
            return true;
        }catch (NumberFormatException error){
            System.out.println(error);
            return false;
        }
    }
}
