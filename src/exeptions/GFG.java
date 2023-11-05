package exeptions;

import javax.crypto.NullCipher;

//package Exeptions;

public class GFG {

	public static void main(String[] args) {
		String s = null;

		try {
			if (s.equals(s)) {
				System.out.println("same");
			} else {
				System.out.println("is not same");
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
