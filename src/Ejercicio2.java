import java.util.Scanner;

public class Ejercicio2 {

    /* PRUEBAS
     * 0 veces : num = 0 / res-esperado= Hay un total de 0 pares y 0 impares / res = Hay un total de 0 pares y 0 impares
     * 1 vez : num = 1  / res-esperado = Hay un total de 0 pares y 1 impares / res = Hay un total de 0 pares y 1 impares
     * Varias veces : num = 4455 / res-esperado = Hay un total de 2 pares y 2 impares / res= Hay un total de 2 pares y 2 impares
     */
    public static void main(String[] args) {
        // Creamos variables. Tenemos contadores de pares e impares, dos variables
        // auxiliares para cada bucle en la que guardaremos num, la variable cifra que
        // se ira sobreescribiendo y la variable cifras que será el contador
        int num, contadorpares = 0, contadorimpares = 0, aux, aux2, cifra = 0, cifras = 0;

        // Creamos escaner para leer datos
        Scanner key = new Scanner(System.in);

        // Pedimos variables al usuario
        System.out.println("Deme un número: ");
        num = key.nextInt();
        // Guardamos el valor en dos variables diferentes.
        aux = num;
        aux2 = num;

        // Se ejecutará mientras aux2 sea mayor que 0
        while (aux2 > 0) {
            // Por cada vuelta el contador se irá sumando para saber las cifras que tenemos
            cifras++;
            // Al ir diviendo vamos quitando cifras al número
            aux2 = aux2 / 10;

        } // Mientras j sea menor que cifras empezamos en 1 y vamos sumando
        for (int j = 1; j <= cifras; j++) {
            // Cogemos la ultima cifra del número haciendo módulo 10
            cifra = aux % 10;
            // Con este if veremos si el número es par si su resto da 0 al dividirlo por 2,
            // y se lo sumamos al contador pares, en caso de que no se lo sumamos a los
            // impares
            if (cifra % 2 == 0) {
                contadorpares++;
            } else {
                contadorimpares++;
            }
            // Por cada vuelta le vamos quitando a el número total una cifra.
            aux = aux / 10;

        }
        // Imprimimos resultado
        System.out.println("Hay un total de " + contadorpares + " pares y " + contadorimpares + " impares");
    }
}
