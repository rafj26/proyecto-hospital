public class Medico extends Persona {
    private String especialidad;

    public Medico(String cedula, String nombre, String apellido, String telefono, String especialidad) {
        super(cedula, nombre, apellido, telefono);
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
