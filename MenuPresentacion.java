import javax.swing.*;
import java.awt.BorderLayout;

public class MenuPresentacion extends JPanel {
    public MenuPresentacion() {
        // Crear un área de texto con el contenido
        JTextArea textArea = new JTextArea();
        textArea.setText("Universidad Tecnológica de Panamá\n"
                        + "Facultad de Ingeniería Computacional\n\n"
                        + "Desarrollo de Software II\n\n");
        textArea.setEditable(false);
        
        // Añadir el área de texto al panel
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
}
