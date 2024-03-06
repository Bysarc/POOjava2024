package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class VigesimoEjercicio {

    public static void main(String[] args) {
        Scanner da = new Scanner(System.in);

        int numre = (int) (Math.random() * (11 + 1) + 1);
        System.out.println("el numero de repartidores son de " + numre);

        int[] numrepar = new int[numre];
        int[] plata = new int[numre];
        String[] nombres = new String[numre];
        String hi =(""), sm = ("");

        for (int i = 0; i < numrepar.length; i++) {
            System.out.println("Cual es el nombre del repartidor " + (i+1) + "?");
            nombres[i] = da.nextLine();

            plata[i] = (int) (Math.random() * (100001 - 20000) + 20000);
            System.out.println("el repartidor " + nombres[i] + " hizó una venta de $" + plata[i]);
        }
        int mayor = 20000, menor = 100000;
        for (int i = 0; i < plata.length; i++) {
            if (plata[i] > mayor) {
                mayor = plata[i];
                hi=nombres[i];
            } else if (plata[i] < menor) {
                menor = plata[i];
                 sm=nombres[i];
            }
        }
        System.out.println("El repartidor con mayor ventas es " + hi);
        System.out.println("con una venta de " + mayor);

        System.out.println("El repartidor con menor ventas es " + sm);
        System.out.println("con una venta de " + menor);
    }
}
