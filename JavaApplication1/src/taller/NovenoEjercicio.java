package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class NovenoEjercicio {

    public static void main(String[] args) {
        Scanner dx = new Scanner(System.in);
        int salary, old, price;
        double sale;
        System.out.println("Escribe el valor de tu sueldo mensual");
        salary = dx.nextInt();
        System.out.println("Cuantos años de antiguedad tiene en la emopresa?");
        old = dx.nextInt();
        if (old < 1) {
            sale = salary * 0.05;
            price = (int) salary - (int) sale;
            System.out.println("la utilidad es de " + price);
        } else if (old >= 1 && old < 2) {
            sale = salary * 0.07;
            price = (int) salary - (int) sale;
            System.out.println("la utilidad es de " + price);
        } else if (old >= 2 && old < 5) {
            sale = salary * 0.10;
            price = (int) salary - (int) sale;
            System.out.println("la utilidad es de " + price);
        } else if (old >= 5 && old < 10) {
            sale = salary * 0.15;
            price = (int) salary - (int) sale;
            System.out.println("la utilidad es de " + price);
        } else {
            sale = salary * 0.2;
            price = (int) salary - (int) sale;
            System.out.println("la utilidad es de " + price);
        }
    }
}
