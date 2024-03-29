# Thread Pool & DBCP

## Thread Pool이란?

프로그램 구동 시에 스레드를 지정한 개수만큼 생성해 놓고 요청이 들어올 떄마다 미리 생성해 놓은 쓰레드를 재사용 하는 메커니즘을 의미한다.

## Connection Pool이란?

프로그램 구동 시에 지정한 connection 개수만큼 미리 생성해 놓고 필요할 때마다  connection을 재사용 하는 메커니즘을 의미한다.

## Thread Pool의 장점?

* Thread Pool을 통해서 요청 마다 스레드를 생성하는 비싼 비용을 절약할 수 있게 된다.
* 제한된 개수의 스레드를 운용하기 떄문에 스레드가 무제한으로 생성되는 것을 방지할 수 있다. (스레드가 무제한으로 생겨나는 OOM의 발생 소지를 없앨 수 있다.)


## 스레드 풀에 몇 개의 스레드를 만들어 두는게 적절할까?
CPU 코어 개수와 task의 성향에 따라 다르다. CPU-bound task라면 코어 개수 만큼 혹은 그 보다 몇 개 많은 정도를 스레드 개수로 가져간다. 
반면에, I/O - bound task라면 코어 개수 보다 1.5배? 두 배? 세 배? 경험적으로 찾아야 한다.

## 스레드 풀에서 실행될 task 개수에 제한이 없다면?

스레드 풀의 큐가 사이즈 제한이 있는지 꼭 확인해야 한다. 
대기하는 큐에 계속해서 요청이 쌓이게 되고, task queue에 제한이 없다면, 잠재적으로 메모리를 고갈시킬 수 있는 위험 요인이 될 수 있다.
요청을 버리더라도 전체 시스템에 문제가 생기지 않도록 해야 한다.

**사이즈 제한이 없는 큐는 상황에 따라서는 메모리를 고갈시키는 잠재적인 위험 요인이 될 수 있다.**

## 스레드 풀과 커넥션 풀의 관계?

client로 부터 요청이 들어온다고 가정하자. 요청이 들어오면 스레드 풀로부터 스레드를 할당 받고, 로직을 수행하게 된다. 이 때 DB에 접근이 필요할 경우 커넥션 풀에서 커넥션을 하나 할당 받게 되고,
DB에 접근이 필요 없을 경우에는 따로 사용하지 않는다.

사용하는 애플리케이션에 따라 다를 수 있겠지만, thread는 무조건적으로 할당하게 되지만 connection은 필요할 경우와 필요하지 않은 경우가 있기 때문에 
thread의 갯수가 connection 수 보다 조금 더 많이 설정하는 것이 바람직하다고 생각한다.

thread수가 connection 수보다 적을 경우, connection은 할 일이 없어 노는 connection이 발생하게 되고 자연스레 불필요한 자원이 되어 버린다. 
반대로 thread 수가 connection 수보다 많을 경우에는 모든 thread를 감당하기에 connection수가 적기 때문에 thread가 작업을 처리하는데 대기를 하는 상황이 발생하게 된다. 
이 차이가 심하면 심할 수록 client가 처리한 내용을 받는데 걸리는 응답시간이 길어질 것이다. 







## 참고

* (스프링부트는 어떻게 다중 유저 요청을 처리할까? (Tomcat9.0 Thread Pool))[https://velog.io/@sihyung92/how-does-springboot-handle-multiple-requests]