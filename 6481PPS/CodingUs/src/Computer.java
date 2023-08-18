public class Computer {
    String brand;
    String model;
    long SN; //serial number
    double price;
    static int count=0;

    Computer() {
        brand="";
        model="";
        SN=0;
        price=0.0;
        count++;
    }
    Computer(String brand,String model,long SN, double price) {
        this.brand=brand;
        this.model=model;
        this.SN=SN;
        this.price=price;
        count++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getSN() {
        return SN;
    }

    public void setSN(long SN) {
        this.SN = SN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printInformation() {
        System.out.println("The Brand is "+brand+", the model is "+model+", the SN is"+Long.toString(SN)+", the price is "+Double.toString(price)+".");
    }

    static void findNumberOfCreatedComputers(){
        System.out.println(count);
    }

    public boolean isEqualComputer(Computer c)
    {
        if(this.brand.equals(c.brand)&& this.model.equals(c.model)&&this.price==c.price)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Computer.findNumberOfCreatedComputers();
        Computer c=new Computer("heelo","fff",1232L,44.5);
        System.out.println(c.getBrand());
        Computer.findNumberOfCreatedComputers();

    }
}
