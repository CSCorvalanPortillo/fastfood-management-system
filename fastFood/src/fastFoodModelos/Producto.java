package fastFoodModelos;

public class Producto {

    private String ID;
    private String descripcion;
    private double precio;
    private boolean disponible;


    public Producto(String ID, String descripcion, double precio) {

        this.ID = ID;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = false;

    }


    public String getID() {

        return ID;

    }


    public String getDescripcion() {

        return descripcion;

    }


    public double getPrecio() {

        return precio;

    }


    public boolean isDisponible() {

        return disponible;

    }


    public void setDisponible(boolean disponible) {

        this.disponible = disponible;

    }


    @Override
    public String toString() {

        return "ID=" + ID +
                ", Descripcion=" + descripcion +
                ", Precio=" + precio +
                ", Disponible=" + disponible;

    }

}