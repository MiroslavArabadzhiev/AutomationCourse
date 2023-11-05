import java.io.*;
import java.rmi.RemoteException;

public class ConstructorsAndExceptions {

    public static void main(String[] args) throws IOException {

        //Employee employee = new Employee();

        //Employee employee1 = new Employee("Miro");

        Employee employee2 = new Employee("Miro", "Arabadzhiev");

        //Employee employee3 = new Employee("Miro", "Arabadzhiev", 1995);

        //testUncheckedException();
        //testTryCatch("src/testFile1.txt");
        //tryMultipleCatch(99,0);
        //tryMultipleCatch2(99,0);
        //changeException(99,0);
        //testFinally("src/testFile.txt");
        testFinally("src/testFile1.txt");
    }

    static void testCheckedException () throws FileNotFoundException {
        File file = new File("src/testFile.txt");
        FileReader fr = new FileReader(file);
    }

    static void testUncheckedException (){
        int num[] = {1, 2, 3, 4};
        System.out.println(num[5]);
    }

    static void testTryCatch(String path) {
        File file = new File(path);

        try {
            FileReader fr = new FileReader(file);
        }
        catch (FileNotFoundException e){
            System.out.println("The filepath is wrong!");
        }
    }


    static void tryMultipleCatch(int number, int factor){
        try {
            if (number % factor == 0) {
                System.out.println(factor + " is factor of " + number);
            }
        }
        catch (ArithmeticException e){
            System.out.println("Arithmetic " + e);
        }
        catch (NumberFormatException e){
            System.out.println("Number " + e);
        }
    }

    static void tryMultipleCatch2(int number, int factor){
        try {
            if (number % factor == 0) {
                System.out.println(factor + " is factor of " + number);
            }
        }
        catch (ArithmeticException | NumberFormatException e){
            System.out.println("Exception encountered " + e);
        }

    }

    static void tryMultipleCatch3(int number, int factor) throws NoSuchMethodException {
        try {
            if (number % factor == 0) {
                System.out.println(factor + " is factor of " + number);
            }
        } catch (ArithmeticException | NumberFormatException e) {
            throw new NoSuchMethodException();
        }
    }

    static void changeException(int number, int factor) {
        try {
            if (number % factor == 0) {
                System.out.println(factor + " is factor of " + number);
            }
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Incorrect input!");
        }
    }

    static void testFinally (String path) throws IOException {
        FileInputStream fis = null;
        BufferedReader in = null;

        try {
            fis = new FileInputStream(path);
            in = new BufferedReader(new InputStreamReader(fis));
            String temp;
            while ((temp = in.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                in.close();
            }
            if (fis != null){
                fis.close();
            }
        }
    }


}