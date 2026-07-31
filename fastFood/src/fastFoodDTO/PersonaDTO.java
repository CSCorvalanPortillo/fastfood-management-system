
package fastFoodDTO;


public abstract class PersonaDTO {
    private String DNI;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;

    public PersonaDTO() {
    }

    

    public PersonaDTO(String DNI, String nombre, String apellido, String usuario, String contraseña) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    

}
