package fastFoodBD;


import fastFoodModelos.EstadoPedido;
import fastFoodModelos.Pedido;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PedidoBD {


    private static final String RUTA = "pedidos.txt";


    public PedidoBD(){

        crearArchivo();

    }



    private void crearArchivo(){

        File archivo = new File(RUTA);


        try {

            archivo.createNewFile();

        } catch(IOException e){

            System.out.println("Error al crear pedidos.txt");

        }

    }




    public void guardar(Pedido pedido){


        try(BufferedWriter bw =
                new BufferedWriter(new FileWriter(RUTA,true))){


            bw.write(
                    pedido.getID()+","
                    +pedido.getFecha()+","
                    +pedido.getEstado()+","
                    +pedido.getIDEmpleado()
            );


            bw.newLine();


        }catch(IOException e){

            System.out.println("Error al guardar pedido.");

        }

    }






    public List<Pedido> leerTodos(){


        List<Pedido> lista = new ArrayList<>();


        try(BufferedReader br =
                new BufferedReader(new FileReader(RUTA))){


            String linea;


            while((linea=br.readLine())!=null){


                String datos[] = linea.split(",");



                Pedido pedido =
                        new Pedido(
                                datos[0],
                                LocalDate.parse(datos[1]),
                                datos[3]
                        );


                pedido.setEstado(
                        EstadoPedido.valueOf(datos[2])
                );


                lista.add(pedido);


            }


        }catch(IOException e){

            System.out.println("Error al leer pedidos.");

        }


        return lista;

    }





    public void sobrescribir(List<Pedido> pedidos){


        try(BufferedWriter bw =
                new BufferedWriter(new FileWriter(RUTA))){


            for(Pedido pedido: pedidos){


                bw.write(
                    pedido.getID()+","
                    +pedido.getFecha()+","
                    +pedido.getEstado()+","
                    +pedido.getIDEmpleado()
                );


                bw.newLine();

            }


        }catch(IOException e){

            System.out.println("Error al sobrescribir pedidos.");

        }

    }

}