package enum_class;

public enum Rank {
    THREE(3, 4_000),
    FOUR(4, 10_000),
    FIVE(5, 30_000);

    private final int match;
    private final int money;
    private int count;

    // Default 생성자는 Private로 설정되어 있다?!
    Rank(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public void plustCount() {
        this.count++;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }
}
