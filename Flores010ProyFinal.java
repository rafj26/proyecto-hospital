import javax.swing.SwingUtilities;

public class Flores010ProyFinal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuInicio().setVisible(true);
            }
        });
    }
}
