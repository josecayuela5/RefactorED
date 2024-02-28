package numerosprimos;

import java.util.Scanner;

/**
 * Clase principal, ejecuta el programa.
 * @author Jose
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes: ");
        int dato = sc.nextInt();
        int[] vector = new int[dato];

        System.out.println("\nVector inicial hasta : " + dato);

        for (int i = 0; i < vector.length; i++) {
            separarEnFilas(i);
            int numero = i + 1;
            System.out.print(numero + "\t");
        }

        vector = Criba.generarPrimos(dato);
        System.out.println("\nVector de primos hasta: " + dato);

        for (int i = 0; i < vector.length; i++) {
            separarEnFilas(i);
            int numeroPrimo=vector[i];
            System.out.print(numeroPrimo + "\t");
        }
    }

    /**
     * Cada 10 valores mostrados por consola inserta un salto de línea
     */
    public static void separarEnFilas(int i) {
        if (i % 10 == 0) System.out.println("\b");
    }
}
