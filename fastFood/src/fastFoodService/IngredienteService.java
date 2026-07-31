package fastFoodService;

import fastFoodDAO.IngredienteDAO;
import fastFoodDAO.IngredienteInterDAO;
import fastFoodModelos.Ingrediente;
import java.util.List;

public class IngredienteService {

    private IngredienteInterDAO ingredienteDAO;


    public IngredienteService() {

        ingredienteDAO = new IngredienteDAO();

    }


    public void registrarIngrediente(Ingrediente ingrediente) {

        ingredienteDAO.guardar(ingrediente);

    }


    public void modificarIngrediente(Ingrediente ingrediente) {

        ingredienteDAO.modificar(ingrediente);

    }


    public void eliminarIngrediente(String id) {

        ingredienteDAO.eliminar(id);

    }


    public Ingrediente buscarIngrediente(String id) {

        return ingredienteDAO.buscar(id);

    }


    public Ingrediente buscarPorDescripcion(String descripcion) {

        return ingredienteDAO.buscarPorDescripcion(descripcion);

    }


    public List<Ingrediente> listarIngredientes() {

        return ingredienteDAO.listar();

    }

}