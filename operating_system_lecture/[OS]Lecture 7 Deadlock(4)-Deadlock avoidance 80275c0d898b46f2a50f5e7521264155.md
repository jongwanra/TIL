# [OS]Lecture 7. Deadlock(4)-Deadlock avoidance

[[OS] Lec 7. Deadlock (4/5) - Deadlock avoidance / 운영체제 강의](https://www.youtube.com/watch?v=qmtOsmixfsA&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=22)

## Deadlock Avoidance

- **시스템의 상태를 계속 감시**

- **시스템이 deadlock 상태가 될 가능성이 있는 자원 할당 요청 보류**

- **시스템을 항상 safe state로 유지**

## Deadlock Avoidance

- **Safe state**
    - 모든 프로세스가 정상적 종료 가능한 상태 → Safe state 정의
    - Safe sequence가 존재 → Safe state인지를 이 기준으로 판단을 한다.
        - Deadlock상태가 되지 않을 수 있음을 보장

- **Unsafe state**
    - Deadlock 상태가 될 가능성이 있음
    - 반드시 발생한다는 의미는 아님.

- **가정**
    - 프로세스의 수가 고정됨
    - 자원의 종류와 수가 고정됨
    - 프로세스가 요구하는 자원 및 최대 수량을 알고 있음
    - 프로세스는 자원을 사용 후 반드시 반납한다.

- **Not practical**

## Deadlock Avoidance

- **Dijkstra's algorithm**
    - Bankers's algorithm

- **Habermann's algorithm**

## Deadlock Avoidance

- **Dijkstra's banker's algorithm**
    - Deadlock avoidance를 위한 간단한 이론적 기법
    - 가정
        - 한 종류(resource type)의 자원이 여러 개(unit)
    - 시스템을 항상 safe state로 유지시키는 알고리즘

- **Dijkstra's banker's algorithm**
    - 1 resource type R, 10 resource units, 3 processes
    - Safe state example

    ![Untitled](%5BOS%5DLecture%207%20Deadlock(4)-Deadlock%20avoidance%2080275c0d898b46f2a50f5e7521264155/Untitled.png)

![Untitled](%5BOS%5DLecture%207%20Deadlock(4)-Deadlock%20avoidance%2080275c0d898b46f2a50f5e7521264155/Untitled%201.png)

→ P3에게 돈을 빌려주는 것이 가능해서 안전 순서가 존재한다. 따라서 Safe state이다.

- **Dijkstra's banker's algorithm**
    - 1 resource type R, 10 resource units, 3 processes
    - Unsafe state example

    ![Untitled](%5BOS%5DLecture%207%20Deadlock(4)-Deadlock%20avoidance%2080275c0d898b46f2a50f5e7521264155/Untitled%202.png)

    → 반드시 교착 상태는 아니지만, 가능성이 있음.

- **Dijkstra's banker's algorithm (example)**
    - 1 resource type R, 10 resource units, 3 processes

    ![Untitled](%5BOS%5DLecture%207%20Deadlock(4)-Deadlock%20avoidance%2080275c0d898b46f2a50f5e7521264155/Untitled%203.png)

    → P1 이 하나더 요청을 했을 때, 줬다고 가정을 해보고,  state 1-1 에서 safe sequence를 찾을 수 있다면(p1 → p3 → p2), 자원을 할당 해 준다(accept) 해준다.

    ![Untitled](%5BOS%5DLecture%207%20Deadlock(4)-Deadlock%20avoidance%2080275c0d898b46f2a50f5e7521264155/Untitled%204.png)

    → 자원을 빌려준 상황을 가정해보고 그 상황이 Unsafe state 라면, 자원할당을 거절 한다. deadlock이 될 가능성이 있기 때문.

    ## Deadlock Avoidance

    - **Habermann's algorithm**
        - Dijkstra's algorithm의 확장
        - 여러 종류의 자원 고려
            - Multiple resource types
            - Multiple resource units for each resource type
        - 시스템을 항상 safe state로 유지

    - **Habermann's algorithm(Example)**
        - 3 types of resources: Ra, Rb, Rc
        - Number of resource units for each type: (10, 5, 7)
        - 5 processes

        ![Untitled](%5BOS%5DLecture%207%20Deadlock(4)-Deadlock%20avoidance%2080275c0d898b46f2a50f5e7521264155/Untitled%205.png)

        ![Untitled](%5BOS%5DLecture%207%20Deadlock(4)-Deadlock%20avoidance%2080275c0d898b46f2a50f5e7521264155/Untitled%206.png)

## Deadlock Avoidance

- **Deadlock의 발생을 막을 수 있음**

- **High overhead**
    - 항상 시스템을 감시하고 있어야 한다.

- **Low resource utilization → 낮은 자원 효율**
    - Safe state 유지를 위해, 사용 되지 않는 자원이 존재

- **Not practical**
    - 가정
        - 프로세스 수, 자원 수가 고정
        - 필요한 최대 자원 수를 알고 있음 → 미리 알고 있다는 거 자체가 말이 안됨.(비현실적)