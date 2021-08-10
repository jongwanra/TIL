def quick_sort(array, start, end):
    if len(array) <= 1:
        return
    pivot = start
    left = start + 1
    right = end

    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left += 1
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left > right:
            array[right], array[pivot] = array[pivot], array[right]
        else:
            array[left], array[right] = array[right], array[left]
        
        quick_sort(array, start, right - 1)
        quick_sort(array, right + 1, end)
        
def solution(array, commands): 
    answer = []
    for i,j,k in commands:
        cutting_arr = array[i-1:j]
        quick_sort(cutting_arr, 0, len(cutting_arr)-1)
        answer.append(cutting_arr[k-1])
    return answer