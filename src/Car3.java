public class Car3 extends Vehicle3{
    private int numberOfDoors;
    private boolean doorClosed = true;
    Car3(String brand, String model, double length, double width, double weight, int numberOfDoors) {
        super(brand, model, length, width, weight);
        this.numberOfDoors = numberOfDoors;
    }
    public void closeOpenDoor() {
        this.doorClosed = !doorClosed;
        if(this.doorClosed) {
            System.out.println("The door is closed");
        } else {
            System.out.println("The door is opened");
        }
    }
}