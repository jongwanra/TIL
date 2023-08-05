package generic;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//public class Chooser {
//    private  final Object[] choiceArray;
//
//    public Chooser(Collection choices) {
//        this.choiceArray = choices.toArray();
//    }
//    public Object choose() {
//        Random rnd = ThreadLocalRandom.current();
//        System.out.println("rnd = " + rnd);
//        return choiceArray[rnd.nextInt(choiceArray.length)];
//    }
//}


public class Chooser<T> {
    private final List<T> choiceList;

    public Chooser(Collection<T> choices) {
        this.choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        System.out.println("rnd = " + rnd);
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        Chooser<Integer> sample = new Chooser<>(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(sample.choose());

    }
}
