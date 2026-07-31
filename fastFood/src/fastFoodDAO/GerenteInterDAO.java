
package fastFoodDAO;

import fastFoodModelos.Gerente;

public interface GerenteInterDAO extends GenericDAO<Gerente> {

    Gerente login(String usuario, String clave);

    Gerente buscarPorDni(String dni);

}