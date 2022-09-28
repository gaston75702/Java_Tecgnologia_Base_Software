package Negocio;

public class Vacuna {

    private String nombre;
    private int cantidad;

    public Vacuna(String nombre) {
        this.nombre = nombre;
        this.cantidad = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "  Vacuna " +
                "" + nombre + '\'' +
                "  cantidad = " + cantidad ;
    }
}
