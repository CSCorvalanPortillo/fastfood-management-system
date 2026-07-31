package fastFoodBD;

import java.io.File;
import java.io.IOException;
import fastFoodModelos.Empleado;
import fastFoodModelos.Rol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoBD {

    private static final String RUTA = "empleado.txt";

    public EmpleadoBD() {
        crearArchivo();
    }

    private void crearArchivo() {

        File archivo = new File(RUTA);

        try {

            if (archivo.createNewFile()) {
                System.out.println("Archivo empleado.txt creado correctamente.");
            }

        } catch (IOException e) {

            System.out.println("Error al crear el archivo empleado.txt.");

        }
    }
    public void guardar(Empleado empleado) {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {

        bw.write(
                empleado.getID() + ","
                + empleado.getDNI() + ","
                + empleado.getNombre() + ","
                + empleado.getApellido() + ","
                + empleado.getUsuario() + ","
                + empleado.getContraseña() + ","
                + empleado.getRol()
        );

        bw.newLine();

    } catch (IOException e) {

        System.out.println("Error al guardar el empleado.");

    }

}
    public List<Empleado> leerTodos() {

    List<Empleado> lista = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {

        String linea;

        while ((linea = br.readLine()) != null) {

            String[] datos = linea.split(",");

            Empleado empleado = new Empleado(
                    datos[0],                  // ID
                    Rol.valueOf(datos[6]),     // Rol
                    datos[1],                  // DNI
                    datos[2],                  // Nombre
                    datos[3],                  // Apellido
                    datos[4],                  // Usuario
                    datos[5]                   // Contraseña
            );

            lista.add(empleado);

        }

    } catch (IOException e) {

        System.out.println("Error al leer empleados.");

    }

    return lista;

}
    public void sobrescribir(List<Empleado> empleados) {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {

        for (Empleado empleado : empleados) {

            bw.write(
                    empleado.getID() + ","
                    + empleado.getDNI() + ","
                    + empleado.getNombre() + ","
                    + empleado.getApellido() + ","
                    + empleado.getUsuario() + ","
                    + empleado.getContraseña() + ","
                    + empleado.getRol()
            );

            bw.newLine();
        }

    } catch (IOException e) {

        System.out.println("Error al sobrescribir empleados: " + e.getMessage());

    }

}
}