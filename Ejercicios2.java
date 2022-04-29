import java.util.Scanner;
import java.util.regex.Pattern;

public class Ejercicios2 {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Introduce ej");
            opcion = Integer.parseInt(in.nextLine());
            switch (opcion){
                case 3 -> ej3();
                case 4 -> ej4();
                case 5 -> ej5();
            }
        }while (opcion!=0);
    }

    private static void ej3(){
        System.out.println("Introduce un numero español");
        String num = in.nextLine();
        System.out.println(Pattern.matches("^\\s*(?:\\+\\s?34)?\\s*\\d{9}$",num));
    }

    private static void ej4(){
        System.out.println("Introduce una contraseña");
        String num = in.nextLine();
        System.out.println(Pattern.matches("^[\\d\\w]{5,7}[A-Z]\\d[^\\d\\w]$",num));
    }

    private static void ej5(){
        System.out.println("Introduce un nombre");
        String num = in.nextLine();
        System.out.println(Pattern.matches("^[\\w]{1,20}$",num));
        System.out.println("Introduce tus apellidos, separados por coma");
        num = in.nextLine();
        System.out.println(Pattern.matches("^[\\w]{1,20},\\s*[\\w]{1,20}$",num));
        System.out.println("Telefono");
        num = in.nextLine();
        System.out.println(Pattern.matches("^\\s*(?:\\+\\s?34)?\\s*\\d{9}$",num));
        System.out.println("Correo");
        num = in.nextLine();
        System.out.println(Pattern.matches("[\\w\\d-]+(?:\\.[\\w\\d-]+)*?@[\\w\\d-]+(?:\\.[\\w\\d-]+)*\\.[\\w]{2,}$",num));
        System.out.println("Edad");
        num = in.nextLine();
        System.out.println(Pattern.matches("^[\\d]{1,3}$",num));
        System.out.println("Introduce contraseña");
        num = in.nextLine();
        System.out.println(Pattern.matches("^[\\d\\w]{5,7}[A-Z]\\d[^\\d\\w]$",num));
    }
}
