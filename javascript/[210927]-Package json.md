# [210927] Package.json

```json
{
  "name": "hanghae-blog",
  "version": "1.0.0",
  "description": "나만의 항해블로그를 요구사항에 맞춰서 만들어보기",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "repository": {
    "type": "git",
    "url": "git+https://github.com/jongwanra/hanghae-blog.git"
  },
  "keywords": [],
  "author": "",
  "license": "ISC",
  "bugs": {
    "url": "https://github.com/jongwanra/hanghae-blog/issues"
  },
  "homepage": "https://github.com/jongwanra/hanghae-blog#readme",
  "dependencies": {
    "dotenv": "^10.0.0",
    "ejs": "^3.1.6",
    "express": "^4.17.1",
    "mongoose": "^6.0.7",
    "uuid": "^8.3.2"
  }
}
```

내가 최근에 진행한 hanghae-blog 프로젝트에도 다음과 같이 package.json 파일이 존재한다.

"name" 키값에는 현재 프로젝트 명이 적혀있고, "main" 키값에는 노드를 실행하는 루트 파일이 적혀있다. "dependencies" 키값 안에는 프로젝트를 사용하면서 다운 받았던 여러 모듈이 적혀져 있다.

## Package.json이란?

- npm 패키지를 주고 받는 장소
- 주고 받는 패키지에 대한 상세 설명서(package의 이름, 버전, 데이터 등이 담긴 파일)
- Node.js 프로젝트의 Root 디렉토리에 위치해 있다.
- npm은 이를 통해서 프로젝트를 식별하고, 프로젝트의 종속(dependency) 사항들을 처리한다.
- 기본적으로 Node.js는 package.json의 단 두 영역만을 식별한다.

```json
{
	"name": "hanghae-blog",
  "version": "1.0.0"
}
```

## Reference

- [package.json 파일 이란 무엇이며 어떤 역할을 할까요?](https://oneroomtable.tistory.com/entry/packagejson-%ED%8C%8C%EC%9D%BC%EC%9D%B4%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B4%EB%A9%B0-%EC%96%B4%EB%96%A4-%EC%97%AD%ED%95%A0%EC%9D%84-%ED%95%A0%EA%B9%8C%EC%9A%94)
