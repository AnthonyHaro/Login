import javax.swing.*;
import javax.swing.*;
import java.awt.*;

public class Formulario extends JFrame {
    private JTextArea textArea1;
    private JPanel panel1;

    // Modifica el constructor para aceptar el texto como parámetro
    public Formulario(String texto) {
        textArea1.setText(texto); // Establece el texto en el JTextArea
        panel1 = new JPanel(new BorderLayout());
        panel1.add(new JScrollPane(textArea1), BorderLayout.CENTER);
        add(panel1);
    }
}

