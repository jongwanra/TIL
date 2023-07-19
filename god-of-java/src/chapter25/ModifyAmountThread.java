package chapter25;

public class ModifyAmountThread extends Thread {
    private CommonCalculate calc;
    private boolean addFlag;

    public ModifyAmountThread(CommonCalculate calc, boolean addFlag) {
        this.calc =calc;
        this.addFlag =addFlag;
    }

    @Override
    public void run() {
        for(int loop=0; loop < 10000; loop++ ){
            if(addFlag) {
//                System.out.println(this.getName() + " / " + loop);
                calc.plus(1);
            }else {
                calc.minus(1);
            }
        }
        System.out.println("thread exit" + this.getName());
    }
}
