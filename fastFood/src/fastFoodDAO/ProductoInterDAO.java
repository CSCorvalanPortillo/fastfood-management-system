
package fastFoodDAO;

import fastFoodModelos.Producto;

public interface ProductoInterDAO extends GenericDAO<Producto> {

    Producto buscarPorDescripcion(String descripcion);

}