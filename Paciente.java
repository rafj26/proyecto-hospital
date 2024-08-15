public class Paciente extends Persona {
    private String provincia;

    public Paciente(String cedula, String nombre, String apellido, String telefono, String provincia) {
        super(cedula, nombre, apellido, telefono);
        this.provincia = provincia;
    }

    // Getters y Setters
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
}
