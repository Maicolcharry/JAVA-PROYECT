// Maicol Donovan Charry Snchez 
// codigo: 20242227242

import java.util.Scanner;
public class seleccioncarro {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("Seleccione el tipo de carro:");
        System.out.println("1. Auto");
        System.out.println("2. SUV");
        System.out.println("3. Camioneta");
        System.out.print("Opción: ");
        int tipoCarro = scanner.nextInt();
        
        String carroSeleccionado = "";
        
        switch (tipoCarro) {
            case 1:
                carroSeleccionado = "Auto";
                break;
            case 2:
                carroSeleccionado = "SUV";
                break;
            case 3:
                carroSeleccionado = "Camioneta";
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        System.out.println("Seleccione el color:");
        System.out.println("1. Negro");
        System.out.println("2. Blanco");
        System.out.println("3. Rojo");
        System.out.print("Opción: ");
        int colorCarro = scanner.nextInt();

        String colorSeleccionado = "";
        
        switch (colorCarro) {
            case 1:
                colorSeleccionado = "Negro";
                break;
            case 2:
                colorSeleccionado = "Blanco";
                break;
            case 3:
                colorSeleccionado = "Rojo";
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }


        System.out.println("Ha seleccionado un " + carroSeleccionado + " de color " + colorSeleccionado + ".");
        
        scanner.close();


     }

    }
    