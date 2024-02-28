/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class DecimoquintoEjercicio {

    public static void main(String[] args) {
        String sexo;
        int naciminetos, totalna = 0, masculinos = 0, femeninos = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dgita la cantidad total de nacimientos");
        naciminetos = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= naciminetos; i++) {
            System.out.println("nombre del bebé " + i);
            sc.nextLine();

            do {
                System.out.println("de que sexo es el bebé?, (m/f)");
                sexo = sc.nextLine();
            } while (!"masculino".equals(sexo) && !"femenino".equals(sexo));
            if ("masculino".equals(sexo)) {
                masculinos++;
            } else {
                femeninos++;
            }
            totalna++;
        }
        System.out.println("Cantidad de bebés nacidos:");
        System.out.println("Masculinos: " + masculinos);
        System.out.println("Femeninos: " + femeninos);
        System.out.println("Total: " + totalna);
    }

}
