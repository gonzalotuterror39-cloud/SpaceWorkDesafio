package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaVerCitas extends JFrame {

    private JPanel contentPane;
    private JTextField txtBuscarDni;
    private JTable tablaCitas;
    private DefaultTableModel tableModel;

    public VentanaVerCitas() {
        setUndecorated(true); // Quita la barra superior con la X
        setTitle("Ver Citas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 400);
        setLocationRelativeTo(null); // Centra en pantalla

        contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);

        // ==========================================
        // PANEL SUPERIOR: Búsqueda y Navegación
        // ==========================================
        JPanel panelTop = new JPanel(new BorderLayout());

        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelBusqueda.add(new JLabel("DNI:"));
        txtBuscarDni = new JTextField(10);
        panelBusqueda.add(txtBuscarDni);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPorDni();
            }
        });
        panelBusqueda.add(btnBuscar);

        JButton btnVerTodas = new JButton("Ver Todas");
        btnVerTodas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarTabla(V1.listaCitas);
            }
        });
        panelBusqueda.add(btnVerTodas);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                V1 v1 = new V1();
                v1.setVisible(true);
                dispose();
            }
        });

        panelTop.add(panelBusqueda, BorderLayout.WEST);
        panelTop.add(btnVolver, BorderLayout.EAST);
        contentPane.add(panelTop, BorderLayout.NORTH);

        // ==========================================
        // PANEL CENTRAL: Tabla
        // ==========================================
        String[] columnas = {"DNI", "Nombre", "Apellido", "Fecha", "Hora", "Especialidad"};
        tableModel = new DefaultTableModel(columnas, 0);
        tablaCitas = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tablaCitas);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // ==========================================
        // PANEL INFERIOR: Botones de Gestión
        // ==========================================
        JPanel panelBotonesInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));

        JButton btnReagendar = new JButton("Reagendar Cita");
        btnReagendar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnReagendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reagendarCita();
            }
        });
        panelBotonesInferior.add(btnReagendar);

        JButton btnEliminar = new JButton("Eliminar Cita");
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarCita();
            }
        });
        panelBotonesInferior.add(btnEliminar);

        contentPane.add(panelBotonesInferior, BorderLayout.SOUTH);

        // Carga inicial de datos si los hay
        cargarTabla(V1.listaCitas);
    }

    // ==========================================
    // MÉTODOS Y LÓGICA DE NEGOCIO
    // ==========================================

    private void cargarTabla(ArrayList<SaludBreña.cita> lista) {
        tableModel.setRowCount(0); // Limpia filas existentes
        for (SaludBreña.cita c : lista) {
            Object[] fila = {c.getDni(), c.getNombre(), c.getApellido(), c.getFecha(), c.getHora(), c.getEspecialidad()};
            tableModel.addRow(fila);
        }
    }

    private void buscarPorDni() {
        String dni = txtBuscarDni.getText().trim();
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI para buscar.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ArrayList<SaludBreña.cita> filtradas = new ArrayList<>();
        for (SaludBreña.cita c : V1.listaCitas) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                filtradas.add(c);
            }
        }

        if (filtradas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron citas para el DNI ingresado.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
        }

        cargarTabla(filtradas);
    }

    private void reagendarCita() {
        String dni = JOptionPane.showInputDialog(this, "Ingrese el DNI del paciente a reagendar:");
        if (dni == null || dni.trim().isEmpty()) return;

        SaludBreña.cita citaEncontrada = null;
        for (SaludBreña.cita c : V1.listaCitas) {
            if (c.getDni().equalsIgnoreCase(dni.trim())) {
                citaEncontrada = c;
                break;
            }
        }

        if (citaEncontrada == null) {
            JOptionPane.showMessageDialog(this, "No se encontró ninguna cita con ese DNI.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pedir nueva fecha
        String nuevaFecha = JOptionPane.showInputDialog(this, "Fecha actual: " + citaEncontrada.getFecha() + "\nIngrese la NUEVA fecha (DD/MM/AAAA):");
        if (nuevaFecha == null || nuevaFecha.trim().isEmpty()) return;

        // Pedir nueva hora
        String nuevaHora = JOptionPane.showInputDialog(this, "Hora actual: " + citaEncontrada.getHora() + "\nIngrese la NUEVA hora (HH:MM):");
        if (nuevaHora == null || nuevaHora.trim().isEmpty()) return;

        // Modificar los valores
        citaEncontrada.setFecha(nuevaFecha.trim());
        citaEncontrada.setHora(nuevaHora.trim());

        JOptionPane.showMessageDialog(this, "¡Cita reagendada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        cargarTabla(V1.listaCitas); // Refresca la tabla
    }

    private void eliminarCita() {
        String dni = JOptionPane.showInputDialog(this, "Ingrese el DNI del paciente cuya cita desea ELIMINAR:");
        if (dni == null || dni.trim().isEmpty()) return;

        boolean eliminada = V1.listaCitas.removeIf(c -> c.getDni().equalsIgnoreCase(dni.trim()));

        if (eliminada) {
            JOptionPane.showMessageDialog(this, "La cita se eliminó correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla(V1.listaCitas); // Refresca la tabla
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ninguna cita con ese DNI.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}