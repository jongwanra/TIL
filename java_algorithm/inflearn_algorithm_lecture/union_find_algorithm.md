# Union & Find Algorithm

Union & Find 알고리즘은 배열을 활용해서 서로 연관 관계가 있는 요소들을 그룹핑 하는 알고리즘

`최소 스패닝 트리` 에서 활용되기 떄문에 이해했으니 외우자!

```java

public class Main {
	static int[] unf;
	
	public static int find(final int v) {
		if (unf[v] == v) {
			return unf[v];
		}
		return unf[v] = find(unf[v]);
	}
	
	public static void union(final int a, final int b) {
		final int fa = find(a);
		final int fb = find(b);
		
		if (fa == fb) {
			return;
		}
		
		unf[fa] = fb;
	}
}

```

## Reference

* greedy -> `친구 찾기` 문제를 풀어보자