public class Greeting {
	public static void main(String[] args) {
		ButterFly butterFlyObjRef = new ButterFly();
		Flight flightObjRef = new Flight();
		ParaGlider paraGliderObjRef = new ParaGlider();
		
		butterFlyObjRef.hexaPoda();
		butterFlyObjRef.fly();
		
		flightObjRef.mechanism();
		flightObjRef.fly();
		
		paraGliderObjRef.think();
		paraGliderObjRef.fly();
	}
}
class Insect {
	void hexaPoda () {
		System.out.println("Insects have 6 legs");
	}
}
class ButterFly extends Insect { //ButterFly is an Insect - isA
	void fly() {
		System.out.println("ButterFly is flying...");
	}
}
/*--------------------------------*/
class Machine {
	void mechanism() {
		System.out.println("Machine with mechanism");
	}
}
class Flight extends Machine { //Flight is a Machine - isA
	void fly() {
		System.out.println("Flight is flying...");
	}
}
/*--------------------------------*/
class Human {
	void think() {
		System.out.println("Human is thinking....");
	}
}
class ParaGlider extends Human { // ParaGlider is a Human - isA
	void fly() {
		System.out.println("ParaGlider is flying...");
	}
}

