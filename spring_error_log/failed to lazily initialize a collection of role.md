
## Occured Error
```text
org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.numble.tossserverbatch.domain.member.entity.Member.accounts, could not initialize proxy - no Session
	at org.hibernate.collection.internal.AbstractPersistentCollection.throwLazyInitializationException(AbstractPersistentCollection.java:614) ~[hibernate-core-5.6.15.Final.jar:5.6.15.Final]
	at org.hibernate.collection.internal.AbstractPersistentCollection.withTemporarySessionIfNeeded(AbstractPersistentCollection.java:218) ~[hibernate-core-5.6.15.Final.jar:5.6.15.Final]
	at org.hibernate.collection.internal.AbstractPersistentCollection.initialize(AbstractPersistentCollection.java:591) ~[hibernate-core-5.6.15.Final.jar:5.6.15.Final]
	at org.hibernate.collection.internal.AbstractPersistentCollection.read(AbstractPersistentCollection.java:149) ~[hibernate-core-5.6.15.Final.jar:5.6.15.Final]
	at org.hibernate.collection.internal.PersistentBag.toString(PersistentBag.java:621) ~[hibernate-core-5.6.15.Final.jar:5.6.15.Final]
	at java.base/java.lang.StringConcatHelper.stringOf(StringConcatHelper.java:453) ~[na:na]
	at com.numble.tossserverbatch.domain.member.entity.Member.toString(Member.java:15) ~[classes/:na]
	at java.base/java.lang.StringConcatHelper.stringOf(StringConcatHelper.java:453) ~[na:na]
	at java.base/java.lang.StringConcatHelper.simpleConcat(StringConcatHelper.java:408) ~[na:na]
	at com.numble.tossserverbatch.domain.auth.jwt.JwtTokenProvider.validateToken(JwtTokenProvider.java:103) ~[classes/:na]
	at com.numble.tossserverbatch.domain.auth.jwt.JwtFilter.doFilter(JwtFilter.java:31) ~[classes/:na]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346) ~[spring-security-web-5.7.9.jar:5.7.9]
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:103) ~[spring-security-web-5.7.9.jar:5.7.9]
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:89) ~[spring-security-web-5.7.9.jar:5.7.9]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346) ~[spring-security-web-5.7.9.jar:5.7.9]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:102) ~[spring-web-5.3.28.jar:5.3.28]
	at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346) ~[spring-security-web-5.7.9.jar:5.7.9]
    ...
```


## Cause
* 영속성 컨텍스트가 지연로딩 처리 전에 clear 되면서 Account를 지연로딩 해오지 못하면서 발생
* 그렇기 떄문에, Transactional로 묶어서 일관되게 처리를 하면 된다고 블로그에서 참고했지만 해결이 안되었음.

## Solved
* servlet에서 Member를 조회하는 로직이 존재했고, 해당 부분을 주석 처리하면서 해결