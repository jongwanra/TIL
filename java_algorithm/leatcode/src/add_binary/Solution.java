package add_binary;
import java.util.*;
public class Solution {
    public String addBinary(String a, String b) {
        LinkedList<Character> stackA = new LinkedList<>();
        LinkedList<Character> stackB = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(char x: a.toCharArray()) stackA.push(x);
        for(char x: b.toCharArray()) stackB.push(x);

        int carry = 0;
        while(!stackA.isEmpty() && !stackB.isEmpty()) {
            int tmpA = stackA.pop() - '0';
            int tmpB = stackB.pop() - '0';
            int sum = tmpA + tmpB + carry;

            carry = sum / 2;
            sb.append(sum % 2);
        }

        while(!stackA.isEmpty()) {
            int tmpA = stackA.pop() - '0';
            int sum = tmpA + carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }

        while(!stackB.isEmpty()) {
            int tmpB = stackB.pop() - '0';
            int sum = tmpB + carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }

        if(carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();

    }
}
