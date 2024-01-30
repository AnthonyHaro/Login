import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class login {
    JPanel login;
    private JLabel titulo;
    private JLabel User;
    private JTextField textField1;
    private JLabel Contraseña;
    private JButton ingresarButton;
    private JLabel validacion;
    private JPasswordField contraPasswordField;

    public login() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textField1.getText();
                char[] contrasenaChar = contraPasswordField.getPassword();
                String contrasena = new String(contrasenaChar);
                try {
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/registros", "root", "");
                    String consulta = "SELECT * FROM usuarios WHERE user = ? AND contra = ?";
                    PreparedStatement statement = conexion.prepareStatement(consulta);
                    statement.setString(1, usuario);
                    statement.setString(2, contrasena);
                    ResultSet resultado = statement.executeQuery();

                    if (resultado.next()) {
                        Main.frame1.dispose();
                        String textoColumna = resultado.getString("texto");
                        Formulario formulario1 = new Formulario(textoColumna);
                        formulario1.setBounds(10, 20, 400, 400);
                        formulario1.setVisible(true);
                        formulario1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } else {
                        validacion.setText("Ingrese credenciales correctas");
                    }
                    resultado.close();
                    statement.close();
                    conexion.close();
                } catch (SQLException ex) {
                    System.out.println("Error al conectar a la base de datos MySQL: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
    }
}
