# Redis vs Memcached 

## Redis란?
> The open source, in-memory data store used by millions of developers as a database, cache, streaming engine, and message broker.
> [Redis Docs](https://redis.io/)

Redis란 **인메모리 데이터 저장소**이다. 

## Memcached란?

> Memcached is an in-memory key-value store for small chunks of arbitrary data (strings, objects) from results of database calls, API calls, or page rendering.
> [Memcached Docs](https://memcached.org/)

Memcached란 **인메모리 key-value 저장소**이다.


## Spring에서는 왜 Memcached 대신 Redis를 선택했을까?

![redis_and_memchaced_comparison.png](images/redis_and_memcached/redis_and_memchaced_comparison.png)

AWS에서 Redis와 Memcached를 비교한 문서에서 발췌했다. 
직관적으로 봤을 떄, 멀티스레딩 아키텍처를 지원하는 것을 제외한 모든 것을 Redis에서 지원하는 것을 알 수가 있다.
이 중에 가장 눈에 들어온 것은 3가지이다.

1. 데이터 타입
Redis는 String, Set, SortedSet, Hash, List등 다양한 데이터 타입을 지원해준다.
반면에 Memcached는 String 데이터 타입만 지원해준다.

2. 저장 용량
Redis는 key와 value 각 512MB에 달하는 저장공간을 가질 수 있다.
반면에 Memcached는 key 250 byte, value 1MB로 상대적으로 데이터 저장 공간이 제한적이다.

3. 데이터 복구 여부
Redis는 서버 종료와 같은 돌발 상황에서 데이터를 Disk에도 저장하기 때문에 복구가 가능하지만 <br>
Memcached는 메모리에만 저장되기 때문에 복구가 불가능하다.


Redis는 다양한 데이터 타입을 지원해주며, 저장 용량 역시 월등히 높으며, 데이터의 복구마저 가능하다.
때문에 Spring에서 Redis를 선택했다고 생각한다.


## Reference

* [Redis 를 실무에 사용하기 전 꼭 알아야 하는 전략](https://velog.io/@youngerjesus/Redis-%EB%A5%BC-%EC%8B%A4%EB%AC%B4%EC%97%90-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-%EC%A0%84-%EA%BC%AD-%EC%95%8C%EC%95%84%EC%95%BC-%ED%95%98%EB%8A%94-%EC%A0%84%EB%9E%B5)
* [[Spring] Spring은 왜 memcached 대신 Redis를 선택했을까?](https://deveric.tistory.com/65)
* [Comparing Redis and Memcached](https://aws.amazon.com/ko/elasticache/redis-vs-memcached/)