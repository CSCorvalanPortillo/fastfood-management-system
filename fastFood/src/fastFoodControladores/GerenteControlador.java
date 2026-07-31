package fastFoodControladores;

import fastFoodModelos.Ingrediente;
import fastFoodView.IngredienteMenu;
import fastFoodModelos.Empleado;
import fastFoodModelos.Producto;
import fastFoodModelos.ProductoIngrediente;
import fastFoodModelos.Rol;
import fastFoodService.EmpleadoService;
import fastFoodService.GerenteService;
import fastFoodService.IngredienteService;
import fastFoodService.PedidoService;
import fastFoodService.ProductoIngredienteService;
import fastFoodService.ProductoService;
import fastFoodView.EmpleadoMenu;
import fastFoodView.GerenteMenu;
import fastFoodView.ProductoMenu;
import java.util.List;

public class GerenteControlador {

    private GerenteService gerenteService;
    private EmpleadoService empleadoService;
    private ProductoService productoService;
    private IngredienteService ingredienteService;
    private PedidoService pedidoService;
    private ProductoIngredienteService productoIngredienteService;

    private GerenteMenu gerenteMenu;
    private EmpleadoMenu empleadoMenu;
    private ProductoMenu productoMenu;
    private IngredienteMenu ingredienteMenu;

    public GerenteControlador() {

        gerenteService = new GerenteService();
        empleadoService = new EmpleadoService();
        productoService = new ProductoService();
        ingredienteService = new IngredienteService();
        pedidoService = new PedidoService();
        productoIngredienteService = new ProductoIngredienteService();

        gerenteMenu = new GerenteMenu();
        empleadoMenu = new EmpleadoMenu();
        productoMenu = new ProductoMenu();
        ingredienteMenu = new IngredienteMenu();

    }

    public void iniciarMenu() {

        int opcion;

        do {

            gerenteMenu.MostrarMenu();
            opcion = gerenteMenu.pedirOpcion();

            switch (opcion) {

                case 1:
                    gestionarEmpleados();
                    break;

                case 2:
                    gestionarProductos();
                    break;

                case 3:
                    gestionarIngredientes();
                    break;

                case 0:
                    System.out.println("Cerrando sesión...");
                    break;

                default:
                    System.out.println("Opción inválida.");

            }

        } while (opcion != 0);

    }

    private void gestionarEmpleados() {

        int opcion;

        do {

            empleadoMenu.mostrarMenu();
            opcion = empleadoMenu.pedirOpcion();

            switch (opcion) {

                case 1:
                    registrarEmpleado();
                    break;

                case 2:

                    List<Empleado> empleados = listarEmpleados();

                    empleadoMenu.mostrarEmpleados(empleados);

                    break;

                case 3:
                    buscarEmpleado();
                    break;

                case 4:
                    modificarEmpleado();
                    break;

                case 5:
                    eliminarEmpleado();
                    break;

                case 0:
                    System.out.println("Volviendo al menú gerente...");
                    break;

                default:
                    System.out.println("Opción inválida.");

            }

        } while (opcion != 0);

    }

    private void registrarEmpleado() {

        String ID;

        do {

            ID = empleadoMenu.pedirID();

            if (empleadoService.buscarEmpleado(ID) != null) {

                System.out.println("Ya existe un empleado con ese ID. Ingrese otro.");

            }

        } while (empleadoService.buscarEmpleado(ID) != null);

        String DNI;

        do {

            DNI = empleadoMenu.pedirDNI();

            if (empleadoService.buscarPorDni(DNI) != null) {

                System.out.println("Ya existe un empleado con ese DNI. Ingrese otro.");

            }

        } while (empleadoService.buscarPorDni(DNI) != null);

        empleadoMenu.limpiarBuffer();

        String nombre = empleadoMenu.pedirNombre();
        String apellido = empleadoMenu.pedirApellido();
        String usuario = empleadoMenu.pedirUsuario();
        String contraseña = empleadoMenu.pedirContraseña();
        String rolTexto = empleadoMenu.pedirRol();

        Empleado empleado = new Empleado(
                ID,
                Rol.valueOf(rolTexto.toUpperCase()),
                DNI,
                nombre,
                apellido,
                usuario,
                contraseña
        );

        empleadoService.registrarEmpleado(empleado);
        System.out.println();
        System.out.println("==================================");
        System.out.println("Empleado registrado correctamente.");
        System.out.println("==================================");

    }

    private void buscarEmpleado() {

        String id = empleadoMenu.pedirIDBusqueda();

        Empleado empleado = empleadoService.buscarEmpleado(id);

        if (empleado != null) {

            empleadoMenu.mostrarEmpleado(empleado);

        } else {

            System.out.println("No se encontró el empleado.");

        }

    }

