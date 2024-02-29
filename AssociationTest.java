
public class AssociationTest {
	public static void main(String[] args) {
		
	}
}
/*
		 
		 The Big Umbrella of Object Oriented Paradigm
		 
			isA 	hasA		usesA		producesA
			  |      |              |             |
			  structural			operational/functional
*/
class WashingTub {
	
}
class CleaningDevice //super class
{
	
}
class WashingPowder { }
class Water { }
class Electricity { }
class Cloth { }
		//sub class
class WashingMachine extends CleaningDevice //isA - Aggregation
{
	WashingTub washTub = new WashingTub(); //hasA - Composition
	
				//usesA - passing object as parameter for 
				//the sake of running this method
	void wash(Water water, Electricity elect, WashingPowder powder, Cloth cloth) {
		
	}
}







