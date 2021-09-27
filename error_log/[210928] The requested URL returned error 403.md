# [210928] The requested URL returned error: 403

## Occured Error

emote: Support for password authentication was removed on August 13, 2021. Please use a personal access token instead.
remote: Please see [https://github.blog/2020-12-15-token-authentication-requirements-for-git-operations/](https://github.blog/2020-12-15-token-authentication-requirements-for-git-operations/) for more information.
fatal: Authentication failed for '[https://github.com/jongwanra/til.git/](https://github.com/jongwanra/til.git/)'

github에 push 할 때, 발생한 에러

## Solved

[맥 OS: git push에서 The requested URL returned error: 403 해결 방법](https://curryyou.tistory.com/403)

해당 내용을 참조해서 해결할 수 있었다.

마지막에 git push origin main을 하고 나서 뜨는 내용에는 , 새로 받은 키 값을 넣어줘야 한다.