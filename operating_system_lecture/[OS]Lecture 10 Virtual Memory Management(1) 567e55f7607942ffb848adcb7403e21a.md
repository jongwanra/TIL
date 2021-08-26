# [OS]Lecture 10. Virtual Memory Management(1)

[[OS] Lec 10. Virtual Memory Management (1/6) - Cost model, HW components / 운영체제 강의](https://www.youtube.com/watch?v=W8q3TKB9Lbo&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=32)

## Virtual Memory Management

- **가상 메모리(기억장치)**
    - Non-continuous allocation
        - 사용자 프로그램을 block으로 분할하여 적재/실행
    - Paging/Segmentation system

- **가상 메모리 관리의 목적**
    - 가상 메모리 시스템 성능 최적화 → *일반적인 목적, 목표*

        *→ 성능이란 표현은 모호하기 때문에 지표가 필요*

        - Cost model
        - 다양한 최적화 기법

## Cost Model for Virtual Mem. Sys.

- **Page fault frequency (발생 빈도)**

    → CPU가 보려고 하는 page가 없는 경우 Page fault라고 함.

- **Page fault rate (발생률)**

- **Page fault rate를 최소화 할 수 있도록 전략들을 설계해야 함**
    - Context switch 및 kernel 개입(cost가 높음)을 최소화
    - 시스템 성능 향상

- **Page reference string(d) → 효율적 으로 사용하기 위한 기준으로 사용하기 위함**
    - 프로세스의 수행 중 참조한 페이지 번호 순서
    - (t) = r_1, r_2, ..., r_k, ... r_t
        - r_i = 페이지 번호, r_i ∈ {0, 1, 2, ..., N-1}
        - N : 프로세스의 페이지 수 (0~ N-1)

- **Page fault rate = F(w)**
    - F(w) =  Num.of page faults during w / |w| (페이지의 갯수, 길이)

## Hardware Components

- **Address translation device(주소 사상 장치) → *주소 변환 장치***
    - 주소 사상을 효율적으로 수행하기 위해 사용
        - E.g., TLB(associated memories), Dedicated page-table register, Cache memories

- **Bit Vectors**
    - Page 사용 상황에 대한 정보를 기록하는 비트들
    - **Reference bits(used bit)**
        - 참조 비트
    - **Update bits(modified bits, write bits, dirty bits)**

        *→ dirty bit : 여기 있는 데이터가 더럽혀 졌다는 의미*

        - 갱신 비트

## Bit Vector

![Untitled](%5BOS%5DLecture%2010%20Virtual%20Memory%20Management(1)%20567e55f7607942ffb848adcb7403e21a/Untitled.png)

- **Reference bit vector**
    - 메모리에 적재된 각각의 page가 최근에 참조 되었는지를 표시
    - 운영
        - 프로세스에 의해 참조되면 해당 page의 Ref. bit를 1로 설정
        - 주기적으로 모든 reference bit를 0으로 초기화

    - Reference bit를 확인함으로서 최근에 참조된 page들을 확인 가능

    ![Untitled](%5BOS%5DLecture%2010%20Virtual%20Memory%20Management(1)%20567e55f7607942ffb848adcb7403e21a/Untitled%201.png)

- **Update bit vector**
    - Page가 메모리에 적재된 후, 프로세스에 의해 수정 되었는지를 표시
    - 주기적 초기화 없음
    - Update bit = 1 → *메모리에서 나올 때, update해줘야하는지 여부를 적어둠.*
        - 해당 page의 (main memory 상 내용) ≠ (Swap device의 내용)
        - 해당 page에 대한 Write-back (to swap device)이 필요