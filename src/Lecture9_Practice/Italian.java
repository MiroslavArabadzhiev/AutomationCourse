package Lecture9_Practice;

public class Italian extends Person{
    public Italian(String name, String sex, String religion, String language, String hasJob, String nationality, long EGN, String country) {
        super(name, sex, religion, language, hasJob, nationality, EGN, country);
    }

    @Override
    public void sayHello() {
        System.out.println("Ciao!");
    }

    public static void makePizza(){
        System.out.println("I am making the best pizza in the world!");
    }

}
