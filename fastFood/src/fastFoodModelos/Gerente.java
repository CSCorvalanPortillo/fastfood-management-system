package fastFoodModelos;

public class Gerente extends Persona {

    private String ID;

    public Gerente(String ID,
                   String DNI,
                   String nombre,
                   String apellido,
                   String usuario,
                   String contraseña) {

        super(DNI, nombre, apellido, usuario, contraseña);

        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {

        return super.toString()
                + ", ID='" + ID + '\'';

    }

}