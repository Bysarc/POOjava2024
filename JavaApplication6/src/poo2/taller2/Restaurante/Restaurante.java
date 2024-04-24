/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo2.taller2.Restaurante;

import java.util.ArrayList;

/**
 *
 * @author SERGIO ROJAS
 */
public class Restaurante {

    private ArrayList<Receta> recetas;
    Menu menu;

    public Restaurante() {
        this.recetas = new ArrayList<>(10);
        this.menu = new Menu();
    }

  
    

    public void creaReceta(String nombre, String[] ingredientes, String[] pasosPreparacion) {
        for (int i = 0; recetas.size() < 10; i++) {
            if (recetas.get(i) == null) {
                recetas.set(i, new Receta(nombre, ingredientes, pasosPreparacion) {
                    @Override
                    public int timempoDePreparacion() {
                        return 0;
                    }

                    @Override
                    public boolean isVegetariano() {
                        return false;
                    }

                    @Override
                    public String tipoPreparacion() {
                        return null;
                    }
                    
                    
                    
                });
                break;

    
            }
        }
    }
    public void añadirRecetaAlMenu(IFastFood receta) {
        menu.getElementos().add(receta);
    }
}
