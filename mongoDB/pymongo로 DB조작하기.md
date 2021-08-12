# pymongo로 DB조작하기

mongodb를 조작하기 위해서 라이브러리(pymongo)를 설치해준다.

## pymongo 기본 코드

```python
from pymongo import MongoClient
client = MongoClient('localhost', 27017)
db = client.dbsparta #없으면 자동으로 db가 생성

# 코딩 시작
```

- insert : 추가
- find: 조회
- update: 수정
- delete: 삭제

## pymongo insert

```python
doc = {'name':'john','age':27}
db.users.insert_one(doc)
```

## pymongo find

```python
same_ages = list(db.users.find({'age':21},{'_id':False})) # 나이가 21인 사람만 가져올 경우
same_ages = list(db.users.find({},{'_id':False})) # 다 가져올 경우
```

## pymongo find_one

```python
# 제일 위에 있는 친구만 가지고 옴.
user = db.users.find_one({'name':'bobby'}) 
```

## pymongo update_one

```python
# name이 bobby인 곳으러 가서 age를 19살로 바꿔줘(제일 위에 있는 친구만)
db.users.update_one({'name':'bobby'},{'$set':{'age':19}})
```

## pymongo update_many

```python
# name이 bobby인 곳으러 가서 age를 19살로 바꿔줘(조건에 맞는 사람 전부)
db.users.update_one({'name':'bobby'},{'$set':{'age':19}})
```

## pymongo delete_one

```python
db.users.delete_one({'name':'bobby'}) # 제일 위에 있는 하나
db.users.delete_many({'name':'bobby'}) # 전부
```