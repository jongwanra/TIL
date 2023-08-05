package study.string_buffer_and_string_builder;

import java.util.GregorianCalendar;

public class TestString {
    public static void main(String[] args) {
        System.gc();
        long start=new GregorianCalendar().getTimeInMillis();
        long startMemory=Runtime.getRuntime().freeMemory();
//        StringBuffer sb = new StringBuffer(); // 2529
        StringBuilder sb = new StringBuilder(); // 2115
        for(int i = 0; i<100_000_000; i++){
            sb.append(":").append(i);
        }
        long end=new GregorianCalendar().getTimeInMillis();
        long endMemory=Runtime.getRuntime().freeMemory();
        System.out.println("Time Taken:"+(end-start));
        System.out.println("Memory used:"+(startMemory-endMemory));
    }
}
