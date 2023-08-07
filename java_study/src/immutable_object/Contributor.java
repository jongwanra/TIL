package immutable_object;

public class Contributor  extends Thread{
    private String myName;

    public Contributor(String myName) {
        this.myName = myName;
    }
    @Override
    public void run() {
        super.run();
        for(int i = 1; i <= 1000; i++) {
//            Contribution.donate();
        }
        System.out.println("myName: " + myName + " donate: " + " total: " );

    }
}
