# [211007] Filezilla Permission deniend Error

## Occured Error

![error.png](./%5B211007%5D%20Filezilla%20Permission%20deniend%20Error/error.png)

파일질라로 파일들을 업로드할 때 에러 발생.

## Solution

해당 에러는 해당 서버의 경로에 권한을 주지 않았기 때문에 발생한 에러이다.

```jsx
// 파일을 업로드할 경로를 적고 권한을 부여해준다.
sudo chmod 777 /home/ubuntu/hanghae-blog
```

해당 경로에 대한 권한을 부여해주는 명령어를 통해 해결
