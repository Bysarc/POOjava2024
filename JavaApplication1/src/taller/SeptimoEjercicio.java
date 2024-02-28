package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class SeptimoEjercicio {

    public static void main(String[] args) {
        Scanner rx = new Scanner(System.in);
        int which;
        double prom, saletotal1;
        int feetec = 18000, feeprof = 30000, sub, saletotal2;
        System.out.println("Si eres profesional marca 2, si eres de tecnologia marca 1");
        which = rx.nextInt();

        if (which == 1) {
            System.out.println("ingresa tu promedio");
            prom = rx.nextDouble();
            if (prom >= 9.5) {
                double sale = 0.25;
                int credits = 55;
                saletotal1 = (credits * feetec) * sale;
                saletotal2 = (int) (credits * feetec) - (int) saletotal1;
                System.out.println("el valor de la matricula es de " + saletotal2);
            } else if (prom >= 9 && prom < 9.5) {
                double sale = 0.10;
                int credits = 50;
                saletotal1 = (credits * feetec) * sale;
                saletotal2 = (int) (credits * feetec) - (int) saletotal1;
                System.out.println("el valor de la matricula es de " + saletotal2);
            } else if (prom > 7 && prom < 9) {
                int credits = 50;
                saletotal2 = credits * feetec;
                System.out.println("el valor de la matricula es de " + saletotal2);
            } else if (prom < 7) {
                System.out.println("cuantas materias tiene reprobadas?");
                sub = rx.nextInt();
                if (sub <= 3) {
                    int credits = 45;
                    saletotal2 = credits * feetec;
                    System.out.println("el valor de la matricula es de " + saletotal2);
                } else if (sub > 4) {
                    int credits = 40;
                    saletotal2 = credits * feetec;
                    System.out.println("el valor de la matricula es de " + saletotal2);
                }
            }
        } else if (which == 2) {
            System.out.println("ingresa tu promedio");
            prom = rx.nextDouble();
            if (prom >= 9.5) {
                    double sale = 0.20;
                    int credits = 55;
                    saletotal1 = (credits * feeprof) * sale;
                    saletotal2 = (int) (credits * feeprof) - (int) saletotal1;
                    System.out.println("el valor de la matricula es de " + saletotal2);
                } else if (prom < 9.5) {
                    int credits = 55;
                    saletotal2 = credits * feeprof;
                    System.out.println("el valor de la matricula es de " + saletotal2);
                }
            }
            {

            }

        }
    }

