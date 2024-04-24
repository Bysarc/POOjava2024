/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo2.taller2.Restaurante;

/**
 *
 * @author SERGIO ROJAS
 */
public class Sandwich extends Receta {

    public Sandwich(String nombre, String[] ingredientes, String[] pasosPreparacion) {
        super(nombre, ingredientes, pasosPreparacion);
    }

    @Override
    public int timempoDePreparacion() {
        int cuenta = 0;
        for(char c : getNombre().toLowerCase().toCharArray()){
            if (c=='a' && c=='e' && c=='i' && c=='o' && c=='u' ) {
                cuenta++;
            }
        }
        return 2 + cuenta;
    }

    @Override
    public boolean isVegetariano() {
        return true;
    }

    @Override
    public String tipoPreparacion() {
    return "plancha";    }
    
}
