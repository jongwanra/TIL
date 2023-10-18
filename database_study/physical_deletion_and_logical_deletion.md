# Physical Deletion Vs Logical Deletion

## 📗 Physical Deletion이란?

실제 row를 삭제하는 것을 의미한다.

## 📗 Logical Deletion이란?

row를 실제로 삭제하는 것이 아닌 `is_deleted`와 같은 column을 지정한 뒤에 사용하는 유저에게 삭제된 것처럼 보이게하는 것을 의미한다.


## 📗 Logical Deletion의 장점?

1. 데이터 복구를 하기가 굉장히 용이하다.

기존 데이터의 삭제를 `is_deleted` column값을 변경한 것에 그치기 때문에 is_deleted 값만 변경해주면 된다. 
  따라서 데이터 복구를 하기가 굉장히 용이하다.

2. 모든 데이터를 보관함으로써 데이터 분석에 용이하다.

예를 들어 주문과 관련된 데이터들이 존재하고 주문을 취소를 하게되는 케이스도 존재할 것이다. 주문이 취소 되었다고 해서 삭제를 하게 된다면
왜 취소가 되었는지에 대한 추후에 분석을 할 수가 없게 된다.

3. 

## 📗 Logical Deletion의 단점?

1. 삭제된 데이터인지를 구분하기 위해서 모든 조회 query에 where문을 추가해줘야 한다.
2. 삭제된 데이터도 함께 보관되기 때문에 물리적 삭제에 비해 더 많은 저장공간을 차지하게 된다.

## 📗 실제 프로젝트 진행시에 Logical Deletion을 적용할까?

updated 23.10.18

이번 outfit-of-the-day 프로젝트에서는 전체를 Logical Deletion을 가져가기로 했다. 
그렇게 정한 이유는, member, post, comment table 같은 경우는 데이터의 복구가 필요한 table이며 데이터를 분석이 필요한 table이기 때문이다.
나머지 table인 follow, post_like, comment_like의 경우에는 처음에는 물리적 삭제를 가져가려고 했었다. 데이터의 복구나 분석이 필요한 테이블이 아니기 때문이다. 
하지만, 연속적으로 누를 경우는 어떨지에 대한 부분도 생각해보았다. 좋아요를 10번씩 누르는 회원이 있다거나. 보통 해당 테이블에 indexing은 2개가 들어갈 것이다.
Primary Key와 관련된 클러스터드 인덱스와 조회 성능을 빠르게 하기 위한 post_like table이라고 한다면 member_id 와 post_id에 대한 index도 추가가 된다. 
하지만 index는 조회를 위해서 그만큼 insert, delete시에 B-Tree 구조로 되어 있는데 인덱스 테이블의 구조를 변경하는 비용이 추가가 된다. (update query에 is_deleted column을 인덱스에 추가하지 않기 때문에 변경 사항 없음)

따라서 Logical Deletion으로 전체 테이블을 가져가기로 했다. (history table 제외)



---
updated 23.10.03

Logical Deletion을 결정할 때 중요한 요인은 **데이터 복구를 필요로 하는지, 데이터 분석에 활용할 Entity인지 여부**이다.
그렇지 않다면 Physical Deletion으로 가져가고 그외에는 Logical Deletion으로 가져가면 좋다고 생각한다. 

member, post, comment등은 Logical Deletion을 적용해야할 대상이다. 하지만 정말 Logical Deletion을 추가하는 방법 말고는 없을까?
deleted_member, deleted_post, deleted_comment table을 따로 구성해서 삭제된 데이터들을 따로 deleted table에 보관하는 방법으로 가져가면 어떨까?
그랬을 경우에 위에 단점들을 해결할 수 있다고 생각했다.



## 📗 Reference
* [physical-vs-logical-hard-vs-soft-delete-of-database-record](https://stackoverflow.com/questions/378331/physical-vs-logical-hard-vs-soft-delete-of-database-record)