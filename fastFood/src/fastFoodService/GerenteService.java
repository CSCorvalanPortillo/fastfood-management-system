package fastFoodService;

import fastFoodDAO.GerenteDAO;
import fastFoodModelos.Gerente;
import java.util.List;

public class GerenteService {

    private GerenteDAO gerenteDAO;

    public GerenteService() {
        gerenteDAO = new GerenteDAO();
    }

    public void registrarGerente(Gerente gerente) {
        gerenteDAO.guardar(gerente);
    }

    public void modificarGerente(Gerente gerente) {
        gerenteDAO.modificar(gerente);
    }

    public void eliminarGerente(String id) {
        gerenteDAO.eliminar(id);
    }

    public Gerente buscarGerente(String id) {
        return gerenteDAO.buscar(id);
    }

    public Gerente buscarPorDni(String dni) {
        return gerenteDAO.buscarPorDni(dni);
    }

    public List<Gerente> listarGerentes() {
        return gerenteDAO.listar();
    }

    public Gerente iniciarSesion(String usuario, String clave) {
        return gerenteDAO.login(usuario, clave);
    }

}