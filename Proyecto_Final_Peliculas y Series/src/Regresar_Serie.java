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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

public class Regresar_Serie extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField IDtoRs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regresar_Serie frame = new Regresar_Serie();
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
	public Regresar_Serie() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juan\\Desktop\\Miselaneos\\LORE.png"));
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
			ResultSet rs=stmt.executeQuery("select * from Series WHERE Prestado='Si'");
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
		scrollPane.setBounds(41, 124, 351, 203);
		contentPane.add(scrollPane);		
		
		JLabel lblRegresoDeSerie = new JLabel("Regreso de Serie");
		lblRegresoDeSerie.setForeground(new Color(106, 90, 205));
		lblRegresoDeSerie.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		lblRegresoDeSerie.setBounds(128, 22, 206, 14);
		contentPane.add(lblRegresoDeSerie);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(20, 35, 372, 1);
		contentPane.add(horizontalBox);
		
		IDtoRs = new JTextField();
		IDtoRs.setForeground(Color.WHITE);
		IDtoRs.setColumns(10);
		IDtoRs.setBackground(new Color(153, 153, 153));
		IDtoRs.setBounds(30, 72, 372, 28);
		contentPane.add(IDtoRs);
		
		JLabel lblIngreseIdDe = new JLabel("Ingrese ID de Seriea Regresar");
		lblIngreseIdDe.setForeground(Color.LIGHT_GRAY);
		lblIngreseIdDe.setFont(new Font("Helvetica", Font.BOLD, 12));
		lblIngreseIdDe.setBounds(111, 47, 225, 14);
		contentPane.add(lblIngreseIdDe);
		
		JButton button = new JButton("SOLICITAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String UPDATE ="UPDATE Series SET Prestado='No' WHERE IDP='"+IDtoRs.getText()+"'";//
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
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Helvetica", Font.BOLD, 12));
		button.setBackground(new Color(51, 204, 51));
		button.setBounds(242, 354, 151, 31);
		contentPane.add(button);
		
		JButton button_1 = new JButton("REGRESAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//<----------- BOTON DE REGRESO A Interfaz ---------->
				Interfaz Natsuki = new Interfaz();//Creacion de Objeto Conector a Interfaz Principal de Login
				Natsuki.setVisible(true);//Se Habilita visualizacion de ventana Principal
				Regresar_Serie.this.setVisible(false);//Se Deshabilita Venta Actual
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Helvetica", Font.BOLD, 12));
		button_1.setBackground(new Color(51, 102, 153));
		button_1.setBounds(41, 352, 151, 34);
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
