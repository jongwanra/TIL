# Enum

* Enum에 대해서 들어가면 들어갈 수록, 깊은 내용이구나 하는 생각이 절로 든다.
* Enum을 이해하려면 class, static, singleton, 등 다양한 부분에 대해서 익히고 있어야 한다는 생각이 많이 들었다.

## Enum이란?(23.08.25)
Enum이란, 상수의 집합으로 일종의 클래스이다.
Enum은 굉장히 장점들이 많다.

대표적으로 3가지를 말해보면 
1. 타입의 안전성을 보장한다. Enum Class를 파라미터로 넘길 때 Enum Class가 아닌 타입이 들어온다면 컴파일 시에 에러를 발생시킨다. 그렇기 때문에 타입의 안정성을 보장한다.
2. Enum은 Class이다. 그렇기 때문에 Field, Interface, Method등을 구현할 수 있다.
3. Enum타입은 완전한 싱글턴이다. Class Loader의 초기화 시점에 생성이 되고 프로그램이 종료될 때까지 공유 자원으로써 어디서든 사용이 가능하다. 또한 불변하기 때문에 Thread Safe하다.

[Java Enum 활용기](https://techblog.woowahan.com/2527/) 글을 통해 많은 생각이 들게 되었다. Enum은 Class이기 때문에 다른 언어의 Enum Type에 비해 더 많은 장점을 가져갈 수 있는데,
1. 데이터들의 연관관계를 표현할 수 있다.
2. 데이터들의 상태와 행위를 한 곳에서 관리할 수 있다.
3. 데이터들을 그룹화해서 관리할 수 있다. 

글을 참조해서 봤을 때 내가 실무에서 활용했다면 어떨까 생각해봤다. 이커머스 플랫폼에선 당연하게도 결제 및 정산이 정말 중요하고 그 중에 은행, 카드사 관련된 데이터들을 많이 다룰 것이다. 그렇다면 이 데이터를 한 곳에서 그룹화해서 관리한다면
얼마나 좋을까?

[카드사 코드](https://docs.tosspayments.com/reference/codes)를 가져와서 한 번 Enum Class로 만들어 보았다.

```java
public enum Bank {
	IBK_BC("3K", "기업비씨", "IBK_BC"),
	GWANGJUBANK("46", "광주", "GWANGJUBANK"),
	LOTTE("71", "롯데", "LOTTE"),
	KDBBANK("30", "산업", "KDBBANK"),
	BC("31", "-", "BC"),
	SAMSUNG("51", "삼성", "SAMSUNG");
	// ...
  
	private String bankCode;
	private String bankNameWithKR;
	private String bankNameWithEN;
	
	Bank(String bankCode, String bankNameWithKR, String bankNameWithEN) {
		this.bankCode = bankCode;
		this.bankNameWithKR = bankNameWithKR;
		this.bankNameWithEN = bankNameWithEN;
	}
	
	public String getBankCode() {
		return bankCode;
	}
	
	public String getBankNameWithKR() {
		return bankNameWithKR;
	}
	
	public String getBankNameWithEN() {
		return bankNameWithEN;
	}
}

```


이렇게 은행/카드사와 관련된 내용을 한곳에서 관리한다는 것은 역할과 책임 측면에서도 중요하고, 따로 수정 및 추가가 필요할 때 해당 Class만을 보면 되니 유지보수에도 엄청난 장점이다.
아직 명확하지는(?) 않지만, 이런식으로 관리한다면 DB Table내에서 따로 은행 타입만을 저장하더라도 문제가 없지 않을까? 생각이 드는데 더 고민해보고 답을 찾아봐야겠다.

---
## Enum이란?
* Enum은 클래스의 일종으로, 상수의 집합이다.

```java
public enum FRUIT {
    APPLE,
    ORANGE,
    BANANA
}
```

## Enum을 사용하는 이유

* 타입에 안전하다.
  * enum type을 parameter로 받는 method에 다른 타입 혹은 enum type에 존재하지 않는 값을 넣을 경우 compile 시에 잡을 수 있다.

* Enum은 클래스이기 때문에 Constructor, Method, Interface, Field등 추가가 가능하다.

* Enum은 완전한 싱글톤이다. (Enum의 핵심)

```java
enum Fruit {
  ORANGE, APPLE, BANANA
}

public class Main {
  public static void main(String[] args) {
      System.out.println(Fruit.APPLE == Fruit.APPLE);
  }
}

```


## Reference 
* 자바의 신(이상민 저)
* Effective Java
* [Java Enum 활용기](https://techblog.woowahan.com/2527/)