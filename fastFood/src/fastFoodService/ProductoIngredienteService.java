package fastFoodService;

import fastFoodDAO.ProductoIngredienteDAO;
import fastFoodDAO.ProductoIngredienteInterDAO;
import fastFoodModelos.ProductoIngrediente;
import java.util.List;

public class ProductoIngredienteService {

    private ProductoIngredienteInterDAO productoIngredienteDAO;

    public ProductoIngredienteService() {

        productoIngredienteDAO = new ProductoIngredienteDAO();

    }

    public void agregarIngrediente(ProductoIngrediente relacion) {

        productoIngredienteDAO.guardar(relacion);

    }

    public List<ProductoIngrediente> listarRelaciones() {

        return productoIngredienteDAO.listar();

    }

    public List<ProductoIngrediente> buscarPorProducto(String idProducto) {

        return productoIngredienteDAO.buscarPorProducto(idProducto);

    }

    public List<ProductoIngrediente> buscarPorIngrediente(String idIngrediente) {

        return productoIngredienteDAO.buscarPorIngrediente(idIngrediente);

    }

    public boolean existeRelacion(String idProducto, String idIngrediente) {

        return productoIngredienteDAO.existeRelacion(idProducto, idIngrediente);

    }

    public void eliminarRelacion(String idProducto, String idIngrediente) {

        productoIngredienteDAO.eliminarRelacion(idProducto, idIngrediente);

    }

    public ProductoIngrediente buscarRelacion(String idProducto, String idIngrediente) {

        return productoIngredienteDAO.buscarRelacion(idProducto, idIngrediente);

    }

}
