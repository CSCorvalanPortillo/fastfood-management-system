package fastFoodModelos;

import java.time.LocalDate;


public class Pedido {

    private String ID;
    private LocalDate fecha;
    private EstadoPedido estado;
    private String IDEmpleado;


    public Pedido(String ID, LocalDate fecha, String IDEmpleado) {

        this.ID = ID;
        this.fecha = fecha;
        this.IDEmpleado = IDEmpleado;
        this.estado = EstadoPedido.PENDIENTE;

    }


    public String getID() {

        return ID;

    }


    public LocalDate getFecha() {

        return fecha;

    }


    public EstadoPedido getEstado() {

        return estado;

    }


    public String getIDEmpleado() {

        return IDEmpleado;

    }


    public void setEstado(EstadoPedido estado) {

        this.estado = estado;

    }


    @Override
    public String toString() {

        return "Pedido: " + ID +
                " | Fecha: " + fecha +
                " | Estado: " + estado +
                " | Empleado: " + IDEmpleado;

    }

}