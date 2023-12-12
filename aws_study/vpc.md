# VPC

## VPC란?
* Virtual Private Cloud의 약자이다.
* AWS에서 본인만의 사설 네트워크를 만들어 주는 서비스이다.
* VPC는 집에 있는 IP공유기와 비슷하다.(IP공유기는 사설 네트워크를 만들어 준다.)
* VPC라는 큰 네트워크를 만들고, 이 큰네트워크 안에 용도 별로 영역을 쪼개서 사용한다. 이 영역을 서브넷이라고 한다.


## Subnet?
* Sub Network의 약자이다.
* VPC를 나눈 영역을 말한다.
* Subnet은 Private Subnet과 Public Subnet으로 나뉜다.
  * Private Subnet은 외부와 통신이 불가능하다.
  * Public Subnet은 외부와 통신이 가능하다.

리
## Default VPC를 사용하면 왜 안될까?
Default VPC는 Public Subnet만 존재하기 때문에 외부에서 접근이 가능하다. 따라서 보안상의 이유로 Default VPC를 사용하지 않는다. 

## CIDR란?

* AWS의 모든 네트워크는 CIDR라는 주소 체계를 사용한다.
* 10.0.1.0/24이라는 CIDR가 있다고 하면 여기서 **24**은 `Prefix`라고 한다.
  * Prefix는 0~32까지 존재한다.
  * 10.0.1.0을 2진수로 바꾸면 00001010.00000000.00000001.00000000이다.
  * 이떄 Prefix가 24이라는 것은 앞에서부터 24개의 비트를 고정하고 나머지 8개의 비트를 사용한다는 것을 의미한다.
  * 즉 00001010.00000000.00000001까지는 고정, 이 외의 .00000000은 가변적으로 바뀌는 거라고 볼 수 있다.
  * 가변적인 부분인 8bit의 경우의 수는 2^8 = 256개(0 ~ 255)의 IP를 사용할 수 있다.


## Internet Gateway란?

* VPC에 하나만 붙일 수 있다.
* 퍼블릭 서브넷에 있는 인스턴스들이 외부와 인터넷을 할 수 있는 통로이다.

## NAT Gateway란?
* Network Address Translation의 약자이다.


## 참고

* [스타트업 성장과 함께하는 AWS 클라우드 아키텍쳐 올인원](https://www.inflearn.com/course/%EC%8A%A4%ED%83%80%ED%8A%B8%EC%97%85-with-aws-1)
