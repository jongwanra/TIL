# (solved) regenerate token and reconnect in source tree

## Occured Error

![Untitled]((solved)%20regenerate%20token%20and%20reconnect%20in%20source%20%2082667ed6bd5146178694f31ae1dd113a/Untitled.png)

![Screen Shot 2021-09-10 at 6.17.13 PM.png]((solved)%20regenerate%20token%20and%20reconnect%20in%20source%20%2082667ed6bd5146178694f31ae1dd113a/Screen_Shot_2021-09-10_at_6.17.13_PM.png)

깃허브 remote repository를 관리를 할 때, 나는 소스트리를 이용해서 관리를 한다.

전날에 했던 git push와 같이 해주었음에도 에러가 발생했다.

## Solution

토큰이 기간이 만료되어 재발급받아야 했다. 재발급 받은 토큰으로 Update를 해줘야 한다.

1. 재발급 후, 토큰 비밀번호를 따로 보관해 둔다.
2. 소스트리 프로그램에 접속, 오른쪽 상단에 ... 아이콘을 클릭 후 Accounts로 들어간다.
3. Accouts 내부에서 연동 하고 있는 github 클릭 후, Edit... 화면으로 들어간다.
4. Edit...에서 비밀번호를 바꿔주면 된다.

![Untitled]((solved)%20regenerate%20token%20and%20reconnect%20in%20source%20%2082667ed6bd5146178694f31ae1dd113a/Untitled%201.png)