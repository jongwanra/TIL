# [OS]Lecture 7. Deadlock(5)-Deadlock detenction and Recovery

[[OS] Lec 7. Deadlock (5/5) - Deadlock detection and Recovery / 운영체제 강의](https://www.youtube.com/watch?v=8XbSgZ2JPQ8&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=23)

## Deadlock Detection(검출)

- **Deadlock 방지를 위한 사전 작업을 하지 않음**
    - Deadlock이 발생 가능

- **주기적으로 deadlock 발생 확인**
    - 시스템이 deadlock 상태인가?
    - 어떤 프로세스가 deadlock 상태인가?

- **Resource Allocation Graph  Graph(RAG) 사용**
    - Deadlock 검출을 위해 사용
    - Directed bipartite Graph

        → 방향성 있고, 2개의 파트로 나눈 그래프(프로세스와 자원으로)

    ![Untitled](%5BOS%5DLecture%207%20Deadlock(5)-Deadlock%20detenction%20and%20%200682c98bb5bc402aaf0b5f9647fbf9a0/Untitled.png)

    - **Directed graph G = (N,E) → 노드들은는 프로세스와 리소스의 집합이다.**
        - N = {Np, Nr} where
            - Np is the set of processes = {P1, P2, ..., Pn}

                and Nr is the set of resources = {R1, R2, ..., Rm}

            ![Untitled](%5BOS%5DLecture%207%20Deadlock(5)-Deadlock%20detenction%20and%20%200682c98bb5bc402aaf0b5f9647fbf9a0/Untitled%201.png)

- **Resource Allocation Graph(RAG)**
    - Edge는 Np와 Nr 사이에만 존재
        - e = (Pi, Rj) : 자원 요청
        - e = (Rj, Pi) : 자원 할당

    ![Untitled](%5BOS%5DLecture%207%20Deadlock(5)-Deadlock%20detenction%20and%20%200682c98bb5bc402aaf0b5f9647fbf9a0/Untitled%202.png)

- **Resource Allocation Graph(RAG)**
    - Rk : k type의 자원
    - tk : Rk의 단위 자원 수 → type k인 자원이 몇개 있는가.
        - For each Rk ∈ Nr, ∃ tk which is the number of units of Rk
    - |(a,b)| : (a,b) edge의 수 → 안에가 숫자가 아니면, a에서 b로 가는 갯수를 의미

    ![Untitled](%5BOS%5DLecture%207%20Deadlock(5)-Deadlock%20detenction%20and%20%200682c98bb5bc402aaf0b5f9647fbf9a0/Untitled%203.png)

- **RAG example**

![Untitled](%5BOS%5DLecture%207%20Deadlock(5)-Deadlock%20detenction%20and%20%200682c98bb5bc402aaf0b5f9647fbf9a0/Untitled%204.png)

→ Deadlock인가?

## Deadlock Detection Method

- **Graph reduction** → deadlock인지 쉽기 파악할 수 있는 방법이 존재.(graph를 줄여 나간다.)
    - 주어진 RAG에서 edge를 하나씩 지워가는 방법

    - **Completely reduced → 다 지워지면 deadlock이 아님.**
        - 모든 edge가 제거 됨
        - Deadlock에 빠진 프로세스가 없음

    - **Irreducible → deadlock이다.**
        - 지울 수 없는 edge가 존재
        - 하나 이상의 프로세스가 deadlock 상태

- **Graph reduction**
    - Unblocked process
        - 필요한 자원을 모두 할당 받을 수 있는 프로세스 → Unblocked process

        ![Untitled](%5BOS%5DLecture%207%20Deadlock(5)-Deadlock%20detenction%20and%20%200682c98bb5bc402aaf0b5f9647fbf9a0/Untitled%205.png)

- **Graph reduction procedure**
    1.  Unblocked process에 연결 된 모든 edge를 제거
    2. 더 이상 unblocked process가 없을 때까지 (1) 반복

    - **최종 Graph에서**
        - 모든 edge가 제거 됨(Completely reduced)
            - 현재 상태에서 deadlock이 없음
        - 일부 edge가 남음(irreducible) → 자원을 할당 받을 수 없는 P가 존재
            - 현재 deadlock이 존재

## Graph Reduction (example 1)

![Untitled](%5BOS%5DLecture%207%20Deadlock(5)-Deadlock%20detenction%20and%20%200682c98bb5bc402aaf0b5f9647fbf9a0/Untitled%206.png)

→ Deadlock이 아니다.

## Graph Reduction(example 2)

![Untitled](%5BOS%5DLecture%207%20Deadlock(5)-Deadlock%20detenction%20and%20%200682c98bb5bc402aaf0b5f9647fbf9a0/Untitled%207.png)

→ Deadlock이다.

- **Graph Reduction**
    - High overhead
        - 검사 주기에 영향을 받음
        - Node의 수가 많은 경우 → 많을 수록 overhead가 커진다.

    - Low overhead deadlock detection methods(Special case)
        - Case-1) Single-unit resources
            - Cycle detection
        - Case-2) Single-unit request in expedient state
            - Knot detection

