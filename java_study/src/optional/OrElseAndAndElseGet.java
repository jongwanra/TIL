package optional;

import java.util.Optional;

public class OrElseAndAndElseGet {
	public static void main(String[] args) {
		OrElseAndAndElseGet main = new OrElseAndAndElseGet();
		String username = "myName";
		String result1 = Optional.ofNullable(username).orElse(main.getDefaultName("result1 name"));
		// System.out.println("result1 = " + result1);
		
		String result2 = Optional.ofNullable(username).orElseGet(() -> main.getDefaultName("result2 name"));
		// System.out.println("result2 = " + result2);
		
	}
	
	private String getDefaultName(String name) {
		System.out.print("호출된 이름: ");
		System.out.println("name = " + name);
		return name;
	}
}
