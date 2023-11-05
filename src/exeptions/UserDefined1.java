package exeptions;

//Test1 Class that uses above MyException 
public class UserDefined1 {
	// Driver Program
	public static void main(String args[]) {
		try {
			// Throw an object of user defined exception
			throw new MyException("Testing User defined exceptions");
		} catch (MyException ex) {
			System.out.println("Caught");

			// Print the message from MyException object
			System.out.println(ex.getMessage());
		}
	}
}
