/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo2.taller2.Restaurante;

/**
 *
 * @author SERGIO ROJAS
 */
public class Pizza extends Receta{

    public Pizza(String nombre, String[] ingredientes, String[] pasosPreparacion) {
        super(nombre, ingredientes, pasosPreparacion);
    }

    @Override
    public int timempoDePreparacion() {
    return 2 + (getNombre().length());   }

    @Override
    public boolean isVegetariano() {
        for (String ingrediente : ingredientes){
        if(ingrediente.toLowerCase().contains("carne")){
        
        
        }
        }
        return false;
            
        
    }

    @Override
    public String tipoPreparacion() {
return "horno";    }
    
}
