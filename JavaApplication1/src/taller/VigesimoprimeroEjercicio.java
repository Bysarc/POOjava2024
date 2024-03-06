package taller;

/**
 *
 * @author SERGIO ROJAS CODE 20232218321
 */
import java.util.Scanner;

public class VigesimoprimeroEjercicio {

    public static void main(String[] args) {
        Scanner ff = new Scanner(System.in);

        int empleados;
        System.out.println("cuantos empleados tiene la empresa?");
        empleados = ff.nextInt();

        int tallasxs = 0, tallasm = 0, tallass = 0, tallasl = 0, tallasxl = 0, tallasxxl = 0, tallasxxxl = 0;
        String nombreempleado = ("");
        int[] numempleados = new int[empleados];
        String[] nombres = new String[empleados];
        String[] tallas = new String[empleados];

        for (int i = 0; i < numempleados.length; i++) {
            System.out.println("cual es el nombre del empleado " + (i + 1));
            nombres[i] = ff.nextLine();
         
           ff.nextLine();
            do {
                System.out.println("que talla es?");
                System.out.println("xs, s, m, l, xl, xxl, xxxl");
                tallas[i] = ff.nextLine();
            } while ("xxl".equals(tallas[i]) && "xxxl".equals(tallas[i]) && "xs".equals(tallas[i]) && "s".equals(tallas[i]) && "l".equals(tallas[i]) && "xl".equals(tallas[i]));
            if (null != tallas[i]) {
                switch (tallas[i]) {
                    case "xxl":
                        tallasxxl++;
                        nombreempleado = nombres[i];
                        System.out.println("el empleado " + nombreempleado + " es talla xxl");
                        break;
                    case "xxxl":
                        tallasxxxl++;
                        nombreempleado = nombres[i];
                        System.out.println("el empleado " + nombreempleado + " es talla xxxl");
                        break;
                    case "xl":
                        tallasxl++;
                        nombreempleado = nombres[i];
                        System.out.println("el empleado " + nombreempleado + " es talla xl");
                        break;
                    case "l":
                        tallasl++;
                        nombreempleado = nombres[i];
                        System.out.println("el empleado " + nombreempleado + " es talla l");
                        break;
                    case "m":
                        tallasm++;
                        nombreempleado = nombres[i];
                        System.out.println("el empleado " + nombreempleado + " es talla m");
                        break;
                    case "s":
                        tallass++;
                        nombreempleado = nombres[i];
                        System.out.println("el empleado " + nombreempleado + " es talla s");
                        break;
                    case "xs":
                        tallasxs++;
                        nombreempleado = nombres[i];
                        System.out.println("el empleado " + nombreempleado + " es talla xs");
                        break;
                    default:
                        break;
                }
            }
        }
        for (int i = 0; i < tallas.length; i++) {
            System.out.println("el empleado " + nombres[i] + " es de talla " + tallas[i]);
        }

        System.out.println("la cantidad de cmamisas de talla xs son de " + tallasxs);
        System.out.println("la cantidad de cmamisas de talla s son de " + tallass);
        System.out.println("la cantidad de cmamisas de talla l son de " + tallasl);
        System.out.println("la cantidad de camisas talla m son de" + tallasm);
        System.out.println("la cantidad de camisas talla xl son de " + tallasxl);
        System.out.println("la cantidad de camisas talla xxl son de " + tallasxxl);
        System.out.println("la cantidad de camisas talla xxxl son de " + tallasxxxl);
    }
}
