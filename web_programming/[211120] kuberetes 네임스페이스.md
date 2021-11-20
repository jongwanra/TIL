## 네임스페이스 사용하기

### namespace 생성

- CLI
  - kubectl create namespacae ${name}
  - kubectl get namespaces
- yaml

  - kubectl create namespace ${name} --dry-run -o yaml > green-ns.yaml
  - vim green-ns.yaml
  - kubectl create -f green-ns.yaml

### 해당 namespace에 yaml file실행

- kubectl create -f nginx.yaml -n ${namespace}

### 네임스페이스 정보 보기

- kubectl config view

### 현재 베이스 네임스페이스 context 확인

- kubectl config current-context

### 네임스페이스 context 추가

- kubectl config set-context ${name} --cluster= ${cluster-name} --user= ${user-name} --namespace= ${namespace}

### 베이스 네임스페이스 context 변경

- kubectl config use-context ${변경할 네임스페이스 name}

### namespace 삭제하기

- kubectl delete namespaces ${namasplace-name}

### 강의 내용 정리

- kubectl get pod명령어를 입력하면, 기본 namespace인 default namespace가 보여짐.
