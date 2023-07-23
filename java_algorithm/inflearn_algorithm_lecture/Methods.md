# Methods 정리

## Charactor

* static char toUpperCase(char ch)
* static char toLowerCase(char ch)
* static boolean isLowerCase(char ch)
* static boolean isUpperCase(char ch)
* static boolean isAlphabetic(char ch)
* static boolean isDigit(char ch)
  * 0-9 숫자인지 여부

## String

* char[] toCharArray() 
  * 문자열을 char[]로 변경 반환
* String substring(int startIdx, int endIdx)
  * 문자열을 자름. (원본 보장)
* String int indexOf(String str)
  * 문자열 중 parameter의 문자열의 index를 반환, 없을 경우 -1
* String int lastIndexOf(String str)
  * 문자열 중 parameter의 문자열를 뒤에서 부터 순회해서 index를 반환, 없을 경우 -1
* static String valueOf(char[] x)
  * char[]를 String객체로 변환
* boolean equals(String targetStr)
  * 대, 소문자 구분 하며 비교
* boolean equalsIgnoreCase(String targetStr)
  * 대, 소문자 구분 없이 비교
* String replaceAll("[^A-Z]", "");
  * 알파벳 대문자가 아닌 경우 전부 제거

## Integer

* static int parseInt(String str)