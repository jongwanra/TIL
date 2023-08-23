package big_integer_and_big_decimal;

import java.math.BigInteger;

public class BigIntegerTest {
	public static void main(String[] args) {
		BigInteger bigInteger = BigInteger.ONE;
		System.out.println("bigInteger = " + bigInteger);
		
		BigInteger add = bigInteger.add(BigInteger.TEN);
		
		System.out.println("bigInteger = " + add);
	}
}
