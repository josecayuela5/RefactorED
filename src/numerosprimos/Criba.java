package numerosprimos;

public class Criba {
    private static boolean[] esPrimo;

    public static int[] generarPrimos(int max) {
        if (max >= 2) {
            esPrimo = new boolean[max];

            inicializarArray();
            cribarPrimos();
            int[] vectorPrimos = rellenarPrimos();

            return vectorPrimos;
        } else {
            int[] emptyArray=new int[0];

            return emptyArray;
        }
    }

    private static int[] rellenarPrimos() {
        int totalPrimos = contarPrimos();
        int[] primos = new int[totalPrimos];
        int insertionIndex = 0;

        for (int i = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                primos[insertionIndex++] = i;
            }
        }

        return primos;
    }

    private static int contarPrimos() {
        int totalPrimos = 0;

        for (boolean b : esPrimo) {
            if (b) {
                totalPrimos++;
            }
        }

        return totalPrimos;
    }

    private static void cribarPrimos() {

        for (int i = 0; i < Math.sqrt(esPrimo.length); i++) {
            if (esPrimo[i]) {

                for (int j = 2 * i; j < esPrimo.length; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    private static void inicializarArray() {

        for (int i = 2; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
    }
}