package fastFoodDAO;

import fastFoodBD.GerenteBD;
import fastFoodModelos.Gerente;
import java.util.List;

public class GerenteDAO implements GerenteInterDAO {

    private GerenteBD gerenteBD;

    public GerenteDAO() {
        gerenteBD = new GerenteBD();
    }

    @Override
    public Gerente login(String usuario, String clave) {

        List<Gerente> gerentes = gerenteBD.leerTodos();

        for (Gerente gerente : gerentes) {

            if (gerente.getUsuario().equals(usuario)
                    && gerente.getContraseña().equals(clave)) {

                return gerente;

            }

        }

        return null;

    }

    @Override
    public Gerente buscarPorDni(String dni) {

        List<Gerente> gerentes = gerenteBD.leerTodos();

        for (Gerente gerente : gerentes) {

            if (gerente.getDNI().equals(dni)) {

                return gerente;

            }

        }

        return null;

    }

    @Override
    public void guardar(Gerente objeto) {

        gerenteBD.guardar(objeto);

    }

    @Override
    public void modificar(Gerente objeto) {

        List<Gerente> gerentes = gerenteBD.leerTodos();

        boolean encontrado = false;
        int i = 0;

        while (i < gerentes.size() && !encontrado) {

            if (gerentes.get(i).getID().equals(objeto.getID())) {

                gerentes.set(i, objeto);
                encontrado = true;

            }

            i++;

        }

        if (encontrado) {

            gerenteBD.sobrescribir(gerentes);

        } else {

            System.out.println("No se encontró el gerente a modificar.");

        }

    }

    @Override
    public void eliminar(String id) {

        List<Gerente> gerentes = gerenteBD.leerTodos();

        boolean encontrado = false;
        int i = 0;

        while (i < gerentes.size() && !encontrado) {

            if (gerentes.get(i).getID().equals(id)) {

                gerentes.remove(i);
                encontrado = true;

            } else {

                i++;

            }

        }

        if (encontrado) {

            gerenteBD.sobrescribir(gerentes);

        } else {

            System.out.println("No se encontró el gerente a eliminar.");

        }

    }

    @Override
    public Gerente buscar(String id) {

        List<Gerente> gerentes = gerenteBD.leerTodos();

        for (Gerente gerente : gerentes) {

            if (gerente.getID().equals(id)) {

                return gerente;

            }

        }

        return null;

    }

    @Override
    public List<Gerente> listar() {

        return gerenteBD.leerTodos();

    }

}