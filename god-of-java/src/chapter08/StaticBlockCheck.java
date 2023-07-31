package chapter08;

public class StaticBlockCheck {
    public static void main(String[] args) {
        StaticBlockCheck check = new StaticBlockCheck();
        check.makeStaticBlockObjectWithData();
    }

    private void makeStaticBlockObjectWithData() {
        System.out.println("data="+ StaticBlock.getData());
        StaticBlock block1 = new StaticBlock();
        block1.data =1;

        System.out.println("-------");
        StaticBlock block2 = new StaticBlock();
        block2.data = 2;
        System.out.println("data="+ StaticBlock.getData());
    }


    // *** First ---
    // *** Secind ====
    // data=5
    // ------
    // data = 2
}
