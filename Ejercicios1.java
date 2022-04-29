import java.util.regex.Pattern;

public class Ejercicios1 {
    public static void main(String[] args) {

        EjerciciosExpresiones();

    }

    public static void EjerciciosExpresiones(){

        System.out.println("1");
        System.out.println(Pattern.matches("^[\\d]+$","32"));
        System.out.println(Pattern.matches("^[\\d]+$","a2"));
        System.out.println("2");
        System.out.println(Pattern.matches("^\\+?[\\d]+$","+32"));
        System.out.println(Pattern.matches("^\\+?[\\d]+$","-98"));
        System.out.println("3");
        System.out.println(Pattern.matches("^\\-\\s?[\\d]+$","-53"));
        System.out.println(Pattern.matches("^\\-\\s?[\\d]+$","78"));
        System.out.println("4");
        System.out.println(Pattern.matches("^[\\d]{8}[a-zA-Z]$","77432934F"));
        System.out.println(Pattern.matches("^[\\d]{8}[a-zA-Z]$","54664d"));
        System.out.println("5");
        System.out.println(Pattern.matches("^([01][0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([01][0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([01][0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([01][0-9][0-9]|2[0-4][0-9]|25[0-5])$","192.168.001.001"));
        System.out.println(Pattern.matches("^([01][0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([01][0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([01][0-9][0-9]|2[0-4][0-9]|25[0-5])\\.([01][0-9][0-9]|2[0-4][0-9]|25[0-5])$","260.168.001.001"));
        System.out.println("6");
        System.out.println(Pattern.matches("^[\\d]{4}[a-zA-Z]{3}$","6542GST"));
        System.out.println(Pattern.matches("^[\\d]{4}[a-zA-Z]{3}$","458esdt"));
        System.out.println("7");
        System.out.println(Pattern.matches("^1[01]*$","1101010001"));
        System.out.println(Pattern.matches("^1[01]*$","101501"));
        System.out.println("8");
        System.out.println(Pattern.matches("^[1-7][0-7]*","7463521"));
        System.out.println(Pattern.matches("^[1-7][0-7]*","92841"));
        System.out.println("9");
        System.out.println(Pattern.matches("^[1-9A-F][\\dA-F]*$","64F"));
        System.out.println(Pattern.matches("^[1-9A-F][\\dA-F]*$","0007"));
        System.out.println("10");
        System.out.println(Pattern.matches("^[\\d]+\\.[\\d]*[1-9]$","85.4"));
        System.out.println(Pattern.matches("^[\\d]+\\.[\\d]*[1-9]$","74.0d"));
        System.out.println("11");
        System.out.println(Pattern.matches("^\\+?\\s?[\\d]+\\.[\\d]*[1-9]$","+879.4"));
        System.out.println(Pattern.matches("^\\+?\\s?[\\d]+\\.[\\d]*[1-9]$","-894.c"));
        System.out.println("12");
        System.out.println(Pattern.matches("^\\-\\s?[\\d]+\\.[\\d]*[1-9]$","-92.7"));
        System.out.println(Pattern.matches("^\\-\\s?[\\d]+\\.[\\d]*[1-9]$","98.4"));
        //x = 4
        System.out.println("13");
        System.out.println(Pattern.matches("[\\d]+\\.[\\d]{3}[1-9]$","12.1234"));
        System.out.println(Pattern.matches("[\\d]+\\.[\\d]{3}[1-9]$","78.246"));
        System.out.println("14");
        System.out.println(Pattern.matches("^\\+?\\s?[\\d]+\\.[\\d]{3}[1-9]$","12.1234"));
        System.out.println(Pattern.matches("^\\+?\\s?[\\d]+\\.[\\d]{3}[1-9]$","-21.1245"));
        System.out.println("15");
        System.out.println(Pattern.matches("^\\-\\s?[\\d]+\\.[\\d]{3}[1-9]$","- 78.8574"));
        System.out.println(Pattern.matches("^\\-\\s?[\\d]+\\.[\\d]{3}[1-9]$","-12.12345"));
        System.out.println("16");
        System.out.println(Pattern.matches("^[\\d]{2}/[\\d]{2}/[\\d]{4}$","12/01/2000"));
        System.out.println(Pattern.matches("^[\\d]{2}/[\\d]{2}/[\\d]{4}$","7/7/12"));
        System.out.println("17");
        System.out.println(Pattern.matches("^[\\w\\s]+$","Oscar Melero"));
        System.out.println(Pattern.matches("^[\\w\\s]+$","FIIUMMMM;"));
        System.out.println("18");
        System.out.println(Pattern.matches("^[\\w\\d-]+(?:\\.[\\w\\d-]+)*?@[\\w\\d-]+(?:\\.[\\w\\d-]+)*\\.[\\w]{2,}$","omelcam934@g.educaand.es"));
        System.out.println(Pattern.matches("^[\\w\\d-]+(?:\\.[\\w\\d-]+)*?@[\\w\\d-]+(?:\\.[\\w\\d-]+)*\\.[\\w]{2,}$","queno@no@no.es"));
        System.out.println("19");
        System.out.println(Pattern.matches("^@[\\w-]+$","@omelcam934_"));
        System.out.println(Pattern.matches("^@[\\w-]+$","twitter"));
        System.out.println("20");
        System.out.println(Pattern.matches("^97[89][\\d]{10}$","9781234567890"));
        System.out.println(Pattern.matches("^97[89][\\d]{10}$","1234567890123"));



    }


    public static void prueba(){
        String regex1 = "[^h-t]"; //a - h
        String regex2 = "[\\d&&[1-5]]";//2 - 6
        String regex3 = "[1-3[7-9]]";//3,7 - 5
        String regex4 = "[d-m[^i-v]]";//e - j
        String regex5 = "[2-7&&[^3-5]]";//2 - e
        String regex6 = "[a-hk-mt-v&&[\\d{3}b]]"; //no existe ninguna correcta, quiere que empiece por una letra pero a la vez empiece por 3 numeros
        String regex7 = "[\\D]\\s[\\w]{2}";
        String regex8 = "\\W{2}[\\d]{3}w[\\s][\\D]";
        String regex9 = "([^a-zA-Z]{3}\\d\\s[\\w]){2}";

        String regex10 = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";

        System.out.println(Pattern.matches(regex1,"a"));
        System.out.println(Pattern.matches(regex2,"2"));
        System.out.println(Pattern.matches(regex3,"3"));
        System.out.println(Pattern.matches(regex4,"e"));
        System.out.println(Pattern.matches(regex5,"2"));

        System.out.println(Pattern.matches(regex7,"s _t"));
        System.out.println(Pattern.matches(regex8,"*&123w a"));
        System.out.println(Pattern.matches(regex9,"*&/1 a/'/1 c"));

        System.out.println(Pattern.matches(regex10,"a@b.com"));
        System.out.println(Pattern.matches(regex10,"+++@+++.com"));
        System.out.println(Pattern.matches(regex10,"@b.com"));
        System.out.println(Pattern.matches(regex10,"a@b.c"));
    }
}
