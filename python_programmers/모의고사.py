def solution(answers):    
    p1 = [1,2,3,4,5]
    p1_i, p1_cnt, p1_size = 0, 0, 5
    p2 = [2,1,2,3,2,4,2,5]
    p2_i, p2_cnt, p2_size = 0, 0, 8
    p3 = [3,3,1,1,2,2,4,4,5,5]
    p3_i, p3_cnt, p3_size = 0, 0, 10
    
    for ans in answers:
        # 정답 범위를 초과했을 경우
        if p1_i >= p1_size:
            p1_i = 0
        if p2_i >= p2_size:
            p2_i = 0
        if p3_i >= p3_size:
            p3_i = 0
        
        if p1[p1_i] == ans:
            p1_cnt += 1
        if p2[p2_i] == ans:
            p2_cnt += 1
        if p3[p3_i] == ans:
            p3_cnt += 1
        p1_i += 1
        p2_i += 1
        p3_i += 1
    print(f"p1: {p1_cnt}")
    print(f"p2: {p2_cnt}")
    print(f"p3: {p3_cnt}")
    
    dic = {
        1: p1_cnt,
        2: p2_cnt,
        3: p3_cnt
    }
    if dic[1] == dic[2] and dic[2] == dic[3]:
        return [1,2,3]
    elif dic[1] == dic[2] and dic[2] != dic[3]:
        if dic[2] > dic[3]:
            return [1,2]
        else:
            return [3]
    elif dic[1] == dic[3] and dic[3] != dic[2]:
        if dic[2] > dic[3]:
            return [2]
        else:
            return [1,3]
        
    elif dic[2] == dic[3] and dic[2] != dic[1]:
        if dic[2] > dic[1]:
            return [2, 3]
        else:
            return [1]
    else:
        max_tmp = max(dic[1], dic[2], dic[3])
        if dic[1] == max_tmp:
            return [1]
        elif dic[2] == max_tmp:
            return [2]
        else:
            return [3]