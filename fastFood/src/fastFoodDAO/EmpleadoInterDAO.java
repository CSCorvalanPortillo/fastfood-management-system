
package fastFoodDAO;

import fastFoodModelos.Empleado;

public interface EmpleadoInterDAO extends GenericDAO<Empleado> {

    Empleado login(String usuario, String clave);

    Empleado buscarPorDni(String dni);

}