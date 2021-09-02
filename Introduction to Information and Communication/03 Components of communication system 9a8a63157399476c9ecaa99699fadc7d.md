# 03. Components  of communication system

→  여러번 반복해서 들어야 하는 강의..!  (통신 시스템의 구조 및 흐름에 관한 강의)

## 통신 시스템의 구성 요소

1. **통신 시스템의 구성**

    ![Untitled](03%20Components%20of%20communication%20system%209a8a63157399476c9ecaa99699fadc7d/Untitled.png)

![Untitled](03%20Components%20of%20communication%20system%209a8a63157399476c9ecaa99699fadc7d/Untitled%201.png)

- 가정에서 컴퓨터에서 전달된 디지털 데이터를 공중 전화망(PSTN)을 통해 전달하기 위해서 모뎀에 연결하였다.
- 모뎀(Modem)은 디지털 테이터를 아날로그 신호로 변환하는 신호 변환기이다.
- 공중 전화망은 컴퓨터가 등장되기 이전부터 있었던 공공의 네트워크이고 음성 대역(300~ 3,400Hz)의 신호를 전달하기 위해서 설계되었다. 지금은 공공의 디지털망인 공중데이터망(PSDN)을 주로 사용한다.
- 공중 전화망을 통해 전달된 신호는 통신 서비스 업체에 있는 모뎀을 만나 다시 디지털 신호로 복조 된다.

1. **통신 시스템의 분류**

![Untitled](03%20Components%20of%20communication%20system%209a8a63157399476c9ecaa99699fadc7d/Untitled%202.png)

- 데이터 전송 시스템의 3대 구성 요소
    - 단말장치, 데이터 전송회선, 통신제어장치

1. **단말장치(DTE)**
    1. 사용자 인터페이스 장비이다.
    2. 단말장치는 사용자가 통신 시스템을 사용하기 위하여 접속하는 부분이다.
    3. 통신 사용자의 손으로 접촉되면 모두 단말장치라고 할 수 있다.
    4. 컴퓨터, 전화, 휴대폰, 팩시밀리 등이 모두 단말장치이다.

2. **신호 변환기(DCE, 회선종단장치)**
    1. 전송 데이터를 통신회선(통신망)에 적합하도록 신호를 변경하는 장치이다.
    2. 송수신 데이터가 올바르게 전달되도록 동기를 유지한다
    3. 오류제어 기능을 추가할 수 있다.

    - 신호 변환기의 종류: 모뎀, DSU, CODEC, Telephone가 있다.

3. **통신제어장치(CCU)**
    1. 데이터 전송에 필요한 각종 제어를 모두 담당한다.
    2. 송수신 되는 자료를 제어, 감시한다.
    3. 전송 속도와 중앙처리장치의 처리속도 사이에서 조정한다.
    4. 통신 회선과의 전기적인 결함을 담당한다.
    5. 전송 문자 및 메시지를 조립, 분해한다.
    6. 송수신 제어 및 전송 제어를 담당한다.
    7. 통신 회선의 감시 및 접속 제어를 담당한다.
    8. 시작과 종료 제어, 송신권 제어, 교환 분기를 담당한다.
    9. 동기제어, 오류제어, 흐름제어, 응답제어를 한다.
    10. 제어 정보 식별, 기밀 보호, 관리 기능을 한다.
    11. 다중 접속 제어 기능을 수행한다.

## Reference

- [https://www.youtube.com/watch?v=6UaAH3zl6kU](https://www.youtube.com/watch?v=6UaAH3zl6kU)