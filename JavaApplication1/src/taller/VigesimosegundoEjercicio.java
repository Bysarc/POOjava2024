package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class VigesimosegundoEjercicio {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int numex = 3;
        int[] personas = new int[numex];
        int[] pesos = new int[numex];
        String[] nombres = new String[numex];

        for (int i = 0; i < personas.length; i++) {
            System.out.println("cual es el nombre de la persona " + (i + 1));
            nombres[i] = ss.nextLine();
             ss.nextLine();
            
            System.out.println("cual es el peso en kg de la persona?");
            pesos[i] = ss.nextInt();
            ss.nextLine();

            System.out.println("el paciente " + (nombres[i]) + " tiene un peso de " + pesos[i]);
        }

        int mayor = pesos[0], menor = pesos[0];
       

            for (int i = 1; i < pesos.length; i++) {
                if (pesos[i] > mayor) {
                    mayor = pesos[i];
                    System.out.println("el peso mayor fue de " + mayor);
                }if (pesos[i] < menor) {
                menor = pesos[i];
                System.out.println("el peso menor fue de " + menor);
            }
             
        

    }
}
}