package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class QuintoEjercicio {

    public static void main(String[] args) {
        Scanner rn = new Scanner(System.in);
        System.out.println("digita la capital actual de la empresa :");
        int balance = rn.nextInt();
        int amount, balanceteams, balancesupp, balanceinsentives;
        if (balance < 0) {
            amount = 10000 - balance;
            balanceteams = 3000;
            balancesupp = balanceteams / 2;
            balanceinsentives = balanceteams / 2;
            System.out.println("Se pidio al banco un prestamo por : " + amount);
            System.out.println("a la cual se destino una cantidad de : " + balancesupp + " para la compra de insumos");
            System.out.println("y una cantidad de " + balanceinsentives + " para incentivos al personal");
        } else if (balance > 0 && balance < 20000) {
            amount = 20000 - balance;
            balanceteams = 13000;
            balancesupp = balanceteams / 2;
            balanceinsentives = balanceteams / 2;
            System.out.println("Se pidio al banco un prestamo por : " + amount);
            System.out.println("a la cual se destino una cantidad de : " + balancesupp + " para la compra de insumos");
            System.out.println("y una cantidad de " + balanceinsentives + " para incentivos al personal");
        } else {
            balanceteams = balance - 7000;
            balancesupp = balanceteams / 2;
            balanceinsentives = balanceteams / 2;
            System.out.println("se destino una cantidad de : " + balancesupp + " para la compra de insumos");
            System.out.println("y una cantidad de " + balanceinsentives + " para incentivos al personal");
        }

    }
}
