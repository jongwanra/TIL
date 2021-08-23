# [OS]Lecture 8. Memory Management(1) -  Backgrounds

[[OS] Lec 8. Memory Management (1/3) - Backgrounds / 운영체제 강의](https://www.youtube.com/watch?v=es3WGii_7mc&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=24)

## 메모리(기억장치)의 종류

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(1)%20-%20Backgrounds%209138bf87f1574632b8e307d9308866a1/Untitled.png)

## 메모리(기억장치) 계층 구조

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(1)%20-%20Backgrounds%209138bf87f1574632b8e307d9308866a1/Untitled%201.png)

- **Block**
    - 보조기억장치와 주기억장치 사이의 데이터 전송 단위 → 최소 단위
    - Size : 1 ~ 4KB
- **Word**
    - 주기억장치와 레지스터 사이의 데이터 전송 단위
    - Size : 16 ~ 64bits

    → 내 컴퓨터 혹은 CPU는 32bit, 64bit라고 불리는 기준 : Word 단위

         레지스터 하나의 크기가 64bit 이고, 메모리에서 데이터를 읽을 때 64bit씩 읽는다고 이해하면 됨.

## Address Binding

→ 주소를 묶는다는 뜻

- **프로그램의 논리 주소를 실제 메모리의 물리 주소로 매핑(mapping)하는 작업**

- **Binding 시점에 따른 구분**
    - Compile time binding
    - Load time binding
    - Run time binding → 실행 중 어드레스 할당

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(1)%20-%20Backgrounds%209138bf87f1574632b8e307d9308866a1/Untitled%202.png)

→ Compile 한다 : Source code를 Object module로 변환한다.

→ Linker : Object module을 (라이브러리를 사용했을 때) Other object module과 묶어서 실행 가능한 형태의 Load module(.exe 실행파일)로 만드는 작업.

→ Loader : Load module을 클릭하여 메모리에 올리는 작업.

- **Compile time binding**
    - 프로세스가 메모리에 적재될 위치를 컴파일러가 알 수 있는 경우
        - 위치가 변하지 않음
    - 프로그램 전체가 메모리에 올라가야 함

- **Load time binding**
    - 메모리 적재 위치를 컴파일 시점에서 모르면, 대체 가능한 상대 주소를 생성
    - 적재 시점(load time)에 시작 주소를 반영하여 사용자 코드 상의 주소를 재설정
    - 프로그램 전체가 메모리에 올라가야 함

    ![Untitled](%5BOS%5DLecture%208%20Memory%20Management(1)%20-%20Backgrounds%209138bf87f1574632b8e307d9308866a1/Untitled%203.png)

- **Run-time binding → 실행 시간에 주소를 할당하겠다.**
    - Address binding 을 시행시간까지 연기

           → ready 상태 ⇒ running 상태가 될때 상태를 정의해 주겠다.

        - 프로세스가 수행 도중 다른 메모리 위치로 이동할 수 있음

    - HW의 도움이 필요
        - MMU: Memory Management Unit

    - 대부분의 OS가 사용

    ![Untitled](%5BOS%5DLecture%208%20Memory%20Management(1)%20-%20Backgrounds%209138bf87f1574632b8e307d9308866a1/Untitled%204.png)

## Dynamic Loading

- **모든 루틴을 교체 가능한 형태로 디스크에 저장**

- **실제 호출 전까지는 루틴을 적재하지 않음**
    - 메인 프로그램만 메모리에 적재하여 수행
    - 루틴의 호출 시점에 address binding 수행

- **장점**
    - 메모리 공간의 효율적 사용

## Swapping

- 프로세서 할당이 끝나고 수행 완료된 프로세스는 swap-device로 보내고 (Swap-out)
- 새롭게 시작하는 프로세스는 메모리에 적재 (Swap-in)

![Untitled](%5BOS%5DLecture%208%20Memory%20Management(1)%20-%20Backgrounds%209138bf87f1574632b8e307d9308866a1/Untitled%205.png)