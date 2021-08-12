# [OS]Lecture 4. Thread management

[[OS] Lecture 4. Thread management / 운영체제 강의](https://www.youtube.com/watch?v=YlnvCIZQDkw&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=7)

## 강의를 시작하기 전에

- context switch는 비용이 크기 때문에 가능한 줄이는 것이 좋고, 그 과정에서 등장한 친구가 thread(실)이다.

## 프로세스(Process)와 스레드(Thread)

![%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled.png](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled.png)

→ 프로세스는 굉장히 여러가지 형태로 정의가 된다. 

프로세스가 하는 일은 자원을 할당 받고, 그 자원을 제어하여 원하는 목적을 달성을 하는 것이다.

프로세스는 자원과 제어라는 두 가지 요소로 나누어서 생각해 볼 수 있다.

이 중에서 제어라는 부분만 따로 떼어 놓은 것을 스레드라고 부른다.

하나의 Process 안에 여러 개의 스레드가 있을 수 있다. 즉, 제어는 여러개 있을 수 있다라는 뜻.

위 그림으로 이미지화 시켜보면, 프로세스는 하나이지만 자원 할당을 여러개를 받을 수 있고, 그 자원들을 제어하는 것을 스레드라고 한다.

## 스레드(Thread)

- 프로세스는 리소스를 제어하는 친구이다. 제어 영역을 보면 다양한 제어 정보들을 가지고 있다. 예를 들어서 program counter, stack pointer 등과 같은 정보들을 가지고 있다.
- 지역데이터를 사용하는 이유는 제어를 하기 위해서이다. 지역 데이터들은 스택 영역에 저장이 된다. 이것들이 제어에 해당하는 요소이다.
- 제어 부분만 떼어놓은 친구를 스레드라고 한다. 자원은 공유하는데 제어하는 친구들은 여러개 있을 수 있다.

![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%201.png)

메모리 관점에서 보면 다음과 같다.

![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%202.png)

- **Light Weight Process(LWP)** → 프로세스지만 무게가 가벼운 프로세스

    (프로세스는 원래자원과 제어를 각각 가지고있어야 하지만, 스레드 같은 경우는 자원은 공유하고 제어 부분만 가지고 있기 때문에 일반 프로세스 보다는 가볍다.)

- **프로세서(e.g, CPU) 활용의 기본 단위**

- **구성요소**
    - Thread ID
    - Register set(PC, SP 등)
    - Stack(i.e local data) → 자기만의 작업 영역이 존재

- **제어 요소 외 코드, 데이터 및 자원들은 프로세스 내 다른 스레드들과 공유**

- **전통적 프로세스 = 단일 스레드 프로세스**

## Single-thread vs Multi-threads

![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%203.png)

single-thread

![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%204.png)

multi-thread

## 스레드의 장점

→ 장점이 있기 때문에 등장하게 된 스레드

- **사용자 응답성(Responsiveness)**
    - 일부 스레드의 처리가 지연되어도, 다른 스레드는 작업을 계속 처리 가능

- **자원 공유(Resource sharing)**
    - 자원을 공유해서 효율성 증가(커널의 개입(context switch를 사용할 경우)을 피할 수 있음)
        - 예) 동일 address space에서 스레드 여러 개

        → single-thread 같은 경우, context switch(비싼 연산, 가능한 한 피하면 좋다.)가 빈번하게 발생한다.(하나의 프로세서를 번갈아가면서 사용해야 하기 때문)

        → multi-thread 같은 경우, context switch는 발생하지 않는다.

- **경제성(Economy)**
    - 프로세스의 생성, context switch에 비해 효율적

- **멀티 프로세서(multi-processor) 활용**
    - 병렬처리를 통해 성능 향상

## 스레드 사용의 예(장점 중 사용자 응답성과 관련)

![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%205.png)

### 해결방법

![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%206.png)

## 스레드 구현(2가지)

- 사용자 수준 스레드(User thread)
- 커널 수준 스레드(Kernel thread)

## 사용자 수준 스레드(User thread)

- **사용자 영역의 스레드 라이브러리로 구현 됨**
    - 스레드의 생성, 스케줄링 등
    - POSIX threads, Win32 threads, Java thread API 등

    → 라이브러리가 스레드처럼 돌아갈 수 있게 해준다는 뜻

- **커널은 스레드의 존재를 모름**
    - 커널의 관리(개입)을 받지 않음
        - 생성 및 관리의 부하가 적음, 유연한 관리 기능
        - 이식성(portability)이 놓음 → 라이브러리만 존재한다면 다른 컴퓨터에서도 바로 프로그램을 작동 시킬 수 있다.

    - 커널은 프로세스 단위로 자원 할당(단점)
        - 하나의 스레드가 block 상태가 되면, 모든 스레드가 대기

            (single-threaded kernel의 경우)

    ![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%207.png)

    라이브러리를 이용해서 여러개의 스레드를 사용하는 것처럼 함.

    커널 수준 스레드는 1: 사용자 수준 스레드: 여러 개

## 커널 수준 스레드(Kernel Threads)

- **OS(Kernel)가 직접 관리**
- **커널 영역에서 스레드의 생성, 관리 수행**
    - Context switching 등 부하(Overhead)가 큼(단점)

- **커널이 각 스레드를 개별적으로 관리**
    - 프로세스 내 스레드들이 병행 수행 가능(장점)
        - **하나의 스레드가 block 상태가 되어도, 다른 스레드는 계속 작업 수행 가능**

![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%208.png)

→ 1 : 1 매핑

## Multi-Threading Model

![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%209.png)

→ 둘의 단점을 보완한 혼합형 스레드가 등장하게 됨.

## 혼합형 (n:m) 스레드

 

- **n개 사용자 수준 스레드 - m개의 커널 스레드(n ≥ m)**
    - 사용자는 원하는 수 만큼 스레드 사용
    - 커널 스레드는 자신에게 할당된 하나의 사용자 스레드가 block상태가 되어도, 다른 스레드 수행 가능
        - 병렬 처리 가능

- **효율적이면서도 유연함**

![Untitled](%5BOS%5DLecture%204%20Thread%20management%209728ff11f33b4e41a9c6d8f1be7d3e94/Untitled%2010.png)

→ 실제로 사용하는 모델은 혼합형 스레드이다.

→ **스레드의 개념을 잡는 것이 굉장히 중요하다.**

- 자원은 공유하지만 각각의 자신만의 제어요소들을 가지고 있는 것을 스레드라고 한다.
- 자원을 공유하기 때문에 작업을 효율적으로 할 수 있다. 자원 여러개를 동시에 사용 가능하므로 병렬 처리가 가능하다.