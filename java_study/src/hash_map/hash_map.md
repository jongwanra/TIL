# HashMap

## HashMap이란?
* key에 대한 hash값을 사용해서 값을 저장하고 조회하며, key와 value쌍의 갯수이 따라 동작으로 크기가 증가하는 associate array(연관 배열)이다.

## HashMap을 사용하는 이유
* HashMap의 조회 성능 때문이 가장 큰 이유라고 생각한다. 
* 조회 성능은 평균적으로 O(1)이라고 할 수 있다. 뿐만 아니라, 해시 충돌이 일어난 Bucket일 지라도 O(log n)의 시간 복잡도를 가지고 있는 자료구조이다.

## 해시충돌(Hash Collision)
서로 다른 두 객체 X, Y가 있을 때, X.equals(Y) == false && x.hashCode() == y.hashCode() 일 경우에 동일한 hashCode이기 때문에 같은 Bucket에 들어가게 된다.
이를 해시 충돌이라고 한다.

## Bucket이란?
* Bucket이란 용어의 혼동이 와서 제대로 찾아보자고 생각했다.
* Bucket은 Capacity와 같은 맥락으로 사용된다.
* Bucket은 연관 배열 요소 각각을 의미한다.

## Load Facter
* Load Facter는 어느 정도의 key-value 쌍의 갯수가 들어와야 Capacity를 확장 시킬 지에 대해서 0.0f ~ 1.0f 사이로 나타내는 것을 의미한다.
* 기본 값은 0.75f이다. 
* 현재 Capacity가 32개라고 했을 때, 75%인 24개를 초과하면 Capacity를 확장한다는 의미이다

## Threshold(임계치)
* The threshold of a HashMap is approximately the product of current capacity and load factor.
* 임계치는 capacity(=bucket) * load factor의 값으로, hashMap.size()가 Threshold를 초과했을 때, re-hashing이 일어난다.

## re-hashing
re-hashing이란, hashMap에서의 총 key-value쌍의 갯수(=map.size())가 Threshold를 초과했을 때, 발생한다. 
re-hashing은 기존 bucket size의 두배로 늘어난 새로운 Node<K,T>[] 배열을 생성하고 새롭게 bucket을 재구성 한다.

이 때 resize method를 호출하게 된다. 아래는 HashMap Class에 구현된 resize method의 일부이다.

```java
public class HashMap<K, V> {
    final Node<K,V>[] resize() {
        // ...
        // 여기서 2배의 크기로 새로운 table(array)를 생성한다.
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            // 반복문을 통해서 기존 테이블을 순회하면서 재구성을 하게 된다.
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    // 첫 번째 경우로 빈 버킷인 경우
                    if (e.next == null)
                        // 빈 Node의 주소값을 참조시킨 후 마무리
                        newTab[e.hash & (newCap - 1)] = e;
                    // 기존 트리노드의 버킷인 경우
                    else if (e instanceof TreeNode)
                        // split method를 호출한다.
                        // 여기서 TreeNode인 Bucket의 크기가 6이하일 경우 untreeify method를 호출하여 트리 구조에서 링크드리스트로 구조 변경이 일어남
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    // 기존 링크드리스트의 버킷인 경우
                    else { 
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
}
```

## 보조 해시 함수 구현
```java
public class HashMap {
    // ...
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }    
}
```


## String에서 hashCode Method
```java
public class String {
    public static int hashCode(byte[] value) {
        int h = 0;
        for (byte v : value) {
            h = 31 * h + (v & 0xff);
        }
        return h;
    }
}
```
String 객체는 String을 byte 배열로 순회를 하면서 누적으로 31을 곱하고 Char 정수 값 더하는 연산을 수행하여 hashCode를 반환하고 있다.

## 31로 연산을 하는 이유
31을 연산할 떄 머신 코드가 손쉽게 연산할 수 있는 숫자이기 때문이다. 
31은 (2^5 - 1)이다. 즉 shift 연산으로 (1 << 5) - 1로 계산이 가능하다.
`31 * h`의 값은  `(h << 5) - h`와 동일하다.



