package taller;

/**
 *
 * @author SERGIO ROJAS
 */
import java.util.Scanner;

public class DecimoterceroEjercicio {

    public static void main(String[] args) {
        Scanner zz = new Scanner(System.in);
        int sex;
        int numdraw;
        System.out.println("si eres hombre 1 o mujer 2?");
        sex = zz.nextInt();
        numdraw = (int) (Math.random() * (6 - 1)) + 1;

        switch (sex) {
            case 1:
                switch (numdraw) {
                    case 1: {
                        System.out.println("Te tocó la bola 1, Ganaste un desodorante");
                        break;
                    }
                    case 2: {
                        System.out.println("Te tocó la bola 2,Ganaste un six-pack de cerveza");
                        break;
                    }
                    case 3: {
                        System.out.println("Te tocó la bola 3, Ganaste una camiseta");
                        break;
                    }
                    case 4: {
                        System.out.println("Te tocó la bola 4,Ganaste una pantaloneta");
                        break;
                    }
                    default: {
                        System.out.println("Te tocó la bola 5,Ganaste una sudadera");
                        break;
                    }
                }
                break;
            case 2:
                switch (numdraw) {
                    case 1: {
                        System.out.println("Te tocó la bola 1, ganaste una loción");
                        break;
                    }
                    case 2: {
                        System.out.println("Te tocó la bola 2, ganaste un bikini");
                        break;
                    }
                    case 3: {
                        System.out.println("Te tocó la bola 3, ganaste una crema para la cara");
                        break;
                    }
                    case 4: {
                        System.out.println("Te tocó la bola 4, ganaste una plancha para el cabello");
                        break;
                    }
                    default: {
                        System.out.println("Te tocó la bola 5, ganaste un esmalte de uñas");
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }

}
