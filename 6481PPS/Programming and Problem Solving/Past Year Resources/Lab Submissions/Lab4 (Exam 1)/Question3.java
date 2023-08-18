// A set of inherited classes. Notice that the code is incomplete 
// and you must add whatever needed to achieve the requirements


// Computer Class
class Computer {

	// Attributes
	protected int screenSize; // screenSize in inches
	protected double price;
	private long serialNum;
	private static long serialNumCtr = 999;

	public Computer() {
		this.screenSize = 4;
		this.price = 10000.0;
		serialNumCtr++;
		serialNum = serialNumCtr;
	}
	
	public Computer(int screenSize, double price) {
		this.screenSize = screenSize;
		this.price = price;
		serialNumCtr++;
		serialNum = serialNumCtr;
	}
	
	public Computer(Computer c) {
		this.screenSize = c.screenSize;
		this.price = c.price;
		serialNumCtr++;
		serialNum = serialNumCtr;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int ss) {
		screenSize = ss;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double pr) {
		price = pr;
	}

	public String toString() {
		return "This Computer has a " + screenSize + " inch screen and its price is " + price + "$.";
	}

	// Find out if that computer has a cheaper price than the passed computer
	public boolean isCheaper(Computer v) {
		// Obtain the class names just for display purposes
		String s1 = this.getClass().toString(), s2 = v.getClass().toString();
		s1 = s1.substring(6); // Remove the word "class" to get only the class name
		s2 = s2.substring(6);

		if (getPrice() < v.getPrice()) {

			System.out.println(
					"The price of this " + s1 + " object is cheaper than the price of the passed " + s2 + " object.");
			return true;
		} else {
			System.out.println("The price of this " + s1 + " object is NOT cheaper than the price of the passed " + s2
					+ " object.");
			return false;
		}
	}

	public long getSerNumber() {
		return serialNum;
	}

	public Computer clone() {
		return new Computer(this);
	}

} // end of Computer class

// Laptop Class - This is a derived class from the Computer Class

class Laptop extends Computer {

	// Attributes
	private int installedRAM;
	private long serialNum;
	private static long serialNumCtr = 1999;

	
	
	public Laptop(int screenSize, int price, int installedRAM) {
		super(screenSize, price);
		this.installedRAM = installedRAM;
		serialNumCtr++;
		serialNum = serialNumCtr;
	}
	
	public Laptop(Laptop l) {
		super(l.screenSize, l.price);
		this.installedRAM = l.installedRAM;
		serialNumCtr++;
		serialNum = serialNumCtr;
	}

	public int getInstalledRAM() {
		return installedRAM;
	}

	public void setInstalledRAM(int ir) {
		installedRAM = ir;
	}

	public String toString() {
		return "This Laptop has a " + getScreenSize() + " inch screen and its price is: " + getPrice()
				+ "$. The installed RAM of this laptop is " + installedRAM + "GB.";
	}

	// Override the setPrice() method
	public void setPrice(double pr) {
		
		super.setPrice(pr);

	}

	public double getPrice() {
		return price;
	}

	public long getSerNumber() {
		return serialNum;
	}
	
	public Laptop clone() {
		return new Laptop(this);
	}


} // end of Laptop class

// Workstation Class - This is a derived class from the Computer Class.
// For a Workstation object, we are interested in its number of CPU cores
class Workstation extends Computer {

	// Attributes
	private int numOfCpuCores;
	private long serialNum;
	private static long serialNumCtr = 2999;

	public Workstation(int screenSize, double price, int numOfCpuCores) {
		super(screenSize, price);
		this.numOfCpuCores = numOfCpuCores;
		serialNumCtr++;
		serialNum = serialNumCtr;
	}
	
	public Workstation(Workstation w) {
		super(w.screenSize, w.price);
		this.numOfCpuCores = w.numOfCpuCores;
		serialNumCtr++;
		serialNum = serialNumCtr;
	}

