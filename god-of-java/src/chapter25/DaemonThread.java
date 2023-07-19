package chapter25;

public class DaemonThread extends Thread{
    @Override
    public void run() {
       try{
           Thread.sleep(Long.MAX_VALUE);
       }catch (Exception e) {
           e.printStackTrace();
       }
    }
}
