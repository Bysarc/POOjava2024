package Parcial3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Traje implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Componente> piezas;
    private String nombre;

    public Traje(String nombre) {
        this.nombre = nombre;
        this.piezas = new ArrayList<>();
    }

    public List<Componente> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Componente> piezas) {
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Traje{" +
                "piezas=" + piezas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
