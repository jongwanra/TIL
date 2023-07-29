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

## Arrays
* static void fill(Object[] objs, int val );
  * 일괄 같은 값으로(원본 보장 X)
* static void sort(int[] arr)
  * 오름차순 정렬(원본 보장 X)
* static void sort(int[] arr, Collections.reverseOrder());
  * 내림차순 정렬(원본 보장 X)


## Math

* static int min(int num1, int num2);
* static int max(int num1, int num2);
* static int abs(int num);
* static double sqrt(double num);

## HashSet
* boolean retainAll(HashSet<?> target)
  * 교집합(원본 보장X)

## HashMap
* V getOrDefault(Object key, V defaultValue)
  * 존재하면 해당 value를 가져오고, 존재하지 않을 때, defaultValue를 가져온다
* V remove(Object key) 
  * 해당 key-value를 삭제하고 value값을 반환한다. 없을 시, null 반환
* boolean containsKey(Object key)
  * key가 존재하는지 유무 반환