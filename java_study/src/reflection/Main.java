package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


// 이렇게 reflection Api를 사용할 수 있는 이유는
// 실행시 JVM 내부적으로 ClassLoader가 존재하는데 ClassLoader가 Loading을 완료했을 때, 해당 클래스의 정보를 담은 클래스 객체를 생성해 힙 영역에 저장하기 때문에 접근이 가능하다.
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Test test = new Test();
        final Class<? extends Test> getClassTest = test.getClass();

        // 생성자를 가져와 보자
        Arrays.stream(getClassTest.getConstructors()).forEach(System.out::println);

        // 생성자를 리플렉션으로 가져와서 객체 생성하기
        final Constructor<? extends Test> constructor = getClassTest.getConstructor(null);
        final Test test1 = constructor.newInstance();
        System.out.println("test1 = " + test1);

        final Constructor<? extends Test> stringConstructor = getClassTest.getConstructor(String.class, String.class, String.class);

        final Test test2 = stringConstructor.newInstance("1", "111", "1111");
        System.out.println("test2 = " + test2);


    }
}
