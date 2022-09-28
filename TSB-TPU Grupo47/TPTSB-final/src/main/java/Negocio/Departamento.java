package Negocio;

public class Departamento {
    private String codigo;
    private String nombre;
    public Contador contador;

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        contador = new Contador();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }



    @Override
    public String toString() {
        return " |||| Departamento{" +
                "|||| \ncodigo = '" + codigo + '\'' +
                ", \nnombre = '" + nombre + '\'' +
                ", \n " + contador +
                '}';
    }
}
