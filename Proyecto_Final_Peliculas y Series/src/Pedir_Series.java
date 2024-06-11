import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pedir_Series extends JFrame {

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
					Pedir_Series frame = new Pedir_Series();
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
	public Pedir_Series() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\ShieldofThorns_Relic.png"));
		setTitle("Pedir Prestamo Series");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);//Ayuda a CENTRAR VENTANA
		
		
		
		try {
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
			ResultSet rs=stmt.executeQuery("select * from Series Where Prestado ='No'");
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
		scrollPane.setBounds(39, 106, 346, 203);
		contentPane.add(scrollPane);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(29, 24, 372, 1);
		contentPane.add(horizontalBox);
		
		JLabel label = new JLabel("Prestamo de Serie");
		label.setForeground(new Color(106, 90, 205));
		label.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		label.setBounds(123, 11, 206, 14);
		contentPane.add(label);
		
		JLabel lblIngreseIdDe = new JLabel("Ingrese ID de Serie a Rentar:");
		lblIngreseIdDe.setForeground(Color.LIGHT_GRAY);
		lblIngreseIdDe.setFont(new Font("Helvetica", Font.BOLD, 12));
		lblIngreseIdDe.setBounds(110, 42, 225, 14);
		contentPane.add(lblIngreseIdDe);
		
		IDtoRentar = new JTextField();
		IDtoRentar.setForeground(Color.WHITE);
		IDtoRentar.setColumns(10);
		IDtoRentar.setBackground(new Color(153, 153, 153));
		IDtoRentar.setBounds(29, 67, 372, 28);
		contentPane.add(IDtoRentar);
		
		JButton button = new JButton("REGRESAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//<----------- BOTON DE REGRESO A Interfaz ---------->
			Interfaz Natsuki = new Interfaz();//Creacion de Objeto Conector a Interfaz Principal de Login
			Natsuki.setVisible(true);//Se Habilita visualizacion de ventana Principal
			Pedir_Series.this.setVisible(false);//Se Deshabilita Venta Actual
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Helvetica", Font.BOLD, 12));
		button.setBackground(new Color(51, 102, 153));
		button.setBounds(44, 344, 151, 34);
		contentPane.add(button);
		
		JButton button_1 = new JButton("SOLICITAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String UPDATE ="UPDATE Series SET Prestado='Si' WHERE IDS='"+IDtoRentar.getText()+"'";
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
		button_1.setBackground(new Color(51, 153, 51));
		button_1.setBounds(250, 346, 151, 31);
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
