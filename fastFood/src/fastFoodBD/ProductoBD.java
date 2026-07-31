package fastFoodBD;

import fastFoodModelos.Producto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoBD {

    private static final String RUTA = "productos.txt";

    public ProductoBD() {

        crearArchivo();

    }

    private void crearArchivo() {

        File archivo = new File(RUTA);

        try {

            if (archivo.createNewFile()) {

                System.out.println("Archivo productos.txt creado correctamente.");

            }

        } catch (IOException e) {

            System.out.println("Error al crear el archivo productos.txt.");

        }

    }

    public void guardar(Producto producto) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {

            bw.write(
                    producto.getID() + ","
                    + producto.getDescripcion() + ","
                    + producto.getPrecio() + ","
                    + producto.isDisponible()
            );

            bw.newLine();

        } catch (IOException e) {

            System.out.println("Error al guardar producto.");

        }

    }

    public List<Producto> leerTodos() {

        List<Producto> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                Producto producto = new Producto(
                        datos[0],
                        datos[1],
                        Double.parseDouble(datos[2])
                );

                producto.setDisponible(Boolean.parseBoolean(datos[3]));

                lista.add(producto);

            }

        } catch (IOException e) {

            System.out.println("Error al leer productos.");

        }

        return lista;

    }

    public void sobrescribir(List<Producto> productos) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {

            for (Producto producto : productos) {

                bw.write(
                        producto.getID() + ","
                        + producto.getDescripcion() + ","
                        + producto.getPrecio() + ","
                        + producto.isDisponible()
                );

                bw.newLine();

            }

        } catch (IOException e) {

            System.out.println("Error al sobrescribir productos.");

        }

    }

}
