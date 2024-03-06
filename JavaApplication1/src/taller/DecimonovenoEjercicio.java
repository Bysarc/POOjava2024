package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class DecimonovenoEjercicio {

    public static void main(String[] args) {
        Scanner ff = new Scanner(System.in);

        int Cantinternos = (int) (Math.random() * (31 - 11) + 11);
        System.out.println("la cantidad de prisioneros de la carcel es de " + Cantinternos);
        
        int cantcond = 0; 
                
        int[] prisioneros = new int[Cantinternos];
        String[] nombres = new String[Cantinternos];
        int[] tiempore = new int[Cantinternos];

        for (int i = 0; i < prisioneros.length; i++) {
            System.out.println("cual es el nombre del prisionero ");
            nombres[i] = ff.nextLine();
            
            
            tiempore[i] = (int) (Math.random()*(49-1)+1);
            System.out.println("el prisionero " + nombres[i] + " tiene una condena de " + tiempore[i] + " meses");
            
            
        }
        
        for (int i = 0; i < prisioneros.length; i++) {
            if (tiempore[i]<34) {
                cantcond++;
            }
        }
        System.out.println("la cantidad de prisioneros que cumplen la condicion son de " + cantcond);
    }
}
