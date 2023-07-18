package chapter23;

import java.util.HashSet;
import java.util.Iterator;

public class SetSample {
    public static void main(String[] args) {
        SetSample sample = new SetSample();
        String[] cars = {
            "Tico", "Sonata", "BMW", "Benz", "Lexus", "Mustang", "Grandeure", "The Beetle", "Mini Cooper", "i30", "BMW",
            "Lexus", "Carnibal", "SM5", "SM7", "SM3", "Tico"
        };

        System.out.println("cars.length:" + cars.length);
        System.out.println(sample.getCarKinds(cars));

    }

    private void printHashSet(HashSet<String> hashSet) {
        for(String car: hashSet ) {
            System.out.print(car + " ");
        }
        System.out.println();
    }

    private void printHashSet2(HashSet<String> hashSet) {
        Iterator<String> iterator = hashSet.iterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    private int getCarKinds(String[] cars) {
        if(cars == null) {
            return 0;
        }
        if(cars.length == 1) {
            return 1;
        }

        HashSet<String> hashSet = new HashSet<>();
        for(String car: cars) {
            hashSet.add(car);
        }

        this.printHashSet2(hashSet);


        System.out.println("hashSet = " + hashSet);
        return hashSet.size();
    }
}
