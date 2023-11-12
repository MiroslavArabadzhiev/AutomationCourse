package Lecture9_Practice;

public class Exercises {

    public static void main(String[] args) {

        //Person object
        Person Miro = new Person("Miroslav Arabadzhiev","Male", "Catholic",
                "Bulgarian","Manual QA", "Bulgarian",
                9502095152L,"Bulgaria");

        Miro.celebrateEaster();
        Miro.canTakeLoan();
        Miro.setCountry("Brazil");
        System.out.println(Miro.getCountry());


        Bulgarian bulgarian = new Bulgarian("Ivan Tachev","Male", "Orthodox",
                "Bulgarian","Programmer", "Bulgarian",
                9509014142L,"Bulgaria");

        bulgarian.sayHello();
        bulgarian.danceHoro();
        System.out.println(bulgarian.getCountry());
        System.out.println(bulgarian.isAdult());

    }
}
