package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class PrimerEjercicio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pricecomputer = 500;
        System.out.print("Hola, cuantas computadoras deseas llevar? : ");
        int pc = sc.nextInt();
        int pricefull;
        double sale;
        double pcsale;
        if (pc < 5) {
            sale = 0.10;
            pcsale = (double) (pricecomputer * pc) * sale;
            pricefull = pc * pricecomputer - (int) pcsale;
            System.out.println("el precio total de tu compra es : " + pricefull);
        } else if (pc >= 5 && pc < 10) {
            sale = 0.20;
            pcsale = (double) (pricecomputer * pc) * sale;
            pricefull = pc * pricecomputer - (int) pcsale;
            System.out.println("el precio total de tu compra es : " + pricefull);
        } else {
            sale = 0.40;
            pcsale = (double) (pricecomputer * pc) * sale;
            pricefull = pc * pricecomputer - (int) pcsale;
            System.out.println("el precio total de tu compra es : " + pricefull);
        }

    }
}
