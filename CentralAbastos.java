//MaicolDonovan Charry Sanchez
//20242227242
//Daniel Mauricio Rojas
//20242226977

import java.util.Scanner;
import java.util.Random;

public class CentralAbastos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int maxVehiculos = 100;
        double[][] datos = new double[maxVehiculos][6];
        int contadorVehiculos = 0;
        boolean continuar = true;

        System.out.println("¿Desea ingresar los datos manualmente o generar datos aleatorios? (M/A): ");
        String modo = sc.next().toUpperCase();

        if (modo.equals("A")) {
            for (int i = 0; i < maxVehiculos; i++) {
                int tipoServicio = rand.nextInt(2) + 1;
                double tipoProducto = (tipoServicio == 2) ? rand.nextInt(2) + 1 : 0;
                double pesoTransportado = (tipoServicio == 2) ? rand.nextDouble() * 20 : 0;
                double tiempoPermanencia = (tipoServicio == 1) ? rand.nextInt(10) + 1 : 0;
                double largoCamion = (tipoServicio == 1) ? rand.nextDouble() * 6 : 0;
                double costoParqueadero = calcularCosto(tipoServicio, tipoProducto, pesoTransportado, tiempoPermanencia, largoCamion);

                datos[i][0] = tipoServicio;
                datos[i][1] = tipoProducto;
                datos[i][2] = pesoTransportado;
                datos[i][3] = tiempoPermanencia;
                datos[i][4] = largoCamion;
                datos[i][5] = costoParqueadero;
                contadorVehiculos++;
            }
            continuar = false;
        }

        while (continuar && contadorVehiculos < maxVehiculos) {
            int tipoServicio = 0;
            while (tipoServicio != 1 && tipoServicio != 2) {
                System.out.println("Ingrese el tipo de servicio (1. Cargue / 2. Descargue): ");
                tipoServicio = sc.nextInt();
                if (tipoServicio != 1 && tipoServicio != 2) {
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            }

            double tipoProducto = 0, pesoTransportado = 0, tiempoPermanencia = 0, largoCamion = 0;

            if (tipoServicio == 2) {
                while (tipoProducto != 1 && tipoProducto != 2) {
                    System.out.println("Ingrese el tipo de producto (1. Perecedero / 2. No Perecedero): ");
                    tipoProducto = sc.nextInt();
                    if (tipoProducto != 1 && tipoProducto != 2) {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }
                }
                System.out.println("Ingrese el peso transportado en toneladas: ");
                pesoTransportado = sc.nextDouble();
            } else {
                System.out.println("Ingrese el tiempo de permanencia en horas: ");
                tiempoPermanencia = sc.nextDouble();
                System.out.println("Ingrese el largo del camión en metros: ");
                largoCamion = sc.nextDouble();
            }

            double costoParqueadero = calcularCosto(tipoServicio, tipoProducto, pesoTransportado, tiempoPermanencia, largoCamion);

            datos[contadorVehiculos][0] = tipoServicio;
            datos[contadorVehiculos][1] = tipoProducto;
            datos[contadorVehiculos][2] = pesoTransportado;
            datos[contadorVehiculos][3] = tiempoPermanencia;
            datos[contadorVehiculos][4] = largoCamion;
            datos[contadorVehiculos][5] = costoParqueadero;
            contadorVehiculos++;

            System.out.println("¿Desea ingresar otro vehículo? (S/N): ");
            String respuesta = sc.next().toUpperCase();
            if (respuesta.equals("N")) {
                continuar = false;
            }
        }

        imprimirInforme(datos, contadorVehiculos);
    }

    public static double calcularCosto(int tipoServicio, double tipoProducto, double pesoTransportado, double tiempoPermanencia, double largoCamion) {
        double costoParqueadero = 0;
        if (tipoServicio == 2) {
            if (tipoProducto == 1) {
                costoParqueadero = (pesoTransportado < 8) ? pesoTransportado * 15000 : pesoTransportado * 9000;
            } else {
                costoParqueadero = (pesoTransportado < 10) ? 60000 : 60000 + (pesoTransportado - 10) * 7000;
            }
        } else {
            if (tiempoPermanencia > 2) {
                costoParqueadero = (tiempoPermanencia - 2) * 4000;
                if (largoCamion > 4) {
                    costoParqueadero *= 1.25;
                }
            }
        }
        return costoParqueadero;
    }

    public static void imprimirInforme(double[][] datos, int contadorVehiculos) {
        System.out.println("\n\nResumen de vehículos en tabla:\n");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Tipo Servicio", "Tipo Producto", "Peso (Ton)", "Tiempo (Hrs)", "Largo (M) ", "Costo ($)");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < contadorVehiculos; i++) {
            System.out.printf("%-15.0f %-15.0f %-15.2f %-15.2f %-15.2f %-15.2f\n",
                    datos[i][0], datos[i][1], datos[i][2], datos[i][3], datos[i][4], datos[i][5]);
        }
    }
}
