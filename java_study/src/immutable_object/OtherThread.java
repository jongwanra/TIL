package immutable_object;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OtherThread  extends Thread{
    @Override
    public void run() {
        super.run();

        new BigInteger("111");
        new StringBuilder("11");

        System.out.println("start!!");
    }
}
