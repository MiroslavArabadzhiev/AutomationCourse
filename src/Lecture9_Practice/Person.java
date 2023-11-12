package Lecture9_Practice;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import static java.time.LocalDate.now;

public class Person {

    private String name;
    private String sex;
    private String religion;
    private String language;
    private String hasJob;
    private String nationality;
    private long EGN;
    private String birthDate;
    private int age;
    private String country;

    public Person(String name, String sex, String religion, String language, String hasJob, String nationality, long EGN, String country) {
        this.name = name;
        setSex(sex);
        this.religion = religion;
        this.language = language;
        this.hasJob = hasJob;
        this.nationality = nationality;
        setEGN(EGN);
        setBirthDate(EGN);
        setAge(EGN);
        this.country = country;
    }

    private void setAge(Long EGN){
        String engString = Long.toString(EGN);
        String year = engString.substring(0,2);
        String birthYear = "19" + year;
        int currentYear = LocalDate.now().getYear();
        int currentAge = currentYear - Integer.parseInt(birthYear);
        this.age = currentAge;
    }

    private void setBirthDate(Long EGN){
        String engNewString = Long.toString(EGN);
        String month = engNewString.substring(2,4);
        String day = engNewString.substring(4,6);
        this.birthDate = month + " " + day;
    }

    public void setEGN(long EGN) {
        String size = Long.toString(EGN);
        if (size.length() == 10) {
            this.EGN = EGN;
        }
        else {
            throw new RuntimeException("EGN is not valid! Please provide 10 digits!");
        }
    }

    public void setSex(String sex) {
        try {
            validateSex(sex);
            this.sex = sex;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateSex(String sex) throws Exception {
        if (!sex.equalsIgnoreCase("Male") && !sex.equalsIgnoreCase("Female")) {
            throw new Exception("Please provide valid value for sex");
        }
    }

    public void setHasJob(String hasJob) {
        this.hasJob = hasJob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void sayHello() {
        System.out.println("Hello");
    }
    public void celebrateEaster() {
        if(religion.equalsIgnoreCase("orthodox") || religion.equalsIgnoreCase("catholic")){
            System.out.println("I am celebrating Easter!");
        }
        else {
            System.out.println("I am not celebrating Easter!");
        }
    }
    public boolean isAdult() {
        switch (country){
            case "Bulgaria", "Italy":
                return age >= 18;
            case "USA":
                return age >= 21;
            default:
                throw new RuntimeException("We don't have information about this country: " + country);
        }
    }
    public boolean canTakeLoan() {
        return !hasJob.isEmpty();
    }

}