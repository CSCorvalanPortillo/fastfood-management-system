package fastFoodBD;

import fastFoodModelos.ProductoIngrediente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoIngredienteBD {

    private static final String RUTA = "productoIngrediente.txt";

    public ProductoIngredienteBD() {

        crearArchivo();

    }

    private void crearArchivo() {

        File archivo = new File(RUTA);

        try {

            if (archivo.createNewFile()) {

                System.out.println("Archivo productoIngrediente.txt creado correctamente.");

            }

        } catch (IOException e) {

            System.out.println("Error al crear el archivo productoIngrediente.txt.");

        }

    }

    public void guardar(ProductoIngrediente productoIngrediente) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {

            bw.write(
                    productoIngrediente.getIDProducto() + ","
                    + productoIngrediente.getIDIngrediente() + ","
                    + productoIngrediente.isObligatorio()
            );

            bw.newLine();

        } catch (IOException e) {

            System.out.println("Error al guardar la relación producto-ingrediente.");

        }

    }

    public List<ProductoIngrediente> leerTodos() {

        List<ProductoIngrediente> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                ProductoIngrediente productoIngrediente = new ProductoIngrediente(
                        datos[0],
                        datos[1],
                        Boolean.parseBoolean(datos[2])
                );

                lista.add(productoIngrediente);

            }

        } catch (IOException e) {

            System.out.println("Error al leer productoIngrediente.");

        }

        return lista;

    }

    public void sobrescribir(List<ProductoIngrediente> lista) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {

            for (ProductoIngrediente productoIngrediente : lista) {

                bw.write(
                        productoIngrediente.getIDProducto() + ","
                        + productoIngrediente.getIDIngrediente() + ","
                        + productoIngrediente.isObligatorio()
                );

                bw.newLine();

            }

        } catch (IOException e) {

            System.out.println("Error al sobrescribir productoIngrediente.");

        }

    }

}
