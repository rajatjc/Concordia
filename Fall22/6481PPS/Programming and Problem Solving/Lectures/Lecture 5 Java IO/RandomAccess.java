// RandomAccess.java
//
// Random access to files is very, very common. In this program, we use the
// RandomAccessFile class to modify random fileds in a "database" of records.


import java.io.*;

class EmployeeRecord {

	// based upon the sizes of the primitives, we can calculate the record size
	// and the position of particular fields within the records (i.e., the offsets)
    static final int RECORD_SIZE = Integer.SIZE + Byte.SIZE + Character.SIZE + Double.SIZE;
	static final int ID_OFFSET = 0;
    static final int AGE_OFFSET = Integer.SIZE;
    static final int GENDER_OFFSET = Integer.SIZE + Byte.SIZE;
    static final int SALARY_OFFSET = Integer.SIZE + Byte.SIZE + Character.SIZE;

	// a counter variable that allows us to create a new ID for each new employee
	static int currentID;

	// the four fields found in each employee record
	final int ID;
	byte age;
	char gender;
	double salary;

	// constructor: uses the static currentID field to create a new employee
	// ID for each object
	public EmployeeRecord(byte age, char gender, double salary){
		ID = currentID++;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}

	// constructor: creates an object from an existing record
	public EmployeeRecord(int ID, byte age, char gender, double salary){
		this.ID = ID;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}

	int getID(){
		return ID;
	}

	int getAge(){
		return age;
	}

	char getGender(){
		return gender;
	}

	double getSalary(){
		return salary;
	}

	public String toString(){
		return ("ID: " + ID + ", Age: " + age + ", Gender: " + gender + ", Salary: " + salary);
	}
}

public class RandomAccess {

	static int DBSIZE = 10;

	public static void main (String[] aArguments) throws IOException{

		String dbFile = "db.dat";

		// create an array of employee records
		EmployeeRecord[] dataBase = buildDataBase();

		System.out.println("Original database:");
		for(int i = 0; i < DBSIZE; i++){
			System.out.println(dataBase[i]);
		}

		// write the database to file. This could have been done with a simple
		// stream class if we wanted.
		RandomAccessFile rf = new RandomAccessFile(dbFile, "rw");
		for(int i = 0; i < DBSIZE; i++){
			rf.writeInt(dataBase[i].getID());
			rf.writeByte(dataBase[i].getAge());
			rf.writeChar(dataBase[i].getGender());
			rf.writeDouble(dataBase[i].getSalary());
		}

		// update the database and store to disk
		System.out.println("\nChanging Salary of employee #3 to 88.88..." + EmployeeRecord.RECORD_SIZE + " "+ Integer.SIZE + " "+Byte.SIZE + " "+
			Character.SIZE + " "+Double.SIZE);
		rf.seek(((3 * EmployeeRecord.RECORD_SIZE ) + EmployeeRecord.SALARY_OFFSET) / 8);
		rf.writeDouble(88.88);

		rf.close();

		// read the new database into an employee array
		rf = new RandomAccessFile(dbFile, "r");
		for(int i = 0; i < DBSIZE; i++){
			EmployeeRecord emp =
				new EmployeeRecord(rf.readInt(), rf.readByte(), rf.readChar(), rf.readDouble());
			System.out.println("**" + emp);
			dataBase[i] = emp;
		}
		rf.close();

		// print the contents
		System.out.println("Updated Database:");
		for(int i = 0; i < DBSIZE; i++){
			System.out.println(dataBase[i]);
		}
	}

	static EmployeeRecord[] buildDataBase(){

		EmployeeRecord[] dataBase = new EmployeeRecord[DBSIZE];
		dataBase[0] = new EmployeeRecord((byte)43, 'M', 19.55);
		dataBase[1] = new EmployeeRecord((byte)83, 'F', 85.60);
		dataBase[2] = new EmployeeRecord((byte)25, 'M', 143.45);
		dataBase[3] = new EmployeeRecord((byte)37, 'M', 29.99);
		dataBase[4] = new EmployeeRecord((byte)111, 'F', 5.50);
		dataBase[5] = new EmployeeRecord((byte)20, 'F', 29.55);
		dataBase[6] = new EmployeeRecord((byte)6, 'M', 19.55);
		dataBase[7] = new EmployeeRecord((byte)19, 'M', 123.99);
		dataBase[8] = new EmployeeRecord((byte)42, 'F', 23.45);
		dataBase[9] = new EmployeeRecord((byte)16, 'M', 13.56);

		return dataBase;
	}
}
