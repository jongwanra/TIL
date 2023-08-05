## Static
* java에서 static keyword는 주어진 클래스의 동일한 변수 혹은 메서드를 `공유`하는데 사용된다.
* static keyword는 variables, methods, blocks, and nested classes에 적용이 가능하다.
* static keyword는 클래스의 모든 인스턴스에서 동일한 상수 변수 또는 메서드에 사용된다.

## Static keyword의 특징
* Shared memory allocation: Static variables and methods는 프로그램 실행 동안에 한 번에 한해서 메모리 공간을 할당 받는다. 이 메모리 공간은 해당 클래스의 모든 인스턴스 사이에서 공유 된다. 
* Accessible without object instantiation: 정적 멤버들은 인스턴스화를 할 필요 없이 접근 할 수 있다. 따라서 전체 프로그램에서 사용할 수 있는 util 기능 및 상수를 제공하는데 유용하다.
* Associated with class, not objects: 정적 멤버들은 각각의 객체들이 아닌 클래스와 관련이 있다. 즉, 정적 멤버가 변경이 되면 해당 클래스의 모든 인스턴스들에게도 반영 된다. 그리고 className을 사용하여 접근할 수 있다.
* Cannot access non-static members
* Can be overloded, but not overridden: 오버로딩에 대해서는 가능하다. 하지만, 오버라이딩은 불가능하다.

## Static Methods
Static Method는 3가지의 제한이 있다.
* 다른 static methods에서만 호출할 수 있다
* static data만 직접적으로 접근 가능하다.
* this keyword or super keyword를 참조할 수 없다.

## When to use static variables and methods?
* 모든 객체에 공통인 속성에 대해서 정적 변수를 사용하면 좋다.

## static 키워드의 사용법과 그로 인해 발생할 수 있는 문제

static 키워드는 class 내의 method에서는 return type 앞에, variable에서는 type 앞에 지정해서 사용이 가능하다.
static keyword를 사용하면 해당 값을 모든 객체에서 사용할 수 있게 
공유가 되어지기 때문에 안전하지 않다. 
그리고, static으로 생성된 method, 혹은 variable은 동일하게 static keyword를 사용한 변수 혹은 메서드에만 접근이 가능하기 때문에 유의해서 사용해야 한다.

## static 키워드로 생성된 변수가 모든 객체에서 공유되는 이유
static으로 생성된 변수는 Method(Static) Area에 저장이 되기 때문이다. 따라서 해당 클래스의 instance 뿐만 아니라 다른 class에서도 접근이 가능하다. 예를 들어 System.out.println method를 어디서든 접근할 수 있는 것과 같은 원리이다.

## static으로 생성된 메서드나 변수에만 접근이 가능한 이유
static으로 생성된 method나 variable은 생성 시점이 class loader에서 byteCode가 읽히고 나서이다. 그렇기 때문에, 생성된 시점이 같은 static 멤버에서만 접근이 가능하다.


## static으로 선언된 변수의 값은 언제 초기화되고 사용할 수 있을까?
static으로 선언된 변수의 값은 class Loader에 의해 읽혀서 Method Area에 적재된 시점에 초기화가 된다.

##  static 멤버에 접근하는 방법
static 멤버에 접근하는 방법은 해당 클래스명.정적멤버명 형식으로 접근이 가능하다

## Method(Static) Area
* Method Area는 class와 interface들을 저장하는 JVM의 공유되는 데이터 영역이다.
* 구체적으로 class loader는 .class 확장자의 byteCode를 읽고 그걸 JVM에 전달한다.
* 그리고 나서, JVM은 클래스의 내부 표현을 생성하여 런타임 때 Object들을 생성하고 Method를 호출하는데 사용한다.
* internal representaion은 class의 field, methods, and constructers 와 interface에 대한 정보들을 모은다.


## Reference
* https://www.geeksforgeeks.org/static-keyword-java/
* https://www.baeldung.com/java-jvm-run-time-data-areas