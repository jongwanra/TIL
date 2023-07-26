package study.equals_and_hashcode;

import java.util.Objects;

public class Team {
    String city;
    String department;

    public Team(String city, String department) {
        this.city = city;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(city, team.city) && Objects.equals(department, team.department);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(city, department);
//    }
}
