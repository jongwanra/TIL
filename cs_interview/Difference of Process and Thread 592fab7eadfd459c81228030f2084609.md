# Difference of Process and  Thread

- **Program이란?**
    - an executable file(실행 가능한 파일)
- **Process란?**
    - a program in execution(실행중인 프로그램)
- **thread란?**
    - the unit of execution within a process(프로세스 안에서 실행의 단위)

## 프로세스란?

- 프로세스는 실행 중인 프로그램(A program in execution)으로 디스크로부터 메모리에 적재되어 CPU의 할당을 받을 수 있는 것을 말한다. 운영체제로부터 주소 공간, 파일, 메모리 등을 할당받으며 이것들을 총칭하여 프로세스라고 한다.

![Untitled](Difference%20of%20Process%20and%20Thread%20592fab7eadfd459c81228030f2084609/Untitled.png)

- 프로세스는 4가지 영역으로 나눌 수 있다. (stack, heap, text and data)

![Untitled](Difference%20of%20Process%20and%20Thread%20592fab7eadfd459c81228030f2084609/Untitled%201.png)

## thread란 무엇일까?

![Untitled](Difference%20of%20Process%20and%20Thread%20592fab7eadfd459c81228030f2084609/Untitled%202.png)

- 스레드는 프로세스 내에서 각각 Stack만 따로 할당받고  Code, Data, Heap 영역은 공유한다.
- 스레드는 한 프로세스 내에서 동작되는 여러 실행의 흐름으로, 프로세스 내의 주소 공간이나 자원들을 같은 프로세스 내에 스레드끼리 공유하면서 실행된다.

[Compare process with thread](https://www.notion.so/85085bebc35f4cb49ca38c9337c29c49)

## Reference

[[SW 기술면접] #1 Thread vs Process 컴퓨터공학 기본](https://www.youtube.com/watch?v=RrfASw-jfZ4)