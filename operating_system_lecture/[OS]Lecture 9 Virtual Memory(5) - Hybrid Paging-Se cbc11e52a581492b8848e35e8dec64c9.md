# [OS]Lecture 9. Virtual Memory(5) -  Hybrid Paging-Segmentation System

[[OS] Lec 9. Virtual Memory (5/5) - Hybrid Paging-Segmentation System / 운영체제 강의](https://www.youtube.com/watch?v=ctfTntZ-RBo&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=31)

## Hybrid paging/Segmentation system

- **Paging과 Segmentation의 장점 결합**

- **프로그램 분할**
    1. 논리 단위의 segment로 분할
    2. 각 segment를 고정된 크기의 page들로 분할

- **Page단위로 메모리에 적재**

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(5)%20-%20Hybrid%20Paging-Se%20cbc11e52a581492b8848e35e8dec64c9/Untitled.png)

- **Address mapping**
    - Virtual address : v = (s, p, d)
        - s : segment number
        - p : page number
        - d : offset in a page
    - SMT와 PMT 모두 사용
        - 각 프로세스 마다 하나의 SMT
        - 각 segment마다 하나의 PMT → page가 실재로 메모리에 적재됨
    - Address mapping
        - Direct, associated 등
    - 메모리 관리
        - FPM과 유사

- **SMT in hybrid mechanism**

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(5)%20-%20Hybrid%20Paging-Se%20cbc11e52a581492b8848e35e8dec64c9/Untitled%201.png)

*No residence bit → *메모리에 올라가는 건 page이고 segment는 올라가지 않기 때문에 필요하지 않다. 대신 PMT address가 필요함.*

- **PMT for a segment k in hybrid mechanism**

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(5)%20-%20Hybrid%20Paging-Se%20cbc11e52a581492b8848e35e8dec64c9/Untitled%202.png)

- **Address mapping tables**

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(5)%20-%20Hybrid%20Paging-Se%20cbc11e52a581492b8848e35e8dec64c9/Untitled%203.png)

- **Direct (address) mapping**

![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(5)%20-%20Hybrid%20Paging-Se%20cbc11e52a581492b8848e35e8dec64c9/Untitled%204.png)

*→ memory access를 3 번 해야한다는 단점이 존재*

- **Summary**
    - 논리적 분할(segment)와 고정 크기 분할(page)을 결합
        - Page sharing/protection이 쉬움
        - 메모리 할당/관리 overhead가 작음
        - No external fragmentation → *Internal fragmentation 존재*

    - 전체 테이블의 수 증가
        - 메모리 소모가 큼
        - Address mapping 과정이 복잡

    - Direct mapping의 경우, 메모리 접근이 3배
        - 성능이 저하될 수 있음.