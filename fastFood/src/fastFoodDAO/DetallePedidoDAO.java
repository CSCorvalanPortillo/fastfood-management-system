package fastFoodDAO;


import fastFoodBD.DetallePedidoBD;
import fastFoodModelos.DetallePedido;
import java.util.List;


public class DetallePedidoDAO implements DetallePedidoInterDAO {


    private DetallePedidoBD detallePedidoBD;



    public DetallePedidoDAO() {

        detallePedidoBD = new DetallePedidoBD();

    }



    @Override
    public void guardar(DetallePedido detalle) {


        detallePedidoBD.guardar(detalle);


    }



    @Override
    public List<DetallePedido> listar() {


        return detallePedidoBD.leerTodos();


    }



    @Override
    public List<DetallePedido> buscarPorPedido(String IDPedido) {


        return detallePedidoBD.buscarPorPedido(IDPedido);


    }



    @Override
    public void eliminarPorPedido(String IDPedido) {


        List<DetallePedido> detalles =
                detallePedidoBD.leerTodos();



        detalles.removeIf(detalle ->
                detalle.getIDPedido().equals(IDPedido)
        );



        detallePedidoBD.sobrescribir(detalles);


    }


}