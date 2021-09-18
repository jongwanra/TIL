# (Not solved) Login decode error

## Occured Error

- 로컬 환경에서 잘 돌아가는 로그인 API가 ubuntu 서버 환경에서는 status code 500 에러가 발생한다.

```python
@app.route('/sign_in', methods=['POST'])
def sign_in():
    # 로그인
    username_receive = request.form['username_give']
    password_receive = request.form['password_give']

    pw_hash = hashlib.sha256(password_receive.encode('utf-8')).hexdigest()
    result = db.users.find_one({'username': username_receive, 'password': pw_hash})
    
    if result is not None:
        print("entered if")
        payload = {
            'id': username_receive,
            'exp': datetime.utcnow() + timedelta(seconds=60 * 60 * 24)  # 로그인 24시간 유지
        }
        token = jwt.encode(payload, SECRET_KEY, algorithm='HS256')
        return jsonify({'result': 'success', 'token': token})
    # 찾지 못하면
    else:
        print("entered else")
        return jsonify({'result': 'fail', 'msg': '아이디/비밀번호가 일치하지 않습니다.'})
```

## Solved

```python
token = jwt.encode(payload, SECRET_KEY, algorithm='HS256').decode('utf-8') # 이 부분!!!! 유심히 확인
```

해당 부분에 .decode('utf-8')을 추가하면서 배포환경에서 에러를 잡을 수 있었다.

하지만 저렇게 코드를 작성해 두면 로컬 환경에서는 에러가 발생한다.

> AttributeError: 'str' object has no attribute 'decode'

왜 이런지 나중에 차근차근 알아봐야겠다.