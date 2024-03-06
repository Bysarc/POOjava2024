package taller;

/**
 *
 * @author SERGIO ROJAS
 */
import java.util.Scanner;

public class DecimoseptimoEjercicio {

    public static void main(String[] args) {
        Scanner xd = new Scanner(System.in);

        int[] temperaturas = new int[7];
        String dias[] = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};

        for (int i = 0; i < dias.length; i++) {
            System.out.println("escribe la temperatura promedio del dia : " + dias[i]);
            temperaturas[i] = xd.nextInt();
            if (temperaturas[i] <= 0) {
                System.out.println("el dia " + dias[i] + " es congelante");
            } else if (temperaturas[i] >= 1 && temperaturas[i] <= 10) {
                System.out.println("el dia " + dias[i] + " es muy frio");
            } else if (temperaturas[i] >= 21 && temperaturas[i] <= 24) {
                System.out.println("el dia " + dias[i] + " frio");
            } else if (temperaturas[i] >= 25 && temperaturas[i] <= 29) {
                System.out.println("el dia " + dias[i] + " es templado");
            } else if (temperaturas[i] >= 30 && temperaturas[i] <= 35) {
                System.out.println("el dia " + dias[i] + " caliente");
            } else {
                System.out.println("el dia " + dias[i] + " es muy caliente");
            }
        }
    }
}
