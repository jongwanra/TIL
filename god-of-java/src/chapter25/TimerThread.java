package chapter25;

import java.util.Date;

public class TimerThread extends Thread {
    @Override
    public void run() {
        Date date = new Date();
        int count = 0;
        while (count < 10) {
            printCurrentTime(date);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }

    }

    private void printCurrentTime(Date date) {
        long currentTimeMills = System.currentTimeMillis();
        long l =  currentTimeMills % 1000;
        if (l >= 500) {
            currentTimeMills = currentTimeMills / 1000 * 1000;
        }else {
            currentTimeMills = (currentTimeMills / 1000+ 1) * 1000;
        }
        System.out.println("l = " + l);


        System.out.println(date.toString()  + " " + currentTimeMills);

    }
}
