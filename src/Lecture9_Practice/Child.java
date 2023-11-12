package Lecture9_Practice;

public class Child extends Person {
    public Child(String name, String sex, String religion, String language, String hasJob, String nationality, long EGN, String country) {
        super(name, sex, religion, language, hasJob, nationality, EGN, country);
    }

    @Override
    public void sayHello() {
        System.out.println("");
    }

    @Override
    public void setHasJob(String hasJob) {
        throw new IllegalArgumentException("I do not have a job!");
    }

    @Override
    public boolean canTakeLoan() {
        System.out.println("Can take money only from my parents!");
        return false;
    }
}
