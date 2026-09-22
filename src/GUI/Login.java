package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField txtCorreo;
    private JPasswordField txtPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
    	setUndecorated(true);
        setTitle("Iniciar Sesión - Centro de Salud Breña");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 483, 320);
        setLocationRelativeTo(null); // Centrar en pantalla

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("INICIAR SESIÓN");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setBounds(50, 20, 280, 30);
        contentPane.add(lblTitulo);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCorreo.setBounds(50, 80, 80, 25);
        contentPane.add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtCorreo.setBounds(140, 80, 190, 25);
        contentPane.add(txtCorreo);
        txtCorreo.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPassword.setBounds(50, 130, 90, 25);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtPassword.setBounds(140, 130, 190, 25);
        contentPane.add(txtPassword);

        JButton btnIngresar = new JButton("INGRESAR");
        btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnIngresar.setBounds(102, 189, 120, 35);
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });
        contentPane.add(btnIngresar);
        
     // BOTÓN SALIR
        JButton btnSalir = new JButton("SALIR");
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSalir.setBounds(260, 189, 120, 35);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación por completo
            }
        });
        contentPane.add(btnSalir);
    }

    private void validarLogin() {
        String correo = txtCorreo.getText().trim();
        String password = new String(txtPassword.getPassword());

        // Credenciales fijas de prueba (puedes cambiarlas si gustas)
        if (correo.equalsIgnoreCase("admin@brena.com") && password.equals("1234")) {
            JOptionPane.showMessageDialog(this, "¡Bienvenido al sistema!", "Acceso Concedido", JOptionPane.INFORMATION_MESSAGE);
            
            // Abre el menú principal V1 y cierra el Login
            V1 principal = new V1();
            principal.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
        }
    }
}