package Homeworks.Lecture8_HW;

public class HW2 {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Stefan", "Petrov", 20);
        String name = employee.getName();
        double annualSalary = employee.getAnnualSalary();
        System.out.println(employee);

        double raisedSalary = employee.raiseSalary(-10);
        annualSalary = employee.getAnnualSalary();
        System.out.println(employee);
    }
}
