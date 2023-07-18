package chapter22;

import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        StackSample sample = new StackSample();
        sample.checkPeek();
    }

    private void checkPeek() {
        Stack<Integer> intStack = new Stack<Integer>();
        for(int loop = 0; loop < 5; loop++) {
            intStack.push(loop);
            System.out.println("peek : " + intStack.peek());
        }

        System.out.println("intStack = " + intStack);
    }
}
