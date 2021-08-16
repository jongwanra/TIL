# [OS]Lecture 6. Process Synchronization and Mutual Exclusion(1)-Introduction

[[OS] Lecture 6. Process Synchronization and Mutual Exclusion (1/7) - Introduction / 운영체제 강의](https://www.youtube.com/watch?v=wdaf2gy83uU&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=12)

## Process Synchronization(동기화)

- **다중 프로그래밍 시스템**
    - 여러 개의 프로세스들이 존재 → 즉, 다중 프로그래밍 시스템이다.
    - 프로세스들은 서로 독립적으로 동작 → 동시에 동작을 한다.
    - 공유 자원 또는 데이터가 있을 때, 문제 발생 가능

        → 공유 자원을 동시에 사용하려고 할 때 등의 경우

- **동기화(Synchronization)**

    **→ 시스템에서 프로세스들 사이에 대화를 나누는 행위**

    - 프로세스들이 서로 동작을 맞추는 것
    - 프로세스들이 서로 정보를 공유 하는 것

    ![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20b8861ac99e6e4e34b7c3c3bdce8c3bd3/Untitled.png)

## Asynchronous and Concurrent P's

- **비동기적(Asynchronous)**
    - 프로세스들이 서로에 대해 모름

- **병행적 (Concurrent)**
    - 여러 개의 프로세스들이 동시에 시스템에 존재

- **병행 수행중인 비동기적 프로세스들이 공유 자원에 동시 접근 할 때 문제가 발생할 수 있음.**

## Terminologies

- **Shared data(공유 데이터) or Critical data**
    - 여러 프로세스들이 공유하는 데이터

- **Critical section (임계 영역)**
    - 공유 데이터를 접근하는 코드 영역(code segment)

- **Mutual exclusion (상호배제)**
    - 둘 이상의 프로세스가 동시에 critical section에 진입하는 것을 막는 것

## Critical Section(example)

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20b8861ac99e6e4e34b7c3c3bdce8c3bd3/Untitled%201.png)

Q : Pi와 Pj 가 공유 데이터인 sdata에 1씩 추가한다고 할 때, sdata == 2일까?

A : 기계어 명령(machine instruction)의 특성인 한 기계어 명령의 실행 동중 인터럽트를 받지 않는다는 특성 때문.

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20b8861ac99e6e4e34b7c3c3bdce8c3bd3/Untitled%202.png)

→ machine instruction 이 각 프로세스 마다 3개씩 존재한다.

→ 기계어 명령의 원자성에 의해 한 기계어 명령의 실행 도중에는 인터럽트를 받지 않지만 사이사이에는 끼어들을 수 있다.

→ Race condition: 실행 순서에 따라 결과가 달라질 수 있다.

Q: 우리가 원하는 결과를 도출해 내기 위해선?

A: Mutual Exclusion(상호배제)

## Mutual Exclusion(상호배제)

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20b8861ac99e6e4e34b7c3c3bdce8c3bd3/Untitled%203.png)

→ critical section 안에 있는 동안 다른 친구가 못 들어오게 막아 주는 것

## Mutual Exclusion Methods

- **Mutual exclusion primitives(가장 기본이 되는 연산, 기본연산)**
    - enterCS() primitive
        - Critical section 진입 전 검사
        - 다른 프로세스가 critical section 안에 있는지 검사
    - exitCS() primitive
        - Critical section을 벗어날 때의 후처리 과정
        - Critical section을 벗어남을 시스템이 알림

        ![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20b8861ac99e6e4e34b7c3c3bdce8c3bd3/Untitled%204.png)

## Requirements for ME primitives

1. **Mutual exclusion (상호배제)**
    - Critical section (CS) 에 프로세스가 있으면, 다른 프로세스의 진입을 금지

1. **Progress(진행)**
    - CS 안에 있는 프로세스 외에는, 다른 프로세스가 CS에 진입하는 것을 방해 하면 안됨

        → 안에 아무도 없으면 들어갈 수 있어야 한다.

1. **Bounded wating(한정대기)**
    - 프로세스의 CS 진입은 유한시간 내에 허용되어야 함.

## Two Process Mutual Exclusion

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20b8861ac99e6e4e34b7c3c3bdce8c3bd3/Untitled%205.png)

Q : 위의 3가지 조건을 다 만족할까?

A : Progress 조건을 위배

- P0이 critical section에 진입 하지 못하고 죽어버리는 경우
- 한 Process가 두 번 연속 CS에 진입 불가

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20b8861ac99e6e4e34b7c3c3bdce8c3bd3/Untitled%206.png)

→ 상대 편의 flag 상태를 보고 들어갈지 말지를 결정.

Q : 위의 3가지 조건을 다 만족할까?

A : Mutual exclusion 조건 위배

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20b8861ac99e6e4e34b7c3c3bdce8c3bd3/Untitled%207.png)

Q : 위의 3가지 조건을 다 만족할까?

A : Progress, Bounded waiting 조건 위배