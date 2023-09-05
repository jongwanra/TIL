package error_and_exception;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesTest implements Closeable {
	public static void main(String[] args) {
		try (TryWithResourcesTest t = new TryWithResourcesTest()) {
			t.checkTryWithResources();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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
	
	@Override
	public void close() throws IOException {
		System.out.println("call close() method");
	}
}
