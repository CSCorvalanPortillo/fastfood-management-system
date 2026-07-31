package fastFoodService;

import fastFoodDAO.ProductoDAO;
import fastFoodModelos.Producto;
import java.util.List;


public class ProductoService {


    private ProductoDAO productoDAO;


    public ProductoService() {

        productoDAO = new ProductoDAO();

    }



    public void registrarProducto(Producto producto) {


        if (productoDAO.buscar(producto.getID()) != null) {

            System.out.println("Ya existe un producto con ese ID.");

            return;

        }


        if (productoDAO.buscarPorDescripcion(producto.getDescripcion()) != null) {

            System.out.println("Ya existe un producto con esa descripción.");

            return;

        }


        productoDAO.guardar(producto);


        System.out.println("Producto registrado correctamente.");

    }



    public void modificarProducto(Producto producto) {

        productoDAO.modificar(producto);

    }



    public void eliminarProducto(String id) {

        productoDAO.eliminar(id);

    }



    public Producto buscarProducto(String id) {

        return productoDAO.buscar(id);

    }



    public Producto buscarPorDescripcion(String descripcion) {

        return productoDAO.buscarPorDescripcion(descripcion);

    }



    public List<Producto> listarProductos() {

        return productoDAO.listar();

    }


}