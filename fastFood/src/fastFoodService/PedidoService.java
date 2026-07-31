package fastFoodService;

import fastFoodDAO.PedidoDAO;
import fastFoodDAO.PedidoInterDAO;
import fastFoodModelos.EstadoPedido;
import fastFoodModelos.Pedido;
import java.util.List;

public class PedidoService {

    private PedidoInterDAO pedidoDAO;


    public PedidoService() {

        pedidoDAO = new PedidoDAO();

    }


    public void registrarPedido(Pedido pedido) {

        pedidoDAO.guardar(pedido);

    }


    public List<Pedido> listarPedidos() {

        return pedidoDAO.listar();

    }


    public Pedido buscarPedido(String id) {

        return pedidoDAO.buscar(id);

    }


    public List<Pedido> listarPendientes() {

        return pedidoDAO.buscarPendientes();

    }


    public void modificarPedido(Pedido pedido) {

        pedidoDAO.modificar(pedido);

    }


    public void cambiarEstado(String idPedido, EstadoPedido estado) {

        Pedido pedido = pedidoDAO.buscar(idPedido);


        if (pedido != null) {

            pedido.setEstado(estado);

            pedidoDAO.modificar(pedido);

        }

    }

}