# [OS]Lecture 5. Process Scheduling(1)

[[OS] Lecture 5. Process Scheduling (1/4) / 운영체제 강의](https://www.youtube.com/watch?v=_gNeoGQx-Tc&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=8)

## 다중프로그래밍(Multi-programming)

- **여러개의 프로세스가 시스템 내 존재**

- **자원을 할당 할 프로세스를 선택 해야 함**
    - 스케줄링(Scheduling)

- **자원 관리**
    - **시간 분할(time sharing) 관리**
        - 하나의 자원을 여러 스레드들이 번갈아 가며 사용
        - 예) 프로세서(Processor)
        - 프로세스 스케줄링( Process scheduling)
            - 프로세서 사용시간을 프로세스들에게 분배
    - **공간 분할(space sharing) 관리**
        - 하나의 자원을 분할하여 동시에 사용
        - 예) 메모리(memory)

## 스케줄링(Scheduling)의 목적

- **시스템의 성능(performance) 향상 → 굉장히 모호한 표현이기 때문에 지표가 필요하다.**

- **대표적 시스템 성능 지표(index)**
    1. 응답시간(response time) → interactive system, real-time system
        - 작업 요청(submission)으로부터 응답을 받을때 까지의 시간
    2. 작업 처리량(throughput) → batch-system
        - 단위 시간 동안 완료된 작업의 수 → 단위 시간동안 얼마나 많은 양을 처리하는가
    3. 자원 활용도(resource utilization) → 비싼 자원을 샀을 경우 안쉬게끔 활용하는 것이 필요.
        - 주어진 시간(Tc) 동안 자원이 활용된 시간(Tr)
        - *Utilization = Tr / Tc*

- **목적에 맞는 지표를 고려하여 스케줄링 기법을 1~3 번 중 선택해야 한다.**

## 대기시간, 응답시간, 반환시간

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(1)%202bd3846be41a4c679cafe8f3d8378ff2/Untitled.png)

## 스케줄링 기준(Criteria)

- **스케줄링 기법이 고려하는 항목들 → 어떤 스케줄링 기법을 사용할지 정하는 기준들**

- **프로세스(process)의 특성 → 중요한 기준이 된다.!**
    - I/O-bounded or compute-bounded

- **시스템 특성**
    - Batch system or interactive system → 목적이 다른 시스템들

- **프로세스의 긴급성(urgency)**
    - Hard- or soft- real time, non-real time systems

- **프로세스 우선순위(priority)**

- **프로세스 총 실행 시간(total service time)**

## CPU burst vs I/O burst

- **프로세스 수행 = CPU 사용 + I/O 대기 → 이 두 가지를 반복하면서 돌아간다.**

     → CPU를 더 많이 사용하는 프로그램 → compute-bounded process

    → I/O를 더 많이 사용하는 프로그램 → I/O bounded process

- **CPU burst**
    - CPU 사용 시간

- **I/O burst**
    - I/O 대기 시간

- **Burst time은 스케줄링의 중요한 기준 중 하나**

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(1)%202bd3846be41a4c679cafe8f3d8378ff2/Untitled%201.png)

## 스케줄링의 단계(Level)

- **발생하는 빈도 및 할당 자원에 따른 구분 → 발생하는 빈도를 기준으로  나눔**

- **Long-term scheduling →가끔**
    - 장기 스케줄링
    - Job scheduling

- **Mid-term scheduling → 종종**
    - 중기 스케줄링
    - Memory allocation

- **Short-term scheduling → 자주**
    - 단기 스케줄링
    - Process scheduling

## Long-term Scheduling → 가끔

- **Job scheduling**
    - 시스템에 제출 할(Kernel에 등록 할) 작업(Job) 결정
        - Admission scheduling, High-level scheduling

        ![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(1)%202bd3846be41a4c679cafe8f3d8378ff2/Untitled%202.png)

        → Job이 커널에 등록되면 프로세스가 된다. 

        → Job들이 시스템에 등록되기 위해 줄을 서 있을 때 이 중에 누구를 먼저 등록시켜 줄지 결정하는 것을 Job scheduling이다.

