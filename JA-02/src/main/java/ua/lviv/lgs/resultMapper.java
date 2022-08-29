package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class resultMapper {
	public static Car map(ResultSet result) throws SQLException {
		String brand = result.getString("brand");
		int power = result.getInt("power");
		int cost = result.getInt("cost");
		int id = result.getInt("id");
		
		Car car = new Car(id,brand,power,cost);
		
		return car;
	}
}
