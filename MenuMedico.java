import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuMedico extends JPanel {
    private JTextField txtCedula, txtNombre, txtApellido, txtTelefono, txtEspecialidad;
    private JButton btnLimpiar, btnBuscar, btnAdicionar, btnModificar, btnEliminar, btnListar;
    private JTable table;
    private DefaultTableModel tableModel;
    private TablaMedico tablaMedico;

    public MenuMedico() {
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

        formPanel.add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        formPanel.add(txtEspecialidad);

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

        tableModel = new DefaultTableModel(new Object[]{"Cédula", "Nombre", "Apellido", "Teléfono", "Especialidad"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnBuscar.setEnabled(true);
        btnAdicionar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        // Add action listeners
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarMedico();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });

        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarMedico();
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarMedico();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarMedico();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarMedicos();
            }
        });

        tablaMedico = new TablaMedico();
    }

    private void buscarMedico() {
        String cedula = txtCedula.getText();
        Medico medico = tablaMedico.buscarMedico(cedula);
        if (medico != null) {
            txtNombre.setText(medico.getNombre());
            txtApellido.setText(medico.getApellido());
            txtTelefono.setText(medico.getTelefono());
            txtEspecialidad.setText(medico.getEspecialidad());
            txtCedula.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnAdicionar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Medico no encontrado.");
        }
    }

    private void limpiarFormulario() {
        txtCedula.setEnabled(true);
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtEspecialidad.setText("");
        btnBuscar.setEnabled(true);
        btnAdicionar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    private void adicionarMedico() {
        Medico medico = new Medico(
            txtCedula.getText(),
            txtNombre.getText(),
            txtApellido.getText(),
            txtTelefono.getText(),
            txtEspecialidad.getText()
        );
        tablaMedico.agregarMedico(medico);
        JOptionPane.showMessageDialog(this, "Medico agregado.");
        limpiarFormulario();
    }

    private void modificarMedico() {
        Medico medico = new Medico(
            txtCedula.getText(),
            txtNombre.getText(),
            txtApellido.getText(),
            txtTelefono.getText(),
            txtEspecialidad.getText()
        );
        tablaMedico.modificarMedico(medico);
        JOptionPane.showMessageDialog(this, "Medico modificado.");
        limpiarFormulario();
    }

    private void eliminarMedico() {
        String cedula = txtCedula.getText();
        tablaMedico.eliminarMedico(cedula);
        JOptionPane.showMessageDialog(this, "Medico eliminado.");
        limpiarFormulario();
    }

    private void listarMedicos() {
        List<Medico> medicos = tablaMedico.listarMedicos();
        tableModel.setRowCount(0);
        for (Medico medico : medicos) {
            tableModel.addRow(new Object[]{
                medico.getCedula(),
                medico.getNombre(),
                medico.getApellido(),
                medico.getTelefono(),
                medico.getEspecialidad()
            });
        }
    }
}
