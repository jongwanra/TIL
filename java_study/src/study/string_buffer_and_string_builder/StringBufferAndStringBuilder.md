# StringBuffer vs StringBuilder

String은 자바에서 불변(Immutable)한 객체이다. String을 자르거나, 연결하는 등에 행위를 할 때, 새로운 String이 생성되고, 기존 String은 GC 
에 의해 수거된다. 이 행위 자체는 무겁고 힙 영역에서 가비지를 발생시킨다. 그렇기 때문에 자바에서는  String 조작에 유용한 String Bulder와 String Buffer를 제공해왔다.

String Buffer와 String Builder는 자바에서 Mutalble한 객체이며, append, insert, delete, substring 등의 Method를 제공한다.

String Buffer는 Java 1.4까지 String 조작 시 사용되어져 왔다. 하지만 thread-safe한 부분이 한 가지 단점으로 받아들여져 왔다. 
Thread Safe는 성능과 비용이 발생하기 때문이다. 대부분의 상황에서 String은 Muti-Thread 환경에서 사용되어지지 않는다. 그래서 Java 1.5에서 Thread-Safe하지 않은 String Builder가 도입되었다.



## Reference
* https://www.digitalocean.com/community/tutorials/string-vs-stringbuffer-vs-stringbuilder