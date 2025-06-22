package siges;

import java.time.LocalDate;

public class Registro {

    private Cliente cliente;
    private Servicio servicio;
    private LocalDate fecha;

    public Registro(Cliente cliente, Servicio servicio, LocalDate fecha) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Registro:\n"
                + "  Fecha: " + fecha + "\n"
                + "  Cliente: " + cliente.getNombre() + "\n"
                + "  Servicio: " + servicio.getDescripcion() + " ($" + servicio.getCosto() + ")";
    }

}
