package ua.lviv.lgs;

public class Car {
	int id;
	String brand;
	int power;
	int cost;
	
	public Car(int id,String brand, int power, int cost) {
		this.id = id;
		this.brand = brand;
		this.power = power;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", power=" + power + ", cost=" + cost + "]";
	}
	
	
}