    private void modificarEmpleado() {

        String ID = empleadoMenu.pedirIDModificar();

        Empleado empleadoActual = empleadoService.buscarEmpleado(ID);

        if (empleadoActual != null) {

            String DNI = empleadoMenu.pedirDNI();
            empleadoMenu.limpiarBuffer();
            String nombre = empleadoMenu.pedirNombre();
            String apellido = empleadoMenu.pedirApellido();
            String usuario = empleadoMenu.pedirUsuario();
            String contraseña = empleadoMenu.pedirContraseña();
            String rolTexto = empleadoMenu.pedirRol();

            Empleado empleadoModificado = new Empleado(
                    ID,
                    Rol.valueOf(rolTexto.toUpperCase()),
                    DNI,
                    nombre,
                    apellido,
                    usuario,
                    contraseña
            );

            empleadoService.modificarEmpleado(empleadoModificado);

            System.out.println();
            System.out.println("==================================");
            System.out.println("Empleado modificado correctamente.");
            System.out.println("==================================");

        } else {

            System.out.println("No existe un empleado con ese ID.");

        }

    }

    private void eliminarEmpleado() {

        String id = empleadoMenu.pedirIDEliminar();

        Empleado empleado = empleadoService.buscarEmpleado(id);

        if (empleado != null) {

            empleadoService.eliminarEmpleado(id);

            System.out.println();
            System.out.println("==================================");
            System.out.println("Empleado eliminado correctamente.");
            System.out.println("==================================");

        } else {

            System.out.println("No existe un empleado con ese ID.");

        }

    }

    public List<Empleado> listarEmpleados() {

        return empleadoService.listarEmpleados();

    }

    public void registrarEmpleado(Empleado empleado) {

        empleadoService.registrarEmpleado(empleado);

    }

    public void modificarEmpleado(Empleado empleado) {

        empleadoService.modificarEmpleado(empleado);

    }

    public void eliminarEmpleado(String id) {

        empleadoService.eliminarEmpleado(id);

    }

