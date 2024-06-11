import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Metodos_Login {
	
	public static Conexion_BD conexion = new Conexion_BD();
	
	public static java.sql.PreparedStatement Sentencia_Preparada;
	public static ResultSet resultado;
	public static String SQL;
	public static int Resultado_numero = 0;
	
	public static String Buscar_Usuario(String nombre){ //Metodo Para Buscar al usuario en Base de datos y Guardar NOmbre del mismo
		
		String Busqueda_Nombre = null;
		Connection conexion = null;
		
		try {
			conexion = Conexion_BD.conectar();
			String Sentencia_Buscar =("SELECT Nombre_Us FROM users WHERE Nombre_Us ='"+nombre+"'");
			
			Sentencia_Preparada = conexion.prepareStatement(Sentencia_Buscar);
			resultado = Sentencia_Preparada.executeQuery();
			if (resultado.next()) {
				String Nombre = resultado.getString("Nombre_Us");
				Busqueda_Nombre = Nombre;
			}
			conexion.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return Busqueda_Nombre;
	}  
	
	public static String Buscar_Usuario_Registrado(String Usuario, String Contraseña){
		String Busqueda_Usuario = null;
		Connection conexion = null;
		
		try {
			conexion = Conexion_BD.conectar();
			String Sentencia_Buscar_Usuario = ("SELECT Nombre_Us,Password,Correo FROM users WHERE Nombre_Us = '"+Usuario+"' &&	 Password ='"+Contraseña+"'");
			Sentencia_Preparada = conexion.prepareStatement(Sentencia_Buscar_Usuario);
			resultado = Sentencia_Preparada.executeQuery();
			if (resultado.next()) {
				Busqueda_Usuario = "Usuario Encontrado";
			}else {
				Busqueda_Usuario = "Usuario No encontrado";
			}
			
			conexion.close();	
		} catch (Exception e) {
			System.out.println(e);
		}
		return Busqueda_Usuario;
	}
	

}
