package fastFoodDAO;

import fastFoodModelos.ProductoIngrediente;
import java.util.List;

public interface ProductoIngredienteInterDAO {


    void guardar(ProductoIngrediente relacion);


    List<ProductoIngrediente> listar();


    List<ProductoIngrediente> buscarPorProducto(String idProducto);


    List<ProductoIngrediente> buscarPorIngrediente(String idIngrediente);


    boolean existeRelacion(String idProducto, String idIngrediente);


    ProductoIngrediente buscarRelacion(String idProducto, String idIngrediente);


    void eliminarRelacion(String idProducto, String idIngrediente);

}