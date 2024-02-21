package taller;

/**
 *
 * @author SERGIO ROJAS
 */
import java.util.Scanner;

public class SextoEjercicio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("El paciente tiene menos de un año, si o no?");
        String age = sc.nextLine();
        System.out.println("que nivel de Hemoglobina tiene");
        int percentagelevel = sc.nextInt();
        switch (age) {
            case "si" -> {
                System.out.println("Cuantos meses tiene?");
                int agebaby = sc.nextInt();

                if (agebaby <= 1 && percentagelevel >= 13 && percentagelevel <= 26) {
                    System.out.println("Tu resultado es negativo");
                } else if (agebaby > 1 && agebaby <= 6 && percentagelevel >= 10 && percentagelevel <= 18) {
                    System.out.println("Tu resultado es negativo");
                } else if (agebaby > 6 && agebaby <= 12 && percentagelevel >= 11 && percentagelevel <= 15) {
                    System.out.println("Tu resultado es negativo");
                }else{
                System.out.println("Tu resultado es positivo"); 
                }
            }
            case "no" -> {
                System.out.println("Cuantos años tiene?");
                float ageboys = sc.nextFloat();
                if (ageboys > 1 && ageboys <= 5 && percentagelevel >= 11.5 && percentagelevel <= 15) {
                    System.out.println("Tu resultado es negativo");
                } else if (ageboys > 5 && ageboys <= 10 && percentagelevel >= 12.6 && percentagelevel <= 15.5) {
                    System.out.println("Tu resultado es negativo");
                } else if (ageboys > 10 && ageboys <= 15 && percentagelevel >= 13 && percentagelevel <= 15.5) {
                    System.out.println("Tu resultado es negativo");
                } else if (ageboys > 15) {
                    System.out.println("Es hombre o mujer?, si es hombre marca 1, si es mujer marca 2");
                    int hom;
                    hom = sc.nextInt();
                    if (hom==1 && percentagelevel>=14 && percentagelevel<=18) {
                    System.out.println("Tu resultado es negativo");   
                    }else if (hom==2 && percentagelevel>=12 && percentagelevel<=16) {
                    System.out.println("Tu resultado es negativo"); 
                    }else{
                    System.out.println("Tu resultado es positivo"); 
                    }
                } else {
                    System.out.println("Tu resultado es positivo");
                }

            }

        }

        
    }
}
