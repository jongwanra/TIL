# [OS]Lecture 8. Memory Management(3) -  Variable Partition Multi-programming

[[OS] Lec 8. Memory Management (3/3) - Variable Partition Multi-programming / 운영체제 강의](https://www.youtube.com/watch?v=o1TB9NWvG9w&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=26)

## Varialbe Partition Multiprogramming

→ partition이 유동적으로 분할될 수 있다.

- **초기에는 전체가 하나의 영역**

- **프로세스를 처리하는 과정에서 메모리 공간이 동적으로 분할**

- **No internal fragmentation → 내부 메모리 낭비가 발생하지 않는다.**

- **VPM Example**
    - Memory space: 120MB

    1. 초기 상태
    2. 프로세스 A(20MB)가 적재된 후
    3. 프로세스 B(10MB)가 적재된 후
    4. 프로세스 C(25MB)가 적재된 후
    5. 프로세스 D(20MB)가 적재된 후
    6. 프로세스 B가 주기억장치를 반납한 후
    7. 프로세스 E(15MB)가 적재된 후
    8. 프로세스 D가 주기억장치를 반납한 후

## 배치 전략(Placement startegies)

- **어디에 배치 할 것인가?**

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(3)%20-%20Variable%20Part%20af7d8dc5a5044b079c96e9db82b8f9f7/Untitled.png)

- **First-fit(최초 적합) → 처음 만나는 공간에 넣어주는 방법**
    - 충분한 크기를 가진 첫 번째 partition을 선택
    - Simple and low overhead
    - 공간 활용률이 떨어질 수 있음

    ![Untitled](%5BOS%5DLecture%208%20Memory%20Management(3)%20-%20Variable%20Part%20af7d8dc5a5044b079c96e9db82b8f9f7/Untitled%201.png)

- **Best-fit (최적 적합)**
    - Process가 들어갈 수 있는 partition 중 가장 작은 곳 선택
    - 탐색시간이 오래 걸림 → overhead가 큼
        - 모든 partition을 살펴봐야 함
    - 크기가 큰 partition을 유지 할 수 있음
    - 작은 크기의 partition이 많이 발생
        - 활용하기 너무 작음

- **Worst-fit (최악 적합)**
    - Process가 들어갈 수 있는 partition 중 가장 큰 곳 선택
    - 탐색시간이 오래 걸림
        - 모든 partition을 살펴봐야 함
    - 작은 크기의 partition 발생을 줄일 수 있음
    - 큰 크기의 partition 확보가 어려움
        - 큰 프로세스에게 필요함.

- **Next-fit (순차 최초 적합)**
    - 최초 적합 전략과 유사
    - State table에서 마지막으로 탐색한 위치부터 탐색
    - 메모리 영역의 사용 빈도 균등화
    - Low overhead

    ![Untitled](%5BOS%5DLecture%208%20Memory%20Management(3)%20-%20Variable%20Part%20af7d8dc5a5044b079c96e9db82b8f9f7/Untitled%202.png)

## Coalescing holes (공간 통합)

- **어디에 배치할 것인가?**

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(3)%20-%20Variable%20Part%20af7d8dc5a5044b079c96e9db82b8f9f7/Untitled%203.png)

- **External fragmentation issue**

- **인접한 빈 영역을 하나의 partition으로 통합**
    - Process가 memory를 release하고 나가면 수행
    - Low overhead

    ![Untitled](%5BOS%5DLecture%208%20Memory%20Management(3)%20-%20Variable%20Part%20af7d8dc5a5044b079c96e9db82b8f9f7/Untitled%204.png)

    → 빨리 들어가야 하는 Process라면?

## Storage Compaction(메모리 압축)

- **모든 빈 공간을 하나로 통합**

- **프로세스 처리에 필요한 적재 공간 확보가 필요할 때 수행**

- **High overhead**
    - 모든 Process 재배치 (Process 중지)
    - 많은 시스템 자원을 소비

- **Example → 자주 해주면 안됨. (일정시간, 요청이 있는 특별한 경우에만 사용)**

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(3)%20-%20Variable%20Part%20af7d8dc5a5044b079c96e9db82b8f9f7/Untitled%205.png)

## 요약: Continuous Memory Allocation

- **Uni-programming**
    - Simple
    - Fragmentation problem

- **Fixed partition multi-programming(FPM)**

- **Variable partition multi-programming(VPM)**
    - Placement startegies
        - First-fit, Best-fit, Worst-fit, Next-fit
    - External fragmentation issue
        - Coalescing hoes
        - Storage compaction

→ 왜?  memory pool기법 참조