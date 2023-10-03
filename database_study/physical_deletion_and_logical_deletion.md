# Physical Deletion Vs Logical Deletion

## Physical Deletion이란??

실제 row를 삭제하는 것을 의미한다.

## Logical Deletion이란?

row를 실제로 삭제하는 것이 아닌 `is_deleted`와 같은 column을 지정한 뒤에 사용하는 유저에게 삭제된 것처럼 보이게하는 것을 의미한다.


## Logical Deletion의 장점?

### 1. 데이터 복구를 하기가 굉장히 용이하다.
* 기존 데이터의 삭제를 `is_deleted` column값을 변경한 것에 그치기 때문에 is_deleted 값만 변경해주면 된다. 
  따라서 데이터 복구를 하기가 굉장히 용이하다.

### 2. 모든 데이터를 보관함으로써 데이터 분석에 용이하다.

예를 들어 주문과 관련된 데이터들이 존재하고 주문을 취소를 하게되는 케이스도 존재할 것이다. 주문이 취소 되었다고 해서 삭제를 하게 된다면
왜 취소가 되었는지에 대한 추후에 분석을 할 수가 없게 된다. 

## Logical Deletion의 단점?

### 1. 삭제된 데이터인지를 구분하기 위해서 모든 조회 query에 where문을 추가해줘야 한다.

### 2. 삭제된 데이터도 함께 보관되기 때문에 물리적 삭제에 비해 더 많은 저장공간을 차지하게 된다.

## 실제 프로젝트 진행시에 Logical Deletion을 적용할까?

Logical Deletion을 결정할 때 중요한 요인은 **데이터 복구를 필요로 하는지, 데이터 분석에 활용할 Entity인지 여부**이다.
그렇지 않다면 Physical Deletion으로 가져가고 그외에는 Logical Deletion으로 가져가면 좋다고 생각한다. 

그런데 logical Deletion에는 위에서 언급한 것처럼 두 가지 단점을 가지고 있다. 나는 그 중에 `삭제된 데이터인지를 구분하기 위해서 모든 조회 query에 where문을 추가해줘야 한다.` 부분이 
조금은 치명적으로 느껴진다. Logical Deletion을 where문에 추가해 줌으로 인해서 SQL에서 PK indexing을 활용할 수 없기 때문이다.
따라서 추가 Indexing이 필요하다. 추가 Indexing을 적용한다면 그만큼 write시 속도가 느려게 된다. 

user, post, comment등은 Logical Deletion을 적용해야할 대상이다. 하지만 정말 Logical Deletion을 추가하는 방법 말고는 없을까?
deleted_user, deleted_post, deleted_comment table을 따로 구성해서 삭제된 column들은 따로 deleted table에 보관하는 방법으로 가져가면 어떨까?
그랬을 경우에 위에 첫 번째 단점을 해결하고 pk indexing을 활용할 수 있을 것 같다고 생각한다.

## Reference
* [physical-vs-logical-hard-vs-soft-delete-of-database-record](https://stackoverflow.com/questions/378331/physical-vs-logical-hard-vs-soft-delete-of-database-record)