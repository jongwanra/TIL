# [OS]Lecture 1. Computer System Overview

## 운영체제란 무엇일까?

→ 하드웨어(컴퓨터 시스템 자원)들을 효율적으로 관리해서 사용자에게 서비스를 제공하는 소프트웨어

![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled.png)

## 하드웨어에는 어떤 것들이 있을까?

- 프로세서(Processor)  → 계산하는 친구들(cpu, gpu, 응용 전용 처리장치 등)
- 메모리(Memory) → 저장하는 친구들(주 기억장치, 보조 기억장치 등)
- 주변장치 → 그 외의 친구들(키보드/마우스, 모니터, 프린터, 네트워크 모뎀 등)

## 프로세서(Processor) → 계산하는 친구들

- 컴퓨터의 두뇌(중앙처리장치)
    - 연산 수행(계산)
    - 컴퓨터의 모든 장치의 동작 제어(제어)

![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%201.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%201.png)

## 레지스터(Register) → 메모리

- **프로세서 내부에 있는 메모리**
    - 프로세서가 사용할 데이터 저장
    - 컴퓨터에서 가장 빠른!! 메모리

- **레지스터의 종류**
    - 용도에 따른 분류

        → 전용 레지스터(정해진 용도로 쓰이는), 범용 레지스터(일반적인 목적으로 쓰이는)

    - 사용자가 정보 변경 가능 여부에 따른 분류

        → 사용자 가시 레지스터, 사용자 불가시 레지스터

    - 저장하는 정보의 종류에 따른 분류

        → 데이터 레지스터(데이터를 저장) , 주소 레지스터(주소를 저장), 상태 레지스터

## 사용자 가시 레지스터

![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%202.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%202.png)

## 사용자 불가시 레지스터

![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%203.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%203.png)

- Program Counter(PC) = 다음에 실행할 명령어의 위치를 가르키고 있는 레지스터
- Instruction Register(IR) = 지금 실행할 명령어(PC를 통해서 가져온)를 가지고 있는 레지스터
- ACCumulator(ACC) = 계산하는 과정에서 값들을 일시적으로 저장하고 있는 레지스터

## 운영체제와 프로세서는 어떤 관계?

→ 운영체제가 하는 역할이 프로세서를 관리하는 역할을 포함한다.

## 메모리 → 저장하는 친구들

- 데이터를 저장하는 장치(기억장치)
- 메모리의 종류

    ![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%204.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%204.png)

위로 올라갈 수록 속도가 빨라지면서 비싸고, 용량은 작아진다.

아래로 내려갈 수록 속도는 느리고, 가격은 싸고, 용량은 크다.

- 주기억장치 (Main memory)
    - 프로세서가 수행할 프로그램과 데이터 저장
    - DRAM을 주로 사용(용량이 크고, 가격이 저렴)
    - 디스크 입출력 병목현상(I/O botteleneck) 해소

    ## 디스크 입출력 병목현상

    → 세월지나면 지날 수록 disk의 속도와 cpu의 속도차이가 커져가면서 둘 사이에 gap이 생기게 되었다. 이걸 해결하는 방법으로 디스크보다는 용량이 작지만 디스크 보단 접근 속도가 빠른 것을 사이에 놓자는 해결 방법을 떠올리게 됨. 

    ![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%205.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%205.png)

    ## 캐시(Cache)

    - 프로세서 내부에 있는 메모리(L1, L2 캐시 등)
        - 속도가 빠르고, 가격이 비싸다
    - 메인 메모리의 입출력 병목현상 해소

    ![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%206.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%206.png)

    ## 캐시의 동작

    - 캐시의 동작
        - 일반적으로 HW적으로 관리 됨
        - 캐시 히트(Cache hit)
            - 필요한 데이터 블록이 캐시 존재
        - 캐시 미스(Cache miss)
            - 필요한 데이터 블록이 없는 경우

         

        ![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%207.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%207.png)

        ## 캐시는 적은 용량으로 효과를 낼 수 있을까?

        ### 지역성(Locality)

        - 공간의 지역성(Spatial locality)
            - 참조한 주소와 인접한 주소를 참조하는 특성(배열, 리스트 등)
        - 시간적 지역성(Temporal locality)
            - 한 번 참조한 주소를 곧 다시 참조하는 특성(for문 등의 순환 문)
        - 지역성은 캐시 적중률(cache hit ratio)와 밀접
            - 알고리즘 성능 향상을 위한 중요한 요소 중 하나이다.

        ![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%208.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%208.png)

        tip: 한 번 가져올때  cache는 블록 단위(cache line)로 데이터를 가져온다.

        예) a[0][0~15]

        결국 A가 훨씬 빠르다. B 같은 경우는 계속 캐시 미스가 난다.

        ## 보조기억 장치

        - 프로그램과 데이터를 저장
        - 프로세서가 직접 접근 불가(주변장치)
        - 주기억장치를 거쳐서 접근
        - 프로그램/데이터 > 주기억장치인 경우엔?
            - 그래서 등장한 것이 가상 메모리(Virtual memory)

                → 하드 디스크의 일부를 메모리 처럼 사용하는 친구이다. 그렇기 때문에 memory 보다 큰 용량의 프로그램을 돌릴 수 있다.

        ## 시스템 버스(System Bus)

        - 하드웨어들이 데이터 및 신호를 주고 받는 물리적인 통로

        ![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%209.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%209.png)

        ![%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%2010.png](%5BOS%5DLecture%201%20Computer%20System%20Overview%2011b4a60fb85647508e70d5f897fd9cd2/Untitled%2010.png)

        ## 주변장치와 운영체제

        - 장치드라이버 관리(주변장치 사용을 위한 인터페이스 제공)
        - 인터럽트(Interrupt) 처리(주변 장치의 요청 처리)
        - 파일 및 디스크 관리
            - 파일 생성 및 삭제
            - 디스크 공간 관리 등