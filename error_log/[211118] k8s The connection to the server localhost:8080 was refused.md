## Occured Error

```javascript
//The connection to the server localhost:8080 was refused - did you specify the right host or port?
```

해당 에러를 마주침

## Cause

1. Config 파일이 $HOME/.kube 디렉토리에 존재하지 않을 경우

2. Config 파일에 현재 유저정보가 반영되지 않았을 경우

## Solution

```javascript
/*
aws eks --region <your-region> update-kubeconfig --name <cluster-name>
*/
```

## Reference

[k8s The connection to the server localhost:8080 was refused](https://potato-yong.tistory.com/122)
