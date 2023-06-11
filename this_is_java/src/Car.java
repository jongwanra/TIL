public class Car {

    // 고유 데이터
    String company;
    String model;
    String color;
    int maxSpeed;

    // 상태 데이터
    int speed;


    public static Car createCar(String company, String model, String color) {
        Car car = new Car();
        car.company = company;
        car.model = model;
        car.color= color;

        return car;
    }

    @Override
    public String toString() {
        return "Car{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", speed=" + speed +
                '}';
    }

    private Car(){}
}
