#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct ListNode {
    char elem;
    struct ListNode*prev;
    struct ListNode*next;
}listNode;

void print(listNode *L);
void add(listNode *L, int num, char x);
void get(listNode *L, int num);
void delete(listNode *L, int num);


int main(){

    listNode *H;
    listNode *T;
    H = (listNode*)malloc(sizeof(listNode));
    T = (listNode*)malloc(sizeof(listNode));

    H->next = T;
    T->prev = H;
    T->next = NULL;
    H->prev = NULL;

    listNode *p;

    p = H;

    int number = 0, i = 0, an = 0,cnt = 1;
    char wh = '\0', pu = '\0';


    scanf("%d", &number);

    while (i != number){
        getchar();
        scanf("%c", &wh);
        cnt = 1;
        if (wh == 'A'){
            p = H->next;
            scanf("%d %c", &an,&pu);

            while (p->next != NULL){
                p = p->next;
                cnt++;
            }
            if (cnt >= an)
                add(H, an, pu);
            else
                printf("invalid position\n");
        }
        else if (wh == 'P')
            print(H);
        else if (wh == 'D'){
            scanf("%d", &an);
            p = H->next;
            while (p->next != NULL){
                p = p->next;
                cnt++;
            }
            if (cnt <=an)
                printf("invalid position\n");
            else
                delete(H, an);
        }
        else{
            scanf("%d", &an);
            p = H->next;
            while (p->next != NULL){
                p = p->next;
                cnt++;
            }
            if (cnt <= an)
                printf("invalid position\n");
            else
                get(H, an);
        }
        i++;
    }

    return 0;
}

void print(listNode *L){
    listNode *p;
    p = L->next;
    while (p != NULL){
        printf("%c", p->elem);
        p = p->next;
    }
    printf("\n");
}

void add(listNode *L, int num, char x){

    listNode *NewNode, *p, *p2;
    int i = 1;
    NewNode = (listNode*)malloc(sizeof(listNode));
    NewNode->elem = x;
    NewNode->prev = NULL;
    NewNode->next = NULL;

    p = L;
    p2 = L->next;
    while (i != num)
    {
        p = p->next;
        p2 = p2->next;
        i++;
    }

    NewNode->prev = p;
    NewNode->next = p2;
    NewNode->prev->next = NewNode;
    NewNode->next->prev = NewNode;


}
void get(listNode *L, int num){
    listNode *p;
    int i = 1;
    p = L->next;
    while (i != num){
        p = p->next;
        i++;
    }
    printf("%c\n", (p->elem));

}
void delete(listNode *L, int num){

    listNode *p;
    listNode *p2;
    int i = 1;

    p = L->next;
    p2 = L->next->next;

    while (i != num){
        p = p->next;
        p2 = p2->next;
        i++;
    }

    p2->prev = p->prev;
    p->prev->next = p2;
}
