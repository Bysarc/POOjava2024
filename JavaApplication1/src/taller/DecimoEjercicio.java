
package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;
public class DecimoEjercicio {
    public static void main(String[] args) {
        Scanner ja = new Scanner(System.in);
        double salehour, payexhours;
        int hours,fullprice,exhours,howhours,pay = 5000;
        System.out.println("Cuantas horas realizas de trabajo?");
        hours = ja.nextInt();
        if (hours<=40) {
           
            fullprice = hours*pay;
            System.out.println("Tu salario semanal es de " + fullprice);
            
        }else if (hours>40) {
            System.out.println("haz hecho horas extras? 1 si, 2 no");
            exhours = ja.nextInt();
            if (exhours == 1) {
                salehour= pay*0.20;
                System.out.println("cuantas horas realizaste?");
                howhours = ja.nextInt();
                payexhours = howhours*salehour;
                fullprice = (int)(hours*pay)+(int)payexhours; 
                System.out.println("Tu salario semanal es de " + fullprice);
            }else if (exhours == 2) {
                fullprice = hours*pay;
                System.out.println("Tu salario semanal es de " + fullprice);
            }
        }
        
    }
}
