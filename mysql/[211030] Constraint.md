## WHAT(제약 조건이란 무엇인가)

- **제약 조건 정의**
  - 제약조건이란, 데이터의 무결성을 지키기 위해 제한된 조건을 의미한다. 데이터를 삽입할 때 조건을 만족했을 경우에만 데이터가 삽입/수정 되도록 제약할 수 있다.
- **제약 조건 종류**

  - NOT NULL: 해당 필드는 NULL값을 저장할 수 없다. 즉, 이 이 제약 조건이 설정된 필드는 무조건 데이터를 가지고 있어야 한다.
  - UNIQUE: 해당 필드는 서로 다른 값을 가져야 한다. 즉, 해당 필드 내에서 중복된 값을 저장할 수 없다.
  - PRIMARY KEY: NOT NULL과 UNIQUE 제약 조건의 특징을 모두 갖는다. PK 제약조건은 테이블당 오직 하나의 필드에만 설정 가능하다.
  - FOREIGN KEY: 외래 키라고 불린다. 한 테이블을 다른 테이블과 연결해주는 역할을 한다. FK 제약 조건을 설정할 때 가리키는 테이블의 필드는 반드시 UNIQUE나 PK 제약 조건이 설정되어 있어야 한다.
  - DEFAULT:해당 필드의 기본값을 설정할 수 있게 해준다. 레코드 입력 시, 해당 필드 값을 전달하지 않으면, 자동으로 설정된 기본값이 저장 된다.

## HOW(제약 조건을 어떻게 다룰까?)

```sql
/* 제약 조건 확인하기 */
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
DESC INFORMATION_SCHEMA.TABLE_CONSTRAINTS;

/* 제약 조건 추가하기 */
/* 외래키 추가 예시 */
ALTER TABLE `ReviewLikes` ADD FOREIGN KEY (`user_id`) REFERENCES `Users` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/* 기본키 추가 예시 */
ALTER TABLE `Posts` ADD CONSTRAINT PRIMARY KEY (`post_id`);

/* 제약조건 추가(NOT NULL) */
ALTER TABLE `Posts` MODIFY (`post_id`) INTEGER CONSTRAINT NOT NULL;

/* 제약조건 삭제 */
ALTER TABLE `Posts` DROP CONSTRAINT NOT NULL;

/* 제약조건 삭제(FOREIGN KEY) */
ALTER TABLE Posts DROP FOREIGN KEY `[확인한 제약 조건 명]`;
/* 참고: FOREIGN KEY 였던 컬럼값 삭제 */
ALTER TABLE Posts DROP category_id;


```

## Refenrece

- [mysql 무결성, 제약조건 확인/추가/삭제/변경](https://velog.io/@bungouk6829/mysql-%EB%AC%B4%EA%B2%B0%EC%84%B1-%EC%A0%9C%EC%95%BD%EC%A1%B0%EA%B1%B4-%ED%99%95%EC%9D%B8%EC%B6%94%EA%B0%80%EC%82%AD%EC%A0%9C%EB%B3%80%EA%B2%BD)
- [TCP SCHOOL](http://tcpschool.com/mysql/intro)
