package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Desarrolladores.desarrolladores;

import java.util.ArrayList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class V1 extends JFrame implements ActionListener {

    private JPanel contentPane;

    // Lista global compartida para almacenar las citas en memoria
    public static ArrayList<SaludBreña.cita> listaCitas = new ArrayList<>();
    private JMenuBar menuBar;
    private JMenu mnNewMenu;
    private JMenuItem mntmNewMenuItem;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    V1 frame = new V1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public V1() {
        setUndecorated(true);
    	setTitle("CENTRO DE SALUD BREÑA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null); // Centrar en pantalla
        {
        	menuBar = new JMenuBar();
        	setJMenuBar(menuBar);
        	{
        		mnNewMenu = new JMenu("Desarrolladores");
        		menuBar.add(mnNewMenu);
        		{
        			mntmNewMenuItem = new JMenuItem("Desarolladores");
        			mntmNewMenuItem.addActionListener(this);
        			mnNewMenu.add(mntmNewMenuItem);
        		}
        	}
        }

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("CENTRO DE SALUD BREÑA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setBounds(50, 30, 330, 30);
        contentPane.add(lblTitulo);

        // BOTÓN AGENDAR
        JButton btnAgendar = new JButton("Agendar");
        btnAgendar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAgendar.setBounds(140, 90, 150, 40);
        btnAgendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaAgendar vAgendar = new VentanaAgendar();
                vAgendar.setVisible(true);
                dispose(); // Cierra el menú principal
            }
        });
        contentPane.add(btnAgendar);

        // BOTÓN VER CITAS
        JButton btnVerCitas = new JButton("Ver Citas");
        btnVerCitas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnVerCitas.setBounds(140, 150, 150, 40);
        btnVerCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaVerCitas vVer = new VentanaVerCitas();
                vVer.setVisible(true);
                dispose(); // Cierra el menú principal
            }
        });
        contentPane.add(btnVerCitas);
        
     // BOTÓN CERRAR SESIÓN Y SALIR
        JButton btnCerrarSesion = new JButton("Cerrar sesión y salir");
        btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCerrarSesion.setBounds(130, 210, 180, 40); // Un poco más ancho para que entre el texto completo
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cierra la aplicación por completo y finaliza la sesión
                System.exit(0);
            }
        });
        contentPane.add(btnCerrarSesion);
    
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem) {
			do_mntmNewMenuItem_actionPerformed(e);
		}
	}
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		desarrolladores ds=new desarrolladores();
		ds.setVisible(true);	
	}
}