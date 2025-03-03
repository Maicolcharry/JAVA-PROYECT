// Maicol Donovan Charry Snchez 
// codigo: 20242227242

import java.util.Scanner;

public class heladeria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantlimon = 0, cantnuez = 0, cantlulo = 0, cantfresa = 0, cantcrema = 0;
        double ventalimon = 0, ventanuez = 0, ventalulo = 0, ventafresa = 0, ventacrema = 0, ventaTotal = 0;
        boolean continua = true;

        while (continua) {
            boolean contvta = true;
            while (contvta) {
                System.out.println("*** Sabores ***");
                System.out.println("1. Limón ($2500)");
                System.out.println("2. Nuez ($2800)");
                System.out.println("3. Lulo ($2600)");
                System.out.println("4. Fresa ($2000)");
                System.out.println("5. Crema ($3000)");
                System.out.print("Seleccione el sabor: ");
                int sabor = sc.nextInt();

                System.out.print("Cantidad vendida: ");
                int cantidad = sc.nextInt();

                switch (sabor) {
                    case 1:
                        cantlimon += cantidad;
                        ventalimon += cantidad * 2500;
                        break;
                    case 2:
                        cantnuez += cantidad;
                        ventanuez += cantidad * 2800;
                        break;
                    case 3:
                        cantlulo += cantidad;
                        ventalulo += cantidad * 2600;
                        break;
                    case 4:
                        cantfresa += cantidad;
                        ventafresa += cantidad * 2000;
                        break;
                    case 5:
                        cantcrema += cantidad;
                        ventacrema += cantidad * 3000;
                        break;
                    default:
                        System.out.println("¡Error! Sabor no identificado.");
                }

                System.out.print("¿Desea incluir otro sabor en la factura? (S/N): ");
                sc.nextLine(); 
                String rto = sc.nextLine();
                contvta = rto.equalsIgnoreCase("S");
            }

            System.out.print("¿Desea procesar otra factura? (S/N): ");
            String rta = sc.nextLine();
            continua = rta.equalsIgnoreCase("S");
        }


        ventaTotal = ventalimon + ventanuez + ventalulo + ventafresa + ventacrema;


        System.out.println("\n*** Reporte de Ventas ***");
        System.out.println("Sabor       Cantidad     Valor");
        System.out.println("---------------------------------");
        System.out.printf("Limón       %5d      $%8.2f%n", cantlimon, ventalimon);
        System.out.printf("Nuez        %5d      $%8.2f%n", cantnuez, ventanuez);
        System.out.printf("Lulo        %5d      $%8.2f%n", cantlulo, ventalulo);
        System.out.printf("Fresa       %5d      $%8.2f%n", cantfresa, ventafresa);
        System.out.printf("Crema       %5d      $%8.2f%n", cantcrema, ventacrema);
        System.out.println("---------------------------------");
        System.out.printf("Total ventas:     $%8.2f%n", ventaTotal);

        sc.close();
    }
}
