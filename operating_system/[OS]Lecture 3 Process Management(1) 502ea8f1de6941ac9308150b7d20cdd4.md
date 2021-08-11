# [OS]Lecture 3. Process Management(1)

[[OS] Lecture 3. Process Management (1/2) / 운영체제 강의](https://www.youtube.com/watch?v=jZuTw2tRT7w&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=5)

## Job vs Process

- **작업(Job) / 프로그램(Program)**
    - 실행 할 프로그램 + 데이터  → 디스크에 보관이 되어 있는 상태(요청 전 상태)
    - 컴퓨터 시스템에 실행 요청 전의 상태

- **프로세스(Process)**
    - 실행을 위해 시스템(커널)에 등록된 작업 → Job이 시스템에 등록 된 상태
    - 시스템 성능 향상을 위해 커널에 의해 관리 됨

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled.png)

→ Job이라고 하는 것은 현재 디스크에 보관되어 있는 상태

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%201.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%201.png)

## 프로세스의 정의

- **실행 중인 프로그램**
    - 커널에 등록되고 커널의 관리하에 있는 작업
    - 각종 자원들을 요청하고 할당 받을 수 있는 개체
    - 프로세스 관리 블록(PCB)을 할당 받은 개체
    - 능동적인 개체(active entity)
        - 실행 중에 각종 자원을 요구, 할당, 반납하며 진행

- **Process Control Block(PCB)**
    - 커널 공간 (kernel space) 내에 존재
    - 각 프로세스들에 대한 정보를 관리

## 프로세스의 종류

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%202.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%202.png)

## 자원(Resource)의 개념

- **커널의 관리 하에 프로세스에게 할당/반납 되는 수동적 개체(passive entity)**

  

- **자원의 분류**
    - H/W resources
        - Processor, memory, disk, monitor, keyboard, Etc.
    - S/W resources
        - Message, signal, files, installed SWs, Etc.

## Process Control Block(PCB)

→ Process를 제어하기 위해서 필요한 정보들을 모아 놓은 공간

- os가 프로세스 관리에 필요한 정보 저장
- 프로세스 생성 시, 생성 됨

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%203.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%203.png)

→ PCB는 커널이 관리하는 영역에 저장되어 있다.

## PCB가 관리하는 정보

- PID : Process Identification Number
    - 프로세스 고유 식별 번호

- 스케줄링 정보
    - 프로세스 우선순위 등과 같은 스케줄링 관련 정보들

- 프로세스 상태
    - 자원 할당, 요청 정보 등

- 메모리 관리 정보
    - Page table, segment table 등

- 입출력 상태 정보
    - 할당 받은 입출력 장치, 파일 등에 대한 정보 등

- 문맥 저장 영역(context save area)
    - 프로세스의 레지스터 상태를 저장하는 공간 등

- 계정 정보 → 다중 사용자 시스템 같은 경우 이 프로세스가 누구꺼인지 알아야 함.
    - 자원 사용 시간 등을 관리

**PCB 정보는 os 별로 서로 다름**

**PCB 참조 및 갱신 속도는 os의 성능을 결정 짓는 중요한 요소 중 하나**

## 프로세스의 상태(Process States)

- **프로세스 - 자원 간의 상호작용에 의해 결정**

- **프로세스 상태 및 특성**

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%204.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%204.png)

## Process State Transition Diagram

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%205.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%205.png)

## Created State

- **작업(Job)을 커널에 등록**
- **PCB 할당 및 프로세스 생성**
- 커널
    - 가용 메모리 공간 체크 및 프로세스 상태 전이 → 어디로 갈것인가에 대한 기준은 **메모리 공간**
        - Ready or Suspended ready

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%206.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%206.png)

## Ready State→ 메모리가 있을 경우

- **프로세서 외에 다른 모든 자원을 할당 받은 상태**
    - 프로세서 할당 대기 상태
    - 즉시 실행 가능 상태

- **Dispatch(or Schedule)**
    - Ready state → running state

    ![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%207.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%207.png)

    → processor(cpu) vs Process(실행 중인 프로그램)

## Running State

- **프로세서와 필요한 자원을 모두 할당 받은 상태**

→ 벗어나는 경우 2가지

1. **Preemption → processor 를 뺏긴 경우**
    - Running state → ready state
    - 프로세서 스케줄링(e.g, time-out, priority changes)

1. **Block/sleep → I/O가 필요한 경우(i/o에서 정보를 가져올 때 까지)**
    - Running state → asleep state
    - I/O 등 자원 할당 요청

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%208.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%208.png)

## Blocked/Asleep State

- **프로세서 외에 다른 자원을 기다리는 상태**
    - 자원 할당은 System call에 의해 이루어 짐

- **Wake-up → 바로 running 상태로 가는 것이 아닌 ready 상태로 들어간다.**
    - Asleep state → ready state

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%209.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%209.png)

## Suspended State → 지연된 상태

→ 메모리가 없는 경우 옮겨지는 상태

- **메모리를 할당 받지 못한(빼앗긴) 상태**
    - Memory image를 swap device에 보관 → 메모리의 상태를 사진으로 찍어둠
        - Swap device: 프로그램 정보 저장을 위한 특별한 파일 시스템
    - 커널 또는 사용자에 의해 발생
- **Swap-out(suspended), Swap-in(resume)**

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%2010.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%2010.png)

## Terminated/Zombie State → 종료된 상태(죽었는데 죽지 않은)

- **프로세스 수행이 끝난 상태**
- **모든 자원 반납 후,**
- **커널 내에 일부 PCB 정보만 남아 있는 상태**
    - 이후 프로세스 관리를 위해 정보 수집

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%2011.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%2011.png)

## 프로세스 관리를 위한 자료구조

- Ready Queue
- I/O Queue
- Device Queue

 

![%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%2012.png](%5BOS%5DLecture%203%20Process%20Management(1)%20502ea8f1de6941ac9308150b7d20cdd4/Untitled%2012.png)

→ asleep 상태에서는 자원 별로 따로 관리하게 된다.