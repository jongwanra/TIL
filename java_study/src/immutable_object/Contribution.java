package immutable_object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Contribution {
    private final int amount;
    private final List<String> sponsers = new ArrayList<>();

    private Contribution(final int amount) {

        this.amount = amount;
    }
    public static Contribution valueOf(final int amount) {
        return new Contribution(amount);
    }

    public Contribution donate() {
        return new Contribution(amount + 1);
    }
    public int getTotal() {
        return amount;
    }


    // 방어적 복사
    public List<String> getSponsers() {
        return Collections.unmodifiableList(sponsers);
    }
}
