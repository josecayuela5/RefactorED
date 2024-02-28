package numerosprimos;

/**
 * Genera el conjunto de números primos desde 2 hasta un valor máximo especificado por el usuario.
 * @author Jose
 * @see <a href = "https://es.wikipedia.org/wiki/N%C3%BAmero_primo"> Numeros primos </a>
 */

public class Criba {

    /**
     * Array de booleanos en la que se van almacenando valores hasta max para determinar los números primos y no primos.
     */
    private static boolean[] esPrimo;

    /**
     * Si max se establece en 2 o superior genera un vector con los números primos hasta max. Si es menor devuelve un vector vacío.
     * @param max
     * Valor máximo hasta el cual se determinarán los números primos.
     * @return <ul>
     *     <li>Vector con los números primos hasta el valor máximo a partir del número 2.</li>
     *     <li>Vector vacío si el valor máximo se establece en 1 o inferior.</li>
     * </ul>
     */

    public static int[] generarPrimos(int max) {
        if (max >= 2) {
            esPrimo = new boolean[max];

            inicializarArray();
            cribarPrimos();
            int[] vectorPrimos = rellenarPrimos();

            return vectorPrimos;
        } else {
            int[] emptyArray = new int[0];

            return emptyArray;
        }
    }

    /**
     * Crea un array de la longitud adecuada, para posteriormente agregar paulatinamente los números primos.
     * @return
     * Vector con los números primos hasta max.
     */
    public static int[] rellenarPrimos() {
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

    /**
     * Cuenta cuantos valores "true" existen en el array "esPrimo".
     * @return
     * Valor entero con el número total de primos.
     */

    public static int contarPrimos() {
        int totalPrimos = 0;

        for (boolean b : esPrimo) {
            if (b) {
                totalPrimos++;
            }
        }

        return totalPrimos;
    }

    /**
     * Se van estableciendo valores "false" en la tabla "esPrimo" para aquellos números no primos, hasta llegar a un valor que sea superior a la raíz cuadrada del número máximo.
     * @see <a href = "https://es.wikipedia.org/wiki/Criba_de_Erat%C3%B3stenes">Criba de Erastótenes</a>
     */

    public static void cribarPrimos() {

        for (int i = 0; i < Math.sqrt(esPrimo.length); i++) {
            if (esPrimo[i]) {

                for (int j = 2 * i; j < esPrimo.length; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    /**
     * Inicializa los valores del array "esPrimo" con el valor booleano "true" a partir del número 2.
     */

    public static void inicializarArray() {

        for (int i = 2; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
    }
}