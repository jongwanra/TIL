# <meta>태그 크롤링 에러

## 문제 발생

```python
title = soup.select_one("head > meta:nth-child(9)")
```

- 기존의 방식대로 <meta>태그에 copy selector를 했는데 출력해보니 "None"이라고 나온다.

## 이유

- 브라우저에서 들어갔을 때의 <meta>태그의 순서와 파이썬 코드로 접속했을 때의 <meta>태그의 순서가 다르기 때문에 None이 출력되었던 것.

## 해결 방법

- 새로운 접근 방식이 필요

```python
title = soup.select_one('meta[property="og:title"]')
```

- <meta> 태그 안에서 [] 안의 속성이 일치하는 친구를 가져오라는 뜻.