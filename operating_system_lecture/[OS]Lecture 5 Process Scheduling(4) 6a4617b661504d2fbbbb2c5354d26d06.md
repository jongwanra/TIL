# [OS]Lecture 5. Process Scheduling(4)

[[OS] Lecture 5. Process Scheduling (4/4) - MLQ, MFQ / 운영체제 강의](https://www.youtube.com/watch?v=actKUqea6Xc&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=11)

## MLQ(Multi-level Queue)

→ 여러개의  ready queue를 둔다.

- **작업 (or 우선순위)별 별도의 ready queue를 가짐**
    - 최초 배정 된 queue를 벗어나지 못함
    - 각각의 queue는 자신만의 스케줄링 기법 사용

- **Queue 사이에는 우선순위 기반의 스케줄링 사용**
    - E.g., fixed-priority preemptive scheduling

- **장점**
    - 빠른 응답시간(?)

- **단점**
    - 여러 개의 Queue 관리 등 스케줄링 overhead
    - 우선순위가 낮은 queue는 starvation 현상 발생 가능

    ![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(4)%206a4617b661504d2fbbbb2c5354d26d06/Untitled.png)

## MFQ(Multi-level Feedback Queue)

- **프로세스의 Queue간 이동이 허용된 MLQ**

- **Feedback을 통해 우선 순위 조정**
    - 현재까지의 프로세서 사용 정보(패턴) 활용

- **특성**
    - Dynamic priority → 동적인 우선순위
    - Preemptive scheduling
    - Favor short burst-time processes
    - Favor I/O bounded processes
    - Improve adaptability

- **프로세스에 대한 사전 정보 없이 SPN, SRTN, HRRN 기법의 효과를 볼 수 있음**

    → BT를 예상하지 않고도 비슷한 효과를 낼 수 있다는 뜻

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(4)%206a4617b661504d2fbbbb2c5354d26d06/Untitled%201.png)

- **단점**
    - 설계 및 구현이 복잡, 스케줄링 overhead가 큼
    - Starvation 문제 등

- **변형**
    - 각 준비 큐마다 시간 할당량을 다르게 배정
        - 프로세스의 특성에 맞는 형태로 시스템 운영 가능

    - 입출력 위주 프로세스들을 상위 단계의 큐로 이동, 우선 순위 높임
        - 프로세스가 block될 때 상위의 준비 큐로 진입하게 함
        - 시스템 전체의 평균 응답 시간 줄임, 입출력 작업 분산 시킴

    - 대기 시간이 지정된 시간을 초과한 프로세스들을 상위 큐로 이동
        - 에이징(aging) 기법

- **Parameters for MFQ scheduling**
    - Queue의 수
    - Queue별 스케줄링 알고리즘
    - 우선 순위 조정 기준
    - 최초 Queue 배정 방법