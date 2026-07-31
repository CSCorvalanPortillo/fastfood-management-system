package fastFoodModelos;

public class ProductoIngrediente {

    private String IDProducto;
    private String IDIngrediente;
    private boolean obligatorio;


    public ProductoIngrediente(String idProducto, String idIngrediente, boolean obligatorio) {

        this.IDProducto = idProducto;
        this.IDIngrediente = idIngrediente;
        this.obligatorio = obligatorio;

    }


    public String getIDProducto() {

        return IDProducto;

    }


    public String getIDIngrediente() {

        return IDIngrediente;

    }


    public boolean isObligatorio() {

        return obligatorio;

    }


    @Override
    public String toString() {

        return "Producto=" + IDProducto +
               ", Ingrediente=" + IDIngrediente +
               ", Obligatorio=" + obligatorio;

    }

}