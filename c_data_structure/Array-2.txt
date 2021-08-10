/*
 N개(2 ≤ N ≤ 100)의 정수로 이루어진 수열 X를 “위치 바꿈 정보”에 의해 변환한 최종 결과를
 출력하는프로그램을작성하시오. 위치 바꿈 방식은 다음과 같다. 예를 들어, 10개 정수의 수열 X와 위치 바꿈 정보가
 다음과 같이 주어졌을때,
 
 ◦ 위치 바꿈 정보:   3 --> 8 --> 0 --> 9 --> 3(위치 바꿈 정보를 구성하는 수의 범위는 0 ~ N – 1 이다. 주어지는 위치 바꿈 정보에서 처음과 마지막 위치는 항상 동일하고, 그 외에는 동일한 위치는 없다고 가정하라)
 
 ◦ 위 순서 바꿈 정보에 의해, 수열 X에서
 3번 위치의 정수 ‘12’는 8번 위치로 이동,
 8번 위치의 정수 ‘91’은 0번 위치로 이동,
 0번 위치의 정수 ‘3’은 9번 위치로 이동,
 9번 위치의 정수 ‘10'은 3번 위치로 이동시킨다.
 
 입력 예시 -1
 10↦ 입력 수열의 길이 (N)
 3 81 9 12 0 –9 36 33 91 10 ↦ 수열 X
 5↦ 순서 바꿈 정보의 길이
 3 8 0 9 3↦ 순서 바꿈 정보
 
 출력 예시 -1
 
 □91 81 9 10 0 –9 36 33 12 3 ↦ 변환 수열
 
 */


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void changeNum(int* arr, int* changeArr, int len, int changeLen);

int main() {
    int N, N2;
    int* arr = NULL;
    int* changeArr = NULL;

    scanf("%d", &N);
    arr = (int*)malloc(sizeof(int) * N);
    if (arr == NULL) {
        printf("arr is error!");
        return -1;
    }
    for (int i = 0; i < N; i++) {
        scanf("%d", (arr + i));
    }

    scanf("%d", &N2);
    changeArr = (int*)malloc(sizeof(int) * N2);
    if (changeArr == NULL) {
        printf("changeArr is error!");
        return -1;
    }

    for (int i = 0; i < N2; i++) {
        scanf("%d", (changeArr + i));
    }

    changeNum(arr, changeArr, N, N2);

    free(changeArr);
    free(arr);
    return 0;
}

void changeNum(int* arr, int* changeArr, int len, int changeLen) {
    int arr2[len];
    int start, to;

    for (int i = 0; i < len; i++)
        arr2[i] = arr[i];

    for (int i = 0; i < changeLen - 1; i++) {
        start = changeArr[i];
        to = changeArr[i + 1];
        arr2[to] = arr[start];
    }
    
    for (int i = 0; i < len; i++)
        printf(" %d", arr2[i]);

}
