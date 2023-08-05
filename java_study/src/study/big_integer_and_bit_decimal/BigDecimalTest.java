package study.big_integer_and_bit_decimal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal val = new BigDecimal("12345.123456789012345678901234567890123");
        System.out.println("val.unscaledValue() = " + val.unscaledValue());
        System.out.println("val.scale() = " + val.scale());
        System.out.println("val.precision() = " + val.precision());
        System.out.println("BigDecimal.valueOf(123.45) = " + BigDecimal.valueOf(123.45));
        

    }
}
