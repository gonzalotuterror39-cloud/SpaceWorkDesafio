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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import SaludBreña.cita;

public class VentanaAgendar extends JFrame {

    private JPanel contentPane;
    private JTextField txtDNI;
    private JTextField txtNom;
    private JTextField txtApe;
    private JTextField txtFecha;
    private JTextField txtHORA;
    private JTextField txtEsp;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaAgendar frame = new VentanaAgendar();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaAgendar() {
    	setUndecorated(true);
        setTitle("Agendar Cita - Centro de Salud Breña");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 420);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("AGENDAR CITA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(100, 20, 230, 25);
        contentPane.add(lblTitulo);

        // --- CAMPOS DE TEXTO ---
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(50, 60, 100, 20);
        contentPane.add(lblDni);

        txtDNI = new JTextField();
        txtDNI.setBounds(160, 60, 200, 20);
        contentPane.add(txtDNI);
        txtDNI.setColumns(10);

        JLabel lblNom = new JLabel("Nombre:");
        lblNom.setBounds(50, 95, 100, 20);
        contentPane.add(lblNom);

        txtNom = new JTextField();
        txtNom.setBounds(160, 95, 200, 20);
        contentPane.add(txtNom);
        txtNom.setColumns(10);

        JLabel lblApe = new JLabel("Apellido:");
        lblApe.setBounds(50, 130, 100, 20);
        contentPane.add(lblApe);

        txtApe = new JTextField();
        txtApe.setBounds(160, 130, 200, 20);
        contentPane.add(txtApe);
        txtApe.setColumns(10);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(50, 165, 100, 20);
        contentPane.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(160, 165, 200, 20);
        contentPane.add(txtFecha);
        txtFecha.setColumns(10);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(50, 200, 100, 20);
        contentPane.add(lblHora);

        txtHORA = new JTextField();
        txtHORA.setBounds(160, 200, 200, 20);
        contentPane.add(txtHORA);
        txtHORA.setColumns(10);

        JLabel lblEsp = new JLabel("Especialidad:");
        lblEsp.setBounds(50, 235, 100, 20);
        contentPane.add(lblEsp);

        txtEsp = new JTextField();
        txtEsp.setBounds(160, 235, 200, 20);
        contentPane.add(txtEsp);
        txtEsp.setColumns(10);

        // --- BOTÓN CONFIRMAR ---
        JButton btnConfirmar = new JButton("CONFIRMAR");
        btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnConfirmar.setBounds(80, 290, 130, 35);
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btnConfirmar_actionPerformed(e);
            }
        });
        contentPane.add(btnConfirmar);

        // --- BOTÓN VOLVER ---
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnVolver.setBounds(230, 290, 130, 35);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btnVolver_actionPerformed(e);
            }
        });
        contentPane.add(btnVolver);
    }

    // ACCIÓN: CONFIRMAR AGENDAR
    protected void do_btnConfirmar_actionPerformed(ActionEvent e) {
        String dni = txtDNI.getText().trim();
        String nombre = txtNom.getText().trim();
        String apellido = txtApe.getText().trim();
        String fecha = txtFecha.getText().trim();
        String hora = txtHORA.getText().trim();
        String especialidad = txtEsp.getText().trim();

        // 1. Validar que ningún campo esté vacío
        if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fecha.isEmpty() || hora.isEmpty() || especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Validar que el DNI tenga exactamente 8 dígitos numéricos
        if (!dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El DNI debe contener exactamente 8 números.", "DNI Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Validar que el DNI no esté repetido
        for (cita c : V1.listaCitas) {
            if (c.dni.equals(dni)) {
                JOptionPane.showMessageDialog(this, "Ya existe una cita registrada con este DNI.", "DNI Duplicado", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // 4. Guardar la nueva cita en la lista compartida de V1
        cita nuevaCita = new cita(dni, nombre, apellido, fecha, hora, especialidad);
        V1.listaCitas.add(nuevaCita);

        JOptionPane.showMessageDialog(this, "¡Cita agendada correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // 5. Retornar al menú principal (V1)
        GUI.V1 menu = new GUI.V1();
        menu.setVisible(true);
        dispose();
    }

    // ACCIÓN: VOLVER
    protected void do_btnVolver_actionPerformed(ActionEvent e) {
        GUI.V1 menu = new GUI.V1();
        menu.setVisible(true);
        dispose();
    }
}