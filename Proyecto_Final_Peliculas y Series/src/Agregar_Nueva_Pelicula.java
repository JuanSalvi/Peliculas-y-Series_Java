import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.annotation.Generated;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import org.omg.CORBA.portable.ValueBase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class Agregar_Nueva_Pelicula extends JFrame {
	private JTextField TxtNpTituloNew;
	private JTextField TxtNpNomD;
	private JTextField TxtNpAnio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agregar_Nueva_Pelicula frame = new Agregar_Nueva_Pelicula();
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
	public Agregar_Nueva_Pelicula() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\Logo_paladin.png"));
		setTitle("Agregar Nueva Pelicula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 353);
		JPanel contentPane = new JPanel();
		contentPane.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);//Ayuda a CENTRAR VENTANA
		contentPane.setLayout(null);
		
		JLabel lblIngresoDeNueva = new JLabel("Ingreso De Nueva Pelicula");
		lblIngresoDeNueva.setBounds(125, 11, 270, 14);
		lblIngresoDeNueva.setForeground(new Color(106, 90, 205));
		lblIngresoDeNueva.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		contentPane.add(lblIngresoDeNueva);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(46, 23, 422, 2);
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(horizontalBox);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(116, 280, 99, 23);
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\juan\\Desktop\\Proyecto_ DefPlanets\\Miselaneos\\Icon400.ico"));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //<----------- BOTON DE REGRESO A MENU ---------->
				Interfaz Regresar = new Interfaz(); //Creacion de Objeto Conector a Interfaz Principal
				Regresar.setVisible(true); //Se Habilita visualizacion de ventana Principal
				Agregar_Nueva_Pelicula.this.setVisible(false); //Se Deshabilita Venta Actual
			}
		});
		contentPane.add(btnRegresar);
		
		JLabel lblTituloDeNueva = new JLabel("Titulo de Nueva Pelicula");
		lblTituloDeNueva.setForeground(new Color(106, 90, 205));
		lblTituloDeNueva.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblTituloDeNueva.setBounds(125, 54, 249, 14);
		contentPane.add(lblTituloDeNueva);
		
		TxtNpTituloNew = new JTextField();
		TxtNpTituloNew.setBounds(116, 79, 258, 20);
		contentPane.add(TxtNpTituloNew);
		TxtNpTituloNew.setColumns(10);
		
		JLabel lblNombreDeDirector = new JLabel("Nombre del Director ");
		lblNombreDeDirector.setForeground(new Color(106, 90, 205));
		lblNombreDeDirector.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblNombreDeDirector.setBounds(138, 110, 205, 14);
		contentPane.add(lblNombreDeDirector);
		
		TxtNpNomD = new JTextField();
		TxtNpNomD.setColumns(10);
		TxtNpNomD.setBounds(116, 135, 258, 20);
		contentPane.add(TxtNpNomD);
		
		JLabel lblAoDePublicacin = new JLabel("A\u00F1o de Publicaci\u00F3n ");
		lblAoDePublicacin.setForeground(new Color(106, 90, 205));
		lblAoDePublicacin.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblAoDePublicacin.setBounds(153, 166, 188, 14);
		contentPane.add(lblAoDePublicacin);
		
		TxtNpAnio = new JTextField();
		TxtNpAnio.setColumns(10);
		TxtNpAnio.setBounds(163, 191, 165, 20);
		contentPane.add(TxtNpAnio);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				
		//Agregamos Codigo a My SQL	
				try {
					String insert = "insert into Peliculas values (";
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
						insert += "\"" + TxtNpTituloNew.getText() + "\",";
						insert += "\"" + TxtNpNomD.getText() + "\",";
						insert += "\"" + TxtNpAnio.getText() + "\",";
						insert += "\"" +"No" + "\")";
						
					/*Ejecutar el query */
					//ResultSet rs=stmt.executeQuery("select * from peliculas");
						stmt.execute(insert);
						stmt.close();
						stmt.close();
						JOptionPane.showMessageDialog(null, "Pelicula Agregada");
				}	
					
						catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Error", e.getMessage(),
																JOptionPane.ERROR_MESSAGE);
							
							System.out.println(e);
						}	
				
				
			}
		});
		btnEnviar.setBounds(285, 280, 89, 23);
		contentPane.add(btnEnviar);
	}
}
