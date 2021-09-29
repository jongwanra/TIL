# 최대 힙(11279)
# https://www.acmicpc.net/problem/11279

from sys import stdin
def upheap(heap, loc):
    size = len(heap) - 1
    
    # 부모가 존재하지 않는 경우
    if loc <= 1:
        return
    
    # 부모가 더 값이 큰 경우
    if heap[loc//2] > heap[loc]:
        return
    
    # 부모노드와 현재 노드 값을 바꾼다
    heap[loc//2], heap[loc] = heap[loc], heap[loc//2]
    
    upheap(heap, loc//2)

def downheap(heap, loc):
    size = len(heap) - 1
    
    left_child = loc * 2
    right_child = (loc * 2) + 1
    # 자식 노드가 없는 경우,
    if size < left_child and size < right_child:
        return
    
    bigger_loc = left_child
    
    # 오른쪽 자식노드가 존재하는 경우
    if size >= right_child:
        # 오른쪽 자식 노드가 더 클 경우
        if heap[bigger_loc] < heap[right_child]:
            bigger_loc = right_child
    
    # 현재 노드가 더 클 경우,
    if heap[loc] > heap[bigger_loc]:
        return
    # 더 큰 자식 노드와 현재 노드 값을 바꾼다.
    heap[loc], heap[bigger_loc] = heap[bigger_loc], heap[loc]
    downheap(heap, bigger_loc)

    
# 루트 노드 값과, 리프노드 값을 바꾼다.
# 바꾼 후 pop()을 진행해서 빼 준다.
# downheap() 호출 해서 다시 최대힙을 만든다.
def heap_pop(heap):
    size = len(heap) - 1
    heap[1], heap[size] = heap[size], heap[1]
    res = heap.pop()
    downheap(heap, 1)
    return res

# 맨 마지막 위치에 노드 추가
# 추가한 위치를 기준으로 upheap()을 호출해서 다시 최대힙을 만든다.
def heap_push(heap, num):
    heap.append(num)
    upheap(heap, len(heap) - 1)

n = int(stdin.readline())
heap = [0]
for _ in range(n):
    num = int(stdin.readline())
    if num == 0:
        if len(heap) == 1:
            print(0)
        else:
            print(heap_pop(heap))
    else:
        heap_push(heap, num)