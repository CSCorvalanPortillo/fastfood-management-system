package fastFoodService;


import fastFoodDAO.DetallePedidoDAO;
import fastFoodDAO.DetallePedidoInterDAO;
import fastFoodModelos.DetallePedido;
import java.util.List;


public class DetallePedidoService {


    private DetallePedidoInterDAO detallePedidoDAO;



    public DetallePedidoService() {


        detallePedidoDAO = new DetallePedidoDAO();


    }



    public void registrarDetalle(DetallePedido detalle) {


        detallePedidoDAO.guardar(detalle);


    }



    public List<DetallePedido> listarDetalles() {


        return detallePedidoDAO.listar();


    }



    public List<DetallePedido> buscarPorPedido(String IDPedido) {


        return detallePedidoDAO.buscarPorPedido(IDPedido);


    }



    public void eliminarDetallesPedido(String IDPedido) {


        detallePedidoDAO.eliminarPorPedido(IDPedido);


    }


}