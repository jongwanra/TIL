# [211008] Swagger UI not showing operations with same Path but different HTTP method

## Occured Error

```jsx
YAMLSemanticError: Map keys must be unique; "/api/comment/:postID/:commentID" is repeated at line 1, column 1:
```

해당 에러가 발생했다.

## Reason for error

해당 에러는  URI가 유저의 고유ID처럼 유니크해야 하는데,  내가 RESTful 하게 작성하고자 한 URI가 같기 때문에 발생했다.

```jsx
//Comment를 수정할 경우
//METHOD: PUT, URI: /api/comment/:postID/:commentID:

//Comment를 삭제할 경우
//METHOD: DELETE, URI: /api/comment/:postID/:commentID:

```

## Solution

해결책은 의외로 단순했다.

- **해결 전**

```jsx
* /api/comment/:postID/:commentID:
*   put:
*     tags:
*      - Comment
*     name: Modify Comment
*     summary: Modify Comment
* /api/comment/:postID/:commentID/:
*   delete:
*     tags:
*      - Comment
*     name: Delete Comment
*     summary: Delete Comment
```

- **해결 후**

```jsx
* /api/comment/:postID/:commentID:
*   put:
*     tags:
*      - Comment
*     name: Modify Comment
*     summary: Modify Comment
*   delete:
*     tags:
*      - Comment
*     name: Delete Comment
*     summary: Delete Comment
```

해결 후의 code처럼 하나의 Path안에 put과 delete 메소드를 넣어서 해결할 수 있었다.

Stackoverflow는 사랑이다..🧡

## Reference

[Swagger UI not showing operations with same Path but different HTTP method](https://stackoverflow.com/questions/62769866/swagger-ui-not-showing-operations-with-same-path-but-different-http-method)