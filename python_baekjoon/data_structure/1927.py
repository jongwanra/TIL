# 최소 힙(1927)
# https://www.acmicpc.net/problem/1927

from sys import stdin

def downheap(heap, idx, size):
    
    left_idx = 2 * idx
    right_idx = (2 * idx) + 1
    
    # 자식 노드가 존재 하지 않다면 종료
    if size < left_idx and size < right_idx:
        return
    
    smaller_loc = left_idx
    
    # 오른쪽 자식이 존재한 경우
    if size >= right_idx:
        # 둘 중 값이 더 작은 것이 smaller_loc이 된다.
        if heap[right_idx] < heap[smaller_loc]:
            smaller_loc = right_idx
            
    # 기존 idx 값이 더 클 경우 종료
    if heap[idx] <= heap[smaller_loc]:
        return
    
    heap[smaller_loc], heap[idx] = heap[idx], heap[smaller_loc]
    downheap(heap, smaller_loc, size)


def upheap(heap, idx):
    # 제일 위의 노드의 위치일 경우
    if idx <= 1:
        return

    # 부모노드가 더 작을 경우
    if heap[idx // 2] < heap[idx]:
        return
    
    heap[idx], heap[idx//2] = heap[idx//2], heap[idx]
    upheap(heap, idx//2)
    
    
def heap_insert(heap, data):
    heap.append(data)
    size = len(heap) - 1
    upheap(heap, size)

def heap_pop(heap):
    size = len(heap) - 1
    heap[1], heap[size] = heap[size], heap[1]
    tmp = heap.pop()
    downheap(heap, 1, size-1)
    
    return tmp

n = int(stdin.readline())
heap = [0]
for _ in range(n):
    num = int(stdin.readline())
    # 가장 작은 값 출력하고 제거하는 경우
    if num <= 0:
        # heap 배열 안에 아무 값이 없는 경우
        if len(heap) == 1:
            print(0)
        else:
            print(heap_pop(heap))
    # 추가하는 경우
    else:
        heap_insert(heap, num)