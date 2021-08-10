def check_distance(cur, compare):
    keypad = [[1, 2, 3], [4, 5, 6], [7,8,9], [100, 0, 101]]
    # 위치 찾기
    for r in range(4):
        for c in range(3):
            if keypad[r][c] == cur:
                cur_loc = [r, c]
            if keypad[r][c] == compare:
                compare_loc = [r, c]
    return abs(cur_loc[0] - compare_loc[0]) + abs(cur_loc[1] - compare_loc[1])
                
def solution(numbers, hand):
    answer = ''
    l_loc = 100
    r_loc = 101
    for number in numbers:
        # 왼손만 필요한 경우
        if number == 1 or number == 4 or number == 7:
            l_loc = number
            answer += 'L'
        # 오른손만 필요한 경우
        elif number == 3 or number == 6 or number == 9:
            r_loc = number
            answer += 'R'
        # 그 밖의 경우
        else:
            # 거리가 같은 경우
            if check_distance(number, l_loc) == check_distance(number, r_loc):
                if hand == 'right':
                    r_loc = number
                    answer += 'R'
                else:
                    l_loc = number
                    answer += 'L'
            # 왼쪽이 더 가까운 경우
            elif check_distance(number, l_loc) < check_distance(number, r_loc):
                l_loc = number
                answer += 'L'
            # 오른쪽이 더 가까운 경우
            else:
                r_loc = number
                answer += 'R'
            
    return answer