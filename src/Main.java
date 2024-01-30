import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class Main {
    static JFrame frame1 = new JFrame("Login");
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/registros";
        String usuario = "root";
        String contrasena = "";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa a la base de datos MySQL.");
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos MySQL: " + e.getMessage());
            e.printStackTrace();
        }

        frame1.setContentPane(new login().login);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 400);
        frame1.setVisible(true);
    }
}

