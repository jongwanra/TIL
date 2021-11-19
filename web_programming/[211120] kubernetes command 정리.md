## CMD 정리

### 명령어들의 약어 정보를 보여준다.

- kubectl api-resources

### 어떤 명령어가 있는지 보여줌

- kubectl --help
- kubectl logs --help

### 시스템의 노드 정보 보기(밑으로 갈수록 더 자세히 정보를 보여줌)

- kubectl get nodes
- kubectl get nodes -o wide
- kubectl describe node ${node name 입력}

### 컨테이너 Pod 만들기(실행하기) : 1개

- kubectl run webserver --image=nginx:1.14 --port 80

### 잘 만들어 졌는지 확인해보기

- kubectl get pods
- kubectl get pods -o wide
- kubectl describe pod webserver

### 컨테이너 Pod 2개 이상 만들기(실행하기): 2개 이상

- kubectl create deployment mainui --image=httpd --replicas=3
  - replicas=3 -> 3개 실행해 달라는 의미(deployment 명령어를 사용하는 이유)

### 잘 만들어 졌는지 확인해보기: 2개 이상

- kubectl get deployments.apps
- kubectl describe deployments.apps ${name}

### pod 접속해 보기

- curl ${kubectl get pods -o wide 해서 나오는 IP}

### pod를 yaml, json 형태로 보기

- kubectl get pod ${name} -o yaml
- kubectl get pod ${name} -o json

### 해당 Container 내부로 들어가기

- kubectl exec ${name} -it -- /bin/bash
  - 참고로 nginx는 cd /usr/share/nginx/html/ 안에 있다.

### container 로그 확인하기

- kubectl logs ${name}

### Port-foward 명령어

- kubectl port-forward ${name} 8080:80

### 동작중인 pods 수정하고 싶을 때

- kubectl edit deployments.apps ${name}

### 실행이 되는지 여부만 체크를 하고 싶을 때

- kubectl run webserver --image=nginx:1.14 --port 80 --dry-run

### 체크한 후 yaml format 으로 보고 해당 내용을 yaml file로 만들기

- kubectl run webserver --image=nginx:1.14 --port 80 --dry-run -o yaml > webserver.pod.yaml

### 동작 중인 pod 삭제

- kubectl delete pod ${name}
- kubectl delete deployments.apps ${name}

### yaml file로 pod 실행하기

- kubectl create -f webserver.pod.yaml

## Reference

- [3-2. kubectl command / pod 생성하기](https://www.youtube.com/watch?v=QGF7igBYSEI&list=PLApuRlvrZKohaBHvXAOhUD-RxD0uQ3z0c&index=6)
