import java.util.*;

interface ICarton {
    boolean tacharNumero(int numero);
    boolean hayLinea();
    boolean hayBingo();
}

public class JuegoDelBingo implements ICarton {
    private int[][] carton;
    private boolean[][] tachado;

    public JuegoDelBingo(int[][] carton) {
        if (!cartonValido(carton)) {
            throw new IllegalArgumentException("Cartón inválido.");
        }
        this.carton = carton;
        this.tachado = new boolean[3][9];
    }

    @Override
    public boolean tacharNumero(int numero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] == numero && !tachado[i][j]) {
                    tachado[i][j] = true;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hayLinea() {
        for (int i = 0; i < 3; i++) {
            int tachados = 0;
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] != 0 && tachado[i][j]) {
                    tachados++;
                }
            }
            if (tachados == 5) return true;
        }
        return false;
    }

    @Override
    public boolean hayBingo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] != 0 && !tachado[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean cartonValido(int[][] carton) {
        if (carton.length != 3 || carton[0].length != 9 ||
            carton[1].length != 9 || carton[2].length != 9) {
            return false;
        }

        Set<Integer> vistos = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            int numerosFila = 0;
            for (int j = 0; j < 9; j++) {
                int num = carton[i][j];
                if (num != 0) {
                    if (num < 1 || num > 90 || !vistos.add(num)) return false;
                    numerosFila++;
                }
                if (j > 0 && num != 0 && carton[i][j - 1] != 0 &&
                    carton[i][j] < carton[i][j - 1]) {
                    return false;
                }
            }
            if (numerosFila != 5) return false;
        }

        return true;
    }

    public void mostrarCarton() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] == 0) {
                    System.out.print(" -- ");
                } else {
                    String num = String.format("%2d", carton[i][j]);
                    System.out.print(tachado[i][j] ? "[" + num + "]" : " " + num + " ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] generarCartonAleatorio() {
        Random rand = new Random();
        int[][] carton = new int[3][9];
        List<Set<Integer>> columnas = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            int inicio = i * 10 + 1;
            int fin = (i == 8) ? 90 : inicio + 9;
            Set<Integer> col = new TreeSet<>();
            while (col.size() < 3) {
                col.add(rand.nextInt(fin - inicio + 1) + inicio);
            }
            columnas.add(col);
        }

        for (int j = 0; j < 9; j++) {
            Integer[] nums = columnas.get(j).toArray(new Integer[0]);
            Arrays.sort(nums);
            for (int i = 0; i < 3; i++) {
                carton[i][j] = nums[i];
            }
        }

        for (int i = 0; i < 3; i++) {
            List<Integer> indices = new ArrayList<>();
            for (int j = 0; j < 9; j++) indices.add(j);
            Collections.shuffle(indices);
            for (int k = 0; k < 4; k++) {
                carton[i][indices.get(k)] = 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] != 0) nums.add(carton[i][j]);
            }
            Collections.sort(nums);
            int idx = 0;
            for (int j = 0; j < 9; j++) {
                if (carton[i][j] != 0) carton[i][j] = nums.get(idx++);
            }
        }

        return carton;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres un cartón aleatorio? (s/n): ");
        String opcion = sc.nextLine().trim().toLowerCase();

        int[][] carton;
        if (opcion.equals("s")) {
            carton = generarCartonAleatorio();
        } else {
            carton = new int[][] {
                {0, 12, 0, 0, 43, 0, 60, 73, 85},
                {5, 0, 22, 34, 0, 55, 0, 78, 0},
                {9, 0, 0, 38, 45, 0, 69, 0, 90}
            };
        }

        if (!cartonValido(carton)) {
            System.out.println("Cartón inválido.");
            return;
        }

        JuegoDelBingo juego = new JuegoDelBingo(carton);
        boolean lineaCantada = false;

        while (true) {
            System.out.println("\nCartón actual:");
            juego.mostrarCarton();
            System.out.print("Introduce un número (1-90): ");
            int num = sc.nextInt();

            if (juego.tacharNumero(num)) {
                System.out.println("¡Tachado!");
                if (!lineaCantada && juego.hayLinea()) {
                    System.out.println("🎉 ¡LÍNEA!");
                    lineaCantada = true;
                } else if (juego.hayBingo()) {
                    System.out.println("🎉 ¡BINGO!");
                    break;
                }
            } else {
                System.out.println("Número no encontrado o ya tachado.");
            }
        }
        sc.close();
    }
}

