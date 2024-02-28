
package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 * */
import java.util.Scanner;
public class UndecimoEjercicio {
    public static void main(String[] args) {
        int price;
        double investown,loanbanck,investfab,fabinte;
        Scanner px = new Scanner(System.in);
        System.out.println("ingresa el valor de la compra");
        price = px.nextInt();
        
        if (price>500000) {
            investown = 0.55 * price;
            loanbanck = 0.30 * price;
            investfab = (price-investown)-loanbanck;
            fabinte = 0.20 * investfab;
            
            System.out.println("La empresa invertirá " + investown + " por su propia cuenta");
            System.out.println("Se pedirá prestado al banco una suma de " + loanbanck );
            System.out.println("Se pedirá un credito al fabricante de " + investfab);
            System.out.println("El fabricante pedirá" + fabinte + " de intereses");
            
        }else{
            investown = 0.70 * price;
            investfab = price - investown;
            fabinte = 0.20 * investfab;
            
            System.out.println("La empresa invertirá " + investown + " por su propia cuenta");
            System.out.println("Se pedirá un credito al fabricante de " + investfab);
            System.out.println("El fabricante pedirá" + fabinte + " de intereses");
        }
    }
}

