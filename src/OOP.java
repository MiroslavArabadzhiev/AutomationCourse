public class OOP {
    public static void main(String[] args) {
        ClassExample myObject = new ClassExample();
        System.out.println("The initial value is: " + myObject.x);
        //System.out.println(myObject.anotherAttribute);

        myObject.x = 30;
        System.out.println("The new value is: " + myObject.x);

        ClassExample myObject2 = new ClassExample();
        myObject2.x = 20;
        System.out.println("The value of Object2 is: " + myObject2.x);

        ClassExample myObject3 = new ClassExample();
        System.out.println("The value of Object3 is: " + myObject3.x);

        //myObject.y = 30;

        ClassExample.printHello();
        System.out.println();
        System.out.println();

        myObject.printHelloOfObject();
        System.out.println();
        System.out.println();

        BankAccount b = new BankAccount("Ivan Ivanov");
        b.getAccountBalance();
        b.getAccountNumber();
        System.out.println(b.getOwnerName() + " " + b.getAccountBalance() + " " + b.getAccountNumber());

        System.out.println();
        System.out.println();

        Car3 c = new Car3("Toyota", "Rav4", 4.4, 1.5, 2, 4);
        c.closeOpenDoor();
        c.honk();

        System.out.println();
        System.out.println();

        //Animal1 myAnimal = new Animal1(); // Create an Animal object
        Animal1 myPig = new Pig(); // Create a Pig object
        Animal1 myDog = new Dog1(); // Create a Dog object

        //myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound();

        System.out.println();
        System.out.println();

        //Abstract class
        Pig myPig1 = new Pig(); // Create a Pig object
        myPig1.animalSound();
        myPig1.sleep();

        System.out.println();
        System.out.println();

        //Interface
        Pig2 myPig2 = new Pig2(); // Create a Pig object
        myPig2.animalSound();
        myPig2.sleep();

    }
}