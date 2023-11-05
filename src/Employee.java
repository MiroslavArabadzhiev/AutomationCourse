public class Employee {
    private String firstName = null;
    private String lastName = null;
    private int birthYear = 0;

    public Employee() {
        System.out.println("New employee object created!");
    }

    public Employee(String firstName) {
        this.firstName = firstName;
    }

    public Employee(String firstName, String lastName) {
        this(firstName, lastName, 1995);
//      this.firstName = firstName;
//      this.lastName = lastName;

    }

    public Employee(String first, String last, int year) {
        firstName = first;
        lastName = last;
        birthYear = year;
    }



}
