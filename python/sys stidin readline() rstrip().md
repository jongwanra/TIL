# sys.stidin.readline().rstrip()

알고리즘 문제를 풀면서 수많은 입력을 처리해야 하는 경우, 

input()을 이용한다면, 시간초과가 난다.

그 대신에 sys.stdin.readline()을 사용해주면 좋다.

단, 맨 끝의 개행문자까지 같이 입력받기 때문에 문자열을 저장하고 싶을 경우 .rstrip()을 추가로 해 주는 것이 좋다.

## .rstrip('string')

→ 인자로 전달된 문자를 String의 오른쪽에서 제거한다. 인자를 전달하지 않으면 String에서 공백 및 개행문자를 제거한다.

```python
s = "\n\n\n\n\n\nsdsdsdsdsdsdsdsd   \n\n\nsdasdasdasd\n\n"
print(s.rstrip(), end='')
print("11111111111")

# 출력 결과
'''
sdsdsdsdsdsdsdsd   

sdasdasdasd11111111111

'''
```