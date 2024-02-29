
class CarFactory
{
	Car getCar(String pistonType) {
		Piston pist = new Piston(pistonType);
		Engine eng = new Engine(pist);
		System.out.println("pist "+pist);
		System.out.println("eng  "+eng);
		Car car = new Car(eng);
		
		return car;
	}
}
public class CarTest {
	public static void main(String[] args) {
		
		CarFactory carFactory = new CarFactory();
		Car car1 = carFactory.getCar("2 cylinder ");
		Car car2 = carFactory.getCar("4 cylinder ");
		Car car3 = carFactory.getCar("8 cylinder ");
		
		
		car1.startCar();
		car2.startCar();
		car3.startCar();
		
		System.out.println("car "+car1);
		System.out.println("car "+car2);
		System.out.println("car "+car3);

		
		
		/*Piston pist = new Piston("4 cylinder");
		Engine eng = new Engine(pist);
		Car car1 = new Car(eng);
		car1.startCar();
		
		System.out.println("car "+car1);
		
		
		Piston pist2 = new Piston("8 cylinder");
		Engine eng2 = new Engine(pist);
		Car car2 = new Car(eng);
		car2.startCar();
		
		System.out.println("car2 "+car2);*/
		
		
	}
}

class Piston {
	
	String type;
	
	Piston(String t) { 
		type= t; 
	}
	void firePiston() {
		System.out.println("Firing piston...."+type);
	}
}
class Engine {
	
	Piston piston;
	
	Engine(Piston p) {
		piston= p;
	}
	
	void ignite() {
		piston.firePiston();
		System.out.println("Igniting the engine...");
	}
}

class Car {
	Engine engine; //null
	
	Car(Engine e) {
		engine = e;
	}
	void startCar() {
		engine.ignite();
		System.out.println("Starting the car...");
	}
}