	public int getNumOfCpuCores() {
		return numOfCpuCores;
	}

	public void setNumOfCpuCores(int nc) {
		numOfCpuCores = nc;
		;
	}

	public String toString() {
		return "This Workstation has a " + getScreenSize() + " inch and its price is: " + getPrice()
				+ "$. The number of CPU cores of this workstation is " + numOfCpuCores + ".";
	}

	public double getPrice() {
		return price;
	}

	public long getSerNumber() {
		return serialNum;
	}

	public Workstation clone() {
		return new Workstation(this);
	}


} // end of Workstation class

// GamingWorkstation Class - This is a derived class from the Workstation Class
// For a Workstation object, we are interested in its gpu memory size.
class GamingWorkstation extends Workstation {

	// Attributes
	private int gpuMemorySize;
	private long serialNum;
	private static long serialNumCtr = 3999;

	public GamingWorkstation(int screenSize, double price, int numOfCpuCores, int gpuMemorySize) {
		super(screenSize, price, numOfCpuCores);
		this.gpuMemorySize = gpuMemorySize;
		serialNumCtr++;
		serialNum = serialNumCtr;
	}
	
	public GamingWorkstation(GamingWorkstation g) {
		super(g.screenSize, g.price, g.getNumOfCpuCores());
		this.gpuMemorySize = g.gpuMemorySize;
		serialNumCtr++;
		serialNum = serialNumCtr;
	}

	public double getGpuMemorySize() {
		return gpuMemorySize;
	}

	public void setGpuMemorySize(int gm) {
		gpuMemorySize = gm;
		
	}

	public String toString() {
		return "This gaming workstation has a " + getScreenSize() + " inch screen and its price is: " + getPrice()
				+ "$. The number of CPU cores of this gaming workstation is " + getNumOfCpuCores() + "\nand has "
				+ gpuMemorySize + " GPU memory size.";
	}

	public double getPrice() {
		return price;
	}

	public long getSerNumber() {
		return serialNum;
	}
	
	public GamingWorkstation clone() {
		return new GamingWorkstation(this);
	}
	
} // end of GamingWorkstation class

public class Question3 {

	// A method that would accept any computer object and displays its information
	public static void showComputerInfo(Computer c) {
		System.out.println("Here is the information of this Computer");
		System.out.println(c);
		System.out.println();
	}

	// A method that takes an array of computers and return a copy of that array
	public static Computer[] copyInventory1(Computer[] ca) {
		// Your code goes here...
		Computer[] inv = new Computer[ca.length];
		for(int i=0; i<ca.length; i++) {
			inv[i] = ca[i];
		}
		return inv;
	}

	// A method that takes an array of computers and return a copy of that array
	public static Computer[] copyInventory2(Computer[] ca) {
		// Your code goes here...
		Computer[] inv = new Computer[ca.length];
		for(int i=0; i<ca.length; i++) {
			inv[i] = ca[i].clone();
		}
		return inv;
	}

	// A method that displays the contents of an inventory
	public static void displayInventoryInfo(Computer[] ca) {
		String s;
		System.out.println("\nHere is the information of computers in that inventory");
		for (int i = 0; i < ca.length; i++) {
			// Obtain the class name just for display purposes
			s = ca[i].getClass().toString();
			s = s.substring(6); // Remove the word "class" to get only the class name
			System.out.print((i + 1) + ". " + s + " with serial number " + ca[i].getSerNumber() + ". ");
			System.out.println(ca[i]);

		}
	}

