//
/*
 N개(3 <= N <= 100)의 정수로 이루어진 수열 X를 "뒤집기 정보"에 의해 변환한 최종결과를 출력하는 프로그램
 입력 예시-1:
 10 //수열의 길이 N
 3 81 9 12 0 -8 36 33 91 10    // 수열 X
 3 //뒤집기 정보의 개수
 3 7 4 5 0 4 // 뒤집기 구간 정보
 
 출력예시-1:
-9 33 9 81 3 36 0 12 91 10 //최종 수열
*/

#include <stdio.h>
#include <stdlib.h>

void changeInf(int* array, int start, int to);
int main(void){
    int N, T; // 3 <= N <= 100
    
    scanf("%d", &N);
    int X[N];
    
    for(int i = 0; i < N; i++) scanf("%d", &X[i]);
    
    scanf("%d", &T);
    
    int t[T * 2];
    
    for(int i = 0; i < T * 2; i++) scanf("%d", &t[i]);
    for(int i = 0; i < T*2; i+=2) changeInf(X, t[i], t[i+1]);
    for(int i = 0; i < N; i++) printf(" %d", X[i]);

    return 0;
}

void changeInf(int* array, int start, int to){
    int cnt = 0;
    int n = (to - start +1)/2;

    while(cnt < n ){
        int tmp = array[start];
        array[start] = array[to];
        array[to] = tmp;
        
        to--;
        start++;
        cnt++;
    }
}

