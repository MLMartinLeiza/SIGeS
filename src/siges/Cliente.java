package siges;

public class Cliente {

    private String nombre;
    private String dni;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Cliente:\n"
                + "  Nombre: " + nombre + "\n"
                + "  DNI: " + dni;
    }

}
