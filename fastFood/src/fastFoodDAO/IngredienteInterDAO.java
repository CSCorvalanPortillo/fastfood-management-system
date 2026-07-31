
package fastFoodDAO;


import fastFoodModelos.Ingrediente;

public interface IngredienteInterDAO extends GenericDAO<Ingrediente> {

    Ingrediente buscarPorDescripcion(String descripcion);

}