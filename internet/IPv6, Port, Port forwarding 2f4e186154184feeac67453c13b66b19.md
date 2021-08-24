# IPv6, Port, Port forwarding

![Untitled](IPv6,%20Port,%20Port%20forwarding%202f4e186154184feeac67453c13b66b19/Untitled.png)

- 자신이 만든 홈페이지를 내 IP를 이용해서 접속을 했을 때 안 되는 경우는, 사설 IP를 사용 중이기 때문이다.

## 왜 안될까?

## IP의 숫자는 몇 개 일까?

- 0.0.0.0 ~ 255.255.255.255(IP 주소는 해당 범위 내에 존재 - 총 42억 개)

    → IP 수가 부족하다.( 핸드폰을 샀는데  핸드폰을 사용 가능한 번호가 없다는 뜻)

**→ 서버에 접속할 수 없는 이유를 IP주소 부족의 문제의 틀에서 생각해보자.**

## IP고갈 문제를 해결하기 위한 방법

- **IPv6**
    - IPv4 예시: 222.109.62.43
    - IPv6 예시: 2001:0db8:85a3:08d3:1319:8a2e:0370:7334

        → 총 2^128  개 만들어낼 수 있다. 

- **사설 IP(Private IP)**
    - 왜 접속이 안될까? → 공유기가 설치가 되어있기 때문일 가능성이 큼
    - 공유기란?

        ![Untitled](IPv6,%20Port,%20Port%20forwarding%202f4e186154184feeac67453c13b66b19/Untitled%201.png)

    - 무선으로 통신하는 방법: Wi-fi

![Untitled](IPv6,%20Port,%20Port%20forwarding%202f4e186154184feeac67453c13b66b19/Untitled%202.png)

→ IP를 찾을 때, 자신의 컴퓨터의 주소가 아닌 공유기의 IP주소가 나오기 때문에 접속할 수 없었던 것.

- 포트포워딩(port forwarding)을 통해 가능!

## PORT

 

![Untitled](IPv6,%20Port,%20Port%20forwarding%202f4e186154184feeac67453c13b66b19/Untitled%203.png)

## Port Forwarding

- 포워딩을 이용해서 무언가를 토스한다는 느낌

![Untitled](IPv6,%20Port,%20Port%20forwarding%202f4e186154184feeac67453c13b66b19/Untitled%204.png)

- 사용자가 80번 포트를 통해 공유기로 들어온다면, 그것을 웹서버가 있는 IP주소로 포워딩을 해줘야 한다.
- 공유기의 관리자로 들어가서, 웹서버로 토스하도록 설정해야함.

## Reference

- [https://opentutorials.org/course/1688/9483](https://opentutorials.org/course/1688/9483)