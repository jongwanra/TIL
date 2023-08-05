package study.equals_and_hashcode;

import java.util.HashMap;
import java.util.Map;

class DataKey {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DataKey [name=" + name + ", id=" + id + "]";
    }

}

public class HashingTest {

        public static void main(String[] args) {
            Map<DataKey, Integer> hm = getAllData();
            DataKey dk = new DataKey();
            dk.setId(1);
            dk.setName("Pankaj");
            System.out.println("check HashCode in Main Method: " + dk.hashCode());

            Integer value = hm.get(dk);

            System.out.println(value);

        }

        private static Map<DataKey, Integer> getAllData() {
            Map<DataKey, Integer> hm = new HashMap<>();

            DataKey dk = new DataKey();
            dk.setId(1);
            dk.setName("Pankaj");

            hm.put(dk, 10);

            return hm;


    }
}
