
package fastFoodDTO;


public class EmpleadoDTO extends PersonaDTO {
    private String rol;
    private String ID;

    

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(String rol, String ID) {
        this.rol = rol;
        this.ID = ID;
    }
   
    
}
