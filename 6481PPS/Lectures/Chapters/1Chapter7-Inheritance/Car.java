// Car.java
//
// A simple example of composition using an automobile paradigm.
//

class Engine {
  public void start() {}
  public void rev() {}
  public void stop() {}
}

class Wheel {
  public void inflate(int psi) {}
}

class Window {
  public void rollup() {}
  public void rolldown() {}
}

class Door {
  public Window window = new Window();
  public void open() {}
  public void close() {}
}



// The car object is constructed by combining the Engine, Wheel
// Window, and Door components - no inheritance is used.

public class Car {
  public Engine engine = new Engine();
  public Door left = new Door();
  public Door right = new Door(); // a 2-door car
  
  // with the wheels, we first crate an array of references to 
  // wheel objects. This does not actually create the wheel
  // objects themselves.
  public Wheel[] wheel = new Wheel[4]; 
  
  
  // constructor - now we create the wheel objects and add them to 
  // wheel array
  public Car() {
	for(int i = 0; i < 4; i++)
	  wheel[i] = new Wheel();
  }
  
  // main method
  //
  // create the car, roll up its window and inflate the first
  // tire. Note that the window, wheel, door and engine objects
  // have public visibility. While we don't ordinarily do this with
  // class members, its OK here because the members are actually
  // objects themseleves and thus have their own internal visibility
  // protection
  public static void main(String[] args) {
	Car myCar = new Car();
	myCar.left.window.rollup();
	myCar.wheel[0].inflate(72);
  }
} 
