import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Nuevo_Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField TxtNombre;
	private JTextField TxtCorreo;
	private JPasswordField TxtContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nuevo_Usuario frame = new Nuevo_Usuario();
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
	public Nuevo_Usuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\Salvation_T3.png"));
		setTitle("Nueva Cuenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);//Ayuda a CENTRAR VENTANA
		contentPane.setLayout(null);
		
		
		
		JLabel lblUsuarioNuevo = new JLabel("Usuario Nuevo");
		lblUsuarioNuevo.setForeground(new Color(106, 90, 205));
		lblUsuarioNuevo.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblUsuarioNuevo.setBounds(124, 12, 154, 14);
		contentPane.add(lblUsuarioNuevo);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(10, 37, 372, 1);
		contentPane.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Nombre de usuario");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Helvetica", Font.BOLD, 12));
		lblNewLabel.setBounds(37, 78, 138, 14);
		contentPane.add(lblNewLabel);
		
		TxtNombre = new JTextField();
		TxtNombre.setBackground(new Color(102, 102, 102));
		TxtNombre.setForeground(new Color(255, 255, 255));
		TxtNombre.setBounds(37, 104, 300, 28);
		contentPane.add(TxtNombre);
		TxtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1.setFont(new Font("Helvetica", Font.BOLD, 12));
		lblNewLabel_1.setBounds(37, 153, 99, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Correo electr\u00F3nico");
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setFont(new Font("Helvetica", Font.BOLD, 12));
		lblNewLabel_2.setBounds(37, 232, 138, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCrear = new JButton("CREAR"); // Creamos cuenta nueva
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Agregamos Codigo a My SQL	
				try {
					String insert = "insert into Users values (";
					/*Revisar si la clase existe */
					Class.forName("com.mysql.jdbc.Driver");
					/*Crear la Connection*/
					Connection con=DriverManager.getConnection(
							/*jdbc:mysql: //localhost:<port> / <base de datos> ) */
							"jdbc:mysql://localhost:3311/Pruebas_Final",
							"root","root");
					/*Create sentencia */
					Statement stmt=con.createStatement();
						
					    insert += "\"" + 0 + "\",";
						insert += "\"" + TxtNombre.getText() + "\",";
						insert += "\"" + TxtContra.getText() + "\",";
						insert += "\"" + TxtCorreo.getText() + "\")";
						
					/*Ejecutar el query */
					//ResultSet rs=stmt.executeQuery("select * from Users");
						stmt.execute(insert);
						stmt.close();
						stmt.close();
						JOptionPane.showMessageDialog(null, "Registro Exitoso");
				}	
					
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error", e.getMessage(),
														JOptionPane.ERROR_MESSAGE);
					
					System.out.println(e);
				}				
							
			}
		});
		btnCrear.setFont(new Font("Helvetica", Font.BOLD, 12));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setBackground(new Color(51, 102, 153));
		btnCrear.setBounds(37, 367, 300, 28);
		contentPane.add(btnCrear);
		
		TxtCorreo = new JTextField();
		TxtCorreo.setForeground(Color.WHITE);
		TxtCorreo.setColumns(10);
		TxtCorreo.setBackground(new Color(102, 102, 102));
		TxtCorreo.setBounds(37, 257, 300, 28);
		contentPane.add(TxtCorreo);
		
		TxtContra = new JPasswordField();
		TxtContra.setBackground(new Color(102, 102, 102));
		TxtContra.setBounds(37, 178, 300, 28);
		contentPane.add(TxtContra);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//<----------- BOTON DE REGRESO A MENU ---------->
			Pantalla_Login Regresar = new Pantalla_Login();//Creacion de Objeto Conector a Interfaz Principal de Login
			Regresar.setVisible(true);//Se Habilita visualizacion de ventana Principal
			Nuevo_Usuario.this.setVisible(false);//Se Deshabilita Venta Actual
			}
		});
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Helvetica", Font.BOLD, 12));
		btnRegresar.setBackground(new Color(153, 153, 153));
		btnRegresar.setBounds(37, 415, 300, 28);
		contentPane.add(btnRegresar);
	}
}
