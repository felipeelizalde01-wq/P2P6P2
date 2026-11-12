package arreglos.tienda.interfaz;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString (String mensaje){
        String nombre;
        do {
            System.out.print(mensaje + " : ");
            nombre = sc.nextLine();
        }while(nombre==null || nombre.trim().isEmpty());
        return nombre;
    }

    public static int leerInt (String mensaje){
        int numero;
        do {
            System.out.print(mensaje + " : ");
            numero = Integer.parseInt(sc.nextLine());
        }while(numero <= 0);
        return numero;
    }

    public static double leerDouble (String mensaje){
        double numero;
        do {
            System.out.print(mensaje + " : ");
            numero = Double.parseDouble(sc.nextLine());
        }while(numero <= 0);
        return numero;
    }
}
