# [OS]Lecture 5. Process Scheduling(3)

[https://www.youtube.com/watch?v=keY9Wi7scEs&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=10](https://www.youtube.com/watch?v=keY9Wi7scEs&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=10)

## SPN(Shortest-Process-Next)

→ 수행 시간이 짧은 순으로 처리

- **Non-preemptive scheduling**

- **스케줄링 기준(Criteria)**
    - 실행시간(burst time 기준)
    - Burst time 가장 작은 프로세스를 먼저 처리
        - SJF(Shortest Job First) scheduling

- **장점**
    - 평균 대기시간(WT) 최소화
    - 시스템 내 프로세스 수 최소화
        - 스케줄링 부하 감소, 메모리 절약 → 시스템 효율 향상
    - 많은 프로세스들에게 빠른 응답 시간 제공

- **단점**
    - Starvation (무한대기) 현상 발생
        - BT가 긴 프로세스는 자원을 할당 받지 못 할 수 있음
            - Aging 등으로 해결(e.g., HRRN)
    - 정확한 실행시간을 알 수 없음 → Burst Time을 정확히 알 수 없음.
        - 실행시간 예측 기법이 필요

### 예제)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(3)%20ae04eb3e8a844aaf86a79201454ebcfc/Untitled.png)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(3)%20ae04eb3e8a844aaf86a79201454ebcfc/Untitled%201.png)

## SRTN(Shortest Remaining Time Next)

→ 남은 시간이 가장 적은 친구들을 먼저 처리해주겠다.

- **SPN의 변형**

- **Preemptive scheduling**
    - 잔여 실행 시간이 더 적은 프로세스가 ready 상태(등장)가 되면 선점됨.

- **장점**
    - SPN의 장점 극대화
- **단점**
    - 프로세스 생성시, 총 실행 시간 예측이 필요함
    - 잔여 실행을 계속 추적해야 함 = overhead
    - Context switching overhead

*→ 구현 및 사용이 비현실적*

### 예시)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(3)%20ae04eb3e8a844aaf86a79201454ebcfc/Untitled%202.png)

## HRRN(High-Response-Ratio-Next)

- **SPN의 변형**
    - SPN + Aging concepts, Non-preemptive scheduling

- **Aging concepts → 나이가 많은 프로세스를 배려하는 컨셉**
    - 프로세스의 대기 시간(WT)을 고려하여 기회를 제공

- **스케줄링 기준(Criteria)**
    - Response ratio가 높은 프로세스 우선

- **Response ratio = (WT + BT) / BT (응답률)**

       → 필요한 수행 시간 대비 얼마나 기다렸는지

    - SPN의 장점 + Starvation 방지
    - 실행 시간 예측 기법 필요(overhead)

### 예시)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(3)%20ae04eb3e8a844aaf86a79201454ebcfc/Untitled%203.png)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(3)%20ae04eb3e8a844aaf86a79201454ebcfc/Untitled%204.png)

## Basic Scheduling algorithms

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(3)%20ae04eb3e8a844aaf86a79201454ebcfc/Untitled%205.png)

→ 실행시간을 예측하기에는 힘들다. 그걸 커버하기 위해 나온 것이 MLQ, MFQ이다.