    private void gestionarProductos() {

        int opcion;

        do {

            productoMenu.mostrarMenu();

            opcion = productoMenu.pedirOpcion();

            switch (opcion) {

                case 1:

                    registrarProducto();

                    break;

                case 2:

                    List<Producto> productos = listarProductos();

                    productoMenu.mostrarProductos(productos);

                    break;

                case 3:

                    buscarProducto();
                    break;

                case 4:

                    modificarProducto();
                    break;

                case 5:

                    eliminarProducto();
                    break;
                case 6:
                    agregarIngredienteAProducto();
                    break;

                case 7:
                    quitarIngredienteDeProducto();
                    break;

                case 8:
                    verIngredientesProducto();
                    break;
                case 0:

                    System.out.println("Volviendo al menú gerente...");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 0);

    }

    private void registrarProducto() {

        String ID;

        do {

            ID = productoMenu.pedirID();

            if (productoService.buscarProducto(ID) != null) {

                System.out.println("Ya existe un producto con ese ID. Ingrese otro.");

            }

        } while (productoService.buscarProducto(ID) != null);

        String descripcion;

        do {

            descripcion = productoMenu.pedirDescripcion();

            if (productoService.buscarPorDescripcion(descripcion) != null) {

                System.out.println("Ya existe un producto con esa descripción. Ingrese otro.");

            }

        } while (productoService.buscarPorDescripcion(descripcion) != null);

        double precio = productoMenu.pedirPrecio();

        Producto producto = new Producto(
                ID,
                descripcion,
                precio
        );

        productoService.registrarProducto(producto);
        System.out.println();
        System.out.println("==================================");
        System.out.println("Producto registrado correctamente.");
        System.out.println("==================================");

        String respuesta = productoMenu.preguntarAgregarIngredientes();

        if (respuesta.equalsIgnoreCase("s")) {

            agregarIngredientesProducto(ID);

        }

    }

    private void agregarIngredientesProducto(String idProducto) {

        String continuar;

        do {

            Producto producto = productoService.buscarProducto(idProducto);

            String idIngrediente = productoMenu.pedirIDIngrediente();

            Ingrediente ingrediente = ingredienteService.buscarIngrediente(idIngrediente);

            if (ingrediente == null) {

                System.out.println("No existe el ingrediente.");

            } else {

                if (productoIngredienteService.existeRelacion(idProducto, idIngrediente)) {

                    System.out.println("Ese ingrediente ya está agregado.");

                } else {

                    boolean obligatorio = productoMenu.pedirObligatorio();

                    ProductoIngrediente relacion
                            = new ProductoIngrediente(
                                    idProducto,
                                    idIngrediente,
                                    obligatorio
                            );

                    productoIngredienteService.agregarIngrediente(relacion);

                    actualizarDisponibilidadProducto(producto);

                    System.out.println();
                    System.out.println("==================================");
                    System.out.println("Ingrediente agregado correctamente.");
                    System.out.println("==================================");

                }

            }

            continuar = productoMenu.continuarAgregandoIngredientes();

        } while (continuar.equalsIgnoreCase("s"));

    }

    public List<Producto> listarProductos() {

        return productoService.listarProductos();

    }

    private void buscarProducto() {

        String id = productoMenu.pedirIDBusqueda();

        Producto producto = productoService.buscarProducto(id);

        if (producto != null) {

            productoMenu.mostrarProducto(producto);

        } else {

            System.out.println("No se encontró el producto.");

        }

    }

    private void modificarProducto() {

        String ID = productoMenu.pedirIDModificar();

        Producto productoActual = productoService.buscarProducto(ID);

        if (productoActual != null) {

            String descripcion = productoMenu.pedirDescripcion();
            double precio = productoMenu.pedirPrecio();

            Producto productoModificado = new Producto(
                    ID,
                    descripcion,
                    precio
            );

            productoService.modificarProducto(productoModificado);

            System.out.println();
            System.out.println("==================================");
            System.out.println("Producto modificado correctamente.");
            System.out.println("==================================");

        } else {

            System.out.println("No existe un producto con ese ID.");

        }

    }

    private void eliminarProducto() {

        String id = productoMenu.pedirIDEliminar();

        Producto producto = productoService.buscarProducto(id);

        if (producto != null) {

            productoService.eliminarProducto(id);

            System.out.println();
            System.out.println("==================================");
            System.out.println("Producto eliminado correctamente.");
            System.out.println("==================================");

        } else {

            System.out.println("No existe un producto con ese ID.");

        }

    }

    private void quitarIngredienteDeProducto() {

        String idProducto = productoMenu.pedirIDProducto();

        Producto producto = productoService.buscarProducto(idProducto);

        if (producto == null) {

            System.out.println("No existe el producto.");

            return;

        }

        String idIngrediente = productoMenu.pedirIDIngrediente();

        ProductoIngrediente relacion
                = productoIngredienteService.buscarRelacion(
                        idProducto,
                        idIngrediente
                );

        if (relacion == null) {

            System.out.println("El ingrediente no está asociado al producto.");

            return;

        }

        if (relacion.isObligatorio()) {

            System.out.println(
                    "No se puede quitar. El ingrediente es obligatorio."
            );

            return;

        }

        productoIngredienteService.eliminarRelacion(
                idProducto,
                idIngrediente
        );

        actualizarDisponibilidadProducto(producto);

        System.out.println();
        System.out.println("==================================");
        System.out.println("Ingrediente eliminado correctamente.");
        System.out.println("==================================");

    }

    private void verIngredientesProducto() {

        String idProducto = productoMenu.pedirIDProducto();

        Producto producto = productoService.buscarProducto(idProducto);

        if (producto == null) {

            System.out.println("No existe el producto.");

            return;

        }

        List<ProductoIngrediente> relaciones
                = productoIngredienteService.buscarPorProducto(idProducto);

        if (relaciones.isEmpty()) {

            System.out.println("El producto no tiene ingredientes cargados.");

            return;

        }

        System.out.println();
        System.out.println("==============================");
        System.out.println(" INGREDIENTES DEL PRODUCTO");
        System.out.println("==============================");

        System.out.println("Producto: " + producto.getDescripcion());

        System.out.println();

        for (ProductoIngrediente relacion : relaciones) {

            Ingrediente ingrediente
                    = ingredienteService.buscarIngrediente(
                            relacion.getIDIngrediente()
                    );

            if (ingrediente != null) {

                System.out.print("- " + ingrediente.getDescripcion());

                if (relacion.isObligatorio()) {

                    System.out.println(" (Obligatorio)");

                } else {

                    System.out.println(" (Opcional)");

                }

            }

        }

    }

    private void gestionarIngredientes() {

        int opcion;

        do {

            ingredienteMenu.mostrarMenu();

            opcion = ingredienteMenu.pedirOpcion();

            switch (opcion) {

                case 1:

                    registrarIngrediente();

                    break;

                case 2:

                    List<Ingrediente> ingredientes = listarIngredientes();

                    ingredienteMenu.mostrarIngredientes(ingredientes);

                    break;

                case 3:

                    buscarIngrediente();

                    break;

                case 4:

                    modificarIngrediente();

                    break;

                case 5:

                    eliminarIngrediente();

                    break;

                case 0:

                    System.out.println("Volviendo al menú gerente...");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 0);

    }

    private void registrarIngrediente() {

        String ID;

        do {

            ID = ingredienteMenu.pedirID();

            if (ingredienteService.buscarIngrediente(ID) != null) {

                System.out.println("Ya existe un ingrediente con ese ID. Ingrese otro.");

            }

        } while (ingredienteService.buscarIngrediente(ID) != null);

        String descripcion;

        do {

            descripcion = ingredienteMenu.pedirDescripcion();

            if (ingredienteService.buscarPorDescripcion(descripcion) != null) {

                System.out.println("Ya existe un ingrediente con esa descripción. Ingrese otro.");

            }

        } while (ingredienteService.buscarPorDescripcion(descripcion) != null);

        double precio = ingredienteMenu.pedirPrecio();

        Ingrediente ingrediente = new Ingrediente(
                ID,
                descripcion,
                precio
        );

        ingredienteService.registrarIngrediente(ingrediente);

        System.out.println();
        System.out.println("==================================");
        System.out.println("Ingrediente registrado correctamente.");
        System.out.println("==================================");

    }

    public List<Ingrediente> listarIngredientes() {

        return ingredienteService.listarIngredientes();

    }

    private void buscarIngrediente() {

        String id = ingredienteMenu.pedirIDBusqueda();

        Ingrediente ingrediente = ingredienteService.buscarIngrediente(id);

        if (ingrediente != null) {

            ingredienteMenu.mostrarIngrediente(ingrediente);

        } else {

            System.out.println("No se encontró el ingrediente.");

        }

    }

    private void modificarIngrediente() {

        String ID = ingredienteMenu.pedirIDModificar();

        Ingrediente ingredienteActual = ingredienteService.buscarIngrediente(ID);

        if (ingredienteActual != null) {

            String descripcion = ingredienteMenu.pedirDescripcion();

            double precio = ingredienteMenu.pedirPrecio();

            Ingrediente ingredienteModificado = new Ingrediente(
                    ID,
                    descripcion,
                    precio
            );

            ingredienteService.modificarIngrediente(ingredienteModificado);

            System.out.println();
            System.out.println("==================================");
            System.out.println("Ingrediente modificado correctamente.");
            System.out.println("==================================");

        } else {

            System.out.println("No existe un ingrediente con ese ID.");

        }

    }

    private void eliminarIngrediente() {

        String id = ingredienteMenu.pedirIDEliminar();

        Ingrediente ingrediente = ingredienteService.buscarIngrediente(id);

        if (ingrediente != null) {

            ingredienteService.eliminarIngrediente(id);

            System.out.println();
            System.out.println("==================================");
            System.out.println("Ingrediente eliminado correctamente.");
            System.out.println("==================================");

        } else {

            System.out.println("No existe un ingrediente con ese ID.");

        }

    }

    private void agregarIngredienteAProducto() {

        String idProducto = productoMenu.pedirIDProducto();

        Producto producto = productoService.buscarProducto(idProducto);

        if (producto == null) {

            System.out.println("No existe el producto.");

            return;

        }

        String idIngrediente = productoMenu.pedirIDIngrediente();

        Ingrediente ingrediente = ingredienteService.buscarIngrediente(idIngrediente);

        if (ingrediente == null) {

            System.out.println("No existe el ingrediente.");

            return;

        }

        if (productoIngredienteService.existeRelacion(idProducto, idIngrediente)) {

            System.out.println("El ingrediente ya está agregado al producto.");

            return;

        }

        boolean obligatorio = productoMenu.pedirObligatorio();

        ProductoIngrediente relacion = new ProductoIngrediente(
                idProducto,
                idIngrediente,
                obligatorio
        );

        productoIngredienteService.agregarIngrediente(relacion);

        actualizarDisponibilidadProducto(producto);

        System.out.println("Ingrediente agregado correctamente al producto.");

    }

    private void actualizarDisponibilidadProducto(Producto producto) {

        List<ProductoIngrediente> ingredientesProducto
                = productoIngredienteService.buscarPorProducto(producto.getID());

        boolean disponible = false;

        for (ProductoIngrediente relacion : ingredientesProducto) {

            if (relacion.isObligatorio()) {

                disponible = true;

                break;

            }

        }

        producto.setDisponible(disponible);

        productoService.modificarProducto(producto);

    }
}
