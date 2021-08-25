# [OS]Lecture 9. Virtual Memory(3) -  Paging system(2)

[[OS] Lec 9. Virtual Memory (3/5) - Paging system (Part 2) / 운영체제 강의](https://www.youtube.com/watch?v=B_QLTChsi04&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=30)

## Memory Management

- **Page와 같은 크기로 미리 분할 하여 관리**
    - Page frame
    - FPM 기법과 유사 → Fixed Partition Multi Programming

- **Frame table**
    - Page frame당 하나의 entry
    - 구성
        - Allocated/available field
        - PID field
        - Link field: For free list(사용 가능한 fp들을 연결)
        - AV: Free list header(free list의 시작점)

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(3)%20-%20Paging%20system(2)%207c3b7bfd5f784ec68ff2697b8fba903c/Untitled.png)

## Page Sharing

- **여러 프로세스가 특정 page를 공유 가능**
    - Non-continuous allocation!

- **공유 가능 page**
    1. Procedure(function) pages
        - Pure code(re-enter code)
    2. Data page
        - Read-only data
        - Read-write data
            - 병행성(concurrency) 제어 기법 관리하에서만 가능

## Page Sharing(Example)

- **Editor 프로그램을 3명이 사용하는 경우**

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(3)%20-%20Paging%20system(2)%207c3b7bfd5f784ec68ff2697b8fba903c/Untitled%201.png)

## Page Sharing

- **Data page sharing**

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(3)%20-%20Paging%20system(2)%207c3b7bfd5f784ec68ff2697b8fba903c/Untitled%202.png)

- **Procedure Page Sharing(Problem)**

*→ 서로 부르는 이름이 다르기 때문에 생기는 문제*

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(3)%20-%20Paging%20system(2)%207c3b7bfd5f784ec68ff2697b8fba903c/Untitled%203.png)

- **Procedure Page Sharing(Solution)**
    - 프로세스들이 shared page에 대한 정보를 PMT의 같은 entry에 저장하도록 함

    → 부르는 이름을 통일 시킴.

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(3)%20-%20Paging%20system(2)%207c3b7bfd5f784ec68ff2697b8fba903c/Untitled%204.png)

## Page Protection(보호)

- **여러 프로세스가 page를 공유 할 때, → *보안의 문제가 발생***
    - Protection bit 사용 → *보안의 문제를 해결하기 위한 방법*

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(3)%20-%20Paging%20system(2)%207c3b7bfd5f784ec68ff2697b8fba903c/Untitled%205.png)

## Paging System - Summary

- **프로그램을 고정된 크기의 block으로 분할(page)**

    **/ 메모리를 block size로 분할 (page frame)**

    - 외부 단편화 문제 없음
    - 메모리 통합/압축 불필요
    - 프로그램의 논리적 구조 고려하지 않음 → *Segmentation System이 생겨난 이유*
        - Page sharing/protection이 복잡

- **필요한 page만 page frame에 적재하여 사용**
    - 메모리의 효율적 활용

- **Page mapping overhead**
    - 메모리 공간 및 추가적인 메모리 접근이 필요
    - 전용 HW활용으로 해결 가능 → *TLB*
        - 하드웨어 비용 증가