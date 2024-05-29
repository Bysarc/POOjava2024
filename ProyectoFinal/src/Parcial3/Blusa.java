package Parcial3;

public class Blusa extends Componente {
    private static final long serialVersionUID = 1L;
    private boolean mangaLarga;

    public Blusa(int id, String nombre, String talla, String color, boolean esComunitario, double precio, boolean mangaLarga) {
        super(id, nombre, talla, color, esComunitario, precio);
        this.mangaLarga = mangaLarga;
    }

    public boolean isMangaLarga() {
        return mangaLarga;
    }

    

    public void setMangaLarga(boolean mangaLarga) {
        this.mangaLarga = mangaLarga;
    }

    @Override
    public String toString() {
        return "Blusa{" +
                "mangaLarga=" + mangaLarga +
                "} " + super.toString();
    }
}