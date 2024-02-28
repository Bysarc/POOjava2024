
package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232219321
 */
import java.util.Scanner;

public class OctavoEjercicio {
    public static void main(String[] args) {
        Scanner rx = new Scanner(System.in);
        int age,old;
        System.out.println("Cuantos años tiene?");
        age = rx.nextInt();
        if (age>=60) {
            System.out.println("cuantos años de anteguidad de empleo tiene");
            old = rx.nextInt();
            if (old>=25) {
                System.out.println("Haces parte de antigüedad adulta ");
            }else {
                System.out.println("Haces parte a la jubilación por edad ");
            }
        }else if (age<60) {
            System.out.println("cuantos años de anteguidad de empleo tiene");
            old = rx.nextInt();
            if (old>25) {
                System.out.println("Haces parte de la jubilacion por antiguedad joven");
        }else
                System.out.println("No haces parte de ningun grupo");
    }
}
}