	public static void main(String[] args) {//System.out.println("Will create three Computer objects");

		Computer c1 = new Computer(), c2 = new Computer(15, 500), c3 = new Computer(c2);

		Laptop l1 = new Laptop(14, 1400, 16), l2 = new Laptop(15, 2000, 32), l3 = new Laptop(l1);

		Workstation w1 = new Workstation(16, 3000, 8), w2 = new Workstation(19, 2500, 6);

		GamingWorkstation gw1 = new GamingWorkstation(16, 3000, 8, 8026),
				gw2 = new GamingWorkstation(16, 2500, 10, 4000), gw3 = new GamingWorkstation(32, 4000, 16, 8000);

		Computer[] compInv1 = new Computer[5];
		compInv1[0] = c1;
		compInv1[1] = l1;
		compInv1[2] = l2;
		compInv1[3] = gw1;
		compInv1[4] = gw2;

		System.out.print("\nInventory compInv1: ");
		displayInventoryInfo(compInv1);

		Computer[] compInv2 = new Computer[4];
		compInv2[0] = c2;
		compInv2[1] = gw3;
		compInv2[2] = l3;
		compInv2[3] = w1;

		System.out.print("\nInventory compInv2: ");
		displayInventoryInfo(compInv2);

		Computer[] compInv3 = copyInventory1(compInv1);
		Computer[] compInv4 = copyInventory2(compInv2);

		System.out.print("\nHere are the contents of Inventory compInv3: ");
		displayInventoryInfo(compInv3);

		System.out.print("\nHere are the contents of Inventory compInv4: ");
		displayInventoryInfo(compInv4);
		
		
		Computer[] compInv5 = new Computer[4];
		compInv5[0] = c3;
		compInv5[1] = w2;
		compInv5[2] = l2;
		compInv5[3] = gw3;
		System.out.print("\nInventory compInv5: ");
		displayInventoryInfo(compInv5);
		
		Computer[] compInv6 = copyInventory1(compInv5);
		Computer[] compInv7 = copyInventory2(compInv5);
		System.out.print("\nInventory compInv6 - compInv5 using copyInventory1: ");
		displayInventoryInfo(compInv6);
		System.out.print("\nInventory compInv7 - compInv5 using copyInventory2: ");
		displayInventoryInfo(compInv7);
	}

}

/* The Output - 3 sample

Inventory compInv5: 
Here is the information of computers in that inventory
1. Computer with serial number 1002. This Computer has a 15 inch screen and its price is 500.0$.
2. Workstation with serial number 3001. This Workstation has a 19 inch and its price is: 2500.0$. The number of CPU cores of this workstation is 6.
3. Laptop with serial number 2001. This Laptop has a 15 inch screen and its price is: 2000.0$. The installed RAM of this laptop is 32GB.
4. GamingWorkstation with serial number 4002. This gaming workstation has a 32 inch screen and its price is: 4000.0$. The number of CPU cores of this gaming workstation is 16
and has 8000 GPU memory size.

Inventory compInv6 - compInv5 using copyInventory1: 
Here is the information of computers in that inventory
1. Computer with serial number 1002. This Computer has a 15 inch screen and its price is 500.0$.
2. Workstation with serial number 3001. This Workstation has a 19 inch and its price is: 2500.0$. The number of CPU cores of this workstation is 6.
3. Laptop with serial number 2001. This Laptop has a 15 inch screen and its price is: 2000.0$. The installed RAM of this laptop is 32GB.
4. GamingWorkstation with serial number 4002. This gaming workstation has a 32 inch screen and its price is: 4000.0$. The number of CPU cores of this gaming workstation is 16
and has 8000 GPU memory size.

Inventory compInv7 - compInv5 using copyInventory2: 
Here is the information of computers in that inventory
1. Computer with serial number 1015. This Computer has a 15 inch screen and its price is 500.0$.
2. Workstation with serial number 3007. This Workstation has a 19 inch and its price is: 2500.0$. The number of CPU cores of this workstation is 6.
3. Laptop with serial number 2004. This Laptop has a 15 inch screen and its price is: 2000.0$. The installed RAM of this laptop is 32GB.
4. GamingWorkstation with serial number 4004. This gaming workstation has a 32 inch screen and its price is: 4000.0$. The number of CPU cores of this gaming workstation is 16
and has 8000 GPU memory size.

*/
