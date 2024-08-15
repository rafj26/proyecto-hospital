import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuPaciente extends JPanel {
    private JTextField txtCedula, txtNombre, txtApellido, txtTelefono, txtProvincia;
    private JButton btnLimpiar, btnBuscar, btnAdicionar, btnModificar, btnEliminar, btnListar;
    private JTable table;
    private DefaultTableModel tableModel;
    private TablaPaciente tablaPaciente;

    public MenuPaciente() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        formPanel.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        formPanel.add(txtCedula);

        formPanel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        formPanel.add(txtNombre);

        formPanel.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        formPanel.add(txtApellido);

        formPanel.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        formPanel.add(txtTelefono);

        formPanel.add(new JLabel("Provincia:"));
        txtProvincia = new JTextField();
        formPanel.add(txtProvincia);

        btnLimpiar = new JButton("Limpiar");
        btnBuscar = new JButton("Buscar");
        btnAdicionar = new JButton("Adicionar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnListar = new JButton("Listar");

        formPanel.add(btnLimpiar);
        formPanel.add(btnBuscar);
        formPanel.add(btnAdicionar);
        formPanel.add(btnModificar);
        formPanel.add(btnEliminar);
        formPanel.add(btnListar);
        
        add(formPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Cédula", "Nombre", "Apellido", "Teléfono", "Provincia"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnBuscar.setEnabled(true);
        btnAdicionar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        // Add action listeners
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPaciente();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });

        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarPaciente();
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarPaciente();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarPaciente();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarPacientes();
            }
        });

        tablaPaciente = new TablaPaciente();
    }

    private void buscarPaciente() {
        String cedula = txtCedula.getText();
        Paciente paciente = tablaPaciente.buscarPaciente(cedula);
        if (paciente != null) {
            txtNombre.setText(paciente.getNombre());
            txtApellido.setText(paciente.getApellido());
            txtTelefono.setText(paciente.getTelefono());
            txtProvincia.setText(paciente.getProvincia());
            txtCedula.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnAdicionar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Paciente no encontrado.");
        }
    }

    private void limpiarFormulario() {
        txtCedula.setEnabled(true);
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtProvincia.setText("");
        btnBuscar.setEnabled(true);
        btnAdicionar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    private void adicionarPaciente() {
        Paciente paciente = new Paciente(
            txtCedula.getText(),
            txtNombre.getText(),
            txtApellido.getText(),
            txtTelefono.getText(),
            txtProvincia.getText()
        );
        tablaPaciente.agregarPaciente(paciente);
        JOptionPane.showMessageDialog(this, "Paciente agregado.");
        limpiarFormulario();
    }

    private void modificarPaciente() {
        Paciente paciente = new Paciente(
            txtCedula.getText(),
            txtNombre.getText(),
            txtApellido.getText(),
            txtTelefono.getText(),
            txtProvincia.getText()
        );
        tablaPaciente.modificarPaciente(paciente);
        JOptionPane.showMessageDialog(this, "Paciente modificado.");
        limpiarFormulario();
    }

    private void eliminarPaciente() {
        String cedula = txtCedula.getText();
        tablaPaciente.eliminarPaciente(cedula);
        JOptionPane.showMessageDialog(this, "Paciente eliminado.");
        limpiarFormulario();
    }

    private void listarPacientes() {
        List<Paciente> pacientes = tablaPaciente.listarPacientes();
        tableModel.setRowCount(0);
        for (Paciente paciente : pacientes) {
            tableModel.addRow(new Object[]{
                paciente.getCedula(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getTelefono(),
                paciente.getProvincia()
            });
        }
    }
}
