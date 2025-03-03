// Maicol Donovan Charry Snchez 
// codigo: 20242227242

import java.util.Scanner;
public class entidadbancaria {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el saldo actual de la empresa:");
        double saldoActual = scanner.nextDouble();

        double nuevoSaldo = saldoActual;
        double prestamo = 0;

        if (saldoActual< 0) {
            prestamo = 10000 - saldoActual;
            nuevoSaldo = 20000;
            
        }else if (saldoActual > 0 && saldoActual < 20000) {
            prestamo = 20000 - saldoActual;
            nuevoSaldo = 20000;
            
        }

        double mobiliario = 2000;
        double equipoComputo = 5000;

        double restante = nuevoSaldo - (equipoComputo + mobiliario);
       

        double insumos = restante / 2;
        double incentivos = restante / 2;

        
        System.out.println("\nResumen financiero:");
        System.out.println("Saldo actual: $" + saldoActual);
        
        if (prestamo > 0) {
            System.out.println("Préstamo solicitado: $" + prestamo);
        } else {
            System.out.println("No se necesita préstamo.");
        }

        System.out.println("Presupuesto total disponible: $" + nuevoSaldo);
        System.out.println("Presupuesto para equipo de cómputo: $" + equipoComputo);
        System.out.println("Presupuesto para mobiliario: $" + mobiliario);
        System.out.println("Presupuesto para insumos: $" + insumos);
        System.out.println("Presupuesto para incentivos al personal: $" + incentivos);
        
        scanner.close();
    }
}
