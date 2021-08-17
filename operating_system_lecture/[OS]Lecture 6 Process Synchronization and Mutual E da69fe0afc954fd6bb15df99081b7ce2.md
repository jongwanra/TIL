# [OS]Lecture 6. Process Synchronization and Mutual Exclusion(2)-SW solutions

[[OS] Lecture 6. Process Synchronization and Mutual Exclusion (2/7) - SW solutions / 운영체제 강의](https://www.youtube.com/watch?v=lY43KR3IItw&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=13)

## Dekker's Algorithm

- **Two process ME을 보장하는 최초의 알고리즘**

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20da69fe0afc954fd6bb15df99081b7ce2/Untitled.png)

## Peterson's Algorithm

- **Dekker's algorithm 보다 간단하게 구현**

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20da69fe0afc954fd6bb15df99081b7ce2/Untitled%201.png)

## N-Process Mutual Exclusion

- **다익스트라**
    - 최초로 프로세스 n개의 상호배제 문제를 소프트웨어적으로 해결
    - 실행 시간이 가장 짧은 프로세스에 프로세서 할당하는 세마포 방법, 가장 짧은 평균 대기시간 제공

## Dijkstra's Algorithm

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20da69fe0afc954fd6bb15df99081b7ce2/Untitled%202.png)

![Untitled](%5BOS%5DLecture%206%20Process%20Synchronization%20and%20Mutual%20E%20da69fe0afc954fd6bb15df99081b7ce2/Untitled%203.png)

→ 2단계를 거쳐서 들어간다.

## SW Solutions

- **SW solution들의 문제점**
    - 속도가 느림
    - 구현이 복잡한
    - ME primitive 실행 중 preemption 될 수 있음
        - 공유 데이터 수정 중은 interruout를 억제 함으로서 해결 가능
            - Overhead 발생
    - Busy waiting → 기다리는데 반복문을 계속 돌고 있는 상태
        - inefficient