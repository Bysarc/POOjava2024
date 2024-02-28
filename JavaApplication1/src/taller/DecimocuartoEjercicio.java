
package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;
public class DecimocuartoEjercicio {
    public static void main(String[] args) {
        
        int typecar,color;
        String selecar = null, selecolor=null;
        
        Scanner zz = new Scanner(System.in);
        System.out.println("seleccioan el tipo de carro :");
        System.out.println("1. auto");
        System.out.println("2. suv");
        System.out.println("3. camioneta");
        typecar = zz.nextInt();
        
        System.out.println("Selecciona el color:");
        System.out.println("1. negro");
        System.out.println("2. blanco");
        System.out.println("3. rojo");
        color = zz.nextInt();
        
        switch (typecar) {
            case 1:
                selecar = "auto";
                break;
            case 2:
                selecar ="suv";
                break;
            case 3:
                selecar = "camioneta";
                break;
            default:
                System.out.println("elegiste mal");
        }
        switch (color) {
            case 1:
                selecolor = "negro";
                break;
            case 2:
                selecolor = "blanco";
                break;
            case 3:
                selecolor = "rojo";
                break;
            default:
                System.out.println("elegiste mal");
        }
    System.out.println("Seleccion realizada con exito");
    System.out.println("tipo de carro : " + selecar);
    System.out.println("color : " + selecolor);
    }
}
