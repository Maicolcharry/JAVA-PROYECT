import java.util.Scanner;
// Maicol Donovan Charry Sanchez
// 20242227242
public class supermercado {

    private static final int FILAS = 50; 
    private static final int COLUMNAS = 6; 
    private static final double PRECIO_ALTO = 100.0; 
    public static void main(String[] args) {

        // Crear la matriz para almacenar los precios de los productos en cada mes
        double[][] tondercar = new double[FILAS][COLUMNAS];
        
        // Crear el vector para almacenar los precios máximos de cada producto
        double[] tondercarMaximos = new double[FILAS];
        
        Scanner scanner = new Scanner(System.in);
        
        // Preguntar si los precios deben ser ingresados manualmente o generados aleatoriamente
        System.out.println("¿Deseas ingresar los precios manualmente o generarlos aleatoriamente?");
        System.out.println("Escribe 'manual' para ingresar los precios o 'aleatorio' para generarlos aleatoriamente:");
        String opcion = scanner.nextLine();
        
        if (opcion.equalsIgnoreCase("manual")) {
            llenarTondercarManual(tondercar); // Método para ingresar los precios manualmente
        } else {
            llenarTondercarAleatorio(tondercar); // Método para generar precios aleatorios
        }
        
        // Llenar el vector con los precios máximos de cada producto
        tondercarMaximos = obtenerTondercarMaximos(tondercar);
        
        // Calcular el promedio general de los precios
        double promedioGeneral = calcularTondercarPromedio(tondercar);
        
        // Mostrar el promedio general
        System.out.println("Promedio general de precios: " + promedioGeneral);
        
    
        
        // Mostrar productos y meses donde el precio es mayor al promedio
        System.out.println("\nProductos y meses con precios mayores que el promedio general:");
        mostrarTondercarPreciosMayoresQuePromedio(tondercar, promedioGeneral);
        
        // Mostrar productos con promedio mayor al promedio general
        System.out.println("\nProductos cuyo promedio es mayor que el promedio general:");
        mostrarTondercarProductosConPromedioMayorQuePromedio(tondercar, promedioGeneral);
    }

    // Método que llena la matriz con precios ingresados manualmente
    private static void llenarTondercarManual(double[][] tondercar) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < FILAS; i++) {
            System.out.println("Ingrese los precios del Producto " + (i + 1) + " para los 6 meses:");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print("Precio del mes " + (j + 1) + ": ");
                tondercar[i][j] = scanner.nextDouble();
            }
        }
    }

    // Método que llena la matriz con precios aleatorios entre 50 y 150
    private static void llenarTondercarAleatorio(double[][] tondercar) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tondercar[i][j] = 50 + Math.random() * 100; // Precio entre 50 y 150
            }
        }
    }

    // Método que obtiene el precio máximo de cada producto
    private static double[] obtenerTondercarMaximos(double[][] tondercar) {
        double[] tondercarMaximos = new double[FILAS];

        for (int i = 0; i < FILAS; i++) {
            double max = 0;
            for (int j = 0; j < COLUMNAS; j++) {
                if (tondercar[i][j] > max) {
                    max = tondercar[i][j];
                }
            }
            tondercarMaximos[i] = max;
        }

        return tondercarMaximos;
    }

    // Método que calcula el promedio general de los precios
    private static double calcularTondercarPromedio(double[][] tondercar) {
        double suma = 0;
        int cantidad = 0;

        // Recorre todos los productos y meses para calcular la suma total de los precios
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                suma += tondercar[i][j];
                cantidad++;
            }
        }

        // Retorna el promedio general
        return suma / cantidad;
    }

    // Método estático que determina si un precio es considerado alto
    public static boolean esTondercarAlto(double precio) {
        return precio >= PRECIO_ALTO;
    }

    // Método que muestra los productos cuyo precio máximo es mayor que el promedio general
    private static void mostrarTondercarConPrecioMayorQuePromedio(double[] tondercarMaximos, double promedioGeneral) {
        for (int i = 0; i < FILAS; i++) {
            if (tondercarMaximos[i] > promedioGeneral) {
                System.out.println("Producto " + (i + 1) + " - Precio máximo: " + tondercarMaximos[i]);
            }
        }
    }

    // Método que muestra los productos y los meses donde el precio es mayor al promedio general
    private static void mostrarTondercarPreciosMayoresQuePromedio(double[][] tondercar, double promedioGeneral) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tondercar[i][j] > promedioGeneral) {
                    System.out.println("Producto " + (i + 1) + " - Mes " + (j + 1) + " - Precio: " + tondercar[i][j]);
                }
            }
        }
    }

    // Método que muestra los productos cuyo promedio es mayor que el promedio general
    private static void mostrarTondercarProductosConPromedioMayorQuePromedio(double[][] tondercar, double promedioGeneral) {
        for (int i = 0; i < FILAS; i++) {
            double suma = 0;
            for (int j = 0; j < COLUMNAS; j++) {
                suma += tondercar[i][j];
            }
            double promedioProducto = suma / COLUMNAS;

            if (promedioProducto > promedioGeneral) {
                System.out.println("Producto " + (i + 1) + " - Promedio: " + promedioProducto);
            }
        }
    }
}
