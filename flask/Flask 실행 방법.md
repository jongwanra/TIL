# Flask 실행 방법

## 1. 가상환경 생성

설정 폴더 위치에 명령어 입력

```python
$python3 -m venv venv
```

## 2. Flask 라이브러리 설치

```python
$pip install flask
```

## 3. Flask 시작 코드(서버를 만듦)

```python
#app.py
from flask import Flask
app = Flask(__name__)

@app.route('/')
def home():
   return 'This is Home!'

if __name__ == '__main__':  
   app.run('0.0.0.0',port=5000,debug=True)
```

## 4. 정해진 틀을 만듦

- [app.py](http://app.py) 파일
- templates 폴더
- static 폴더 (css or image files)

## 5. Example

index.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
    <h1>서버를 만들었다!</h1>
</body>
</html>
```

app.py

```python
from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def home():
   return render_template('index.html')

if __name__ == '__main__':  
   app.run('0.0.0.0',port=5000,debug=True)
```