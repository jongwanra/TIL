# 소수 관련

## 에라토스테네스의 체

```java
public class Prime {
    public boolean[] getIsPrimeArr (int n) {
        boolean[] isPrimeArr = new boolean[n + 1];
        Arrays.fill(isPrimeArr, true);
        isPrimeArr[0] = false;
        isPrimeArr[1] = false;

        for(int i = 2; i <= n; i++) {
            // 이미 소수가 아닌 걸 판별했을 경우
            if(!isPrimeArr[i]) {
                continue;
            }

            for(int j = i * 2; j <= n; j += i) {
                isPrimeArr[j] = false;
            }
        }

        return isPrimeArr;
    }
}

```

## 제곱근까지 순회해서 소수 여부 판단

```java

public class Prime {
    public boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }

        for(i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

```