## Deadlock Avoidance vs Detection

- **Deaadlock avoidance**
    - 최악의 경우를 생각
        - 앞으로 일어날 일을 고려
    - Deadlock이 발생 하지 않음

- **Deadlock detection**
    - 최선의 경우를 생각
        - 현재 상태만 고려
    - Deadlock 발생 시 Recovery 과정이 필요

## Deadlock Recovery

- **Deadlock을 검출 한 후 해결 하는 과정**

- **Deadlock recovery methods**
    - Process termination
        - Deadlock 상태에 있는 프로세스를 종료 시킴
        - 강제 종료 된 프로세스는 이후 재시작 됨
    - Resource preemption
        - Deadlock 상태 해결 위해 선점할 자원 선택
        - 선점 된 자원을 가지고 있는 프로세스에서 자원을 빼앗음
            - 자원을 빼앗긴 프로세스는 강제 종료 됨

## Deadlock Recovery

- **Process termination**
    - Deadlock 상태인 프로세스 중 일부 종료 → 여러개가 deadlock이면 누구를 죽임.

    - **Termination cost model** → 누구를 죽일지를 고르는 방법
        - 종료 시킬 deadlock 상태의 프로세스 선택
        - Termination cost
            - 우선순위 / Process priority
            - 종류 / Process type
            - 총 수행 시간 / Accumulated execution time of the process
            - 남은 수행 시간 / Remaining time of the process
            - 종료 비용 / Accounting cost
            - Etc.

    - **종료 프로세스 선택**
        - Lowest-termination cost process first
            - simple
                - Low overhead
                - 불필요한 프로세스들이 종료 될 가능성이 높음

            - Minimum cost recovery → 최고의 선택
                - 최소 비용으로 deadlock 상태를 해소 할 수 있는 process 선택
                    - 모든 경우의 수를 고려 해야 함
                - Complex
                - High overhead
                    - O(2^k) → 하나의 프로세스당 죽이고 살리는 경우

        - **Resource Preemption → 자원을 뺏는 방법**
            - Deadlock 상태 해결을 위해 선점할 자원 선택
            - 해당 자원을 가지고 있는 프로세스를 종료 시킴
                - Deadlock 상태가 아닌 프로세스가 종료 될 수도 있음
                - 해당 프로세스는 이후 재시작 됨

            - **선점할 자원 선택**
                - Preemption cost model 이 필요 → 기준
                - Minimum cost recovery method 사용
                    - O(r)

        - **Checkpoint-restart method**
            - 프로세스의 수행 중 특점 지점(checkpoint) 마다 context를 저장
            - Rollback을 위해 사용
                - 프로세스 강제 종료 후, 가장 최근의 checkpoint에서 재시작

                ![Untitled](%5BOS%5DLecture%207%20Deadlock(5)-Deadlock%20detenction%20and%20%200682c98bb5bc402aaf0b5f9647fbf9a0/Untitled%208.png)