# [OS]Lecture 9. Virtual Memory(4) -  Segmentation System

[[OS] Lec 9. Virtual Memory (4/5) - Segmentation System / 운영체제 강의](https://www.youtube.com/watch?v=Dprd7V842WY&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=30)

## Segmentation(세분화) System

- **프로그램을 논리적 block으로 분할(segment)**
    - Block의 크기가 서로 다를 수 있음 → *미리 나누는 것이 불가*
    - 예) stack, heap, main procedure, shared lib, Etc.

- **특징**
    - 메모리를 미리 분할 하지 않음
        - VPM과 유사 → *variable partition multi programming과 유사*
    - Segment sharing/protection이 용이 함
    - Address mapping 및 메모리 관리의 overhead가 큼 → *관리하기 복잡함*
    - No internal fragmentation
        - External fragmentation 발생 가능 → *프로세스가 종료될 때, 외부 단편화가 발생한다.*

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(4)%20-%20Segmentation%20Sys%20d78bbaf2668e47f09c8b023ce60ef8eb/Untitled.png)

- **Address mapping**
    - Virtual address: v = (s, d)
        - s:  segment number
        - d: displacement in a segment → *offset*
    - Segment Map Table (SMT)
    - Address mapping mechanism
        - Paging system과 유사

- **Segment Map Table(SMT)**

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(4)%20-%20Segmentation%20Sys%20d78bbaf2668e47f09c8b023ce60ef8eb/Untitled%201.png)

- **Address mapping(direct mapping)**

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(4)%20-%20Segmentation%20Sys%20d78bbaf2668e47f09c8b023ce60ef8eb/Untitled%202.png)

1. **프로세스의 SMT가 저장되어 있는 주소 b에 접근**
2. **SMT에서 segment s의 entry 찾음**
    1. s의 entry 위치 = b + s * entrySize
3. **찾아진 Entry에 대해 다음 단계들을 순차적으로 실행**
    1. 존재 비트가 0인 경우,

        // missing segment fault → *메모리에 없는 경우*

        swap device로 부터 해당 segment를 메모리로 적재

        SMT를 갱신

    2. 변위(d)가 segment 길이보다 큰 경우 ( d > l_s),

        segment overflow exception 처리 모듈을 호출 → *segment 크기를 넘었다.*

    3. 허가되지 않은 연산일 경우 (protection bit field 검사),

        segment protection exception 처리 모듈을 호출

4. **실제 주소 r 계산 ( r = a_s + d)**
5. **r로 메모리에 접근**

- **Memory management**
    - VPM과 유사
        - Segment 적재 시, 크기에 맞추어 분할 후 적재

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(4)%20-%20Segmentation%20Sys%20d78bbaf2668e47f09c8b023ce60ef8eb/Untitled%203.png)

- **Segment sharing/protection**
    - 논리적으로 분할되어 있어, 공유 및 보호가 용이함.

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(4)%20-%20Segmentation%20Sys%20d78bbaf2668e47f09c8b023ce60ef8eb/Untitled%204.png)

## Segmentation System - Summary

- **프로그램을 논리 단위로 분할 (segment)**

    **/메모리를 동적으로 분할**

    - 내부 단편화 문제 없음
    - Segment sharing/protection이 용이함
    - Paging system 대비 관리 overhead가 큼

- **필요한 segment만 메모리에 적재하여 사용**
    - 메모리의 효율적 활용

- **Segment mapping overhead**
    - 메모리 공간 및 추가적인 메모리 접근이 필요
    - 전용 HW 활용으로 해결 가능

## Paging vs Segmentation

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(4)%20-%20Segmentation%20Sys%20d78bbaf2668e47f09c8b023ce60ef8eb/Untitled%205.png)