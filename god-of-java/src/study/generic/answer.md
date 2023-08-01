# Generic Question

## Generic이란?

내부 클래스의 타입을 가상의 타입으로 지정해 두고, 외부에서 사용자의 지정에 의해 타입이 정해지는 것.

## Generic이 자바에 추가된 이유는 무엇일까?

형변환의 문제점을 사전에 없애기 위해서 추가되었다.
여기서 말하는 '사전에'는 런타임 시가 아닌 컴파일 시를 말한다.
Generic이 Java5에 추가되기 이전에는 최상위 부모 클래스인 Object를 내부 클래스의 타입으로 설정했었다.

```java
class ResponseDto {
    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

public class Main {
    public static void main(String[] args) {
        ResponseDto dto1 = new ResponseDto();
        dto1.setResult(new String());
        ResponseDto dto2 = new ResponseDto();
        dto2.setResult(new StringBuilder());
        ResponseDto dto3 = new ResponseDto();
        dto3.setResult(new StringBuffer());
    }
}
```

위의 코드 예시와 같이 생성해서 값을 넣는 것에는 문제가 없었다. 하지만, 문제는 값을 가져올 때 발생한다.

```java

class ResponseDto {
    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

public class Main {
    public static void main(String[] args) {
        ResponseDto dto1 = new ResponseDto();
        dto1.setResult(new String());
        ResponseDto dto2 = new ResponseDto();
        dto2.setResult(new StringBuilder());
        ResponseDto dto3 = new ResponseDto();
        dto3.setResult(new StringBuffer());

        // 위와 같이 정보를 가져오게 되면 타입이 Object를 지정해서 반환이 되다보니, 형변환을 해줘야 한다.
        // Object result = dto1.getResult();
        String result = (String) dto1.getResult();
        StringBuilder result = (String) dto2.getResult();
        StringBuffer result = (String) dto3.getResult();
    }
}
```

이렇게 계속 형변환을 해주면 되지 않을까 생각할 수 있다.
형변환을 시도하게 되면 3개 정도의 데이터는 문제가 없겠지만, 데이터가 10만개 이상으로 갈 경우에는, 적지 않은 비용이 소모가 될 것이다.
뿐만 아니라, 형변환을 하게 된 데이터는 안정성을 보장할 수가 없다.
나의 실수로 인해서 String으로 형변환이 필요했던 객체를 StringBuilder로 적용했을 때, Compile이후, RunTime 시, 해당 에러를 마주하게 될 것이다.

위의 형변환의 문제점을 사전에 없애기 위해서 Generic이 생기게 되었다.

## Generic을 사용헸을 때 장점이 뭘까?

Generic을 사용 했을 때,
첫 번째, 안정성이 보장된다는 것이다. Generic으로 선언된 타입은 컴파일 시에 에러를 내뱉는다.
두 번째, 따로 형변환을 해주지 않아도 된다. 

상단에 ResponseDto Class를 Generic Type으로 변경해 보자. 그리고 main method안에서 가져와 보자.

```java
class ResponseDto<T> {
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

public class Main {
    public static void main(String[] args) {
        ResponseDto<String> dto1 = new ResponseDto<String>();
        dto1.setResult(new String());
        ResponseDto<StringBuilder> dto2 = new ResponseDto<StringBuilder>();
        dto2.setResult(new StringBuilder());
        ResponseDto<StringBuffer> dto3 = new ResponseDto<StringBuffer>();
        dto3.setResult(new StringBuffer());

        // 객체를 가져와 보자.
        String result = dto1.getResult();
        StringBuilder result1 = dto2.getResult();
        StringBuffer result2 = dto3.getResult();
    }
}
```

이렇게 형변환을 하지 않아도 data를 가져올 때, 기존에 생성되었던 타입으로 가져와 진다.

## 제네릭 선언시 wildcard라는 것을 선언했을 때 어떤 제약 사항이 있을까?
..?

## 메소드를 제네릭하게 선언하려면 리턴 타입 앞에 어떤 것을 추가해 주면 될까?
return type앞에 <T> 와 같이 작성해 주면 된다.

## 자바에서 정의한 Generic 타입의 명명 규칙을 적어보자.

T: Type의 약자
E: Element의 약자 (Collection에서 많이 사용됨)
V: 값의 약자
K: Key의 약자
N: Number의 약자
S, U, V: 각각 두번째, 세번째, 네번째 타입의 약자

## Generic에 ? 의 의미가 무엇인가?
* 알 수 없는 타입이라는 의미로, wildcard type으로 불린다. 

## wildcard type은 왜 method에서 parameter로 전달하는 경우에만 사용하는게 좋을까?
선언 시에 wildcard type에 <?>를 사용하면 해당 type에 대해서 알 수 없기 때문에, 상태값을 변경하는 것이 불가능하다. 
따라서 선언 시에 사용하는 것이 아닌 parameter로 전달하는 경우에만 사용하는 것이 좋다.

## Reference

* 자바의 신(이상민 저)