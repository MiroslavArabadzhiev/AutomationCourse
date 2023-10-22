// Exercise with a Scanner

import java.io.InputStream;

public class Scanner {
    public Scanner(InputStream in) {
    }

    public static void main(String[] args) {

        java.util.Scanner myObj = new java.util.Scanner(System.in);
        System.out.println("Enter username: ");

        String userName = myObj.nextLine();
        System.out.println("Username is: " + userName);
    }
}