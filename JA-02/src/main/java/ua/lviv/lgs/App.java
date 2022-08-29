package ua.lviv.lgs;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		CarDao carDao = new CarDao(ConnectionUtils.connectToDB());
		
		System.out.println(carDao.readById(27));
		carDao.deleteById(25);
		carDao.create(new Car(0, "Ford", 400, 23000));
		carDao.readAll().stream().forEach(System.out::println);
	}
}
