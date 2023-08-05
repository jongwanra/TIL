package singleton;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {

    }
    public static Elvis getInstance() {
        return INSTANCE;
    }
    // 싱글턴임을 보장해주는 readResolve 메서드
    private Object readResolve() {
        // 진짜 Elvis를 반환하고, 가짜 Elvis는 가비지 컬렉터에 맡긴다.
        return INSTANCE;
    }
    public void leaveTheBuilding() {}
}
