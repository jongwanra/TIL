# [OS]Lecture 8. Memory Management(2) -  Fixed Partition Multiprogramming

[[OS] Lec 8. Memory Management (2/3) - Fixed Partition Multiprogramming / 운영체제 강의](https://www.youtube.com/watch?v=te-GU7NKa5Y&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=25)

## Memory Allocation

- **Continuous Memory Allocation(연속할당)**
    - Uni-programming
    - Multi-programming
        - Fixed partition(FPM)
        - Variable partition(VPM)

- **Non-continuous Memory Allocation(비연속할당)**
    - Next chapter!

## Continuous Memory Allocation

- **프로세스(context)를 하나의 연속된 메모리 공간에 할당하는 정책**
    - 프로그램, 데이터, 스택 등

- **메모리 구성 정책**
    - 메모리에 동시에 올라갈 수 있는 프로세스 수
        - Multiprogramming degree
    - 각 프로세스에게 할당되는 메모리 공간 크기
    - 메모리 분할 방법

- **Uni-programming → 1개**
    - Multiprogramming degree = 1 → process가 한 번에 한 개만 올라 간다.

- **Multi-programming**
    - Fixd(static) partition multi-programming (FPM)
        - 고정 분할
    - Variable(dynamic) partition multi-programming (VPM)
        - 가변 분할

## Uni-Programming

- **하나의 프로세스만 메모리 상에 존재**

- **가장 간단한 메모리 관리 기법**

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(2)%20-%20Fixed%20Partiti%20b81eea54d9b94fa88779f74b9cddbd43/Untitled.png)

- **문제점(1)**
    - 프로그램의 크기 > 메모리 크기

- **해결법**
    - Overlay structure

        → 공통된 부분만 올려두고 그렇지 않은 부분은 번갈아 가며 올리는 기법

        - 메모리에 현재 필요한 영역만 적재
        - 사용자가 프로그램의 흐름 및 자료구조를 모두 알고 있어야 함

        ![Untitled](%5BOS%5DLecture%208%20Memory%20Management(2)%20-%20Fixed%20Partiti%20b81eea54d9b94fa88779f74b9cddbd43/Untitled%201.png)

- **문제점(2)**
    - 커널(Kernel) 보호 → 커널영역을 침범해서 올리면 안됨.

- **해결방법**
    - 경계 레지스터 (boundary register) 사용 → 커널 영역을 건드리지 못하도록

    ![Untitled](%5BOS%5DLecture%208%20Memory%20Management(2)%20-%20Fixed%20Partiti%20b81eea54d9b94fa88779f74b9cddbd43/Untitled%202.png)

- **문제점(3) → 메모리 공간의 낭비, 활용도가 적다.**
    - Low system resource utilization
    - Low system performance

- **해결방법**
    - Multi-programming

## Fixed Partition Multiprogramming

- **메모리 공간을 고정된 크기로 분할**
    - 미리 분할되어 있음

- 각 프로세스는 하나의 partition(분할)에 적재
    - Process : Partition = 1 : 1

- Partition의 수 = K
    - Multiprogramming degree = K

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(2)%20-%20Fixed%20Partiti%20b81eea54d9b94fa88779f74b9cddbd43/Untitled%203.png)

- **자료구조의 예**

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(2)%20-%20Fixed%20Partiti%20b81eea54d9b94fa88779f74b9cddbd43/Untitled%204.png)

- **커널 및 사용자 영역 보호**

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(2)%20-%20Fixed%20Partiti%20b81eea54d9b94fa88779f74b9cddbd43/Untitled%205.png)

## Fragmentation (단편화)

- **Internal fragmentation**
    - 내부 단편화 →
    - Partition 크기 > Process 크기
        - 메모리가 낭비 됨 → 이걸 Internal fragmentation이라고 함.

- **External fragmentation**
    - 외부 단편화 → 남은 메모리 공간은 충분하지만, 못들어가는 현상.
    - (남은 메모리 크기 > Process 크기)지만, 연속된 공간이 아님
        - 메모리가 낭비 됨

    ![Untitled](%5BOS%5DLecture%208%20Memory%20Management(2)%20-%20Fixed%20Partiti%20b81eea54d9b94fa88779f74b9cddbd43/Untitled%206.png)

- **요약**
    - 고정된 크기로 메모리 미리 분할
    - 메모리 관리가 간편함
        - Low overhead
    - 시스템 자원(memory)이 낭비될 수 있다.
        - Internal/external fragmentation