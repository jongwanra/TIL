# [OS]Lecture 6. Process Synchronization and Mutual Exclusion(3)-HW solutions

[[OS] Lecture 6. Process Synchronization and Mutual Exclusion (3/7) - HW solution / 운영체제 강의](https://www.youtube.com/watch?v=Zps0ckSvKys&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=14)

→ SW solution이 비효율적이여서 HW solution을 조금 이용하는 방법으로 생각

## Synchronizaition Hardware

- **TestAndSet(TAS) instruction**
    - Test 와 Set을 한 번에 수행하는 기계어
    - Machine instruction
        - Atomicity, indivisible
        - **실행 중 interrupt를 받지 않음(preemption 되지 않음)**
    - Busy waiting
        - inefficient

## TAS Instruction

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%200edad162ffd043dd9eab5ae8d7bdf17d/Untitled.png)

## ME with TAS Instruction

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%200edad162ffd043dd9eab5ae8d7bdf17d/Untitled%201.png)

→ Mutual Instruction 문제를 간단히 해결

- **3개 이상의 프로세스의 경우, Bounded wating 조건 위배**

- **N-Process mutual exclusion**

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%200edad162ffd043dd9eab5ae8d7bdf17d/Untitled%202.png)

- **장점**
    - 구현이 간단

- **단점**
    - Busy waiting →여전히 해결되지 않음
        - inefficient

    →  여전히 SW, HW solution으로 해결 하지 못한 Busy waiting 문제를 OS를 통해서 해결할 수 있게 함.

- **Busy wating 문제를 해소한 상호배제 기법**
    - Semaphore
        - 대부분의 os들이 사용하는 기법