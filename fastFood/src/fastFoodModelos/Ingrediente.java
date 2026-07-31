package fastFoodModelos;

public class Ingrediente {

    private String ID;
    private String descripcion;
    private double precio;

    public Ingrediente(String ID, String descripcion, double precio) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.precio = precio;
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

    @Override
    public String toString() {

        return "ID='" + ID + '\''
                + ", Descripcion='" + descripcion + '\''
                + ", Precio=" + precio;

    }

}
