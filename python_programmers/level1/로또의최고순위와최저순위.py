# [211115] - 로또의 최고순위와 최저순위

# 현재의 로또 순위를 반환해줌.
def rank_cnt(num):
    if num == 6:
        return 1
    if num == 5:
        return 2
    if num == 4:
        return 3
    if num == 3:
        return 4
    if num == 2:
        return 5
    return 6

def solution(lottos, win_nums):
    dp = [0] * 46
    for data in lottos:
        dp[data] += 1
    for data in win_nums:
        dp[data] += 1
    
    matching_cnt = 0    
    for i in range(1, 46):
        if dp[i] == 2:
            matching_cnt += 1
    
    answer = []
    if rank_cnt(matching_cnt) - dp[0] >= 1:
        answer.append(rank_cnt(matching_cnt) - dp[0])
    else:
        answer.append(1)    
    answer.append(rank_cnt(matching_cnt))

    return answer

# main 
lottos = [44, 1, 0, 0,31,25] 
win_nums = [31, 10, 45, 1, 6, 19]
print(solution(lottos, win_nums))