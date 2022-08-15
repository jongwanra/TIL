/*
Deep Dive 11장
원시 값과 객체의 비교

자바 스크립트에서는 데이터 타입을 크게 2가지로 구분할 수 있다.
  - 원시 타입(primitive type)
  - 객체 타입(object/reference type)

두 가지 타입의 차이점
  - 원시 값은 변경 불가능한 값이다(Immutable value)
  - 객체 타입의 값은 변경 가능한 값이다(mutable value)
  - 원시 값을 실제 변수에 할당하게 되면 메모리에는 실제 값이 저장된다.
  - 객체 타입의 값을 변수에 할당하게 되면 메모리에는 주소 값(참조 값)이 저장 된다.

문자열과 불변성
  - 문자열 타입은 2byte 숫자 타입은 8byte의 메모리를 할당하게 된다.
  - 자바 스크립트의 문자열은 원시 타입이며, 변경 불가능하다. 
 */

  let score = 80;
  let copy = score;

  score = 100;

  console.log(score);
  console.log(copy);