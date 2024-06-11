import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Regresar_Pelicula extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField iDtoRp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regresar_Pelicula frame = new Regresar_Pelicula();
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
	public Regresar_Pelicula() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\LORE.png"));
		setTitle("Regresar Pelicula");
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
			ResultSet rs=stmt.executeQuery("select * from Peliculas WHERE Prestado='Si'");
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
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 125, 352, 203);
		contentPane.add(scrollPane);
		
		JLabel lblRegresoDePelicula = new JLabel("Regreso de Pelicula");
		lblRegresoDePelicula.setForeground(new Color(106, 90, 205));
		lblRegresoDePelicula.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblRegresoDePelicula.setBounds(118, 22, 206, 14);
		contentPane.add(lblRegresoDePelicula);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(24, 35, 372, 1);
		contentPane.add(horizontalBox);
		
		JLabel lblIngreseIdDe = new JLabel("Ingrese ID de Pelicula a Regresar");
		lblIngreseIdDe.setForeground(Color.LIGHT_GRAY);
		lblIngreseIdDe.setFont(new Font("Helvetica", Font.BOLD, 12));
		lblIngreseIdDe.setBounds(105, 47, 225, 14);
		contentPane.add(lblIngreseIdDe);
		
		iDtoRp = new JTextField();
		iDtoRp.setForeground(Color.WHITE);
		iDtoRp.setColumns(10);
		iDtoRp.setBackground(new Color(153, 153, 153));
		iDtoRp.setBounds(24, 72, 372, 28);
		contentPane.add(iDtoRp);
		
		JButton button = new JButton("REGRESAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//<----------- BOTON DE REGRESO A Interfaz ---------->
				Interfaz Natsuki = new Interfaz();//Creacion de Objeto Conector a Interfaz Principal de Login
				Natsuki.setVisible(true);//Se Habilita visualizacion de ventana Principal
				Regresar_Pelicula.this.setVisible(false);//Se Deshabilita Venta Actual
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Helvetica", Font.BOLD, 12));
		button.setBackground(new Color(51, 102, 153));
		button.setBounds(35, 361, 151, 34);
		contentPane.add(button);
		
		JButton button_1 = new JButton("SOLICITAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String UPDATE ="UPDATE Peliculas SET Prestado='No' WHERE IDP='"+iDtoRp.getText()+"'";//
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
						JOptionPane.showMessageDialog(null, "Regreso Exitoso");
				
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
		button_1.setBounds(236, 363, 151, 31);
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
