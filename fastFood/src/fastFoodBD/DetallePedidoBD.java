package fastFoodBD;

import fastFoodModelos.DetallePedido;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DetallePedidoBD {


    private static final String RUTA = "detallePedido.txt";


    public DetallePedidoBD() {

        crearArchivo();

    }



    private void crearArchivo() {

        File archivo = new File(RUTA);


        try {

            if (archivo.createNewFile()) {

                System.out.println("Archivo detallePedido.txt creado correctamente.");

            }

        } catch (IOException e) {

            System.out.println("Error al crear el archivo detallePedido.txt.");

        }

    }



    public void guardar(DetallePedido detallePedido) {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {


            bw.write(
                    detallePedido.getIDPedido() + ","
                    + detallePedido.getIDProducto() + ","
                    + detallePedido.getCantidad() + ","
                    + detallePedido.getPrecioVenta()
            );


            bw.newLine();


        } catch (IOException e) {

            System.out.println("Error al guardar detalle del pedido.");

        }

    }




    public List<DetallePedido> leerTodos() {


        List<DetallePedido> lista = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {


            String linea;


            while ((linea = br.readLine()) != null) {


                String[] datos = linea.split(",");



                DetallePedido detalle = new DetallePedido(

                        datos[0],
                        datos[1],
                        Integer.parseInt(datos[2]),
                        Double.parseDouble(datos[3])

                );


                lista.add(detalle);


            }


        } catch (IOException e) {

            System.out.println("Error al leer detalles de pedidos.");

        }


        return lista;

    }





    public List<DetallePedido> buscarPorPedido(String IDPedido) {


        List<DetallePedido> resultado = new ArrayList<>();


        for (DetallePedido detalle : leerTodos()) {


            if (detalle.getIDPedido().equals(IDPedido)) {


                resultado.add(detalle);


            }

        }


        return resultado;

    }





    public void sobrescribir(List<DetallePedido> detalles) {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {


            for (DetallePedido detalle : detalles) {


                bw.write(
                        detalle.getIDPedido() + ","
                        + detalle.getIDProducto() + ","
                        + detalle.getCantidad() + ","
                        + detalle.getPrecioVenta()
                );


                bw.newLine();


            }


        } catch (IOException e) {

            System.out.println("Error al sobrescribir detalles de pedido.");

        }

    }

}