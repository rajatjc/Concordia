class Computer {
	protected int length = 0;
	protected int width = 0;
	protected int height = 0;
	
	public static float sumThreeVolumes(Object o1, Object o2, Object o3) {
		if(o1 instanceof Computer && o2 instanceof Computer && o3 instanceof Computer)	 {
			Computer co1 = (Computer) o1;
			Computer co2 = (Computer) o2;
			Computer co3 = (Computer) o3;
			Computer[] tempArr = {co1, co2, co3};
			float volumeSum = 0;
			
			for(Computer c : tempArr) {
				float cVol = c.height * c.length * c.width;
				if(c instanceof Workstation) {
					volumeSum += ( ((Workstation) c).volumeMultiplier * cVol );
				}
				else {
					volumeSum += cVol;
				}
			}
			
			return volumeSum;
		}
		else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Computer [length=" + length + ", width=" + width + ", height=" + height + " volume= " + (height * length * width) + "]";
	}
	
}

class Laptop extends Computer {
	protected String screenType = "attached";
	
	public Laptop() {
		super.length = 30;
		super.width = 20;
		super.height = 5;
	}

	@Override
	public String toString() {
		return "Laptop [screenType=" + screenType + ", length=" + length + ", width=" + width + ", height=" + height
				+ " volume= " + (height * length * width) + "]";
	}
	
}

class Desktop extends Computer { 
	protected String screenType = "separate";
	
	public Desktop() {
		super.length = 50;
		super.width = 30;
		super.height = 45;
	}

	@Override
	public String toString() {
		return "Desktop [screenType=" + screenType + ", length=" + length + ", width=" + width + ", height=" + height
				+ " volume= " + (height * length * width) + "]";
	}
	
}

class Workstation extends Desktop { 
	protected int volumeMultiplier = 2;
	
	public Workstation() {
		super.length = 50;
		super.width = 30;
		super.height = 45;
	}

	@Override
	public String toString() {
		return "Workstation [volumeMultiplier=" + volumeMultiplier + ", screenType=" + screenType + ", length=" + length
				+ ", width=" + width + ", height=" + height + " volume= " + (height * length * width) + "]";
	}
	
}

class DellLaptop extends Laptop {
	protected String brand;
	
	public DellLaptop() {
		super.length = 35;
		super.width = 25;
		super.height = 10;
	}

	@Override
	public String toString() {
		return "DellLaptop [brand=" + brand + ", screenType=" + screenType + ", length=" + length + ", width=" + width
				+ ", height=" + height + " volume= " + (height * length * width) + "]";
	}
	
} 

class AlienDesktop extends Workstation {
	protected String brand;
	
	public AlienDesktop() {
		super.length = 60;
		super.width = 40;
		super.height = 50;
	}

	@Override
	public String toString() {
		return "AlienDesktop [brand=" + brand + ", volumeMultiplier=" + volumeMultiplier + ", screenType=" + screenType
				+ ", length=" + length + ", width=" + width + ", height=" + height + " volume= " + (height * length * width) + "]";
	}
	
}


public class ComputerWarehouse {
	
	public static void FindBiggestRow(Computer[][] compArr) {
		System.out.println("** FindBiggestRow() **");
		int maxVolIndex = 0;
		float maxVol = 0;
		for(int i=0; i<6; i++) {
			float rowVol = Computer.sumThreeVolumes(compArr[i][0] ,compArr[i][1], compArr[i][2]);
			if(rowVol > maxVol) {
				maxVol = rowVol;
				maxVolIndex = i;
			}
			System.out.println("Row " + i + " has total volume of " + rowVol);
		}
		
		System.out.println("> Row " + Integer.toString(maxVolIndex) + " has the largest volume!");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Computer[][] compArr = new Computer[6][3];
		
		
		compArr[0][0] = new Computer();
		compArr[0][1] = new Laptop();
		compArr[0][2] = new Desktop();
		compArr[1][0] = new Workstation();
		compArr[1][1] = new DellLaptop();
		compArr[1][2] = new AlienDesktop();
		compArr[2][0] = new Computer();
		compArr[2][1] = new AlienDesktop();
		compArr[2][2] = new Computer();
		compArr[3][0] = new Workstation();
		compArr[3][1] = new Laptop();
		compArr[3][2] = new DellLaptop();
		compArr[4][0] = new Desktop();
		compArr[4][1] = new Workstation();
		compArr[4][2] = new Desktop();
		compArr[5][0] = new Workstation();
		compArr[5][1] = new AlienDesktop();
		compArr[5][2] = new Desktop();
		
		System.out.println("Created a 6x3 matrix");
		System.out.println("Generating " + 6*3 + " Computer objects and placing them in the array");
		System.out.println();
		
		
		ComputerWarehouse.FindBiggestRow(compArr);
		
		System.out.println();
		System.out.println(compArr[0][0]);
		System.out.println(compArr[0][1]);
		System.out.println(compArr[0][2]);
		System.out.println(compArr[1][0]);
		System.out.println(compArr[1][1]);
		System.out.println(compArr[1][2]);

	}

}
