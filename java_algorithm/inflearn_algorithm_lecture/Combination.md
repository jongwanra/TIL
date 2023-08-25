## Combination

* nCr = n-1Cr-1 + n-1Cr;
* nCr = n! / (n-r)! * r!

### Combination - DFS

```java
class Combination {
	private void myDfs(final int depth, final int startIdx) {
		if (depth == m) {
			for (int x : combi) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = startIdx; i < pizzaHouses.size(); i++) {
			combi[depth] = i;
			myDfs(depth + 1, i + 1);
		}
	
	}
}

```

## Reference

* 7.조합수(메모이제이션)