- **다중프로그래밍 정도(multi-programming degree) 조절**
    - 시스템 내에 프로세스 수 조절

- **I/O-bounded 와 compute-bounded 프로세스들을 잘 섞어서 선택해야 함**
    - why? → 한 쪽에 치우쳐져 있으면 한 쪽은 놀고 있을 것이기 때문.

- **시분할 시스템에서는 모든 작업을 시스템에 등록**
    - Long-term scheduling이 상대적으로 덜 중요하다.
        - why? → 시간을 나누어서 사용하기 때문에 몇 개가 들어와도 크게 문제가 없기 때문

## Mid-term Scheduling → 메모리할당과 관련

- **메모리 할당 결정(memory allocation)**
    - Intermediate-level scheduling
    - Swapping(swap-in/swap-out)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(1)%202bd3846be41a4c679cafe8f3d8378ff2/Untitled%203.png)

→ 메모리 없이 대기하고 있는 많은 프로세스들에 대해서 누구한테 메모리를 줄건지를 정하는 것.

## Short-term Scheduling → CPU를 할당해주는 스케줄링(가장 중요!)

- **Process scheduling**
    - Low-level scheduling
    - 프로세서(processor)를 할당할 프로세스(process)를 결정
        - Processor scheduler, dispatcher

- **가장 빈번하게 발생**
    - Interrupt, block(I/O), time-out, Etc.
    - 매우 빨라야 함
        - E.g.,
        - average CPU burst = 100ms

            scheduling decision = 10ms

        - 10 * (100 + 10) = 9%

            of the CPU is being used simply for scheduling

            ![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(1)%202bd3846be41a4c679cafe8f3d8378ff2/Untitled%204.png)

## 스케줄링의 단계 (Level)

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(1)%202bd3846be41a4c679cafe8f3d8378ff2/Untitled%205.png)

## 스케줄링 정책(Policy)

→ 방법

1. **선점 vs 비선점**
    - Preemptive scheduling, Non-preemptive scheduling

1. **우선순위**
    - Priority

## Preemptive/Non-preemptive scheduling

- **Non-preemptive sheduling(비선점) → 누가 내 것을 뺏을 수 없다.**
    - 할당 받을 자원을 스스로 반납할 때까지 사용
        - 예) system call, I/O, Etc.
    - 장점
        - Context switch overhead가 적음
    - 단점
        - 잦은 우선순위 역전(우선순위가 높은 일을 먼저 처리 못하는 현상), 평균 응답 시간 증가

- **Preemptive scheduling(선점) → 누가 내 것을 빼앗을 수 있다.**
    - 타의에 의해 자원을 빼앗길 수 있음
        - 예) 할당 시간 종료, 우선순위가 높은 프로세스 등장
    - Context switch overhead가 큼
    - Time-sharing system, real-time system 등에 적합 → 응답성 위!

## Priority → 우선순위

- **프로세스의 중요도**

- **Static priority(정적 우선순위) → 한 번 우선순위가 정해지면 계속 유지됨.**
    - 프로세스 생성시 결정된 priority가 유지 됨
    - 구현이 쉽고, overhead가 적음 → 장점
    - 시스템 환경 변화에 대한 대응이 어려움 → 단점 (아까는 a가 급했는데, 지금은 b가 급해!)

- **Dynamic priory(동적 우선순위) → 우선순위를 바꾸는 정책**
    - 프로세스의 상태 변화에 따라 priority 변경
    - 구현이 복잡, priority 재계산 overhead가 큼 → 단점
    - 시스템 환경 변화에 유연한 대응 가능 → 장점

![Untitled](%5BOS%5DLecture%205%20Process%20Scheduling(1)%202bd3846be41a4c679cafe8f3d8378ff2/Untitled%206.png)

## 요약: Scheduling Concepts

- **멀티프로그래밍(멀티테스킹)**

- **스케줄링 개념**
    - 목적
    - 성능 지표(index)
        - cpu burst vs I/O burst
    - 스케줄링 기준(Criteria)

- **스케줄링 레벨**
    - long-term, mid-term, short-term

- **스케줄링 정책**
    - Preemptive/Non-preemptive
    - Priority
