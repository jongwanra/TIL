/*
 N x N (1 ≤ N ≤ 100) 크기의 행렬에 1 ~ N² 의 수를 아래 그림과 같이 차례로 위에서부터 → 방향과 ← 방향을 번갈아 가면서 채운 결과를 출력하시오.
 
 입력 예시 -1
 4  -> 행렬 크기 N
 
 출력 예시 -1
 
 □1 2 3 4 ↦ 한 줄에 한 행씩 출력
 □8 7 6 5
 □9 10 11 12
 □16 15 14 13
 
*/
#include <stdio.h>
#include <stdlib.h>

void goFunc(int N, int *arr, int* cnt);
void go0Func(int N, int *arr, int* cnt);
void backFunc(int N, int *arr, int* cnt);

int main(void){
    int N;
    int i;
    int cnt = 1;
    int **arr = NULL;
    scanf("%d", &N);
    
    arr = (int **)malloc(sizeof(int *) * N);
    
    for(i = 0; i < N; i++)
     arr[i] = (int *)malloc(sizeof(int) * N);
    
    i = 0;
    while(i < N){
        if(i == 0)
            go0Func(N, arr[i], &cnt);
        else if(i % 2 == 0)
            goFunc(N, arr[i], &cnt);
        else if(i % 2 == 1)
            backFunc(N, arr[i], &cnt);
        i++;
    }
    
    for(i = 0; i < N; i++) free(arr[i]);
    free(arr);
    return 0;
}

void goFunc(int N, int *arr, int* cnt){
    *cnt = *cnt +N;
    for(int i = 0; i < N; i++){
        printf(" %d", *cnt);
        if(i < N -1 ) (*cnt)++;
        
    }
        
    printf("\n");
}

void go0Func(int N, int *arr, int* cnt){
    for(int i = 0; i < N; i++)
        printf(" %d", (*cnt)++);
    (*cnt)--;
    printf("\n");
}


void backFunc(int N, int* arr, int* cnt){
    *cnt = *cnt + N;
    for(int i = 0; i < N; i++){
        printf(" %d", *cnt);
        if(i < N -1 ) (*cnt)--;
    }
        
    printf("\n");
}


