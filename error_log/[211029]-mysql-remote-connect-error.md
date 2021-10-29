## Occured Error

![211029](./err-image/211029.png)

- Mysql로 계정을 새로 생성했다.

```sql
 CREATE USER 'user-name'@'localhost' IDENTIFIED BY 'password';
 GRANT ALL PRIVILEGES ON *.* to 'user-name'@'localhost';
```

- 하지만 위의 이미지 처럼 1045번 Access denied 에러가 발생했다.

## Solution

- '%'를 사용하지 않았다.

```sql
 CREATE USER 'user-name'@'%' IDENTIFIED BY 'password';
 GRANT ALL PRIVILEGES ON *.* to 'user-name'@'%';
```

- 여기서 localhost 라는 의미는 외부 접속은 허용하지 않는다는 의미였다.
- 외부 접속을 허용 하기 위해서는 '%'로 계정을 생성해야했다.

## Reference

- [MySQL 유저 원격접속 허용하기](https://1mini2.tistory.com/87)

## Occured Error-2

이번에는 서버를 배포하고 나서 접근 에러가 발생했다. 왜 에러가 났을까?

결국에는 내가 접근 허용을 제대로 안해서 일어났을 것이다.
다시 솔루션을 찾았다.

## Solution-2

1.  root 계정으로 접속
2.  다음 명령어를 입력한다.

    ```sql
    grant all on db_master.* to 'db_user'@'%';

    flush privileges;
    ```

3.  다시 접속해서 확인해 보자!

## Reference

- [ER_DBACCESS_DENIED_ERROR: Access denied for user ‘db_user’@’%’ to database ‘db_master’](http://www.dark-hamster.com/programming/how-to-solve-error-message-er_dbaccess_denied_error-access-denied-for-user-db_user-to-database-db_master/)
