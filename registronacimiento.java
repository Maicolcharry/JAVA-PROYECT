// Maicol Donovan Charry Snchez 
// codigo: 20242227242

import java.util.Scanner;
public class registronacimiento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar la cantidad de nacimientos
        System.out.print("Ingrese la cantidad de bebés nacidos: ");
        int n = scanner.nextInt();
        
        int contadorM = 0, contadorF = 0;
        
        for (int i = 1; i <= n; i++) {
            System.out.print("Ingrese el nombre del bebé #" + i + ": ");
            String nombre = scanner.next();
            
            char sexo;
            do {
                System.out.print("Ingrese el sexo del bebé (M/F): ");
                sexo = scanner.next().toUpperCase().charAt(0);
            } while (sexo != 'M' && sexo != 'F'); // Validación
            
            if (sexo == 'M') {
                contadorM++;
            } else {
                contadorF++;
            }
        }
        
        // Mostrar resultados
        System.out.println("\nCantidad de bebés masculinos: " + contadorM);
        System.out.println("Cantidad de bebés femeninos: " + contadorF);
        
        scanner.close();

    }
}

    
