import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pedir_Pelicula extends JFrame {

	protected static final TableModel DefaultTableModel = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField IDtoRentar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedir_Pelicula frame = new Pedir_Pelicula();
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
	public Pedir_Pelicula() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\Asi_T3.png"));
		setTitle("Pedir Prestamo Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);//Ayuda a CENTRAR VENTANA
		
		try {
			/*Pantalla frame = new Pantalla();
			frame.setVisible(true);*/
			
			//CONEXION CON BASE DE DATOS
			/*Revisar si la clase existe */
			Class.forName("com.mysql.jdbc.Driver");
			//CREAR CONEXION
			Connection con=DriverManager.getConnection(
					/*jdbc:mysql: //localhost:<port> / <base de datos> ) */
					"jdbc:mysql://localhost:3311/Pruebas_Final",
					"root","root");
			/*Create sentencia */
			Statement stmt=con.createStatement();
			/*Ejecutar el query */
			ResultSet rs=stmt.executeQuery("select * from Peliculas WHERE Prestado='No'");
			table = new JTable(buildTableModel(rs));
			
			/* CERRAR Todo*/
			rs.close();
			stmt.close();
			con.close();	
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		contentPane.setLayout(null);
		JScrollPane scrollPanePel = new JScrollPane(table);
		scrollPanePel.setBounds(42, 103, 352, 203);
		contentPane.add(scrollPanePel);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(22, 24, 372, 1);
		contentPane.add(horizontalBox);
		
		JLabel lblPrestamoDePelicula = new JLabel("Prestamo de Pelicula");
		lblPrestamoDePelicula.setForeground(new Color(106, 90, 205));
		lblPrestamoDePelicula.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblPrestamoDePelicula.setBounds(116, 11, 206, 14);
		contentPane.add(lblPrestamoDePelicula);
		
		IDtoRentar = new JTextField();
		IDtoRentar.setForeground(Color.WHITE);
		IDtoRentar.setColumns(10);
		IDtoRentar.setBackground(new Color(153, 153, 153));
		IDtoRentar.setBounds(32, 64, 372, 28);
		contentPane.add(IDtoRentar);
		
		JLabel label_1 = new JLabel("Ingrese ID de Pelicula a Rentar:");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Helvetica", Font.BOLD, 12));
		label_1.setBounds(113, 39, 225, 14);
		contentPane.add(label_1);
		
		JButton button = new JButton("REGRESAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//<----------- BOTON DE REGRESO A Interfaz ---------->
			Interfaz Natsuki = new Interfaz();//Creacion de Objeto Conector a Interfaz Principal de Login
			Natsuki.setVisible(true);//Se Habilita visualizacion de ventana Principal
			Pedir_Pelicula.this.setVisible(false);//Se Deshabilita Venta Actual
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Helvetica", Font.BOLD, 12));
		button.setBackground(new Color(51, 102, 153));
		button.setBounds(37, 349, 151, 34);
		contentPane.add(button);
		
		JButton button_1 = new JButton("SOLICITAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String UPDATE ="UPDATE Peliculas SET Prestado='Si' WHERE IDP='"+IDtoRentar.getText()+"'";
					/*Revisar si la clase existe */
					Class.forName("com.mysql.jdbc.Driver");
					/*Crear la Connection*/
					Connection con=DriverManager.getConnection(
							/*jdbc:mysql: //localhost:<port> / <base de datos> ) */
							"jdbc:mysql://localhost:3311/Pruebas_Final",
							"root","root");
					/*Create sentencia */
					Statement stmt=con.createStatement();
					
					/*Ejecutar el query */
					//ResultSet rs=stmt.executeQuery("select * from Alumno");
						stmt.execute(UPDATE);
						stmt.close();
						stmt.close();
						JOptionPane.showMessageDialog(null, "Prestamo Exitoso");
				
				}	
					
						catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Error", e2.getMessage(),
																JOptionPane.ERROR_MESSAGE);
							System.out.println(e2);
						}	
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Helvetica", Font.BOLD, 12));
		button_1.setBackground(new Color(51, 204, 51));
		button_1.setBounds(243, 351, 151, 31);
		contentPane.add(button_1);
	}
	
	//MOSTRAR TABLAS DE BASE DE DATOS
		public static DefaultTableModel buildTableModel (ResultSet rs)
				throws SQLException {
				
				ResultSetMetaData metaData = rs.getMetaData();
				
				//MOSTRAR TABLAS
				//Nombres de Columnas
				Vector<String> ColumnNames = new Vector<String>();
				int columCount = metaData.getColumnCount();
				for(int column = 1; column <= columCount; column++)
				{
					ColumnNames.add(metaData.getColumnName(column));
				}
				
				//DATOS DE LAS TABLAS
				Vector<Vector<Object>> data = new Vector<Vector<Object>>();
				while(rs.next()) {
					Vector<Object> vector = new Vector<Object>();
					for (int ColumIndex = 1; ColumIndex <= columCount;ColumIndex++)
					{
						vector.add(rs.getObject(ColumIndex));
					}
					data.add(vector);
				}
				return new DefaultTableModel(data,ColumnNames);
				
			}//FIN DE MOSTRAR TABLAS
}
