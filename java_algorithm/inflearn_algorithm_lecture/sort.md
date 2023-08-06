# Sort 관련 정리


## 두개 이상의 기준으로 정렬 시

```java

class Chart implements Comparable<Chart> {
    int x, y;
    Chart(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Chart o) {
        // 오름차순 정렬 시에는 this - o 를 빼준다고 생각하면 좋다.
        // 내림차순은 반대로 o - this
        if(this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}

```