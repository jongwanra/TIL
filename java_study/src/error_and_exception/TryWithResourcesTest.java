package error_and_exception;

import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesTest {
	public static void main(String[] args) {
		TryWithResourcesTest t = new TryWithResourcesTest();
		t.checkTryWithResources();
	}
	
	private void checkTryCatchFinally() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("data.txt");
			fw.write("Hello");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void checkTryWithResources() {
		try (FileWriter fw = new FileWriter("data.txt")) {
			fw.write("Hello");
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
}
