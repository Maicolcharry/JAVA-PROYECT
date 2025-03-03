// Maicol Donovan Charry Snchez 
// codigo: 20242227242

import java.util.Scanner;;
public class sevitecallantas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de llantas a comprar");
        int cantidad = scanner.nextInt();

        double precioporllanta;

        if (cantidad< 5) {
            precioporllanta= 100.0;
        }else if (cantidad <= 10) {
            precioporllanta = 75.0;
        } else {
            precioporllanta = 50.0;
        }

        double totalPagar = cantidad * precioporllanta;

        System.out.println("precio por llante: $" + precioporllanta);
        System.out.println("Total a pagar: $" + totalPagar);

        scanner.close();





    }
    
}
