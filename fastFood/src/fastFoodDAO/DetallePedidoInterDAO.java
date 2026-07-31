package fastFoodDAO;

import fastFoodModelos.DetallePedido;
import java.util.List;


public interface DetallePedidoInterDAO {


    void guardar(DetallePedido detalle);


    List<DetallePedido> listar();


    List<DetallePedido> buscarPorPedido(String IDPedido);


    void eliminarPorPedido(String IDPedido);


}