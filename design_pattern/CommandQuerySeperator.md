## CQS(Command Query Seperator)

## What

## Why


## CQS에 대한 생각

전 회사에서 CQS에 대해 알았으면 좋았겠다는 생각이 절실하게 든다.
Command Query를 분리하지 않는 로직으로 설계를 진행했었다.

왜 절실하게 들었을까? 
버그가 났을 때 사이드 이펙으로 인해 수정하는데 더욱이 시간이 걸려서 이다.



```java
@Transactional(readOnly = false)
public Member updateMember(Long memberId, String name) {
    Member member = memberRepository.findOne(memberId);
    member.setName(name);

    return member;
}
```



```java
@Transactional(readOnly = false)
public void updateMember(Long memberId, String name) {
  Member member = memberRepository.findOne(memberId);
  member.setName(name);
}
```




## Reference
https://www.inflearn.com/questions/27795/cqrs
