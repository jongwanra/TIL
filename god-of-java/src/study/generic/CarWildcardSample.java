package study.generic;

public class CarWildcardSample {
    public static void main(String[] args) {
        CarWildcardSample sample = new CarWildcardSample();
        sample.callBoundedWildcardMethod();
    }

    private void callBoundedWildcardMethod() {
        WildCardGeneric<Car> wildcard = new WildCardGeneric<>();
        WildCardGeneric<Bus> busWildCard = new WildCardGeneric<>();
        wildcard.setWildCard(new Car("Mustang"));
        busWildCard.setWildCard(new Bus("BusCard"));
        boundedWildcardMethod(wildcard);
        boundedWildcardMethod(busWildCard);

    }

    private void boundedWildcardMethod(WildCardGeneric<? extends Car> c) {
        Car value = c.getWildCard();
        System.out.println("value = " + value);
    }
}
