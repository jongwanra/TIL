# [OS]Lecture 7. Deadlock(3)-Deadlock Prevention

[[OS] Lec 7. Deadlock (3/5) - Deadlock Prevention / 운영체제 강의](https://www.youtube.com/watch?v=XMrlt3ZwfM4&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=21)

## Deadlock 발생 필요 조건

1. **Exclusive use of resources → 혼자**
2. **Non-preemptible resources**
3. **Hold and wait(Partial allocation)**
    - 자원을 하나 hold하고 다른 자원 요청
4. **Circular wait**

→ Deadlock을 없애기 위해서 쉽게 생각해서 이 중에 하나를 없애면 된다.

## Deadlock 해결 방법

- **Deadlock prevention methods**
    - 교착상태 예방
- **Deadlock avoidance method**
    - 교착상태 회피
- **Deadlock detection and deadlock recovery methods**
    - 교착상태 탐지 및 복구

## Deadlock Prevention

- **4개의 deadlock  발생 필요 조건 중 하나를 제거**
    1. **Exclusive use of resources → 혼자**
    2. **Non-preemptible resources**
    3. **Hold and wait(Partial allocation)**
    4. **Circular wait**

- **Deadlock이 절대 발생하지 않음**

1. **모든 자원을 공유 허용 → 포기!**
    - Exclusive use of resources 조건 제거
    - 현실적으로 불가능

1. **모든 자원에 대해 선점 허용 →  불가능하지만, 유사한 방법으로 구현 가능**
    - Non-preemptible resources 조건 제거
    - 현실적으로 불가능
    - 유사한 방법
        - 프로세스가 할당 받을 수 없는 자원을 요청한 경우, 기존에 가지고 있던 자원을 모두 반납하고 작업 취소
            - 이후 처음 (또는 check-point) 부터 다시 시작
            - 심각한 자원 낭비 발생 → 비현실적

1. **필요 자원 한번에 모두 할당(Total allocation)**
    - Hold and wait 조건 제거
        - 자원 낭비 발생
            - 필요하지 않은 순간에도 가지고 있음
    - 무한 대기 현상 발생 가능

![Untitled](%5BOS%5DLecture%207%20Deadlock(3)-Deadlock%20Prevention%20bb5887b47503404b958f567afe2e44f4/Untitled.png)

1. **Circular wait 조건 제거**
    - Totally allocation을 일반화 한 방법
    - 자원들에게 순서를 부여
    - 프로세스는 순서의 증가 방향으로만 자원 요청 가능
    - 자원 낭비 발생

    ![Untitled](%5BOS%5DLecture%207%20Deadlock(3)-Deadlock%20Prevention%20bb5887b47503404b958f567afe2e44f4/Untitled%201.png)

    → 내가 쓸 수 있는 자원 3번이 있는데 순서를 증가 방향으로만 가능하보니 기다리는 상황 발생

## Deadlock Prevention 정리

- **4개의 deadlock 발생 필요 조건 중 하나를 제거**
- **Deadlock이 절대 발생하지 않음**
- **하지만, 심각한 자원 낭비 발생**
    - Low device utilization
    - Reduced system throughput
- **비현실적**