package fastFoodDAO;


import fastFoodBD.PedidoBD;
import fastFoodModelos.EstadoPedido;
import fastFoodModelos.Pedido;
import java.util.ArrayList;
import java.util.List;



public class PedidoDAO implements PedidoInterDAO {


    private PedidoBD pedidoBD;



    public PedidoDAO(){

        pedidoBD = new PedidoBD();

    }




    @Override
    public void guardar(Pedido pedido){

        pedidoBD.guardar(pedido);

    }





    @Override
    public List<Pedido> listar(){

        return pedidoBD.leerTodos();

    }





    @Override
    public Pedido buscar(String ID){


        for(Pedido pedido: pedidoBD.leerTodos()){


            if(pedido.getID().equals(ID)){

                return pedido;

            }

        }


        return null;

    }






    @Override
    public List<Pedido> buscarPendientes(){


        List<Pedido> resultado = new ArrayList<>();


        for(Pedido pedido: pedidoBD.leerTodos()){


            if(pedido.getEstado()==EstadoPedido.PENDIENTE){

                resultado.add(pedido);

            }

        }


        return resultado;

    }







    @Override
    public void modificar(Pedido pedido){


        List<Pedido> pedidos =
                pedidoBD.leerTodos();



        for(int i=0;i<pedidos.size();i++){


            if(pedidos.get(i).getID().equals(pedido.getID())){


                pedidos.set(i,pedido);


            }


        }


        pedidoBD.sobrescribir(pedidos);

    }

}