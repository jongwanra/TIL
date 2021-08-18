# [OS]Lecture 7. Deadlock(1)-Deadlock and Resource types

[[OS] Lec 7. Deadlock (1/5) - Deadlock and Resource types / 운영체제 강의](https://www.youtube.com/watch?v=xvoEsy2zJnc&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=19)

## Deadlock

![Untitled](%5BOS%5DLecture%207%20Deadlock(1)-Deadlock%20and%20Resource%20ty%20cd5204a552db4a4fa4c4a0d042bf412f/Untitled.png)

→ 어느 프로세스 들도 자기가 원하는 자원을 가져갈 수 없는 상황

## Deadlock의 개념

- **Blocked/Asleep state → Processor가 아닌 다른 자원을 기다릴 때**
    - 프로세스가 특정 이벤트를 기다리는 상태
    - 프로세스가 필요한 자원을 기다리는 상태

- **Deadlock state**
    - 프로세스가 발생 가능성이 없는 이벤트를 기다리는 경우
        - 프로세스가 deadlock 상태에 있음
    - 시스템 내에 deadlock에 빠진 프로세스가 있는 경우
        - 시스템이 deadlock 상태에 있음

![Untitled](%5BOS%5DLecture%207%20Deadlock(1)-Deadlock%20and%20Resource%20ty%20cd5204a552db4a4fa4c4a0d042bf412f/Untitled%201.png)

- **Deadlock vs Starvation(기아 상태)**

    → Deadlock: 이벤트를 기다리고 있는데 일어날 가능성이 없는 경우

         (가능성이 없음)

    → Starvation: CPU를 기다리고 있는데 우선순위에 밀려서 계속 기다리는 상태

         (가능성이 없음) 

    → 발생 가능성과 기다리고 있는 자원, 어느 상태에 존재하는지에 대한 차이가 있음.

## 자원의 분류

- **일반적 분류**
    - **Hardware resources vs Software resources**

- **다른 분류법**
    - 선점 가능 여부에 따른 분류
    - 할당 단위에 따른 분류
    - 동시 사용 가능 여부에 따른 분류
    - 재사용 가능 여부에 따른 분류

## 1. 선점 가능 여부에 따른 분류

- **Preemptible resources →**
    - 선점 당한 후, 돌아와도 문제가 발생하지 않는 자원
    - Processor, memory 등 → context switching, swap device 덕분에 뺏겨도 문제가 생기지 않는다.

- **Non-preemptible resources**
    - 선점 당하면, 이후 진행에 문제가 발생하는 자원
        - Rollback, restart등 특별한 동작이 필요
    - E.g., disk drive, USB 등

   

![Untitled](%5BOS%5DLecture%207%20Deadlock(1)-Deadlock%20and%20Resource%20ty%20cd5204a552db4a4fa4c4a0d042bf412f/Untitled%202.png)

→ 아들에게 선점 당해서 결국 해외를 가지 못한 아빠

## 2. 할당 단위에 따른 분류

- **Total allocation resources →줄 때, 전체를 다 줌**
    - 자원 전체를 프로세스에게 할당
    - E.g., Processor, disk drive 등

- **Partitioned allocation resources**
    - 하나의 자원을 여러 조작을 나누어, 여러 프로세스들에게 할당
    - E.g., Memory 등

## 3. 동시 사용 가능 여부에 따른 분류

- **Exclusive allocation resources**
    - 한 순간에 한 프로세스만 사용 가능한 자원
    - E.g., Processor, memory, disk drive 등

        → 메모리는 왜? : 본인에게 할당된 영역을 다른 프로세스가 와서 사용할 수 없기 때문에(p1, p2 각자 영역을 가지고 있다)

- **Shared allocation resource**
    - 여러 프로세스가 동시에 사용 가능한 자원

        → Word Press, Google Chrome(창을 여러개 띄워서 사용 가능하다.)

    - E.g, Program(sw), shared data 등

## 4. 재사용 가능 여부에 따른 분류

- **SR (Serially-reusable Resources) → 계속 사용 가능한 자원**
    - 시스템 내에 항상 존재하는 자원
    - 사용이 끝나면, 다른 프로세스가 사용 가능
    - E.g., Processor, memory, disk drive, program 등

- **CR(Consumable Resources) → 쓰고 사라지는 자원**
    - 한 프로세스가 사용한 후에 사라지는 자원
    - E.g., signal, message 등

## Deadlock과 자원의 종류

- **Deadlock을 발생시킬 수 있는 자원의 형태**
    - Non-preemptible resources
    - Exclusive allocation resources
    - Serially reusable resources
    - 할당 단위는 영향을 미치지 않음

- **CR을 대상으로 하는 Deadlock model**
    - 너무 복잡!