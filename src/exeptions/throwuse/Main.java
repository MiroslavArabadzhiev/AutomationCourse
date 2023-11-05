package exeptions.throwuse;

import java.io.*;

class Main {
	public String loader(String FilePath) {
		// initialize the reader with null
		BufferedReader br = null;
		String str = null;
		StringBuilder strb = new StringBuilder();
		try {
			// really initialize it inside the try block
			br = new BufferedReader(new FileReader(FilePath));
			while ((str = br.readLine()) != null) {
				strb.append(str).append("\n");
			}
		} catch (FileNotFoundException f) {
			System.out.println(FilePath + " does not exist");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// this block will be executed in every case, success or caught exception
			if (br != null) {
				// again, a resource is involved, so try-catch another time
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return strb.toString();
	}

	public static void main(String[] args) {
		FileReader file = null;
		BufferedReader fileInput = null;
		try {
			file = new FileReader("C:\\test\\a.txt");
			fileInput = new BufferedReader(file);

			// Print first 3 lines of file "C:\test\a.txt"
			for (int counter = 0; counter < 3; counter++)
				System.out.println(fileInput.readLine());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (fileInput != null) {
				System.out.println("Closing PrintWriter");
				try {
					fileInput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("PrintWriter not open");
			}
		}

	}
}
