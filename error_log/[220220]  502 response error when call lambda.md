## Occured Error

- AWS Lambda 호출 시 계속 502 Errorr가 뜸.


## Reason

- API Gateway Trigger가 잡혀 있기 떄문에 정해진 형식으로 응답 값을 줘야 함.

## Solution

- 해결 예시

```javascript
sendSqsMessage
    .then((data) => {
      console.log("[SUCCESS]");
      callback(null, {
        statusCode: 200,
        body: JSON.stringify("성공적으로 요청이 완료되었습니다."),
      });
    })
    .catch((err) => {
      // Send email to emails API
      console.log("[ERROR]");
      callback(null, {
        statusCode: err.statusCode || 500,
        body: JSON.stringify(err.message),
      });
    });
```
