# (solved) when upload in server, raised Error(MongoDB)

## Occured Error

> mongo server error: command find requires authentication ubuntu error

AWS EC2 서비스를 이용해, ubuntu 인스턴스를 샀고, 해당 내용을 배포하는 도중에 발생한 에러. 해결하는데 3시간 이상 소요했다.

## Solution

몽고 DB에 접근 방식

- Before
    - "mongodb://localhost:27017/${database}"
- After
    - "mongodb://${ID}:${PWD}@${ec2 server IP address}:27017/${database}?authSource=admin"