/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller;

/**
 *
 * @author SERGIO ROJAS
 */
import java.util.Scanner;
public class DecimooctavoEjercicio {
    public static void main(String[] args) {
        Scanner sx = new Scanner(System.in);
        int[] edad = new int[37];
        String[] nombres = new String[37];
        
        for (int i = 0; i < edad.length; i++) {
            System.out.println("cual es el nombre de este triple hp?");
            nombres[i] = sx.nextLine();
            
            System.out.println("cual es la edad del viejo cacorro?");
            edad[i] = sx.nextInt();
            sx.nextLine();
        }  
        
        for (int i = 0; i <edad.length; i++) {
            if (edad[i]>85) {
                System.out.println("el señor " + nombres[i] + " con la edad de " + edad[i] + " cumple la condicion solicitada" );
            }else{
            System.out.println("el señor " + nombres[i] + " con la edad de " + edad[i] + " no cumple la condicion solicitada" );
            }
        }
        
    
        }
    }
