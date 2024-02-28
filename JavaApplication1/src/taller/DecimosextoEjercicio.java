package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class DecimosextoEjercicio {

    public static void main(String[] args) {
        int ventas, paletas, helados, venli = 0, vennu = 0, venlu = 0, venfr = 0, vencr = 0;
        int x = 1, ventatotal = 0;
        int canli = 0, cannu = 0, canlu = 0, canfr = 0, cancr = 0;
        Scanner sx = new Scanner(System.in);
        System.out.println("cuantas ventas se obtuvieron esta semana?");
        ventas = sx.nextInt();

        for (int i = 1; i <= ventas; i++) {
            System.out.println("cuantas paletas compraron en esta venta?");
            paletas = sx.nextInt();
            
            sx.nextLine();
            for (int y = 1; y<=paletas; y++) {
                System.out.println("que sabor de helado llevaron?");
            
            System.out.println(" 1.limon = $2500");
            System.out.println(" 2.nuez  = $2800");
            System.out.println(" 3.lulo  = $2600");
            System.out.println(" 4.fresa  = $2000");
            System.out.println(" 5.crema  = $3000");
            helados = sx.nextInt();

            
                switch (helados) {
                    case 1:
                        canli++;
                        venli+=2500;
                        break;
                    case 2:
                        cannu++;
                        vennu+=2800;
                        break;
                    case 3:
                        canlu++;
                        venlu+=2600;
                                break;
                    case 4:
                        canfr++;
                        venfr+=2000;
                        break;
                    case 5:
                        cancr++;
                        vencr+=3000;
                    default:
                        break;
                }
                
               
}           
            ventatotal = venli+vennu+venlu+venfr+vencr;
        }
        
        System.out.println("La cantidad vendida de paletas de limon fueron " + canli);
        System.out.println("el valor vendido es de " + venli);
        
        
       System.out.println("La cantidad vendida de paletas de nuez fueron " + cannu);
       System.out.println("el valor vendido es de " + vennu);
       
       System.out.println("La cantidad vendida de paletas de lulo fueron " + canlu);
       System.out.println("el valor vendido es de " + venlu);

       
       System.out.println("La cantidad vendida de paletas de fresa fueron " + canfr);
       System.out.println("el valor vendido es de " + venfr);

       
       System.out.println("La cantidad vendida de paletas de crema fueron " + cancr);
       System.out.println("el valor vendido es de " + vencr);
       
       System.out.println("la venta total fue de $" + ventatotal);
    
    }
}