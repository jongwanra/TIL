# API 토큰 적용하기

### API 요청 파이썬

```python
r = requests.get("https://owlbot.info/api/v4/dictionary/owl", headers={"Authorization": "Token [내토큰]"})
result = r.json()
print(result)
```

### API 요청 Ajax

```jsx
$.ajax({
    type: "GET",
    url: "", // <- api-url
    beforeSend: function (xhr) {
        xhr.setRequestHeader("Authorization", "Token [내토큰]");
    },
    data: {},
    error: function (xhr, status, error) {
        alert("에러 발생!");
    },
    success: function (response) {
        console.log(response)
    }
})
```