# Github Actions and Jenkins

## Jenkins VS Github Actions

| Jenkins                          | GihHub Actions               |
|----------------------------------|------------------------------|
| 오픈소스 자동화 서버 소프트웨어                | Github에서 제공하는 자동화 플랫폼        |
| 서버 설치 필요                         | 클라우드가 있으므로, 별도 설치 필요없음       |
| 작업을 동기적으로 처리한다.                  | 작업을 병렬적으로 처리가 가능하다.          |
| 환경 호환성을 위해 도커 이미지에서 실행해야 한다.     | 모든 환경과 호환된다.                 |
| 캐싱 메커니즘을 지원하기 위해 플러그인을 사용할 수 있다. | 캐싱이 필요한 경우 자체 캐싱 메커니즘을 작성해야 한다. |
| 공유가 불가능 하다.                      | Github 마켓 플레이스를 통해 공유 가능하다.  |
| 전 세계적으로 많은 커뮤니티가 존재한다.           | 잰킨스에 비해 문서가 없다.              |


## Jenkins의 특징 및 장점
* 사용자가 직접 UI에서 작업을 구성하거나 작업 순서를 코드로 정의할 수 있다.
* 전 세계적으로 많은 사람들이 오랜 시간 동안 이용하고 있기 때문에, 다양한 정보를 접하기 용이하다.
* 젠킨스는 거의 모든 환경에서 사용할 수 있도록 다양한 플러그인을 제공하고 있다.
* Jenkins는 오픈 소스로 무료로 제공된다. 뿐만 아니라 

## Github Actions의 특징 및 장점
* Software as a service(Saas) 플랫픔이기 때문에 별도로 설치가 필요 없다.
* 작업을 병렬적으로 처리가 가능하다.
* Github market place를 통해 서로 공유할 수 있다.
* public repository일 경우에는 무료로 제공된다. 반면에 private repository일 경우에는 일정 부분을 초과하면 비용이 발생한다.


## Reference
* [워크서버개발팀의 GitHub Actions 적용기](https://tech.kakaoenterprise.com/180)
* [[DevOps/번역글] Github Actions냐 Jenkins냐! 올바른 선택을 해봅시다](https://wookiist.dev/155)