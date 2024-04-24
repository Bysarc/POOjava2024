/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo2.taller2.Restaurante;

/**
 *
 * @author SERGIO ROJAS
 */
public abstract class Receta implements IFastFood{
    private String nombre;
    String[] ingredientes;
    private String [] pasosPreparacion;

    public Receta(String nombre, String[] ingredientes, String[] pasosPreparacion) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.pasosPreparacion = pasosPreparacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String[] getPasosPreparacion() {
        return pasosPreparacion;
    }

    public void setPasosPreparacion(String[] pasosPreparacion) {
        this.pasosPreparacion = pasosPreparacion;
    }
    
}
