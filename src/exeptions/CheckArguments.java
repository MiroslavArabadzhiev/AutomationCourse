package exeptions;

public class CheckArguments {
	public static void main(String[] args) {
		// String s set an empty string and calling getLength()
		String s = "";
		try {
			System.out.println(getLength(s));
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException caught");
		}

		// String s set to a value and calling getLength()
		s = "testing arguments";
		try {
			System.out.println(getLength(s));
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException caught");
		}

		// Setting s as null and calling getLength()
		s = null;
		try {
			System.out.println(getLength(s));
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException caught");
			System.out.println(e.getMessage());
		}
	}

	// Function to return length of string s. It throws
	// IllegalArgumentException if s is null.
	public static int getLength(String s) {
		if (s == null)
			throw new IllegalArgumentException("The argument cannot be null");
		return s.length();
	}
}
