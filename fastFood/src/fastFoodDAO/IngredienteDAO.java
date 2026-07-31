package fastFoodDAO;

import fastFoodBD.IngredienteBD;
import fastFoodModelos.Ingrediente;
import java.util.List;

public class IngredienteDAO implements IngredienteInterDAO {

    private IngredienteBD ingredienteBD;

    public IngredienteDAO() {

        ingredienteBD = new IngredienteBD();

    }


    @Override
    public void guardar(Ingrediente ingrediente) {

        ingredienteBD.guardar(ingrediente);

    }


    @Override
    public Ingrediente buscar(String id) {

        List<Ingrediente> ingredientes = ingredienteBD.leerTodos();

        for (Ingrediente ingrediente : ingredientes) {

            if (ingrediente.getID().equals(id)) {

                return ingrediente;

            }

        }

        return null;

    }


    @Override
    public Ingrediente buscarPorDescripcion(String descripcion) {

        List<Ingrediente> ingredientes = ingredienteBD.leerTodos();

        for (Ingrediente ingrediente : ingredientes) {

            if (ingrediente.getDescripcion().equalsIgnoreCase(descripcion)) {

                return ingrediente;

            }

        }

        return null;

    }


    @Override
    public List<Ingrediente> listar() {

        return ingredienteBD.leerTodos();

    }


    @Override
    public void modificar(Ingrediente objeto) {

        List<Ingrediente> ingredientes = ingredienteBD.leerTodos();

        boolean encontrado = false;

        int i = 0;


        while (i < ingredientes.size() && !encontrado) {


            if (ingredientes.get(i).getID().equals(objeto.getID())) {

                ingredientes.set(i, objeto);
                encontrado = true;

            }

            i++;

        }


        if (encontrado) {

            ingredienteBD.sobrescribir(ingredientes);

        } else {

            System.out.println("No se encontró el ingrediente a modificar.");

        }

    }


    @Override
    public void eliminar(String id) {

        List<Ingrediente> ingredientes = ingredienteBD.leerTodos();

        ingredientes.removeIf(ingrediente ->
                ingrediente.getID().equals(id)
        );


        ingredienteBD.sobrescribir(ingredientes);

    }

}