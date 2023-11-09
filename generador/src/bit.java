public class bit {



    public class constrasenias{


        public static String numeros = "1234567890";
        public static String mayusculas= "ABCDEFGHIJKLMNO"
                + "PQRSTUVWXYXZ";
        public static String minusculas ="abcdefghijklmno"
                + "pqrstuvwxyz";


        public static String getnumber() {
            return getpassword(numeros,4);
        }

        public static String getpassword() {
            return getpassword(8);
        }

        public static String getpassword(int length) {
            return getpassword(mayusculas+minusculas+numeros,length);

        }

        public static String getpassword(String key, int length) {
            String pswd ="";

            for (int i = 0; i < length ; i++) {
                pswd +=(key.charAt((int)(Math.random() * key.length())));
            }
            System.out.println(pswd);
            return pswd;

        }
    }
}
