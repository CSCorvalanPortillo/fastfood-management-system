package fastFoodBD;

import fastFoodModelos.Gerente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenteBD {

    private static final String RUTA = "gerente.txt";

    public GerenteBD() {
        crearArchivo();
    }

    private void crearArchivo() {

        File archivo = new File(RUTA);

        try {

            if (archivo.createNewFile()) {
                System.out.println("Archivo gerente.txt creado correctamente.");
            }

        } catch (IOException e) {

            System.out.println("Error al crear el archivo gerente.txt.");

        }

    }

    public void guardar(Gerente gerente) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {

            bw.write(
                    gerente.getID() + ","
                    + gerente.getDNI() + ","
                    + gerente.getNombre() + ","
                    + gerente.getApellido() + ","
                    + gerente.getUsuario() + ","
                    + gerente.getContraseña()
            );

            bw.newLine();

        } catch (IOException e) {

            System.out.println("Error al guardar el gerente.");

        }

    }

    public List<Gerente> leerTodos() {

        List<Gerente> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                Gerente gerente = new Gerente(
                        datos[0], // ID
                        datos[1], // DNI
                        datos[2], // Nombre
                        datos[3], // Apellido
                        datos[4], // Usuario
                        datos[5]  // Contraseña
                );

                lista.add(gerente);

            }

        } catch (IOException e) {

            System.out.println("Error al leer gerentes.");

        }

        return lista;

    }

    public void sobrescribir(List<Gerente> gerentes) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {

            for (Gerente gerente : gerentes) {

                bw.write(
                        gerente.getID() + ","
                        + gerente.getDNI() + ","
                        + gerente.getNombre() + ","
                        + gerente.getApellido() + ","
                        + gerente.getUsuario() + ","
                        + gerente.getContraseña()
                );

                bw.newLine();

            }

        } catch (IOException e) {

            System.out.println("Error al sobrescribir gerentes.");

        }

    }

}