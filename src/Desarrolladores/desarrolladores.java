package Desarrolladores;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class desarrolladores extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			desarrolladores dialog = new desarrolladores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public desarrolladores() {
		setBounds(100, 100, 1005, 694);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("Desarrolladores");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblNewLabel.setBounds(393, 11, 295, 53);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(desarrolladores.class.getResource("/imagen/pablo.jpeg")));
			lblNewLabel_1.setBounds(55, 75, 186, 212);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setBounds(351, 75, 224, 225);
			contentPanel.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setBounds(633, 75, 229, 226);
			contentPanel.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setBounds(255, 332, 212, 223);
			contentPanel.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("New label");
			lblNewLabel_5.setBounds(531, 337, 212, 212);
			contentPanel.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("Fabian Mendoza Temoche");
			lblNewLabel_6.setBounds(78, 297, 155, 14);
			contentPanel.add(lblNewLabel_6);
		}
		{
			lblNewLabel_7 = new JLabel("Pool Gallo");
			lblNewLabel_7.setBounds(351, 311, 100, 14);
			contentPanel.add(lblNewLabel_7);
		}
		{
			lblNewLabel_8 = new JLabel("Yuriko");
			lblNewLabel_8.setBounds(633, 311, 46, 14);
			contentPanel.add(lblNewLabel_8);
		}
		{
			lblNewLabel_9 = new JLabel("Gonzalo");
			lblNewLabel_9.setBounds(283, 566, 71, 14);
			contentPanel.add(lblNewLabel_9);
		}
		{
			lblNewLabel_10 = new JLabel("Mayers");
			lblNewLabel_10.setBounds(529, 566, 71, 14);
			contentPanel.add(lblNewLabel_10);
		}
	}
}
