# [OS]Lecture 5. Process Scheduling(2)

## Basic Scheduling algorithms

1. **FCFS(First-Come-First-Service)**
2. **RR(Round-Robin)**
3. **SPN(Shortest-Process-Next)**
4. **HRRN(High-Response-Ratio-Next)**
5. **MLQ(Multi-level Queue)**
6. **MFQ(Muti-level Feedback Queue)**

## 1. FCFS(First-Come-First-Service)

     → 선착순 알고리즘

- **Non-preemptive scheduling**

- **스케줄링 기준(Criteria)**
    - 도착 시간(ready queue 기준)
    - 먼저 도착한 프로세스를 먼저 처리

- **자원을 효율적으로 사용 가능(장점)**
    - High resource utilization
        - why?

               → Scheduling overhead가 낮음

               → CPU가 계속 일할 수 있다.

- **Batch system(일괄처리 시스템)에 적합, interactive system(대화형 시스템)에 부적합**

- **단점**
    - **Convoy effect**
        - 하나의 수행시간이 긴 프로세스에 의해 다른 프로세스들이 긴 대기시간을 갖게 되는 현상

            (대기시간 >> 실행 시간)

    - **긴 평균 응답시간(response time)**

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(2)%20521c7d0b36ec4979af17e74d46b19a25/Untitled.png)

### 연습)

- Normalized TT(NTT) = TT/BT

    → 내가 써야하는 burst time 대비해서 내가 얼마나 기다렸는가에 대한 지표

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(2)%20521c7d0b36ec4979af17e74d46b19a25/Untitled%201.png)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(2)%20521c7d0b36ec4979af17e74d46b19a25/Untitled%202.png)

## 2. **RR(Round-Robin)**

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(2)%20521c7d0b36ec4979af17e74d46b19a25/Untitled%203.png)

→ 2초씩 돌아가면서 쓰자! 

- **Preemptive scheduling**

- **스케줄링 기준(Criteria)**
    - 도착 시간(ready queue 기준)
    - 먼저 도착한 프로세스를 먼저 처리

- ★**자원 사용 제한 시간(time quantum)이 있음**
    - System parameter()
    - 프로세스는 할당된 시간이 지나면 자원 반납
        - Timer-runout
    - 특정 프로세스의 자원 독점(monopoly) 방지(장점)
    - Context switch overhead가 큼(단점)

- **Interactive system(대화형), Time-sharing system(시분할 시스템)에 적합**

- **Time quantum(제한시간) 이 시스템 성능을 결정하는 핵심 요소**
    - Very large(infinite) → FCFS
    - Very small time quantum → processor sharing
        - 사용자는 모든 프로세스가 각각의 프로세서 위에서 실행되는 것처럼 느낌
            - 체감 프로세서 속도 = 실제 프로세서 성능의 1/n
        - High context switch overhead

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(2)%20521c7d0b36ec4979af17e74d46b19a25/Untitled%204.png)

### 연습)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(2)%20521c7d0b36ec4979af17e74d46b19a25/Untitled%205.png)

 

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(2)%20521c7d0b36ec4979af17e74d46b19a25/Untitled%206.png)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(2)%20521c7d0b36ec4979af17e74d46b19a25/Untitled%207.png)