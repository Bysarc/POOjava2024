/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo2.taller2.Restaurante;

import java.util.ArrayList;
import java.util.Scanner;

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

    Restaurante(Receta[] recetasRestaurante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public void añadirRecetaAlMenu() {
        Scanner sx = new Scanner(System.in);

        System.out.println("Elige una receta para añadir al menú:");
        for (int i = 0; i < recetas.size(); i++) {
            System.out.println((i + 1) + ". " + recetas.get(i).getNombre());
        }
        int opcion = sx.nextInt();
        if (opcion >= 1 && opcion <= recetas.size()) {
            menu.getElementos().add(recetas.get(opcion - 1));
            System.out.println("Receta añadida al menú");
        } else {
            System.out.println("elige bien.");
        }

    }

    public double tiempoMedio() {
        if (menu.getElementos().isEmpty()) {
            return -1;
        }
        int totalTiempo = 0;
        for (IFastFood elemento : menu.getElementos()) {
            totalTiempo += elemento.timempoDePreparacion();
        }
        return (double) totalTiempo / menu.getElementos().size();
    }
    
    public double porcentajeVegetariano() {
    if (menu.getElementos().isEmpty()) {
      return 0;
    }
    int vegetarianos = 0;
    for (IFastFood elemento : menu.getElementos()) {
      if (elemento.isVegetariano()) {
        vegetarianos++;
      }
    }
    return ((double) vegetarianos / menu.getElementos().size()) * 100;
  }

}
