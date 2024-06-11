import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Pantalla_Login extends JFrame {

	private JPanel contentPane;
	public static JTextField TxtUser;
	public static JPasswordField TxtPass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_Login frame = new Pantalla_Login();
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

	public Pantalla_Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\smite_logo_png_1258079.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("USERNAME");
		lblUser.setFont(new Font("Helvetica", Font.BOLD, 14));
		lblUser.setBounds(10, 40, 113, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Helvetica", Font.BOLD, 14));
		lblPassword.setBounds(10, 124, 113, 20);
		contentPane.add(lblPassword);
		
		TxtUser = new JTextField();
		TxtUser.setFont(new Font("Helvetica", Font.BOLD, 12));
		TxtUser.setForeground(new Color(153, 153, 51));
		TxtUser.setBackground(new Color(255, 255, 255));
		TxtUser.setBounds(10, 60, 298, 32);
		contentPane.add(TxtUser);
		
		TxtPass = new JPasswordField();
		TxtPass.setForeground(new Color(51, 51, 153));
		TxtPass.setFont(new Font("Helvetica", Font.BOLD, 15));
		TxtPass.setBackground(new Color(255, 255, 255));
		TxtPass.setBounds(10, 155, 298, 32);
		contentPane.add(TxtPass);
		
		JButton btnLogin = new JButton("LOGIN");//<----------- BOTON DE ACCESO A Interfaz ---------->
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Metodos_Login metodos = new Metodos_Login();
			String Busqueda_Usuario = metodos.Buscar_Usuario_Registrado(TxtUser.getText(),TxtPass.getText());
			
			if (TxtUser.getText().equals("Admin") && TxtPass.getText().equals("Admin")) {
				JOptionPane.showMessageDialog(null, "Se inicio Como Administrador");
				Interfaz Mostrar = new Interfaz(); //Creacion de Objeto Conector a Interfaz Principal
				Mostrar.setVisible(true); //Se Habilita visualizacion de ventana Principa
				Pantalla_Login.this.setVisible(false);//Se Deshabilita Venta Actual
				//Mostrar.LabelName.setText("Administrador");//Se inserta Usuario Logueado
		
			}else if (Busqueda_Usuario.equals("Usuario Encontrado")) {
				String Busqueda_Nombre = metodos.Buscar_Usuario(TxtUser.getText());
				JOptionPane.showMessageDialog(null, "Bienvenido \n"+Busqueda_Nombre);
				Interfaz Mostrar = new Interfaz();//Creacion de Objeto Conector a Interfaz Principal
				Mostrar.setVisible(true); //Se Habilita visualizacion de ventana Principa
				Pantalla_Login.this.setVisible(false);//Se Deshabilita Venta Actual
				//Mostrar.LabelName.setText(Busqueda_Nombre);//Se inserta Usuario Logueado
			}else {
				
				JOptionPane.showMessageDialog(null, "Usuario No Registrado");
			}
		
			
			}
		});
		btnLogin.setFont(new Font("Helvetica", Font.BOLD, 11));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 102, 51));
		btnLogin.setBounds(65, 219, 177, 40);
		contentPane.add(btnLogin);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new LineBorder(new Color(0, 51, 102), 5));
		verticalBox.setBounds(336, 21, 1, 272);
		contentPane.add(verticalBox);
		
		JButton btnNew_Cuenta = new JButton("Crear Cuenta");//<----------- BOTON DE ACCESO A NUEVO USUARIO ---------->
		btnNew_Cuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuevo_Usuario Ir = new Nuevo_Usuario();//Creacion de Objeto Conector a Nuevo Usuario
				Ir.setVisible(true);//Se Habilita visualizacion de Formulario Nuevo usuario
				Pantalla_Login.this.setVisible(false);//Se Deshabilita Venta Actual
			}
		});
		btnNew_Cuenta.setForeground(new Color(255, 255, 255));
		btnNew_Cuenta.setFont(new Font("Helvetica", Font.BOLD, 12));
		btnNew_Cuenta.setBackground(new Color(51, 102, 153));
		btnNew_Cuenta.setBounds(347, 124, 150, 32);
		contentPane.add(btnNew_Cuenta);
		this.setLocationRelativeTo(null);//Ayuda a CENTRAR VENTANA
	}
}
