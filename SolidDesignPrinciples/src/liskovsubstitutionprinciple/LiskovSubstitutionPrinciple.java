package liskovsubstitutionprinciple;



class Bird {
    String name;

    public Bird(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void makeSound() {
        System.out.println(name + " is making a sound.");
    }
}

interface Fly {
    void fly();
}

class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    // Penguins cannot fly, so we don't implement the Fly interface

    @Override
    public void makeSound() {
        System.out.println(name + " is making a unique penguin sound.");
    }
}

class Sparrow extends Bird implements Fly {
    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " is chirping.");
    }
}

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Bird penguin = new Penguin("Penguin1");
        Bird sparrow = new Sparrow("Sparrow1");

        // Demonstrating Liskov Substitution Principle
        penguin.eat();
        penguin.makeSound();

        sparrow.eat();
        sparrow.makeSound();
        ((Sparrow) sparrow).fly(); // Cast to Sparrow to access the fly() method
    }
}
