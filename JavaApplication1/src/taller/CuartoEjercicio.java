package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class CuartoEjercicio {

    public static void main(String[] args) {
        Scanner tt = new Scanner(System.in);
        double price = 3.84;
        System.out.println("el valor de un kilo de manzana es de : 3.84");
        System.out.println("cuantos kilos de manzanas vas a compar? :");
        double kl = tt.nextDouble();
        double fullprice;
        if (kl <= 2) {
            fullprice = kl * price;
            System.out.println("tu descuento es de 0% y tu valor total es de : " + fullprice);
        } else {
            double sale;
            double klsale;
            if (kl > 2 && kl <= 5) {
                sale = 0.10;
                klsale = kl * price * sale;
                fullprice = kl * price - klsale;
                System.out.println("tu descuento es de 10% y tu valor total es de : " + fullprice);
            } else if (kl > 5 && kl <= 10) {
                sale = 0.15;
                klsale = kl * price * sale;
                fullprice = kl * price - klsale;
                System.out.println("tu descuento es de 15% y tu valor total es de : " + fullprice);
            } else if (kl > 10) {
                sale = 0.2;
                klsale = kl * price * sale;
                fullprice = kl * price - klsale;
                System.out.println("tu descuento es de 20% y tu valor total es de : " + fullprice);
            } else {
                System.out.println("digita bien tu cifra");
            }
        }

    }
}
