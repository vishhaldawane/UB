//Restaurant restaurant = new Restaurant();

//Thali thali = restaurant.getThali();

class WashingMachineFactory // factory 'design pattern' 
{
	WashingMachine getWashingMachine(String brandName) {
		WashingTub washTub = new WashingTub();
		WashingMachine washingMachine = new WashingMachine(brandName, washTub);
		Water h2o= new Water();
		Electricity relianceEnergy = new Electricity();
		WashingPowder surfExcel= new WashingPowder();
		Cloth jean = new Cloth();
		Laundry laundry = washingMachine.wash(h2o, relianceEnergy , surfExcel, jean);
		laundry.bill();
		System.out.println("------------------------");
		return washingMachine;
	}
}

public class AssociationTest {
	public static void main(String[] args) {
		
	
		//isA Machine, hasA WashingTub
		WashingMachineFactory factory = new WashingMachineFactory();
		
		WashingMachine washingMachine1 = factory.getWashingMachine("Samsung"); 
		WashingMachine washingMachine2 = factory.getWashingMachine("LG");
		WashingMachine washingMachine3 = factory.getWashingMachine("IFB");
		WashingMachine washingMachine4 = factory.getWashingMachine("Whirlpool");
		WashingMachine washingMachine5 = factory.getWashingMachine("Bosch");
	
		
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
	
	WashingTub washTub ; //hasA - Composition- mandate for the physical presence of a washing machine
	String brandName;
	
	
	public WashingMachine(String brandName,WashingTub wt) {
		super();
		this.brandName = brandName;
		washTub = wt;
	}

				//usesA - passing object as parameter for 
				//the sake of running this method
	Laundry wash(Water water, Electricity elect, WashingPowder powder, Cloth cloth) {
		System.out.println(brandName+" Washing machine is using the water............");
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







