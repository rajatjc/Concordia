public class ExampleCasting {

   public static void main (String[] args) {
        
       Animal a1 = new Dog();
       Dog d1 = new Dog();
       a1 = d1;
       
       // Dog d2 = new Animal(); // compiler: incompatible types
     //  Dog d2 = (Dog) new Animal(); // runtime: ClassCastException
       
       Dog d3 = new Dog();
       Animal a3 = d3;
       Dog d4 = (Dog) a3;
       
       Animal a5 = new Dog();
       //Dog d5 = a5;   // compiler: incompatible types
       Dog d6 = (Dog) a5; 
                   
       Helicopter h = new Helicopter();
       // Animal a5 = (Animal) h;  // compiler: incompatible types
       
       
       // let's try with interfaces now...
       
       Inflatable i = new Balloon();
       i = new BigBalloon();
       
       // Balloon b = i; // compiler: incompatible types
       Balloon b = (Balloon) i;   
       
       //BigBalloon bb = (BigBalloon) new Balloon();  // runtime: ClassCastException
       
       //BigBalloon bb2 = i;  // compiler: incompatible types
       //BigBalloon bb3 = (Balloon) i;  // compiler: incompatible types
         BigBalloon bb4 = (BigBalloon) i;   
         
         i = new Pool();
         b = new Balloon();
         i = b;  
    }
}

class Animal {
}

class Helicopter {
}

class Dog extends Animal {
}


interface Inflatable {
}

class Balloon implements Inflatable {
}

class BigBalloon extends Balloon {
}

class Pool implements Inflatable {
}