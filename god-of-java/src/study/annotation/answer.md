# Answer

## Annotation이란?
Annotation이란, 컴파일 과정과 실행 과정에서 코드를 어떻게 처리할지 알려주는 정보 

## Annotation은 용도?
* 컴파일 시 사용하는 정보 전달
* 빌드툴로 코드를 자동으로 생성 할 때 사용하는 정보 전달
* 실행 시, 특정 기능을 처리할 때 사용하는 정보 전달


## Annotation을 사용하는 이유?
사용자 혹은 Compiler에게 명시적으로 정보를 알려주기 위해서 사용한다.

## @Override의 용도?
부모 클래스에서 사용한 Method를 자식 클래스에서 재정의할 때 사용한다. 잘못 재정의를 했을 경우 Compiler가 에러를 뱉어준다.

## @SuppressWarnings의 용도?
경고가 나는 Class 혹은 Method의 경우 @SuppressWarnings를 사용해서 Compiler가 해당 경고를 무시할 수 있도록 해주는 Annotation이다.

## @Deprecated의 용도?
User와 Compiler에게 해당 Class 혹은 Method가 더이상 사용하지 않는다는 정보를 전달하는 목적이다.
User가 해당 Method를 호출 시 Compiler는 경고를 보여준다.


## @Retention의 용도?

## @Target의 용도?

## @Inherited의 용도?


## Reference
* 자바의 신(이상민 저)
* https://veneas.tistory.com/entry/Java-Annotation-%EB%A9%94%ED%83%80%EB%8D%B0%EC%9D%B4%ED%84%B0