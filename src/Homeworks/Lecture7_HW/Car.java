package Homeworks.Lecture7_HW;

public class Car {

    private String name = "N/A";
    private String colour = "N/A";
    private int releaseYear = -1;
    private int hoursePower = -1;
    private Boolean secondHand = false;

    public Car(String name, String colour, int releaseYear, int hoursePower, Boolean secondHand) {
        this.name = name;
        this.colour = colour;
        this.releaseYear = releaseYear;
        this.hoursePower = hoursePower;
        this.secondHand = secondHand;
    }

    public Car(String name, String colour, Boolean secondHand) {
        this.name = name;
        this.colour = colour;
        this.secondHand = secondHand;
    }

    public Car(String name, String colour, int releaseYear, int hoursePower) {
        this.name = name;
        this.colour = colour;
        this.releaseYear = releaseYear;
        this.hoursePower = hoursePower;
    }

    public Car(String name, int releaseYear, int hoursePower, Boolean secondHand) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.hoursePower = hoursePower;
        this.secondHand = secondHand;
    }

    public Car() {
    }
}
