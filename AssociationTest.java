
public class AssociationTest {
	public static void main(String[] args) {
		
		//isA Machine, hasA WashingTub
		WashingMachine washingMachine = new WashingMachine(); 
		
		Water h2o= new Water();
		Electricity relianceEnergy = new Electricity();
		WashingPowder surfExcel= new WashingPowder();
		Cloth jean = new Cloth();
		
												//using these objects
		Laundry laundry = washingMachine.wash(h2o, relianceEnergy , surfExcel, jean);
		//producing Laundry
		laundry.bill();
		
	}
}
/*
		 
		 The Big Umbrella of Object Oriented Paradigm
		 
			isA 	hasA		usesA		producesA
			  |      |              |             |
			  structural			operational/functional
*/
class WashingTub {
	void rinse() {
		System.out.println("WashingTub is rinsing.....");
	}
	void spin() {
		System.out.println("WashingTub is spinning....");
	}
}
class CleaningDevice {} //super class
class WashingPowder { }
class Water { }
class Electricity { }
class Cloth { }
class Laundry { 
	void bill() {
		System.out.println("Finally got the laundry bill....");
	}
}
		//sub class
class WashingMachine extends CleaningDevice //isA - Aggregation
{
	WashingTub washTub = new WashingTub(); //hasA - Composition- mandate for the physical presence of a washing machine
	
				//usesA - passing object as parameter for 
				//the sake of running this method
	Laundry wash(Water water, Electricity elect, WashingPowder powder, Cloth cloth) {
		System.out.println("Washing machine is using the water............");
		System.out.println("Washing machine is using the electricity......");
		System.out.println("Washing machine is using the washing powder...");
		washTub.rinse();
		System.out.println("Washing machine is washing the cloth..........");
		washTub.spin();
		Laundry laundry = new Laundry();
		System.out.println("Washing machine is generating laundry bill....");
		return laundry;
	}
}







