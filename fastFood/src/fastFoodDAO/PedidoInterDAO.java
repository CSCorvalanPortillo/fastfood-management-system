package fastFoodDAO;


import fastFoodModelos.Pedido;
import java.util.List;


public interface PedidoInterDAO {


    void guardar(Pedido pedido);


    List<Pedido> listar();


    Pedido buscar(String ID);


    List<Pedido> buscarPendientes();


    void modificar(Pedido pedido);


}