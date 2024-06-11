import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	public static JLabel LabelName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		setFont(new Font("OVERWATCH", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\VIP_logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);//Ayuda a CENTRAR VENTANA
		
		JLabel lblPeliculasYSeries = new JLabel("Peliculas y Series");
		lblPeliculasYSeries.setBounds(111, 0, 251, 40);
		lblPeliculasYSeries.setForeground(new Color(0, 102, 153));
		lblPeliculasYSeries.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 14));
		contentPane.add(lblPeliculasYSeries);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(50, 29, 372, 1);
		contentPane.add(horizontalBox);
		
		JLabel lblAgregar = new JLabel("Agregar Nueva");
		lblAgregar.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblAgregar.setForeground(new Color(102, 153, 204));
		lblAgregar.setBounds(150, 51, 142, 14);
		contentPane.add(lblAgregar);
		
		JButton btnAgPelicula = new JButton("Pelicula");
		btnAgPelicula.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) { //<------ BOTON IR A VENANA AGREGAR PELICULA
				Agregar_Nueva_Pelicula AgP = new Agregar_Nueva_Pelicula(); //Agregar Pelicula Vinculacion a Siguente Ventana
				AgP.setVisible(true);//Se muestra la Ventana VINCULADA	
				Interfaz.this.setVisible(false);//No muestra pagina Actual
			}
		});
		btnAgPelicula.setBounds(89, 86, 89, 23);
		contentPane.add(btnAgPelicula);
		
		JButton btnAgSerie = new JButton("Serie");
		btnAgSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //<-------- BOTON IR A VENANA AGREGAR SERIE
				Agregar_Nueva_Serie AgS = new Agregar_Nueva_Serie(); //Agregar Objeto Vincualnte a Ventana Siguiente
				AgS.setVisible(true); //Se habilita Visulizacion de Nueva ventana: Nueva Pelicula
				Interfaz.this.setVisible(false);  //Se deshabilita Ventana Principal
				
			}
		});
		btnAgSerie.setBounds(255, 86, 89, 23);
		contentPane.add(btnAgSerie);
		
		JLabel lblMostrar = new JLabel("Mostrar Disponibles");
		lblMostrar.setForeground(new Color(102, 153, 204));
		lblMostrar.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblMostrar.setBounds(126, 132, 218, 14);
		contentPane.add(lblMostrar);
		
		JButton btnMoPeliculas = new JButton("Peliculas");
		btnMoPeliculas.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { //<--------BOTON IR A VENANA MOSTRA PELICULAS DISPONIBLES  ------->
				Mostrar_Peliculas_Disponibles BtnMoP = new Mostrar_Peliculas_Disponibles();//Agregar Objeto Vincualnte a Ventana Siguiente
				BtnMoP.setVisible(true);//Se habilita Visulizacion de Nueva ventana: Mostrar Pelicula
				Interfaz.this.setVisible(false); //Se deshabilita Ventana Principal
			}
		});
		btnMoPeliculas.setBounds(89, 167, 89, 23);
		contentPane.add(btnMoPeliculas);
		
		JButton btnMoSeries = new JButton("Series");
		btnMoSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//<--------BOTON IR A VENANA MOSTRA SERIES DISPONIBLES  ------->
				Mostrar_Series_Disponibles BtnMoS = new Mostrar_Series_Disponibles();//Agregar Objeto Vincualnte a Ventana Siguiente
				BtnMoS.setVisible(true); //Se habilita Visulizacion de Nueva ventana: Mostrar SERIE
				Interfaz.this.setVisible(false);//Se deshabilita Ventana Principal
			}
		});
		btnMoSeries.setBounds(255, 167, 89, 23);
		contentPane.add(btnMoSeries);
		
		JLabel lblPedirPrestado = new JLabel("En Prestamo");
		lblPedirPrestado.setForeground(new Color(102, 153, 204));
		lblPedirPrestado.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblPedirPrestado.setBounds(148, 396, 149, 14);
		contentPane.add(lblPedirPrestado);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		horizontalBox_1.setBounds(124, 64, 193, 1);
		contentPane.add(horizontalBox_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		horizontalBox_2.setBounds(111, 145, 233, 1);
		contentPane.add(horizontalBox_2);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		horizontalBox_3.setBounds(124, 409, 193, 1);
		contentPane.add(horizontalBox_3);
		
		JButton btnPrPelicula_1 = new JButton("Pelicula");
		btnPrPelicula_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //<--------BOTON IR A PEDIR PELICULA PRESTADA  ------->
			 Pedir_Prestado_Pelicula BtnPresP = new Pedir_Prestado_Pelicula();
			 BtnPresP.setVisible(true);//Se habilita Visulizacion de Nueva ventana: Prestar PELICULA
			 Interfaz.this.setVisible(false);//Se deshabilita Ventana Principal
			}
			
		});
		btnPrPelicula_1.setBounds(89, 421, 89, 23);
		contentPane.add(btnPrPelicula_1);
		
		JButton btnPrSeries_1 = new JButton("Series");
		btnPrSeries_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//<--------BOTON IR A PEDIR SERIE PRESTADA  ------->
			 Pedir_Prestado_Series BtnPresS = new Pedir_Prestado_Series();
			 BtnPresS.setVisible(true);//Se habilita Visulizacion de Nueva ventana: Prestar SERIE
			 Interfaz.this.setVisible(false);//Se deshabilita Ventana Principal
			 }
		});
		btnPrSeries_1.setBounds(255, 421, 89, 23);
		contentPane.add(btnPrSeries_1);
		
		JButton button = new JButton("LOGOUT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//<--------BOTON IR LOG OUT  ------->
			  Pantalla_Login Logout = new Pantalla_Login();//Creacion de Objeto Conector a Interfaz Principal de Login
			  Logout.setVisible(true);//Se habilita Visulizacion de Pantalla Login
			  Interfaz.this.setVisible(false);//Se deshabilita Ventana Principal
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Helvetica", Font.BOLD, 12));
		button.setBackground(new Color(51, 102, 153));
		button.setBounds(80, 467, 300, 28);
		contentPane.add(button);
		
		JLabel LabelName = new JLabel("");
		LabelName.setBounds(10, 328, 96, 14);
		contentPane.add(LabelName);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		horizontalBox_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		horizontalBox_4.setBounds(124, 220, 193, 1);
		contentPane.add(horizontalBox_4);
		
		JLabel lblPedirPrestado_1 = new JLabel("Pedir Prestado");
		lblPedirPrestado_1.setForeground(new Color(102, 153, 204));
		lblPedirPrestado_1.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblPedirPrestado_1.setBounds(148, 207, 149, 14);
		contentPane.add(lblPedirPrestado_1);
		
		JButton Btn_Pelp = new JButton("Pelicula");
		Btn_Pelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //<--------BOTON PEDIR PRESTADA PELICULA ------->
				Pedir_Pelicula Pedir_P = new Pedir_Pelicula();//Creacion de Objeto Conector a Interfaz Principal de Login
				Pedir_P.setVisible(true);//Se habilita Visulizacion de Pantalla Login
				Interfaz.this.setVisible(false);//Se deshabilita Ventana Principal
			}
		});
		Btn_Pelp.setBounds(89, 258, 89, 23);
		contentPane.add(Btn_Pelp);
		
		JButton Btn_Serp = new JButton("Series");
		Btn_Serp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//<--------BOTON PEDIR PRESTADA SERIE ------->
			Pedir_Series Pedir_S = new Pedir_Series();//Creacion de Objeto Conector a Interfaz Principal de Login
			Pedir_S.setVisible(true);//Se habilita Visulizacion de Pantalla Login
			Interfaz.this.setVisible(false);//Se deshabilita Ventana Principal
			}
		});
		Btn_Serp.setBounds(255, 258, 89, 23);
		contentPane.add(Btn_Serp);
		
		JLabel lblRegresar = new JLabel("Regresar");
		lblRegresar.setForeground(new Color(102, 153, 204));
		lblRegresar.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblRegresar.setBounds(171, 303, 96, 14);
		contentPane.add(lblRegresar);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		horizontalBox_5.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		horizontalBox_5.setBounds(126, 315, 193, 1);
		contentPane.add(horizontalBox_5);
		
		JButton button_1 = new JButton("Pelicula");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Regresar_Pelicula Regresarp = new Regresar_Pelicula();//Creacion de Objeto Conector a Interfaz Principal de Login
				Regresarp.setVisible(true);//Se habilita Visulizacion de Pantalla Login
				Interfaz.this.setVisible(false);//Se deshabilita Ventana Principal		
			}
		});
		button_1.setBounds(89, 339, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Series");
		button_2.setBounds(255, 339, 89, 23);
		contentPane.add(button_2);
	}
}
