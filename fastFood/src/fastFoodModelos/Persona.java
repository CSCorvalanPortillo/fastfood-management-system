package fastFoodModelos;

public abstract class Persona {

    private String DNI;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;

    public Persona(String DNI, String nombre, String apellido, String usuario, String contraseña) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    

}
