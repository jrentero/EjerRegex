import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicios3 {

    public static void main(String[] args) throws FileNotFoundException {
        TestConstitucion.main(args);
    }

}

class PalabraLeida{

    private String palabra;

    public PalabraLeida(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int NumeroDeLetras(){
        return palabra.length();
    }

    public boolean EmpiezaPorVocal(){
        return Pattern.matches("^[aeiouAEIOU].*$",palabra);
    }

    public boolean AcabaEnVocal(){
        return Pattern.matches("^.*[aeiouAEIOU]$",palabra);
    }

    public int NumeroDeVocales(){
        Pattern pat = Pattern.compile("[aeiouAEIOU]");
        Matcher mat = pat.matcher(this.palabra);
        int n = 0;
        while (mat.find())
            n++;
        return n;
    }

    public boolean ContieneH(){
        return Pattern.matches("^.*[hH].*$",palabra);
    }

    public boolean EsUnPalindromo(){
        StringBuilder s = new StringBuilder(palabra);
        return palabra.equals(s.reverse());
    }

    public boolean SonIguales(String palabra){
        return palabra.toLowerCase().equals(this.palabra.toLowerCase());
    }
}

class TestPalabraLeida{

    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        PalabraLeida pal;
        do {
            System.out.println("Introduce una palabra");
            pal = new PalabraLeida(in.nextLine());
            System.out.println("Numero de letras "+pal.NumeroDeLetras());
            System.out.println("Empieza por vocal "+pal.EmpiezaPorVocal());
            System.out.println("Acaba en vocal "+pal.AcabaEnVocal());
            System.out.println("Numero de vocales "+pal.NumeroDeVocales());
            System.out.println("Contiene H "+pal.ContieneH());
            System.out.println("Es un Palindromo "+pal.EsUnPalindromo());
            System.out.println("Introduce una segunda string para ver si son iguales");
            System.out.println("Son Iguales "+pal.SonIguales(in.nextLine()));

        }while (!pal.getPalabra().equals("salir"));
    }
}

class ClaveSegura{

    private String clave;

    public ClaveSegura(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean esClaveSegura(){
        return clave.length()>=8&&clave.matches(".*[a-z].*")&&clave.matches(".*[A-Z].*")&&clave.matches(".*[\\d].*")&&clave.matches(".*[^\\d\\w].*");
    }
}

class TestClaveSegura{

    private static final String FUENTE_CARACTERES = "aAbBcCdDeEfFgGhHiIjJkKlLm-MnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789¿?()=@.:,!¡&{}";
    private static final Random r = new Random();
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            int longitud = r.nextInt(FUENTE_CARACTERES.length());
            StringBuilder pass = new StringBuilder();
            for (int j = 0; j < longitud; j++) {
                pass.append(FUENTE_CARACTERES.charAt(r.nextInt(FUENTE_CARACTERES.length())));
            }
            ClaveSegura clave = new ClaveSegura(pass.toString());
            System.out.println(clave.getClave()+" -> "+ clave.esClaveSegura());
            }
    }
}

class Ej3{
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        while (in.hasNext())
            nombres.add(in.nextLine());

        if(args.length!=0){
            System.out.println(args[0].toLowerCase()+" esta en la lista = "+nombres.contains(args[0].toLowerCase()));
            return;
        }

        System.out.println("Leidas "+nombres.size()+" palabras");
        ArrayList<String> nombresEmpiezanA = new ArrayList<>();
        ArrayList<String> nombresNoTerminanVocal = new ArrayList<>();
        for (String nombre: nombres) {
            if(nombre.matches("^[aA].*"))
                nombresEmpiezanA.add(nombre);
            if(nombre.matches(".*[^aeiouAEIOU]$"))
                nombresNoTerminanVocal.add(nombre);
        }
        System.out.println("Nombres que empiezan por A");
        System.out.println(nombresEmpiezanA);
        System.out.println("\n\n\n\n\nNombres que no terminan por vocal");
        System.out.println(nombresNoTerminanVocal);

        ArrayList<String> menos = new ArrayList<>();
        ArrayList<String> mas = new ArrayList<>();
        menos.add(nombres.get(0));
        mas.add(nombres.get(0));

        for (String nombre: nombres) {
            if(nombre.length()<menos.get(0).length()) {
                menos = new ArrayList<>();
                menos.add(nombre);
            }else if(nombre.length()==menos.get(0).length())
                menos.add(nombre);

            if(nombre.length()>mas.get(0).length()) {
                mas = new ArrayList<>();
                mas.add(nombre);
            }else if(nombre.length()==mas.get(0).length())
                mas.add(nombre);
        }
        System.out.println("\n\n\n\n\nNombres mas pequeños");
        System.out.println(menos);
        System.out.println("\n\n\n\n\nNombres mas grandes");
        System.out.println(mas);

    }

}

class Constitucion{
    public static final String[] ARTICULOS_DETERMINADOS = {"el","la","los","las"};
    public static final String[] ARTICULOS_INDETERMINADOS = {"un","unos","una","unas"};
    public static final String[] PREPOSICIONES = {"a","ante","bajo","con","contra","de"
            ,"desde","en","entre","hacia","hasta","durante","mediante","para","por","pro"
            ,"sin","so","sobre","tras","versus","via"};

    public static int numeroPalabras(String frase){
        int n = 0;
        Matcher mat = Pattern.compile("[\\w]+").matcher(frase);
        while (mat.find())
            n++;
        return n;
    }

    public static int numeroPreoposiciones(String frase){
        int n = 0;
        String[] palabras = frase.split("\\s");
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < PREPOSICIONES.length; j++) {
                if(PREPOSICIONES[j].equals(palabras[i]))
                    n++;
            }
        }
        return n;
    }

    public static int numeroArticulosDeterminados(String frase){
        int n = 0;
        String[] palabras = frase.split("\\s");
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < ARTICULOS_DETERMINADOS.length; j++) {
                if(ARTICULOS_DETERMINADOS[j].equals(palabras[i]))
                    n++;
            }
        }
        return n;
    }

    public static int numeroArticulosIndeterminados(String frase){
        int n = 0;
        String[] palabras = frase.split("\\s");
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < ARTICULOS_INDETERMINADOS.length; j++) {
                if(ARTICULOS_INDETERMINADOS[j].equals(palabras[i]))
                    n++;
            }
        }
        return n;
    }

    public static String devolverMayuscula(int comienzo, int fin, String frase){
        return frase.substring(comienzo,fin-comienzo).toUpperCase();
    }

}

class TestConstitucion{


    public static void main(String[] args) throws FileNotFoundException {
        Random r = new Random();
        ArrayList<String> palabras = new ArrayList<>();
        File file = new File("constitucion.txt");
        Scanner lector = new Scanner(file);
        while (lector.hasNext())
            palabras.add(lector.next());
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            p.append(palabras.get(r.nextInt(palabras.size()))+" ");
        }

        System.out.println("numero de palabras "+Constitucion.numeroPalabras(p.toString()));
        System.out.println("numero de preposiciones "+Constitucion.numeroPreoposiciones(p.toString()));
        System.out.println("numero de articulos determinados "+Constitucion.numeroArticulosDeterminados(p.toString()));
        System.out.println("numero de articulos indeterminados "+Constitucion.numeroArticulosIndeterminados(p.toString()));
        System.out.println("primeras 10 a mayusculas " +Constitucion.devolverMayuscula(0,10,p.toString()));

    }

}