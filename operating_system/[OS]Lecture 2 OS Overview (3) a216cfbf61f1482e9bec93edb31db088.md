# [OS]Lecture 2. OS Overview (3/3)

[[OS] Lecture 2. OS Overview (3/3) / 운영체제 강의](https://www.youtube.com/watch?v=knF9lzHA3LI&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=4)

## 운영체제의 구조(2가지로 구성)

1. **커널(Kernel) → '알맹이' 즉, 핵심을 말함.**
    - os의 핵심 부분(메모리 상주) → 메모리에 항상 올라가 있음.
        - 가장 빈번하게 사용되는 기능들 담당
            - 시스템 관리(processor, memory, Etc) 등
    - 동의어
        - 핵(neuleus), 관리자(supervisor) 프로그램, 상주 프로그램(resident program), 제어 프로그램(control program) 등

2. **유틸리티(Utility) → 커널을 제외한 나머지 부분, 가끔씩 사용하는 친구들**
    - 비상주 프로그램
    - UI등 서비스 프로그램

![%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled.png](%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled.png)

하드웨어 →( 커널 → 시스템 콜 → 유틸리티 )→ 어플리케이션

## 단일 구조 운영체제

![%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled%201.png](%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled%201.png)

- **장점**
    - 커널 내 모듈간 직접 통신 → 빠르고 효율적으로 주고 받을 수 있다.
        - 효율적 자원 관리 및 사용

- **단점**
    - 커널의 거대화 → 기능이 추가될 수록 커져감.
        - 오류 및 버그, 추가 기능 구현 등 유지보수가 어려움
        - 동일 메모리에 모든 기능이 있어, 한 모듈의 문제가 전체 시스템에 영향

            (예, 악성 코드 등)

## 계층 구조 운영체제 → 기능별로 따로 관리(현대식)

![%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled%202.png](%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled%202.png)

- **장점**
    - 모듈화
        - 계층간 검증 및 수정 용이
    - 설계 및 구현의 단순화
- **단점**
    - 단일구조 대비 성능 저하
        - 원하는 기능 수행을 위해 여러 계층을 거쳐야 함.

## 마이크로 커널 구조 운영체제

- **커널의 크기 최소화 → 커널이 점점 커지는 거대화를 방지**
    - 필수 기능만 포함
    - 기타 기능은 사용자 영역에서 수행 → 나머지는 사용자영역에서 응용프로그램처럼 실행

![%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled%203.png](%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled%203.png)

## 운영체제의 기능 → 다양한 자원들을 관리한다.

- 프로세스 관리
- 프로세서 관리
- 메모리 관리
- 파일 관리
- 입출력 관리
- 보조 기억 장치 및 기타 주변장치 관리 등

## Process Management

- **프로세스 (Process)**
    - 커널에 등록된 실행 단위(실행 중인 프로그램)
    - 사용자 요청/프로그램의 수행 주체(entity)

- **OS의 프로세스 관리 기능**
    - 생성/삭제, 상태관리
    - 자원 할당
    - 프로세스 간 통신 및 동기화(synchronization)
    - 교착상태(deadlock) 해결

        → 여러 개의 프로세스들이 하나의 자원을 동시에 쓰려고 할때를 중재하는 역할을 운영체제가 관리한다.

- **프로세스 정보 관리**
    - PCB(Procsess Control Bloc)

## Processor Management

- **중앙 처리 장치(CPU)**
    - 프로그램을 실행하는 핵심 자원

- **프로세스 스케줄링(Scheduling)**
    - 시스템 내의 프로세스 처리 순서 결정

- **프로세서 할당 관리**
    - 프로세스들에 대한 프로세서 할당
        - 한 번에 하나의 프로세스만 사용 가능

→ Processor = CPU 같다고 봐도 무방

→ Processor를 누구한테 줄지를 관리

## Memory Management

- **주기억장치( 예) DRAM)**
    - 작업을 위한 프로그램 및 데이터를 올려 놓는 공간

- **Multi-user, Multi-tasking 시스템**
    - 프로세스에 대한 메모리 할당 및 회수
    - 메모리 여유 공간 관리
    - 각 프로세스의 할당 메모리 영역 접근 보호

- **메모리 할당 방법(scheme)**
    - 전체 적재
        - 장점: 구현이 간단
        - 단점: 제한적 공간
    - 일부 적재(virtual memory concept)
        - 프로그램 및 데이터의 일부만 적재
        - 장점: 메모리의 효율적 사용
        - 단점: 보조기억 장치 접근 필요

## File Management

- **파일: 논리적 데이터 저장 단위 → 대표적인 소프트웨어 자원인 파일을 관리하는 일도 운영체제가 함.**

- **사용자 및 시스템의 파일 관리**
- **디렉토리 구조 지원**
- **파일 관리 기능**
    - 파일 및 디렉토리 생성 및 삭제
    - 파일 접근 및 조작
    - 파일을 물리적 저장 공간으로 매핑(mapping)
    - 백업 등.

## I/O Management

- **입출력(I/O) 과정**
    - OS를 반드시 거쳐야 함.

    ![%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled%204.png](%5BOS%5DLecture%202%20OS%20Overview%20(3%203)%20a216cfbf61f1482e9bec93edb31db088/Untitled%204.png)

    → 키보드가 직접 프로세서에 명령을 내릴 수 없고 반드시 운영체제를 거쳐야 한다.

    ## Others

    - **Disk**
    - **Networking**
    - **Security and Protection system**
    - **Command interpreter system**
    - **System call interface**
        - 응용 프로그램과 os 사이의 인터페이스
        - os가 응용프로그램에 제공하는 서비스