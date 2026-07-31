package fastFoodDAO;

import fastFoodBD.ProductoIngredienteBD;
import fastFoodModelos.ProductoIngrediente;
import java.util.ArrayList;
import java.util.List;

public class ProductoIngredienteDAO implements ProductoIngredienteInterDAO {

    private ProductoIngredienteBD productoIngredienteBD;

    public ProductoIngredienteDAO() {

        productoIngredienteBD = new ProductoIngredienteBD();

    }

    @Override
    public void guardar(ProductoIngrediente relacion) {

        productoIngredienteBD.guardar(relacion);

    }

    @Override
    public List<ProductoIngrediente> listar() {

        return productoIngredienteBD.leerTodos();

    }

    @Override
    public List<ProductoIngrediente> buscarPorProducto(String idProducto) {

        List<ProductoIngrediente> resultado = new ArrayList<>();

        for (ProductoIngrediente relacion : productoIngredienteBD.leerTodos()) {

            if (relacion.getIDProducto().equals(idProducto)) {

                resultado.add(relacion);

            }

        }

        return resultado;

    }

    @Override
    public List<ProductoIngrediente> buscarPorIngrediente(String idIngrediente) {

        List<ProductoIngrediente> resultado = new ArrayList<>();

        for (ProductoIngrediente relacion : productoIngredienteBD.leerTodos()) {

            if (relacion.getIDIngrediente().equals(idIngrediente)) {

                resultado.add(relacion);

            }

        }

        return resultado;

    }

    @Override
    public boolean existeRelacion(String idProducto, String idIngrediente) {

        for (ProductoIngrediente relacion : productoIngredienteBD.leerTodos()) {

            if (relacion.getIDProducto().equals(idProducto)
                    && relacion.getIDIngrediente().equals(idIngrediente)) {

                return true;

            }

        }

        return false;

    }

    @Override
    public ProductoIngrediente buscarRelacion(String idProducto, String idIngrediente) {

        List<ProductoIngrediente> relaciones = productoIngredienteBD.leerTodos();

        for (ProductoIngrediente relacion : relaciones) {

            if (relacion.getIDProducto().equals(idProducto)
                    && relacion.getIDIngrediente().equals(idIngrediente)) {

                return relacion;

            }

        }

        return null;

    }

    @Override
    public void eliminarRelacion(String idProducto, String idIngrediente) {

        List<ProductoIngrediente> relaciones = productoIngredienteBD.leerTodos();

        relaciones.removeIf(relacion
                -> relacion.getIDProducto().equals(idProducto)
                && relacion.getIDIngrediente().equals(idIngrediente)
        );

        productoIngredienteBD.sobrescribir(relaciones);

    }

}
