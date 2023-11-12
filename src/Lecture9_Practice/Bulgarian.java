package Lecture9_Practice;

public class Bulgarian extends Person{

    public Bulgarian(String name, String sex, String religion, String language, String hasJob, String nationality, long EGN, String country) {
        super(name, sex, religion, language, hasJob, nationality, EGN, country);
    }

    @Override
    public void sayHello() {
        System.out.println("Здравей!");
    }

    public void danceHoro(){
        System.out.println("Айде на хорото!");
    }

}
