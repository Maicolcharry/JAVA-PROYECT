// Maicol Donovan Charry Snchez 
// codigo: 20242227242

import java.util.Scanner;

public class ventacomputadores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double precioporcomputadora = 500.0;

        System.out.print("Ingrese la cantidad de computadoras a comprar: ");
        int cantidad = scanner.nextInt();

        double totalcompra = cantidad * precioporcomputadora;
        double descuento = 0;

        if (cantidad < 5) {
            descuento = 0.10;
        }else if (cantidad < 10) {
            descuento = 0.20;
        } else {
            descuento = 0.40;
        }

        double montodescuento = totalcompra *descuento;
        double totalPagar = totalcompra - montodescuento;

        System.out.println("Total sin descuento: $" + totalcompra);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Monto de descuento: $" + montodescuento);
        System.out.println("Total a pagar: $" + totalPagar);

        scanner.close();
    }
    
}
