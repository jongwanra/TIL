# FTP

## FTP란?

File Transfer Protocol의 약자로 컴퓨터들 사이에서 파일을 전송하기 위한 네트워크 프로토콜이다. 
TCP 기반으로 동작한다. FTP는 Application Layer Protocol에 속해있다. 

## FTP를 사용하는 이유
프로그램의 원본 소스가 올라가 있는 웹상에 접속하여 파일 수정 및 추가 등을 할 때 사용 된다.

## FTP를 사용했을 때 장점?
인터넷을 통한 파일 송수신 만을 위해 고안되었기 때문에 www방식 보다 파일을 빠른 속도로 주고 받을 수 있다.

## FTP를 사용했을 때 단점?
FTP는 보안에 상당히 취약하다. 오로지 빠른 송수신만을 목적으로 고안되었기 때문이다. FTP는 해커들에게 중간에 탈취를 당할 수 있는 위험이 존재하는데
이를 막기 위한 대안으로 SFTP(SSH File Transfer Protocol)이 존재한다.


## FileZila 
> Welcome to the homepage of FileZilla®, the free FTP solution. The FileZilla Client not only supports FTP, but also FTP over TLS (FTPS) and SFTP. It is open source software distributed free of charge under the terms of the GNU General Public License.
We are also offering FileZilla Pro, with addition

무료 FTP 솔루션으로는 `파일질라`가 존재한다. FTP 뿐만 아니라 암호화 및 보안과 관련된 FTPS와 SFTP도 지원한다.


## Active Mode, Passive Mode
FTP모드는 두 가지가 존재하고 기본 설정은 Active Mode로 되어 있다.
Active Mode는 클라이언트가 서버에게 연결할 데이터 포트를 알려주는 모드이며,
Passive Mode는  서버가 클라이언트에게 연결할 데이터 포트를 알려주는 모드이다.

처음 연결을 시도할 때에는 21번 포트로 서로 신호를 주고 받고 그 후 데이터 포트를 연결할 때 Active Mode는 클라이언트가 서버에게 20번 포트로 연결하라고
알려주면 서버는 클라이언트의 20번 포트로 연결을 하게 된다. 하지만 이러한 동작은 방화벽으로 인해서 이어지지 않는 경우가 발생한다.
그렇기 때문에 Passive Mode가 존재한다.



## Reference
* [[IT KEYWORD] FTP란?](https://www.easymedia.net/Culture/EasyStory/index.asp?no=172&mode=view&IDX=1170&p=1)