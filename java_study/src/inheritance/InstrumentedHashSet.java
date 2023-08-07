package inheritance;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet() {

    }

//    @Override
//    public boolean add(E e) {
//        System.out.println("add method: " + addCount);
//        addCount++;
//        return super.add(e);
//    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        System.out.println("addAll");
        System.out.println(addCount);
        addCount += c.size();
        System.out.println(addCount);
        boolean b = super.addAll(c);
        System.out.println(addCount);
        return b;
    }

    public int getAddCount() {
        return addCount;
    }
}
