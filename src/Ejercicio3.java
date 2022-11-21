import java.util.Scanner;

// PRUEBAS
/* 0 veces : nombre = 0 / res-esperado = Los valores no son correctos / res = Los valores no son correctos 
 * 1 vez : nombre = Yerai, notapractica = 2, notaproblemas = 5, teoria = 4 
 * Segunda vuelta: nombre = 0 opcion = 3 / res-esperado = La media de todos los alumnos es 4.300000000000001 / res La media de todos los alumnos es 4.300000000000001
 * Varias veces : nombre = Yerai, notapractica = 2, notaproblemas = 5, teoria = 4
 * Segunda vuelta: nombre = Juan, notapractica = 7, notaproblemas = 7, teoria = 5
 * Tercera vuelta: nombre = Ibai, notapractica = 8, notaproblemas = 9, teoria = 7 
 * Cuarta vuelta: nombre = 0, opcion = 2
 * Res esperado = Su nombre es Yerai y su nota es 4.300000000000001 / res = Su nombre es Yerai y su nota es 4.300000000000001
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        // Creamos variables que pediremos al usuario
        String nombre = "";
        int notapractica, notaproblemas, notateoria;
        // Variable para que el bucle se ejecute
        boolean haynombre = true;
        // Variables que usaremos para almacenar datos
        // Estas serán para almacenar el dato en valor double
        double practica, problemas, teoria;
        // Para calcular la nota máxima, mínima y la media en la que guardaremos los
        // datos sumándolos.
        double notamax = 0, notamin = 0, media = 0;
        // Aquí guardaremos los nombres de los alumnos con mayor y menos nota.
        String nombremax = "", nombremin = "";
        // Un contador que usaremos por cada vuelta en el bucle para saber cuantos
        // alumnos hemos introducido.
        int contador = 0;
        // Nota total de cada alumno
        double alumnototal;

        // Creamos escaner para leer datos
        Scanner key = new Scanner(System.in);

        // Creamos bucle que se ejecutará siempre ya que le hemos asignado el valor
        // true.
        while (haynombre == true) {
            // Pedimos constantemente las variables
            System.out.println("Deme su nombre: ");
            nombre = key.next();
            // Esta variable tendrá una prueba de error en este if si la variable valor es
            // igual a 0 saldremos del bucle.
            if (nombre.equals("0")) {
                break;
            }
            System.out.println("Deme su nota práctica: ");
            notapractica = key.nextInt();
            System.out.println("Deme su nota de problemas: ");
            notaproblemas = key.nextInt();
            System.out.println("Deme su nota teórica: ");
            notateoria = key.nextInt();

            // Ahora en el if comprobaremos que todos los números están dentro del rango
            if ((notapractica > 10 || notapractica < 0)
                    || (notaproblemas > 10 || notaproblemas < 0) || (notateoria > 10 || notateoria < 0)) {
                // Imprimimos un mensaje de error y volvemos al bucle
                System.out.println("Los valores tienen que estar entre el rango de 0 y 10");

            } else { // Una vez comprobado que no pueda haber errores iniciamos el programa
                // A partir de aquí vamos sumando al contador.
                contador++;
                // Ponderaciones de cada alumno con una multiplicación y haciendo un cast para
                // pasar los valores a double.
                // Pasamos el valor a las variables double para hacer la multiplicación con
                // decimales
                practica = notapractica;
                problemas = notaproblemas;
                teoria = notateoria;

                practica *= 0.1;
                problemas *= 0.5;
                teoria *= 0.4;

                // Creamos la suma de ellas tres para saber la nota de nuestro alumno
                alumnototal = practica + problemas + teoria;
                // Aquí iremos añadiendo las notas totales de cada alumno para después hacer la
                // media
                media += alumnototal;

                //Sobreescribimos la primera vez todos los datos en las variables máximas y mínimas
                if (contador==1) {
                    notamax = alumnototal;
                    nombremax = nombre;
                    notamin = alumnototal;
                    nombremin = nombre;
                }

                // En este if si la nota del alumno es mayor a la notamax actual la notamax
                // tomará como nuevo valor la nota que se encuentre ahora mismo en el bucle.
                // Como también necesitamos el nombre le añadiremos el nombre actual a la
                // variable nombremax
                if (alumnototal > notamax) {
                    notamax = alumnototal;
                    nombremax = nombre;
                }
                // En este if si la nota del alumno es mayor a la notamin actual la notamin
                // tomará como nuevo valor la nota que se encuentre ahora mismo en el bucle.
                // Como también necesitamos el nombre le añadiremos el nombre actual a la
                // variable nombremin
                else if (alumnototal < notamax) {
                    notamin = alumnototal;
                    nombremin = nombre;
                }

            }

        } // Si la variable haynombre sigue valiendo true al salir del bucle ejecutaremos
          // el menú
        if (haynombre == true) {
            // Creamos el menú de todos los alumnos
            System.out.println("---------MENÚ---------");
            System.out.println("Elige una opción especificando el número de ella");
            System.out.println("1. Nota máxima");
            System.out.println("2. Nota mínima");
            System.out.println("3. Nota media");
            // Pedimos la opción del menú
            int opcion = key.nextInt();

            // Ahora hacemos un switch en el que tengamos las tres opciones
            switch (opcion) {
                case 1:
                    // En esta opción imprimimos la variable nombremax y la notamax
                    System.out.printf("Su nombre es " + nombremax + " y su nota es " + notamax);
                    // Y salimos del menú
                    break;
                case 2:
                    // En esta opción imprimimos la variable nombremin y la notamin
                    System.out.println("Su nombre es " + nombremin + " y su nota es " + notamin);
                    // Y salimos del menú
                    break;
                case 3:
                    // Para hacer la media usaremos la variable donde tenemos almacenadas todas las
                    // notas y la dividimos con contador que sería el número de alumnos pasado
                    System.out.println("La media de todos los alumnos es " + media / contador);
                    // Y salimos del menú
                    break;
                default:
                    // En caso de que la opción pasada no sea correcta imprimimos un error
                    System.out.println("Esa opción no existe");
                    // Y salimos del menú
                    break;
            }

        } else { // En caso de que no imprimimos un mensaje de error
            System.out.println("Los valores no son correctos");

        }

    }
}