## Number Class를 상속받는 Integer, Short, Byte, Long, Double 등등은 각각 어떻게 hashCode가 구현되어 있을까?
* Integer: 값을 그대로 내보낸다.
* Short: int형으로 형변환하여 값을 내보낸다.
* Byte: int형으로 형변환하여 값을 내보낸다.
* Long: (int)(originValue ^ (originValue >> 32))
* Float: float의 bit를 integer bit로 변환하여 반환
* Double: double type -> long type 으로 변환 및 (int)(originValue ^ (originValue >> 32))



## put()

```java

public class HashMap {
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K,V>[] tab; 
        Node<K,V> p; 
        int n, i;
        
        // Node<K, V>[]가 없는 경우
        if ((tab = table) == null || (n = tab.length) == 0){
            n = (tab = resize()).length;
        }
            
        // bucket이 비어있는 경우
        if ((p = tab[i = (n - 1) & hash]) == null) {
            tab[i] = newNode(hash, key, value, null);
        }
        // hash collision이 나있는 경우
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        // 여기서 TREEIFY_THRESHOLD = 8
                        // put시, bucket 내부적으로 8개 이상이되면, treeifyBin method 호출
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // 중복된 key값이 존재할 경우?!
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;
                    }
                     
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
}

```

## HashMap vs HashTable vs ConcurrentHashMap
이 세 가지의 차이점은 크게 두 종류로 구성 되어 있다. 
1. Thread-Safe 여부
2. key or value null 허용 여부
---
* `HashMap`은 Thread-Safe 하지 않다. 그리고 key-value에 null값이 허용된다.
* `HashTable`은 Thread-Safe 하다. 그리고 null값을 허용하지 않는다.

```java
public class HashTable {
    
    // HashTable은 method 자체에 synchronized가 걸려 있다.
    public synchronized V put(K key, V value) {
        // 여기서 value값이 null 일경우 NullPointerException이 발생
        if (value == null) {
            throw new NullPointerException();
        }
        
        Entry<?,?> tab[] = table;
        // 이 부분에서 key가 null일 경우 Exception 발생
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K,V> entry = (Entry<K,V>)tab[index];
        for(; entry != null ; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }

        addEntry(hash, key, value, index);
        return null;
    }
}

```
* `ConcurrentHashMap`은 Thread-Safe 하다. 그리고 null값을 허용 하지 않는다.
아래는 ConcurrentHashMap 내부에  put method에 관한 내용이다.
```java

public class ConcurrentHashMap {
    final V putVal(K key, V value, boolean onlyIfAbsent) {
        
        // 해당 부분을 통해서 null값이 허용되지 않음을 알 수있다. (key, value)
        if (key == null || value == null) throw new NullPointerException();
        int hash = spread(key.hashCode());
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh; K fk; V fv;
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                if (casTabAt(tab, i, null, new Node<K,V>(hash, key, value)))
                    break;                
            }
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else if (onlyIfAbsent // check first node without acquiring lock
                    && fh == hash
                    && ((fk = f.key) == key || (fk != null && key.equals(fk)))
                    && (fv = f.val) != null)
                return fv;
            else {
                V oldVal = null;
                // 이 부분을 통해서 Thread-Safe 한 것을 알 수 있다.
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                if (e.hash == hash &&
                                        ((ek = e.key) == key ||
                                                (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key, value);
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                    value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                        else if (f instanceof ReservationNode)
                            throw new IllegalStateException("Recursive update");
                    }
                }
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);
        return null;
    }

}

```

## HashTable vs ConcurrentHashMap 

* 위에 HashTable 과 ConcurrentHashMap의 put method를 보면
* 두 개의 class 모두 Thread-Safe 하게 구현이 되어 있지만 차이점은 HashTable은 Method 자체에 동기화 락이 걸려있다.
* ConcurrentHashMap은 Method가 아닌 Bucket 내부 데이터를 조작하는 시점에 동기화 락이 걸려있다!.



## Reference
* https://d2.naver.com/helloworld/831311
* https://www.baeldung.com/java-hashmap-load-factor
* 자바의 신(이상민 저)