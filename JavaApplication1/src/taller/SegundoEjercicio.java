package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class SegundoEjercicio {

    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.print("Cuantas llantas deseas comprar? : ");
        int tires = cs.nextInt();
        byte pricetire;
        int pricefull;
        if (tires < 5) {
            pricetire = 100;
            pricefull = pricetire * tires;
            System.out.println("El precio de cada llanta es de " + pricetire);
            System.out.println("El precio total de tu compra es de " + pricefull);
        } else if (tires >= 5 && tires < 10) {
            pricetire = 75;
            pricefull = pricetire * tires;
            System.out.println("El precio de cada llanta es de " + pricetire);
            System.out.println("El precio total de tu compra es de " + pricefull);
        } else {
            pricetire = 50;
            pricefull = pricetire * tires;
            System.out.println("El precio de cada llanta es de " + pricetire);
            System.out.println("El precio total de tu compra es de " + pricefull);
        }

    }
}
