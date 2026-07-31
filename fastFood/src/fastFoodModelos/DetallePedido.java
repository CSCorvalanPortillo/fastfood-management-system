package fastFoodModelos;


public class DetallePedido {

    private String IDPedido;
    private String IDProducto;
    private int cantidad;
    private double precioVenta;


    public DetallePedido(String IDPedido, String IDProducto, int cantidad, double precioVenta) {

        this.IDPedido = IDPedido;
        this.IDProducto = IDProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;

    }


    public String getIDPedido() {

        return IDPedido;

    }


    public String getIDProducto() {

        return IDProducto;

    }


    public int getCantidad() {

        return cantidad;

    }


    public double getPrecioVenta() {

        return precioVenta;

    }


    public double calcularSubtotal() {

        return cantidad * precioVenta;

    }


    @Override
    public String toString() {

        return "Producto: " + IDProducto +
               " | Cantidad: " + cantidad +
               " | Precio: " + precioVenta +
               " | Subtotal: " + calcularSubtotal();

    }

}