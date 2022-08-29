package ua.lviv.lgs;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static String username = "root";
	private static String user_password = "root";
	private static String url = "jdbc:mysql://localhost/test";
	
	public static Connection connectToDB() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class.forName ("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		return DriverManager.getConnection (url, username, user_password);
		
	}
}
