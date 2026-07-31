
package fastFoodDAO;

import java.util.List;

public interface GenericDAO<T> {

    void guardar(T objeto);

    void modificar(T objeto);

    void eliminar(String id);

    T buscar(String id);

    List<T> listar();
}

