package chapter23;

import java.util.HashSet;
import java.util.Random;
public class RandomNumberMaker {
    public static void main(String[] args) {
        RandomNumberMaker maker = new RandomNumberMaker();
        for(int loop = 1; loop <= 10; loop++) {
            HashSet<Integer> sixNumber = maker.getSixNumber();
            maker.printHashSet(sixNumber);
        }
    }

    public HashSet<Integer> getSixNumber() {

        Random random = new Random();
        HashSet<Integer> randomSet = new HashSet<>();

        do {
            randomSet.add(random.nextInt(45));
        }while (randomSet.size() < 6);

        return randomSet;
    }

    private <E> void printHashSet(HashSet<E> hashSet) {
        System.out.println(hashSet);
    }
}
