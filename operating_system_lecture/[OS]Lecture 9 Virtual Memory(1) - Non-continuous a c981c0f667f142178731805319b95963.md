# [OS]Lecture 9. Virtual Memory(1) -  Non-continuous allocation

[[OS] Lec 9. Virtual Memory (1/5) - Non-continuous allocation / 운영체제 강의](https://www.youtube.com/watch?v=YCfP9I4K-8Y&list=PLBrGAFAIyf5rby7QylRc6JxU5lzQ9c4tN&index=27)

## Virtual Storage (Memory)

- **Non-continuous allocation → process를 분할한 상태에서 연속되지 않게 메모리에 할당시키는 기법**
- **사용자 프로그램을 여러 개의 block으로 분할**
- **실행 시, 필요한 block들만 메모리에 적재**
    - 나머지 block들은 swap device(disk)에 존재

- **기법들**
    - Paging system
    - Segmentation system
    - Hybrid paging/segmentation system → 위에 두가지를 섞은 기법

## Address Mapping

- **Continuous allocation**
    - Relative address(상대 주소)
        - 프로그램의 시작 주소를 0으로 가정한 주소
    - Relocation(재배치)
        - 메모리 할당 후, 할당된 주소(allocation address)에 따라 상대 주소들을 조정하는 작업

- **Non-continuous allocation**
    - Virtual address(가상주소) = relative address
        - Logical address(논리주소)
        - 연속된 메모리 할당을 가정한 주소
    - Real address(실제주소) = absolute(physical)
        - 실제 메모리에 적재된 주소
    - **Address mapping**
        - Virtual address ⇒ real address

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(1)%20-%20Non-continuous%20a%20c981c0f667f142178731805319b95963/Untitled.png)

## Block Mapping

- **사용자 프로그램을 block 단위로 분할/ 관리**
    - 각 block에 대한 address mapping 정보 유지

- **Virtual address : v = (b, d)**
    - b = block number
    - d = displacement(offset) in a block

        → d는 시작점으로 부터 얼마만큼 떨어져있는지를 나타냄.

- **Block map table(BMT)**
    - Address mapping 정보 관리
        - Kernel 공간에 프로세스마다 하나의 BMT를 가짐

        ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(1)%20-%20Non-continuous%20a%20c981c0f667f142178731805319b95963/Untitled%201.png)

        - Resident bit: 해당 블록이 메모리에 적재되었는지 여부(0 or 1)

    ![Untitled](%5BOS%5DLecture%209%20Virtual%20Memory(1)%20-%20Non-continuous%20a%20c981c0f667f142178731805319b95963/Untitled%202.png)

- **흐름**
    1. **프로세스의 BMT에 접근**
    2. **BMT에서 block b에 대한 항목(entry)를 찾음**
    3. **Residence bit 검사**
        1. Residence bit = 0인 경우, swap device에서 해당 블록을 메모리로 가져옴. BTM업데이트 후 3- b 단계 수행
        2. Residence bit = 1인 경우, BMT에서 b에 대한 real address값 확인
    4. **실제 주소 r 계산 (r =  a+ d)**
    5. **r을 이용하여 메모리에 접근**