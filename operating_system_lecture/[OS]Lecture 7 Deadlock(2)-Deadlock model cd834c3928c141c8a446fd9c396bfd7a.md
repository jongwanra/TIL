# [OS]Lecture 7. Deadlock(2)-Deadlock model

[[OS] Lec 7. Deadlock (2/5) - Deadlock model / 운영체제 강의](https://www.youtube.com/watch?v=czjtYkjhtgo&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=20)

## Deadlock 발생의 예

- 2개의 프로세스(P1, P2)
- 2개의 자원(R1, R2)

![Untitled](%5BOS%5DLecture%207%20Deadlock(2)-Deadlock%20model%20cd834c3928c141c8a446fd9c396bfd7a/Untitled.png)

→ 발생 가능성이 없는 교착상태가 발생.

## Deadlock Model(표현법)

- **Graph Model**

- **State Transition Model**

# Graph Model

- **Node**
    - 프로세스 노드(P1, P2), 자원 노드(R1, R2)
- **Edge**
    - Rj → Pi : 자원 Rj 이 프로세스 Pi에 할당 됨
    - Pi → Rj : 프로세스 Pi 가 자원 Rj 을 요청 (대기 중)

    ![Untitled](%5BOS%5DLecture%207%20Deadlock(2)-Deadlock%20model%20cd834c3928c141c8a446fd9c396bfd7a/Untitled%201.png)

    → 싸이클이 생성됨 : Dead lock이 발생함을 알 수 있음.

    ## State Transition Model

    - **예제**
        - 2개의 프로세스와 A type의 자원 2개(unit) 존재
        - 프로세스는 한 번에 자원 하나만 요청/반납 가능

    - **State**

        ![Untitled](%5BOS%5DLecture%207%20Deadlock(2)-Deadlock%20model%20cd834c3928c141c8a446fd9c396bfd7a/Untitled%202.png)

        → Process가 2개 라면?

        ![Untitled](%5BOS%5DLecture%207%20Deadlock(2)-Deadlock%20model%20cd834c3928c141c8a446fd9c396bfd7a/Untitled%203.png)

        ## Deadlock 발생 필요 조건

        → 밑에 4가지가 모두 성립 ⇒ Deadlock 발생

        1. **Exclusive use of resources → 자원의 특성**
        2. **Non-preemptible resources → 자원의 특성**
        3. **Hold and wait(Partial allocation) →프로세스의 특성**
            - 자원을 하나 hold하고 다른 자원 요청

                → 자원 1개를 잡고 다른 자원을 요청 하는 상황

        4. **Circular wait → 프로세스의 특성**