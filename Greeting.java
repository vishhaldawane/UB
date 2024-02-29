public class Greeting {
	public static void main(String[] args) {
		ButterFly butterFlyObjRef = new ButterFly();
		Flight flightObjRef = new Flight();
		ParaGlider paraGliderObjRef = new ParaGlider();
		
		butterFlyObjRef.hexaPoda();
		butterFlyObjRef.fly();
		butterFlyObjRef.checkAeroDynamics();
		butterFlyObjRef.land();
		System.out.println("-----------------------");
		flightObjRef.mechanism();
		flightObjRef.fly();
		flightObjRef.checkAeroDynamics();
		flightObjRef.land();
		System.out.println("-----------------------");
		paraGliderObjRef.think();
		paraGliderObjRef.fly();
		paraGliderObjRef.checkAeroDynamics();
		paraGliderObjRef.land();
	}
}
interface Flying {
	void fly(); // declaration of a function | function without body  | abstract function
		// by default interface functions are public 
	void checkAeroDynamics();
}
interface Landing {
	void land(); //public and abstract without body
}
/*--------------------------------*/
class Insect {
	void hexaPoda () {
		System.out.println("Insects have 6 legs");
	}
}
//The type ButterFly must implement the inherited abstract method Flying.checkAeroDynamics()
class ButterFly extends Insect implements Flying, Landing { //ButterFly is an Insect - isA
	public void fly() {
		System.out.println("ButterFly is flying...");
	}
	public void checkAeroDynamics() {
		System.out.println("ButterFly is checking its aerodynamics..via nature...");
	}
	public void land() {
		System.out.println("ButterFly is landing... on a Rose Flower...");
	}
}
/*--------------------------------*/
class Machine {
	void mechanism() {
		System.out.println("Machine with mechanism");
	}
}
class Flight extends Machine implements Flying, Landing { //Flight is a Machine - isA
	public void fly() {
		System.out.println("Flight is flying...");
	}
	public void checkAeroDynamics() {
		System.out.println("Flight is checking its aerodynamics....via computers....");
	}
	public void land() {
		System.out.println("Flight is landing at Mumbai Airport...");
	}
}
/*--------------------------------*/
class Human {
	void think() {
		System.out.println("Human is thinking....");
	}
}
class ParaGlider extends Human implements Flying,Landing { // ParaGlider is a Human - isA
	public void fly() {
		System.out.println("ParaGlider is flying...");
	}
	public void checkAeroDynamics() {
		System.out.println("ParaGlider is checking its aerodynamics...via..analysis");
	}
	public void land() {
		System.out.println("ParaGlider is landing at the mountain landscape....");
	}
}

