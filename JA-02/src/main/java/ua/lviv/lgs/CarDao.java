package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	static String READ_ALL = "select * from cars_catalog";
	static String READ_BY_ID = "select * from cars_catalog where id=?";
	static String CREATE = "INSERT INTO cars_catalog (brand,power,cost) values(?,?,?)";
	static String UPDATE_BY_ID = "update cars_catalog set brand=?,power=?,cost=? where id=?";
	static String DELETE_BY_ID = "delete from cars_catalog where id=?";
	
	public CarDao(Connection connection) {
		this.connection = connection;
	}
	
	public void create(Car car) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, car.brand);
		preparedStatement.setInt(2, car.power);
		preparedStatement.setInt(3, car.cost);
		preparedStatement.executeUpdate();
	}
	
	public Car readById(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return resultMapper.map(result);
		
	}
	
	public void updateById(int id,Car car) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, car.brand);
		preparedStatement.setInt(2, car.power);
		preparedStatement.setInt(3, car.cost);
		preparedStatement.setInt(4, id);
		preparedStatement.executeUpdate();
	}
	
	public void deleteById(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();	
	}
	
	public List<Car> readAll() throws SQLException {
		preparedStatement = connection.prepareStatement(READ_ALL);
		
		List<Car> carsList = new ArrayList<>();
		ResultSet result = preparedStatement.executeQuery();
		
		while (result.next()) {
			carsList.add(resultMapper.map(result));
		}
		
		return carsList;
		
	}
}
