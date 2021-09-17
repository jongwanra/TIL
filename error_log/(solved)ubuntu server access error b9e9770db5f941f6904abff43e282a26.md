# (solved)ubuntu server access error

### Occured Error

![Untitled]((solved)ubuntu%20server%20access%20error%20b9e9770db5f941f6904abff43e282a26/Untitled.png)

전에도 이런 Permission denied (pulickey) 에러가 생겼었는데 무슨 이유 때문일까 ...

### Solution

하.. 30분 정도 찾았는데 결국, 스펠링 에러였다.

ubunto가 아니라 ubuntu인걸 명심하자.. ㅠㅠ 

### 배포 방법

1. $sudo chmod 400 (keypair 끌어 당기기)
2. $ssh -i (keypair 끌어 당기기) [ubuntu@ec2-52-79-249-178.ap-northeast-2.compute.amazonaws.com](mailto:ubuntu@ec2-52-79-249-178.ap-northeast-2.compute.amazonaws.com)