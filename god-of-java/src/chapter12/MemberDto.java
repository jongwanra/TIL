package chapter12;

import java.util.Objects;

public class MemberDto {
    public String name;
    public String phone;
    public String email;


    public MemberDto(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        // 주소가 동일하면 true
        if (this == o) return true;

        // class가 다르면 false
        if (o == null || getClass() != o.getClass()) return false;

        MemberDto memberDto = (MemberDto) o;
        return Objects.equals(name, memberDto.name) && Objects.equals(phone, memberDto.phone) && Objects.equals(email, memberDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, email);
    }
}
