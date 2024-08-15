import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TablaMedico {
    private DB db;

    public TablaMedico() {
        db = new DB();
    }

    public void agregarMedico(Medico medico) {
        try {
            String query = "INSERT INTO medico (cedula, nombre, apellido, telefono, especialidad) VALUES (?, ?, ?, ?, ?)";
            db.abrir();
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, medico.getCedula());
            ps.setString(2, medico.getNombre());
            ps.setString(3, medico.getApellido());
            ps.setString(4, medico.getTelefono());
            ps.setString(5, medico.getEspecialidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Medico buscarMedico(String cedula) {
        Medico medico = null;
        try {
            String query = "SELECT * FROM medico WHERE cedula = ?";
            db.abrir();
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                medico = new Medico(
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("especialidad")
                );
            }
            db.cerrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }

    public void modificarMedico(Medico medico) {
        try {
            String query = "UPDATE medico SET nombre = ?, apellido = ?, telefono = ?, especialidad = ? WHERE cedula = ?";
            db.abrir();
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getTelefono());
            ps.setString(4, medico.getEspecialidad());
            ps.setString(5, medico.getCedula());
            ps.executeUpdate();
            db.cerrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarMedico(String cedula) {
        try {
            String query = "DELETE FROM medico WHERE cedula = ?";
            db.abrir();
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ps.setString(1, cedula);
            ps.executeUpdate();
            db.cerrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medico> listarMedicos() {
        List<Medico> medicos = new ArrayList<>();
        try {
            String query = "SELECT cedula,nombre,apellido,telefono,especialidad FROM medico";
            db.abrir();
            Statement stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Medico medico = new Medico(
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("especialidad")
                );
                medicos.add(medico);
            }

            db.cerrar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }
}
