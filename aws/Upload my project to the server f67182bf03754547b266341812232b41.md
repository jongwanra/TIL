# Upload my project to the server

## 1. File Zilla 다운

[Download FileZilla Client for Windows (64bit x86)](https://filezilla-project.org/download.php)

### 2. 가비아 도메인 구입

### 3. AWS

[](https://ap-northeast-2.console.aws.amazon.com/ec2/v2/home?region=ap-northeast-2)

- 오른 쪽 상단의 지역이 '서울'인지 확인
- 인스턴스(컴퓨터 한대) → 인스턴스를 산다.
    - "인스턴스" 클릭
    - "인스턴스 시작" 클릭
    - 클릭(linux 기반 Ubuntu 계열 Server 선택)

    ![Untitled](Upload%20my%20project%20to%20the%20server%20f67182bf03754547b266341812232b41/Untitled.png)

    ![Untitled](Upload%20my%20project%20to%20the%20server%20f67182bf03754547b266341812232b41/Untitled%201.png)

    - 선택 후, 검토 및 시작 클릭

    - 컴퓨터를 샀을 때, 그 컴퓨터에 원격 접속을 가능하게 해주는 키 (키 페어)

    ![Untitled](Upload%20my%20project%20to%20the%20server%20f67182bf03754547b266341812232b41/Untitled%202.png)

    키 페어 다운로드 → 인스턴스 시작 → 인스턴스 보기

    - 1년 동안 무료이다 (끌 수 있는 기능 → 인스턴스 종료 누름)

- 컴퓨터에 원격 접속 해보자.
    - terminal 켜기
    - $sudo chmod 400 (keypair 끌어 당기기)
    - $ssh -i  (keypair 끌어 당기기) [ubuntu@ec2-52-79-249-178.ap-northeast-2.compute.amazonaws.com](mailto:ubuntu@ec2-52-79-249-178.ap-northeast-2.compute.amazonaws.com)

    ![Untitled](Upload%20my%20project%20to%20the%20server%20f67182bf03754547b266341812232b41/Untitled%203.png)

    성공!