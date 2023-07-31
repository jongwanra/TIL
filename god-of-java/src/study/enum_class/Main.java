package study.enum_class;

public class Main {
    public static void main(String[] args) {
        System.out.println(Rank.FIVE.getMoney());
        System.out.println(Rank.THREE.getMatch());

//        Rank[] values = Rank.values();
//        for(Rank x: values) {
//            System.out.print(x + " ");
//        }

        System.out.println(Rank.FOUR);

        System.out.println(OverTimeValues.WEEKEND_FOUR_HOUR.name());
        System.out.println(OverTimeValues.WEEKEND_FOUR_HOUR);


    }
}
