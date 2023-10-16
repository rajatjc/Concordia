class Clothing {
	private double price;
	private static int noOfClothingObjects = 0;

	public Clothing(double price) {
		this.price = price;
		noOfClothingObjects += 1;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Clothing other = (Clothing) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	public static void getNumberOfCreatedObjects() {
		System.out.println(noOfClothingObjects + " Clothing objects were created");
	}
}
	
class Dresses extends Clothing {
	private double height;
	private static int noOfDressesObjects = 0;

	public Dresses(double price, double height) {
		super(price);
		this.height = height;
		noOfDressesObjects += 1;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dresses other = (Dresses) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		return true;
	}
	
	public static void getNumberOfCreatedObjects() {
		System.out.println(noOfDressesObjects + " Dress objects were created");
	}
	
}
	
class Jacket extends Clothing {
	private String color;
	private static int noOfJacketObjects = 0;

	public Jacket(double price, String color) {
		super(price);
		this.color = color;
		noOfJacketObjects += 1;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jacket other = (Jacket) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
	
	public static void getNumberOfCreatedObjects() {
		System.out.println(noOfJacketObjects + " Jacket objects were created");
	}

}
	
class Shirts extends Clothing {
	private double size;
	private double width;
	private double height;
	private static int noOfShirtsObjects = 0;
	
	public Shirts(double price, double size, double width, double height) {
		super(price);
		this.size = size;
		this.width = width;
		this.height = height;
		noOfShirtsObjects += 1;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shirts other = (Shirts) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}
	
	public static void getNumberOfCreatedObjects() {
		System.out.println(noOfShirtsObjects + " Shirts objects were created");
	}
	
}
	
class SportsJacket extends Jacket {
	private int year;
	private String countryOfManufacture;
	private static int noOfSportsJacketObjects = 0;
	
	public SportsJacket(double price, String color, int year, String countryOfManufacture) {
		super(price, color);
		this.year = year;
		this.countryOfManufacture = countryOfManufacture;
		noOfSportsJacketObjects += 1;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountryOfManufacture() {
		return countryOfManufacture;
	}

	public void setCountryOfManufacture(String countryOfManufacture) {
		this.countryOfManufacture = countryOfManufacture;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SportsJacket other = (SportsJacket) obj;
		if (countryOfManufacture == null) {
			if (other.countryOfManufacture != null)
				return false;
		} else if (!countryOfManufacture.equals(other.countryOfManufacture))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	public static void getNumberOfCreatedObjects() {
		System.out.println(noOfSportsJacketObjects + " SportsJacket objects were created");
	}

	@Override
	public void setPrice(double price) {
		if(price >= 50) {
			super.setPrice(price);
		}
	}
}

public class UtilizeClothing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clothing c1 = new Clothing(100);
		Clothing c2 = new Clothing(200);
		Dresses d1 = new Dresses(100, 10);
		Dresses d2 = new Dresses(200, 20);
		Jacket j1 = new Jacket(100, "black");
		Jacket j2 = new Jacket(200, "brown");
		Shirts s1 = new Shirts(100, 30, 40, 10);
		Shirts s2 = new Shirts(200, 32, 42, 20);
		SportsJacket sj1 = new SportsJacket(150, "black", 2020, "China");
		SportsJacket sj2 = new SportsJacket(140, "black", 2020, "China");
		
		sj1.setPrice(140);
		sj1.setPrice(40);
		
		Clothing.getNumberOfCreatedObjects();
		Dresses.getNumberOfCreatedObjects();
		Jacket.getNumberOfCreatedObjects();
		Shirts.getNumberOfCreatedObjects();
		SportsJacket.getNumberOfCreatedObjects();
		
		System.out.println("C1 equals C2 : " + c1.equals(c2));
		System.out.println("D1 equals D2 : " + d1.equals(d2));
		System.out.println("J1 equals J2 : " + j1.equals(j2));
		System.out.println("S1 equals S2 : " + s1.equals(s2));
		System.out.println("SJ1 equals SJ2 : " + sj1.equals(sj2));
		
		System.out.println("J1 equals SJ1 : " + j1.equals(sj1));
	}

}
