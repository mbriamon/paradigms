public class activity10 {
    public static void main(String[] args) {
        Dog myDog = new Dog("Rex");
        System.out.println("Dog's name: " + myDog.getName());
        myDog.makeSound();  // Should print "Bark"
    }
}

// Interface Animal
interface Animal {
    void makeSound();
}

// Abstract class Mammal
abstract class Mammal {
    protected String name;

    public Mammal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Concrete class Dog
class Dog extends Mammal implements Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}
