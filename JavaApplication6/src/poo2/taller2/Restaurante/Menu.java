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
public class Menu {
    private ArrayList <IFastFood> elementos;

    public Menu() {
        this.elementos = new ArrayList<>();
    }

    public ArrayList<IFastFood> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<IFastFood> elementos) {
        this.elementos = elementos;
    }
    
}
