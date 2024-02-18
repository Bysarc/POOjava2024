package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class TercerEjercicio {

    public static void main(String[] args) {
        Scanner dx = new Scanner(System.in);
        int priceone;
        double iva = 0.19, sale, pricesale, priceonesale, priceiva, pricefull;
        System.out.println("Que reproductor quieres?");
        System.out.println("SAMSUNG : 800, SONY : 400, NOSY : 600");
        String brand = dx.nextLine();
        switch (brand) {
            case "SAMSUNG" -> {
                priceone = 800;
                sale = 0.1D;
                pricesale = (double) priceone * sale;
                priceonesale = (double) priceone - pricesale;
                priceiva = priceonesale * iva;
                pricefull = priceonesale + priceiva;
                System.out.println("el precio total de tu aparato con iva incluido es de :" + pricefull);
            }
            case "SONY" -> {
                priceone = 400;
                priceiva = (double) priceone * iva;
                pricefull = (double) priceone + priceiva;
                System.out.println("el precio total de tu aparato con iva incluido es de :" + pricefull);
            }
            case "NOSY" -> {
                priceone = 600;
                sale = 0.15D;
                pricesale = (double) priceone * sale;
                priceonesale = (double) priceone - pricesale;
                priceiva = priceonesale * iva;
                pricefull = priceonesale + priceiva;
                System.out.println("el precio total de tu aparato con iva incluido es de :" + pricefull);
            }
            default ->
                System.out.println("repite bien cual aparato quieres");
        }

    }
}
