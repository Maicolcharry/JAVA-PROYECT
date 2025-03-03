// Maicol Donovan Charry Snchez 
// codigo: 20242227242

import java.util.Scanner;
public class Tiendamanzanas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el precio del reproductor de música: ");
        double precio = scanner.nextDouble();
        
        System.out.println("ingrese la marca del reproductor:");
        scanner.nextLine ();
        String marca = scanner.nextLine();

        double descuento = 0;

        if (precio >= 500) {
            descuento +=0.10;
        }

        if (marca.equalsIgnoreCase("NOSY")) {
            descuento += 0.05;
        }

        double preciocondescuento = precio;
        if (descuento > 0) {
            preciocondescuento = precio - ( precio * descuento);

            double iva = preciocondescuento * 0.19;
            double totalPagar = preciocondescuento + iva;

            System.out.println("precio original: $" + precio);

            if (descuento > 0) {
                System.out.println("Descuento aplicado:" + (descuento * 100) +"%");
                System.out.println(" Precio con descuento: $" + preciocondescuento);
                
            }else{
                System.out.println("No se aplicaron descuentos.");
            }

            System.out.println("IVA (19%): $" + iva);
            System.out.println("Total a pagar : $" + totalPagar);

            scanner.close();
            
        }


    }
    

}
