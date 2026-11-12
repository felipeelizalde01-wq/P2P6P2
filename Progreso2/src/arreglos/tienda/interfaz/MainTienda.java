package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;
        tienda.inicializarDatos();
        do{
            menu();
            opc = Validacion.leerInt("Ingrese una opción");
            switch (opc){
                case 1:{
                    ingresarJuego();
                }break;
                case 2:{
                    imprimirJuegos();
                }break;
                case 3:{
                    buscarJuegos();
                }break;
                case 4:{
                    comprar();
                }break;
                case 5:{
                        vender();
                }break;
                case 6:{
                        juegoMasVendido();
                }break;
                case 7:{

                }break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(opc != 7);
    }
    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuego(){
        System.out.println("*******Ingreso de datos********");
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco");
        String categoria = Validacion.leerString("Ingrese la categoria, no puede ser nulo ni blanco");
        int tamanio = Validacion.leerInt("Ingrese el tamaño, no puede ser menor a 0 ni 0");
        double precio = Validacion.leerInt("Ingrese el precio, no puede ser menor a 0 ni 0");
        int licenciasDisponibles = Validacion.leerInt("Ingrese el stock inicial, no puede ser menor a 0 ni 0");

        if(tienda.agregarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null,"Juego ingresado con éxito");
        }else{
            JOptionPane.showMessageDialog(null,"No fue posible agregar el juego");
        }
    }

    public static void imprimirJuegos(){
        Juego juegos[] = tienda.getJuegos();
        for(Juego j : juegos){
            if(j != null){
                System.out.println(j);
            }else{
                System.out.println("No hay más juegos a mostrar");
                return;
            }
        }
    }

    public static void buscarJuegos(){
        String juegoBuscado = Validacion.leerString("Ingrese el juego a buscar");
        Juego juegoEncontrado = tienda.buscarJuego(juegoBuscado);
        if (juegoEncontrado != null){
            System.out.println("Juego econtrado exitosamente");
            System.out.println(juegoEncontrado);
        }
        else{
            System.out.println("No se encontró el juego");
        }

    }

    public static void comprar(){
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco");
        int cantidad = Validacion.leerInt("Ingrese la cantidad, no puede ser 0 ni menor a 0");
        boolean compraExitosa = tienda.comprar(nombre, cantidad);
        if(!compraExitosa){
            System.out.println("No fue posible realizar la compra");
        }else{
            System.out.println("Se han comprado " +cantidad+ " licencias del juego " + nombre);
        }
    }


    public static void vender(){
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco");
        int cantidad = Validacion.leerInt("Ingrese la cantidad, no puede ser 0 ni menor a 0");
        double totalVenta = tienda.vender(nombre,cantidad);
        if( totalVenta == 0){
            System.out.println("No fue posible realizar la venta");
        }else{
            System.out.println("Usted ha vendido " +cantidad+ " licenciad del juego " + nombre);
            System.out.println("Valor a pagar: "+totalVenta);
        }
    }

    public static void juegoMasVendido(){
        String juegoMV = tienda.juegoMasVendido();
        Juego juegoEncontrado = tienda.buscarJuego(juegoMV);
        System.out.println("El juego mas vendido es: "+juegoMV+" Con "+juegoEncontrado.getLicenciasVendidas()+" Licencias vendidas");
    }


}
