# Answer

## Annotation이란?

* Annotation은 작성한 코드에 대해 추가적인 정보를 제공한다.
* Annotation을 통해 컴파일 시 혹은 런타임 시에 해당 코드에 필요한 추가적인 처리가 가능하다.

## Annotation을 사용하는 이유?(개인적인 생각)
* 런타임시에 발생할 수 있는 경고 혹은 에러를 사전에 방지하기 위해서
  * 해당 예시로는 @Override, @SuppressWarnings가 있다.
* 중복적으로 작성 되었던 코드에 대해서 편리하게 처리하기 위해서
  * Getter, Setter 등이 존재한다.


## @Override의 용도?
부모 클래스에서 사용한 Method를 자식 클래스에서 재정의할 때 사용한다. 잘못 재정의를 했을 경우 Compiler가 에러를 뱉어준다.(RetentionPolicy.SOURCE)

## @SuppressWarnings의 용도?
경고가 나는 Class 혹은 Method의 경우 @SuppressWarnings를 사용해서 Compiler가 해당 경고를 무시할 수 있도록 해주는 Annotation이다.(RetentionPolicy.SOURCE)

## @Deprecated의 용도?
User와 Compiler에게 해당 Class 혹은 Method가 더이상 사용하지 않는다는 정보를 전달하는 목적이다.
User가 해당 Method를 호출 시 Compiler는 경고를 보여준다.(RetentionPolicy.RUNTIME)


## @Retention의 용도?
@Retention은 해당 annotation을 어느 시기까지 제공할지를 정하는 Meta-Annotation으로 총 3가지가 존재한다.
* RetentionPolicy.SOURCE
  * Compile전 까지 제공된다. 즉 .java 파일 까지
* RetentionPolicy.CLASS 
  * Complie시 까지 제공된다. 하지만, JVM에서는 사라짐. 즉, .class 파일 까지
* RetentionPolicy.RUNTIME
  * 실행시 제공된다. 즉, 프로그램 종료되기 전까지


## Reference
* 자바의 신(이상민 저)
* https://veneas.tistory.com/entry/Java-Annotation-%EB%A9%94%ED%83%80%EB%8D%B0%EC%9D%B4%ED%84%B0
* https://joel-dev.site/83