package fastFoodBD;

import fastFoodModelos.Ingrediente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IngredienteBD {

    private static final String RUTA = "ingrediente.txt";


    public IngredienteBD() {

        crearArchivo();

    }


    private void crearArchivo() {

        File archivo = new File(RUTA);

        try {

            if (archivo.createNewFile()) {

                System.out.println("Archivo ingrediente.txt creado correctamente.");

            }

        } catch (IOException e) {

            System.out.println("Error al crear el archivo ingrediente.txt.");

        }

    }


    public void guardar(Ingrediente ingrediente) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {

            bw.write(
                    ingrediente.getID() + ","
                    + ingrediente.getDescripcion() + ","
                    + ingrediente.getPrecio()
            );

            bw.newLine();

        } catch (IOException e) {

            System.out.println("Error al guardar ingrediente.");

        }

    }


    public List<Ingrediente> leerTodos() {

        List<Ingrediente> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                Ingrediente ingrediente = new Ingrediente(
                        datos[0],
                        datos[1],
                        Double.parseDouble(datos[2])
                );

                lista.add(ingrediente);

            }

        } catch (IOException e) {

            System.out.println("Error al leer ingredientes.");

        }

        return lista;

    }


    public void sobrescribir(List<Ingrediente> ingredientes) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {

            for (Ingrediente ingrediente : ingredientes) {

                bw.write(
                        ingrediente.getID() + ","
                        + ingrediente.getDescripcion() + ","
                        + ingrediente.getPrecio()
                );

                bw.newLine();

            }

        } catch (IOException e) {

            System.out.println("Error al sobrescribir ingredientes.");

        }

    }

}