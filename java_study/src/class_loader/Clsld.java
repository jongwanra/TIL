package class_loader;

public class Clsld {
	public static void main(String[] args) {
		String clInfo = null;
		ClassLoader cls = null;
		cls = Thread.currentThread().getContextClassLoader();
		
		while (cls != null) {
			clInfo = cls.toString();
			System.out.println("###" + clInfo);
			cls = cls.getParent();
		}
	}
}
