package siges;

public class Servicio {

    private String descripcion;
    private double costo;

    public Servicio(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Servicio:\n"
                + "  Descripción: " + descripcion + "\n"
                + "  Costo: $" + costo;
    }

}
