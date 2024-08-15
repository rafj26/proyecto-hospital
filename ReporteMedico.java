import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
 
public class ReporteMedico extends JPanel implements ActionListener{
    private JRadioButton rbPorApellido;
    private JRadioButton rbPorCedula;
    private JRadioButton rbPorEspecialidad;
    private JButton boton;
    public ReporteMedico() {
        setLayout(new BorderLayout());
 
        JLabel label = new JLabel("Reporte de Médicos");
        add(label, BorderLayout.NORTH);
 
        // Panel para los radio buttons
        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(3, 1));
 
        rbPorApellido = new JRadioButton("Ordenar por Apellido");
        rbPorCedula = new JRadioButton("Ordenar por Cédula");
        rbPorEspecialidad = new JRadioButton("Ordenar por Especialidad");
 
        // Agrupamos los radio buttons en un ButtonGroup para que solo se pueda seleccionar uno a la vez
        ButtonGroup grupoOrdenamiento = new ButtonGroup();
        grupoOrdenamiento.add(rbPorApellido);
        grupoOrdenamiento.add(rbPorCedula);
        grupoOrdenamiento.add(rbPorEspecialidad);
 
        panelOpciones.add(rbPorApellido);
        panelOpciones.add(rbPorCedula);
        panelOpciones.add(rbPorEspecialidad);
 
        boton = new JButton("REPORTE");
        boton.setBounds(230, 60, 100, 20);
        boton.addActionListener(this);
        panelOpciones.add(boton);
        add(panelOpciones, BorderLayout.CENTER);
    }
        public void reporte(String od)
       {
        try
        {
            DB base_datos = new DB();
            base_datos.abrir();
            Map<String,Object> parametro = new HashMap<>();
 
            parametro.put("orden",od);
 
            JasperPrint jasperPrint = JasperFillManager.fillReport("Medico.jasper",parametro, base_datos.getConnection());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);
            base_datos.cerrar();
        }
        catch(Exception e)
        {
             System.out.println("error reporte " + e.getMessage());
        }
    }

 
 
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == boton){
        if(rbPorApellido.isSelected()){
            reporte("apellido");
        }
        if(rbPorCedula.isSelected()){
            reporte("cedula");
        }
        if(rbPorEspecialidad.isSelected()){
            reporte("especialidad");
        }
    }
    }
      }
