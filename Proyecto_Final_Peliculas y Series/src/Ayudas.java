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
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ayudas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayudas frame = new Ayudas();
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
	public Ayudas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		try {
			/*Pantalla frame = new Pantalla();
			frame.setVisible(true);*/
			
			//CONEXION CON BASE DE DATOS
			/*Revisar si la clase existe */
			Class.forName("com.mysql.jdbc.Driver");
			//CREAR CONEXION
			Connection con=DriverManager.getConnection(
					/*jdbc:mysql: //localhost:<port> / <base de datos> ) */
					"jdbc:mysql://localhost:3311/alumnos",
					"root","root");
			/*Create sentencia */
			Statement stmt=con.createStatement();
			/*Ejecutar el query */
			ResultSet rs=stmt.executeQuery("select * from alumnos");
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
		scrollPane.setBounds(10, 74, 414, 113);
		contentPane.add(scrollPane);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
		horizontalBox.setBounds(34, 24, 372, 1);
		contentPane.add(horizontalBox);
		
		JLabel label = new JLabel("Prestamo De Serie");
		label.setForeground(new Color(106, 90, 205));
		label.setFont(new Font("Paladins Semi-Italic", Font.PLAIN, 11));
		label.setBounds(115, 11, 225, 14);
		contentPane.add(label);
		
		JButton button = new JButton("Regresar");
		button.setBounds(166, 215, 89, 23);
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
