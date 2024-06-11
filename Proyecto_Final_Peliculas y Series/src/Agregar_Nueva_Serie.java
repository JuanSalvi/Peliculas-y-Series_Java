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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Agregar_Nueva_Serie extends JFrame {

	private JPanel contentPane;
	private JTextField TxtNsTituloNew;
	private JTextField TxtNsNomPro;
	private JTextField TxtNsNumTem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agregar_Nueva_Serie frame = new Agregar_Nueva_Serie();
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
	public Agregar_Nueva_Serie() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\Logo_paladin.png"));
		setTitle("Agregar Nueva Serie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//Ayuda a CENTRAR VENTANA
		
		JLabel lblIngresoDeNueva = new JLabel("Ingreso De Nueva Serie\r\n");
		lblIngresoDeNueva.setForeground(new Color(106, 90, 205));
		lblIngresoDeNueva.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblIngresoDeNueva.setBounds(126, 11, 228, 14);
		contentPane.add(lblIngresoDeNueva);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(48, 24, 372, 1);
		contentPane.add(horizontalBox);
		
		JButton button = new JButton("Regresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //<----------- BOTON DE REGRESO A MENU ---------->
				Interfaz Regresar = new Interfaz(); //Creacion de Objeto Conector a Interfaz Principal
				Regresar.setVisible(true); //Se Habilita visualizacion de ventana Principal
				Agregar_Nueva_Serie.this.setVisible(false); //Se Deshabilita Venta Actual
			}
		});
		button.setBounds(126, 264, 89, 23);
		contentPane.add(button);
		
		JLabel lblTituloDeNueva = new JLabel("Titulo de Nueva Serie");
		lblTituloDeNueva.setForeground(new Color(106, 90, 205));
		lblTituloDeNueva.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblTituloDeNueva.setBounds(136, 53, 220, 14);
		contentPane.add(lblTituloDeNueva);
		
		TxtNsTituloNew = new JTextField();
		TxtNsTituloNew.setColumns(10);
		TxtNsTituloNew.setBounds(126, 75, 242, 20);
		contentPane.add(TxtNsTituloNew);
		
		JLabel lblNombreDelProductora = new JLabel("Nombre de laProductora");
		lblNombreDelProductora.setForeground(new Color(106, 90, 205));
		lblNombreDelProductora.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblNombreDelProductora.setBounds(126, 106, 242, 14);
		contentPane.add(lblNombreDelProductora);
		
		TxtNsNomPro = new JTextField();
		TxtNsNomPro.setColumns(10);
		TxtNsNomPro.setBounds(126, 131, 242, 20);
		contentPane.add(TxtNsNomPro);
		
		JLabel lblNumeroDeTemporadas = new JLabel("Numero de Temporadas");
		lblNumeroDeTemporadas.setForeground(new Color(106, 90, 205));
		lblNumeroDeTemporadas.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblNumeroDeTemporadas.setBounds(140, 162, 228, 14);
		contentPane.add(lblNumeroDeTemporadas);
		
		TxtNsNumTem = new JTextField();
		TxtNsNumTem.setColumns(10);
		TxtNsNumTem.setBounds(169, 187, 149, 20);
		contentPane.add(TxtNsNumTem);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				//Agregamos Codigo a My SQL	
				try {
					String insert = "insert into Series values (";
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
						insert += "\"" + TxtNsTituloNew.getText() + "\",";
						insert += "\"" + TxtNsNomPro.getText() + "\",";
						insert += "\"" + TxtNsNumTem.getText() + "\",";
						insert += "\"" +"No" + "\")";

						
					/*Ejecutar el query */
					//ResultSet rs=stmt.executeQuery("select * from peliculas");
						stmt.execute(insert);
						stmt.close();
						stmt.close();
						JOptionPane.showMessageDialog(null, "Serie Agregada");
				}	
					
						catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Error", e.getMessage(),
																JOptionPane.ERROR_MESSAGE);
							
							System.out.println(e);
						}	
			}
		});
		btnEnviar.setBounds(279, 264, 89, 23);
		contentPane.add(btnEnviar);
	}
}
