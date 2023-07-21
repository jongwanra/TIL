# Methods 정리

## Charactor

* static char toUpperCase(char ch)
* static char toLowerCase(char ch)
* static boolean isLowerCase(char ch)
* static boolean isUpperCase(char ch)
* 

## String

* char[] toCharArray() 
  * 문자열을 char[]로 변경 반환
* String substring(int startIdx, int endIdx)
  * 문자열을 자름. (원본 보장)
* String int indexOf(String str)
  * 문자열 중 parameter의 문자열의 index를 반환, 없을 경우 -1
* String int lastIndexOf(String str)
  * 문자열 중 parameter의 문자열를 뒤에서 부터 순회해서 index를 반환, 없을 경우 -1