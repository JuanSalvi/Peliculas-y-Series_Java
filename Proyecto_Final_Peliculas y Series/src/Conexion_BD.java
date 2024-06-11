import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Conexion_BD {
	
	public static String url = "jdbc:mysql://localhost:3311/Pruebas_Final";
	public static String Usuario = "root";
	public static String Contraseña = "root";
	public static String Clase = "com.mysql.jdbc.Driver";
	
	public static Connection conectar(){
		Connection conexion = null;
		
		try {
			Class.forName(Clase);
			conexion = (Connection) DriverManager.getConnection(url, Usuario, Contraseña);	
			System.out.println("Conexion establecida");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return conexion;
	}
	

}
