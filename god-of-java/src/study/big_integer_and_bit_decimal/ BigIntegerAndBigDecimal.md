# Java에서 100자리 이상의 수를 계산하기 위한 클래스는 무엇이 있을까?

* 100자리 이상의 수를 계산하기 위한 클래스로는 두 가지가 존재한다. `BigInteger`, `BigDecimal`
* `BigInteger`는 long type(8byte)의 범위를 넘어 더 큰 범위의 정수를 다룰 때 사용되는 클래스로 java.math에 속한다.
* `BigDecimal`는 부동 소수점 타입인 float, double의 정밀도 대한 문제점과 더 큰 범위의 소수를 다룰 때 사용되는 클래스로 java.math에 속한다.
* `BigInteger`, `BigDecimal`은 Immutable하다.


## BigDecimal 기본 용어 정리
* precision: 숫자를 구성하는 전체 자리수이다. 0이 아닌 수가 시작하는 위치부터 오른쪽부터 0이 아닌 수로 끝나는 위치 까지의 총 자리수
  * 012345.67890  => 9
* scale: 전체 소수점 자리수이다. 소수점 첫째 자리부터 끝에서 0이 아닌수로 끝나는 위치까지의 총 소수점 자리수이다.
  * 012345.67890  => 4
  * 0.00, 0.0의 scale은 모두 1

## IEEE 754
* https://ko.wikipedia.org/wiki/IEEE_754
* IEEE 754는 IEEE에서 개발한 컴퓨터에서 부동소수점을 표현하는 가장 널리 쓰이는 표준이다.

## Reference 
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigDecimal.html
* https://codegym.cc/groups/posts/216-how-to-use-bigdecimal-in-java
* https://jsonobject.tistory.com/466