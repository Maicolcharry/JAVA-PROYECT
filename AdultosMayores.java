// Maicol Donovan Charry Snchez 
// codigo: 20242227242


import java.util.Scanner;

public class AdultosMayores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese los datos de las 37 personas:");
        for (int i = 1; i <= 37; i++) {
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();

            if (edad > 85) {
                System.out.println("Adulto mayor registrado: " + nombre + " - " + edad + " años");
            }
        }
        
        scanner.close();
    }
}

