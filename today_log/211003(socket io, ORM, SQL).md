# 211003(socket.io, ORM, SQL)

## 오늘한 일

- [Socket.io](http://Socket.io) 모듈을 활용한 오픈 채팅 구현

[Socket.io](http://Socket.io) 모듈을 활용해서 채팅방 기능을 구현해 봤다.

```jsx
// app.js
io.on('connection', (socket) => {
  let roomNum = '';

  // private한 채팅방을 만들기 위해서는 room 문법을 사용할 수 밖에 없다.
  socket.on('방들어가고파', function (data) {
    console.log('방에 들어온 접속자 한 사람: ', socket.id);

    socket.join(data);
    roomNum = data;
  });

  // 메세지를 보냈을 경우
  socket.on('sendMsg', (data) => {
    console.log(data);
    // 나 포함 모든 유저에게 전달.
    io.to(roomNum).emit('퍼뜨리기', data);
  });

  // 방에서 나갈 경우,
  socket.on('disconnect', () => {
    console.log('방에서 나갔습니다 :', socket.id);
  });
});
```

```jsx
//chat.ejs

<script>
        const socket = io();

        //방1 버튼 클릭 시
        $('.mt-1').eq(0).click(function () {
            socket.emit('방들어가고파', 'room1');
        })

        $('.mt-1').eq(1).click(function () {
            socket.emit('방들어가고파', 'room2');
        })

        $('#button-addon2').click(function () {

            console.log($('#main-input').val());
            socket.emit('sendMsg', $('#main-input').val());
            $('#main-input').val('');
            $('#main-input').focus();

        });

        socket.on('퍼뜨리기', (data) => {
            $('.list-group').append(`<li class="list-group-item">${data}</li>`)
            $('.list-group').scrollTop($('.list-group').prop('scrollHeight'));
        });

    </script>
```

사실은 node.js 4주차 과제 중에 한 문제를 해결하기 위해서 room문법을 이용해서 과제를 해결해보자 생각해서 만들어 봤다. 그런데, 예상과 다르게 과제를 아직까지 해결하지 못했다...

내일 다른 조원분은 어떻게 해결했는지에 대해서 물어보고 로직에 대해서  생각해봐야겠다 ㅠ.

- [NoSQL vs SQL](https://github.com/jongwanra/til/blob/main/web_programming/%5B211004%5D-NoSQL%20vs%20SQL.md)
- [ORM](https://github.com/jongwanra/til/blob/main/web_programming/%5B211004%5D-ORM.md)