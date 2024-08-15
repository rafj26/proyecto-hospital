import javax.swing.*;
import java.awt.event.*;

public class MenuInicio extends JFrame {
    public MenuInicio() {
        setTitle("Sistema de Gestión");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu inicioMenu = new JMenu("Inicio");
        JMenuItem presentacionItem = new JMenuItem("Presentación");
        JMenuItem salirItem = new JMenuItem("Salir");
        inicioMenu.add(presentacionItem);
        inicioMenu.add(salirItem);
        menuBar.add(inicioMenu);
        
        JMenu mantenimientoMenu = new JMenu("Mantenimiento");
        JMenuItem pacienteItem = new JMenuItem("Paciente");
        JMenuItem medicoItem = new JMenuItem("Médico");
        mantenimientoMenu.add(pacienteItem);
        mantenimientoMenu.add(medicoItem);
        menuBar.add(mantenimientoMenu);
        
        JMenu reporteMenu = new JMenu("Reporte");
        JMenuItem reportePacienteItem = new JMenuItem("Reporte de Pacientes");
        JMenuItem reporteMedicoItem = new JMenuItem("Reporte de Médicos");
        reporteMenu.add(reportePacienteItem);
        reporteMenu.add(reporteMedicoItem);
        menuBar.add(reporteMenu);
        
        setJMenuBar(menuBar);
        
        presentacionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setContentPane(new MenuPresentacion());
                revalidate();
            }
        });

        salirItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pacienteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setContentPane(new MenuPaciente());
                revalidate();
            }
        });

        medicoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setContentPane(new MenuMedico());
                revalidate();
            }
        });

        reportePacienteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setContentPane(new ReportePaciente());
                revalidate();
            }
        });

        reporteMedicoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setContentPane(new ReporteMedico());
                revalidate();
            }
        });
    }
}
