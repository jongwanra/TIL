# [OS]Lecture 3. Process Management(2)

[[OS] Lecture 3. Process Management (2/2) / 운영체제 강의](https://www.youtube.com/watch?v=MJTr37lgaMA&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=6)

## 인터럽트(Interrupt)

→ 누가 옆에서 쿡 찌른다.

- **예상치 못한, 외부에서 발생한 이벤트**
    - Unexpected, external events

- **인터럽트의 종류**
    - I/O interrupt → ex) 게임 중에 마우스 클릭, 키보드를 누름
    - Clock interrupt → ex) CPU
    - Console interrupt → ex) console 창에서 발생함
    - Program check interrupt
    - Machine check interrupt
    - Inter-process interrupt → 다른 프로세스에서 발생함
    - System call interrupt

## 인터럽트 처리 과정

![%5BOS%5DLecture%203%20Process%20Management(2)%209296b03314e7431e819ba8cf950f318a/Untitled.png](%5BOS%5DLecture%203%20Process%20Management(2)%209296b03314e7431e819ba8cf950f318a/Untitled.png)

⇒ 인터럽트가 발생 → 커널이 개입해서 프로세스를 중단시키고 발생한 인터럽트를  2단계에 걸쳐서 처리 해준다.  

1. Interrupt handling (인터럽트 발생 장소, 원인 파악 후 인터럽트 서비스를 할 것인지 결정)
2. Interrupt service (인터럽트 서비스 루틴 호출)

조금 더 자세히 들여다 보자.

![%5BOS%5DLecture%203%20Process%20Management(2)%209296b03314e7431e819ba8cf950f318a/Untitled%201.png](%5BOS%5DLecture%203%20Process%20Management(2)%209296b03314e7431e819ba8cf950f318a/Untitled%201.png)

1. 프로세스 Pi가 수행중에 누가 interrupt를 발생시킴. 
2.  kernel이 개입되서 Pi를 잠시 중단시키고,  그때 Context saving이 발생하고 PCB(i)에 저장한다. (흐름을 저장해놓는다.) 
3.  kernel은 Interrupt가 어디서, 왜 발생했는지를 파악 한다.(Interrupt handling) 
4.  처리 하는데 어떤 서비스 루틴을 호출 할지 결정 한 후, Pi는 빠져 나오고 그 자리에 interrupt service program이 프로세스에 들어가서 실행 된다. 
5. 서비스가 끝나고 나서 비어진 프로세서 자리에 ready 상태에서 기다리고 있던 프로세스가 들어간다. Pj가 가지고 있던 책갈피를 복구시키고 프로세서 안에 들어가서 자신의 일을 수행하게 된다.

## Context Switching(문맥 교환)

- **Context**
    - 프로세스와 관련된 정보들의 집합 → context는 두 군데 정보가 저장되게 된다.
        1. CPU register context ⇒ in CPU
        2. Code & data, Stack, PCB ⇒ in memory

- **Context saving**
    - 현재 프로세스의 Register context를 저장하는 작업

- **Context restoring**
    - Register context를 프로세스로 복구하는 작업

- **Context switching( = Process switching)**
    - 실행 중인 프로세스의 context를 저장하고 앞으로 실행 할 프로세스의 context를 복구 하는 일
        - 커널의 개입으로 이루어짐

## Context Switch Overhead

- **Context switching에 소요되는 비용**
    - os마다 다름
    - os의 성능에 큰 영향을 줌

- **불필요한 Context switching을 줄이는 것이 중요**
    - 예, 줄이는 방법: 스레드(thread) 사용 등