
public class AssociationTest {
	public static void main(String[] args) {
		WashingMachine washingMachine = new WashingMachine();
		
		Water h2o= new Water();
		Electricity relianceEnergy = new Electricity();
		WashingPowder surfExcel= new WashingPowder();
		Cloth jean = new Cloth();
		
		Laundry laundryBill = washingMachine.wash(h2o, relianceEnergy , surfExcel, jean);
		
	}
}
/*
		 
		 The Big Umbrella of Object Oriented Paradigm
		 
			isA 	hasA		usesA		producesA
			  |      |              |             |
			  structural			operational/functional
*/
class WashingTub { }
class CleaningDevice {} //super class
class WashingPowder { }
class Water { }
class Electricity { }
class Cloth { }
class Laundry { }
		//sub class
class WashingMachine extends CleaningDevice //isA - Aggregation
{
	WashingTub washTub = new WashingTub(); //hasA - Composition- mandate for the physical presence of a washing machine
	
				//usesA - passing object as parameter for 
				//the sake of running this method
	Laundry wash(Water water, Electricity elect, WashingPowder powder, Cloth cloth) {
		
		Laundry laundry = new Laundry();
		return laundry;
	}
}







