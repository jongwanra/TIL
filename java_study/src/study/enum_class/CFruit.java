package study.enum_class;

class CFruitObj {
    int price;
    String color;

    public CFruitObj(int price, String color) {
        this.price = price;
        this.color = color;
    }
}

public class CFruit {
    public static final CFruitObj APPLE = new CFruitObj(3000, "RED");
    public static final CFruitObj ORANGE = new CFruitObj(2000, "ORANGE");
    public static final CFruitObj BANANA = new CFruitObj(3000, "YELLOW");

}
