// Maicol Donovan Charry Snchez 
// codigo: 20242227242


import java.util.Scanner;

public class temperaturadiaria{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        
        for (String dia : dias) {
            System.out.print("Ingrese la temperatura promedio del " + dia + ": ");
            int temperatura = scanner.nextInt();

            String mensaje;
            if (temperatura <= 0) mensaje = "Congelante";
            else if (temperatura <= 10) mensaje = "Muy frío";
            else if (temperatura <= 20) mensaje = "Frío";
            else if (temperatura <= 24) mensaje = "Templado";
            else if (temperatura <= 29) mensaje = "Agradable";
            else if (temperatura <= 35) mensaje = "Caliente";
            else mensaje = "Muy caliente";

            System.out.println(dia + ": " + mensaje);
        }
        
        scanner.close();
    }
}

