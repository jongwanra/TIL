package java8_updated;

import java.time.Clock;
import java.time.LocalDateTime;

public class TimeTest {
	public static void main(String[] args) {
		LocalDateTime min = LocalDateTime.MIN;
		LocalDateTime max = LocalDateTime.MAX;
		
		System.out.println("min = " + min);
		System.out.println("max = " + max);
		System.out.println(LocalDateTime.now(Clock.systemUTC()));
	}
}
