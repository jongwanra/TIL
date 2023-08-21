package reflection;

import jdk.jfr.Label;

@Label("1232132")
public class Test {
	
	@Label("private String a !!")
	private String a;
	private String b;
	private String c;
	
	public Test() {
	
	}
	
	public Test(String a, String b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public String toString() {
		return "Test{" +
			"a='" + a + '\'' +
			", b='" + b + '\'' +
			", c='" + c + '\'' +
			'}';
	}
}
