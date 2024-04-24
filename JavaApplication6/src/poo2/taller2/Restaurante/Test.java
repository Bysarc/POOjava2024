/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo2.taller2.Restaurante;

/**
 *
 * @author SERGIO ROJAS
 */
public class Test {
    public static void main(String[] args) {
         Restaurante r1 = new Restaurante();
         
        Receta pizza = new Pizza("Pizza Margarita", new String[]{"harina", "tomate", "queso"}, new String[]{"Extender la masa", "Agregar ingredientes", "Hornear"});
        Receta sandwich = new Sandwich("Sandwich de vegetales", new String[]{"pan", "lechuga", "tomate", "pepino"}, new String[]{"Tostar el pan", "Agregar ingredientes", "Servir"});
        
        r1.añadirRecetaAlMenu(pizza);
        r1.añadirRecetaAlMenu(sandwich);
        
        System.out.println("Tiempo medio de preparación del menú: " + r1.tiempoMedio() + " minutos");
        System.out.println("Porcentaje de elementos vegetarianos en el menú: " + r1.porcentajeVegetariano() + "%");
        
        
    }
}
