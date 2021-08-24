# [OS]Lecture 9. Virtual Memory(2) -  Paging system(1)

[[OS] Lec 9. Virtual Memory (2/5) - Paging system (Part 1) / 운영체제 강의](https://www.youtube.com/watch?v=mTFYeZwPj0s&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=28)

## Virtual Storage Methods

- **Paging system**
- **Segmentation system**
- **Hybird paging/segmentation system**

## Paging System

- **프로그램을 같은 크기의 블록으로 분할(Pages)**

    *→ 나누어진 블록 : page*

- **Terminologies**
    - Page
        - 프로그램의 분할된 block
    - Page frame *→ 페이지와 같은 크기로 잘려진 메모리 상의 공간을 의미*
        - 메모리의 분할 영역
        - Page와 같은 크기로 분할

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(2)%20-%20Paging%20system(1)%207310ccac6b924df9b4ae9738d784083e/Untitled.png)

- **특징**
    - 논리적 분할이 아님(크기에 따른 분할)
        - Page 공유(sharing) 및 보호(protection) 과정이 복잡함
            - Segmentation 대비 → *segmentation에 비해서*
        - Simple and Efficient
            - Segmentation 대비
        - No external fragmentation
            - Internal fragmentation 발생 가능 → *페이지를 일정한 크기로 자르 다보면 마지막에 나머지가 생길 수 있다.*

## Address Mapping

- **Virtual address : v = (p, d)**
    - p : page number
    - d : displacement(offset)

- **Address mapping**
    - PMT(Page Map Table) 사용

- **Address mapping mechanism**
    - Direct mapping (직접 사상) *→ block mapping과 유사*
    - Associative mapping(연관 사상)
        - TLB(Translation Look-aside Buffer)
    - Hybrid direct/associative mapping

- **Page Map Table(PMT)**

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(2)%20-%20Paging%20system(1)%207310ccac6b924df9b4ae9738d784083e/Untitled%201.png)

- **Direct mapping**
    - Block mapping 방법과 유사
    - 가정
        - PMT를 커널 안에 저장
        - PMT entry size = entrySize *→ 1 row의 크기*
        - Page size = pageSize *→ Process가 나누어 놓은 크기*

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(2)%20-%20Paging%20system(1)%207310ccac6b924df9b4ae9738d784083e/Untitled%202.png)

- 흐름
    1. 해당 프로세스의 PMT가 저장되어 있는 주소 b에 접근
    2. 해당 PMT에서 page p에 대한 entry 찾음
        1. p의 entry 위치 = b + p * entrySize
    3. 찾아진 entry의 존재 비트 검사
        1. Residence bit  = 0 인 경우 (page fault) 

            *→ context switching 발생 (I/O) overhead가 큼*

            swap device에서 해당 page를 메모리로 적재 PMT를 갱신한 후 3 - b 단계 수행

        2. Residence bit = 1 인 경우, 해당 entry에서 page frame 번호 p'를 확인
    4. p`와 가상 주소의 변위 d를 사용하여 실제 주소 r 형성
        1. r = p` * pageSize + d
    5. 실제 주소 r로 주기억장치에 접근

- 문제점
    - 메모리 접근 횟수가 2배
        - 성능 저하(performance degradation)
    - PMT를 위한 메모리 공간 필요

- 해결방안
    - Associative mapping(TLB)
    - PMT를 위한 전용 기억장치(공간)사용
        - Dedicated register or cache memory
    - Hierarchical paging
    - Hashed page table
    - Inverted page table

## Associative Mapping

- **TLB(Translation Look-aside Buffer)에 PMT 적재**
    - Associative high-speed memory

- **PMT를 병렬 탐색**

- **Low overhead, high speed**

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(2)%20-%20Paging%20system(1)%207310ccac6b924df9b4ae9738d784083e/Untitled%203.png)

- **Expensive hardware *→ 비쌈(단점)***
    - 큰 PMT를 다루기가 어려움

## Hybrid Direct/Associative Mapping

- **두 기법을 혼합하여 사용**
    - HW 비용은 줄이고, Associative mapping의 장점 활용

- **작은 크기의 TLB 사용**
    - PMT : 메모리(커널 공간)에 저장
    - TLB : PMT 중 일부 entry들을 적재
        - 최근에 사용된 page들에 대한 entry 저장

    - Locality(지역성) 활용
        - 프로그램의 수행과정에서 한 번 접근한 영역을 다시 접근(temporal locality) 또는 인접 영역을 다시 접근(spatial locality)할 가능성이 높음

- **흐름**
    - 프로세스의 PMT가 TLB에 적재되어 있는지 확인
        1. TLB에 적재되어 있는 경우,
            1. residence bit를 검사하고 page frame번호 확인

        1. TLB에 적재되어 있지 않은 경우,
            1. Direct mapping으로 page frame 번호 확인
            2. 해당 PMT entry를 TLB에 적재함

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(2)%20-%20Paging%20system(1)%207310ccac6b924df9b4ae9738d784083e/Untitled%204.png)