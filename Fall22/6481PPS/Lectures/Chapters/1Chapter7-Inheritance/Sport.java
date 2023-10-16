// Sport.java
//
// An example of a typical inheritance hierarchy. At the top of the 
// tree, we have the athlete class. There are two subclass of athlete,
// proAthlete and amateurAthlete. In turn, there are two classes of
// amateurAthlete, competitiveAthlete and recreationalAthlete.
// Note how common functionality is pushed as high as possible 
// up into the tree. You never want to implment the same thing twice
// in two different classes.

// the base of the hierarchy. Name and sport are common to all athletes
class Athlete{

	private String name;
	private String sport;
	
	public String getName(){
		return name;	
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getSport(){
			return sport;	
	}
	
	public void setSport(String sport){
		this.sport = sport;
	}
}


// a pro athlete adds a team and a salary
class ProAthlete extends Athlete{
	
	private String team;
	private double salary;
	
	public String getTeam(){
		return team;	
	}
	
	public void setName(String team){
		this.team = team;
	}
	
	public double getSalary(){
		return salary;	
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
}


// an amateur athlete add a province member
class AmateurAthlete extends Athlete{
	
	private String province;
	
	public String getProvince(){
		return province;	
	}
	
	public void setProvince(String province){
		this.province = province;
	}
}


// a competitive amateur athlete has funding 
class CompetitiveAthlete extends AmateurAthlete{
	
	private String funding;
	
	public String getFunding(){
		return funding;	
	}
	
	public void setFunding(String funding){
		this.funding = funding;
	}
}



// a recreational athlete adds no additonal information
// to the amateurAthlete class, but is does provide
// a different kind of formatting for the name. It uses
// the getName() method inherited from the original
// base class (athlete).

class RecreationalAthlete extends AmateurAthlete{
	
	public String getName( ){
		return (super.getName() + " (recreational) ");
	}
	
}




// a test class. Try adding some objects to test the above
// classes
public class Sport {

	public static void main(String[] args) {
		CompetitiveAthlete comAt = new CompetitiveAthlete();
		comAt.setName("Billy Sue");
		
		RecreationalAthlete recAt = new RecreationalAthlete();
		recAt.setName("Betty Jack");
		
		System.out.println("Competitive Athlete = " + comAt.getName());
		System.out.println("Recreational Athlete = " + recAt.getName());
		
	}
}
