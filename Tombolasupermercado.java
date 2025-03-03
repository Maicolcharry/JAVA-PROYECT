// Maicol Donovan Charry Snchez 
// codigo: 20242227242

import java.util.Scanner;
public class Tombolasupermercado {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su genero (H para hombre, M para mujer):");
        char genero = scanner.next().toUpperCase().charAt(0);
        if (genero != 'H' && genero != 'M') {
            System.out.println("Opción inválida. Intente de nuevo.");
            return;
        }
        
        System.out.print("Ingrese el número de la bolita (1-5): ");
        int bolita = scanner.nextInt();
        
        String premio = "";
        switch (genero) {
            case 'H':
                switch (bolita) {
                    case 1: premio = "Desodorante"; break;
                    case 2: premio = "Six-Pack de cerveza"; break;
                    case 3: premio = "Camiseta"; break;
                    case 4: premio = "Pantaloneta"; break;
                    case 5: premio = "Sudadera"; break;
                    default: premio = "Número de bolita inválido."; break;
                }
                break;
            case 'M':
                switch (bolita) {
                    case 1: premio = "Loción"; break;
                    case 2: premio = "Bikini"; break;
                    case 3: premio = "Crema para la cara"; break;
                    case 4: premio = "Plancha para el cabello"; break;
                    case 5: premio = "Esmalte de uñas"; break;
                    default: premio = "Número de bolita inválido."; break;
                }
                break;
        }

        System.out.println("¡Felicidades! Su premio es: " + premio);
        
        scanner.close();

    


        }
    }
    