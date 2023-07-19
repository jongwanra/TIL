package chapter25;

public class EndlessThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try{
                System.out.println(System.currentTimeMillis());
                Thread.sleep(1000);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
