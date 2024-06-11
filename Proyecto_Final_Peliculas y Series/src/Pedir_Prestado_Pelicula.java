import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
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
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pedir_Prestado_Pelicula extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedir_Prestado_Pelicula frame = new Pedir_Prestado_Pelicula();
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
	public Pedir_Prestado_Pelicula() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\ShapeShifterShield_T3.png"));
		setTitle("Prestamos de Pelicula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
			ResultSet rs=stmt.executeQuery("select * from Peliculas WHERE Prestado	 = 'Si' ");
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
		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(10, 34, 419, 180);
		contentPane.add(scrollPane1);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(29, 24, 372, 1);
		contentPane.add(horizontalBox);
		
		JLabel label = new JLabel("Prestamo De Pelicula");
		label.setForeground(new Color(106, 90, 205));
		label.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		label.setBounds(110, 11, 225, 14);
		contentPane.add(label);
		
		JButton button = new JButton("Regresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  Interfaz Regresar = new Interfaz();//Creacion de Objeto Conector a Interfaz Principal
			  Regresar.setVisible(true);//Se Habilita visualizacion de ventana Principal
			  Pedir_Prestado_Pelicula.this.setVisible(false); //Se Deshabilita Venta Actual
			}
		});
		button.setBounds(169, 227, 89, 23);
		contentPane.add(button);
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
