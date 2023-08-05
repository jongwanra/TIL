package study.reflection;

public class Test {
    private String c = "c";
    private String d = "d";
    private String e = "e";

    public Test(){

    }

    public Test(String c, String d, String e) {
        this.c = c;
        this.d = d;
        this.e = e;
    }

    @Override
    public String toString() {
        return "Test{" +
                "c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", e='" + e + '\'' +
                '}';
    }

}
