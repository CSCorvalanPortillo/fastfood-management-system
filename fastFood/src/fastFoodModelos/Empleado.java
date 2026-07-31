package fastFoodModelos;

public class Empleado extends Persona {

    private String ID;
    private Rol rol;

    public Empleado(String ID,
            Rol rol,
            String DNI,
            String nombre,
            String apellido,
            String usuario,
            String contraseña) {

        super(DNI, nombre, apellido, usuario, contraseña);

        this.ID = ID;
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", ID='" + ID + '\''
                + ", Rol=" + rol;
    }
}
