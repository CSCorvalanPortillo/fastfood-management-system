package fastFoodDAO;

import fastFoodBD.ProductoBD;
import fastFoodModelos.Producto;
import java.util.List;


public class ProductoDAO implements ProductoInterDAO {


    private ProductoBD productoBD;


    public ProductoDAO() {

        productoBD = new ProductoBD();

    }



    @Override
    public void guardar(Producto producto) {

        productoBD.guardar(producto);

    }



    @Override
    public Producto buscar(String id) {


        List<Producto> productos = productoBD.leerTodos();


        for (Producto producto : productos) {


            if (producto.getID().equals(id)) {

                return producto;

            }

        }


        return null;

    }



    @Override
    public Producto buscarPorDescripcion(String descripcion) {


        List<Producto> productos = productoBD.leerTodos();


        for (Producto producto : productos) {


            if (producto.getDescripcion().equalsIgnoreCase(descripcion)) {

                return producto;

            }

        }


        return null;

    }



    @Override
    public List<Producto> listar() {


        return productoBD.leerTodos();


    }



    @Override
    public void modificar(Producto objeto) {


        List<Producto> productos = productoBD.leerTodos();


        boolean encontrado = false;

        int i = 0;


        while (i < productos.size() && !encontrado) {


            if (productos.get(i).getID().equals(objeto.getID())) {


                productos.set(i, objeto);

                encontrado = true;


            }


            i++;

        }


        if (encontrado) {


            productoBD.sobrescribir(productos);


        } else {


            System.out.println("No se encontró el producto a modificar.");

        }


    }



    @Override
    public void eliminar(String id) {


        List<Producto> productos = productoBD.leerTodos();


        productos.removeIf(producto -> producto.getID().equals(id));


        productoBD.sobrescribir(productos);


    }


}