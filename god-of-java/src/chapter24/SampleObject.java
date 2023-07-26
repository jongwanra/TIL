package chapter24;

import java.util.Objects;

public class SampleObject {
    private String name;
    private int age;
    private String favoriteColor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleObject that = (SampleObject) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(favoriteColor, that.favoriteColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, favoriteColor);
    }
}
