import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TablaPaciente {
    private DB db;

    public TablaPaciente() {
        db = new DB();
    }

    public void agregarPaciente(Paciente paciente) {
        try {
            String query = "INSERT INTO paciente (cedula, nombre, apellido, telefono, provincia) VALUES (?, ?, ?, ?, ?)";
            db.abrir();
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, paciente.getCedula());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getApellido());
            ps.setString(4, paciente.getTelefono());
            ps.setString(5, paciente.getProvincia());
            ps.executeUpdate();
            db.cerrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Paciente buscarPaciente(String cedula) {
        Paciente paciente = null;
        try {
            String query = "SELECT * FROM paciente WHERE cedula = ?";
            db.abrir();
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente(
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("provincia")
                );
            }
            db.cerrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public void modificarPaciente(Paciente paciente) {
        try {
            String query = "UPDATE paciente SET nombre = ?, apellido = ?, telefono = ?, provincia = ? WHERE cedula = ?";
            db.abrir();
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getTelefono());
            ps.setString(4, paciente.getProvincia());
            ps.setString(5, paciente.getCedula());
            ps.executeUpdate();
            db.cerrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPaciente(String cedula) {
        try {
            String query = "DELETE FROM paciente WHERE cedula = ?";
            db.abrir();
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, cedula);
            ps.executeUpdate();
            db.cerrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            String query = "SELECT cedula,nombre,apellido,telefono,provincia FROM paciente";
            db.abrir();
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("provincia")
                );
                pacientes.add(paciente);
            }
            db.cerrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }
}
