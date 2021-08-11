# [OS]Lecture 2. OS Overview(1/3)

[[OS] Lecture 2. OS Overview (1/3) / 운영체제 강의](https://www.youtube.com/watch?v=nxl_cUd55Ag&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=2)

## 운영체제의 역할(4가지)

1. User Interface(편리성)
    - CUI(Character user interface)  - 과거에는 문자로 서로 주고 받음.
    - GUI(Graphical User interface) - 그림 형태로 서로 주고 받음.
    - EUCI(End-User Comfortable Interface) - mp3 플레이어 같은 것들.

2. Resource management(효율성) - 자원(H/W)들을 효율적으로 관리 하는 역할
    - HW resource(processor, memory, I/O devices, Etc.)
    - SW resource (file, application, messagem signal, Etc.)

3. Process and Thread management

1. System management(시스템 보호)

## 컴퓨터 시스템은 어떻게 구성되어져 있을까?

![%5BOS%5DLecture%202%20OS%20Overview(1%203)%200a777c4714924dad97842133ee47a94c/Untitled.png](%5BOS%5DLecture%202%20OS%20Overview(1%203)%200a777c4714924dad97842133ee47a94c/Untitled.png)

- 컴퓨터 하드웨어 위에 OS가 존재하고, OS위에 사용자들이 사용하는 프로그램들이 존재한다.
- Kernel : 운영체제의 핵심
- System Call Interface
    - 필요한 기능을 요청하는 통로(커널을 사용자 마음대로 조작하지 못하도록 하기 위함)
    - 커널이 제공하는 기능들 중에 사용자가 사용할 수 있는 기능들을 모아놓은 것들

![%5BOS%5DLecture%202%20OS%20Overview(1%203)%200a777c4714924dad97842133ee47a94c/Untitled%201.png](%5BOS%5DLecture%202%20OS%20Overview(1%203)%200a777c4714924dad97842133ee47a94c/Untitled%201.png)

- 시스템 라이브러리 → System Call Interface

## 운영체제의 구분

3가지 형태로 운영체제를 구분하고 있다.

- 동시 사용자 수(운영체제를 혼자쓰나 여러명이 쓰나)
    - Single-user system
    - Multi-user system

- 동시 실행 프로세스 수
    - Single-tasking system
    - Muiti-tasking system(Muitiprogramming system)

- 작업 수행 방식(사용자가 느끼는 사용 환경)
    - Batch processing system
    - Time-sharing system
    - Distributed processing system
    - Real-time system

## 동시 사용자 수

- **단일 사용자(Single-user system)**
    - 한 명의 사용자만 시스템 사용 가능
        - 한 명의 사용자가 모든 시스템 자원 독점
        - 자원관리 및 시스템 보호 방식이 간단
    - 개인용 장비(pc, mobile) 등에 사용
        - windows 7/10, android, ms-dos 등

- 다중 사용자(Multi-user system)
    - 동시에 여러 사용자들이 시스템 사용
        - 각종 시스템 자원(파일 등)들에 대한 소유 권한 관리 필요
        - 기본적으로 Multi-tasking 기능 필요
        - OS의 기능 및 구조가 복잡
    - 서버, 클러스터(cluster)장비 등에 사용
        - Unix, Linux, Windows server 등

## 동시 실행 프로세스 수

- 단일작업(Single-tasking system)
    - 시스템 내에 하나의 프로세스만 존재
        - 하나의 프로그램 실행을 마친 뒤에 다른 프로그램의 실행
    - 운영체제의 구조가 간단
    - 예) ms-dos

- 다중작업(Multi-tasking system)
    - 동시에 여러 프로세스 수행 가능
        - 작업들 사이의 동시 수행, 동기화 등을 관리해야 함
    - 운영체제의 기능 및 구조가 복잡
    - 예) Unix/Linux, Windows 등