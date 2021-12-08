# 끝 시간과 시작 시간의 차이를 반환하는 함수
def getTime(start_time, end_time):
    start_h, start_m = int(start_time[:2]), int(start_time[3:])
    end_h, end_m = int(end_time[:2]), int(end_time[3:])
    
    start_total_m = (start_h) * 60 + start_m
    end_total_m = (end_h) * 60 + end_m
    return end_total_m - start_total_m
    
# C# -> c, D# -> d, F# -> f, G# -> g,  A# -> a
# #이 붙은 음들은 소문자로 변경 후 변환
def convertString(s):
    s = list(s)
    for i in range(len(s)):
        if s[i] == '#':
            s[i-1] = chr(ord(s[i-1]) + 32)
            s[i] = ''
    return ''.join(s)
    
def solution(m, musicinfos):
    answer = []
    m = convertString(m) 
    for music_info in musicinfos:
        info = music_info.split(',')
        title = info[2]
        music = convertString(info[3])
        music_size = len(music)
        total_minute = getTime(info[0], info[1]) # 라디오 방송이 나온 시간
        # 방송이 나온 시간에 맞춰서 음악 정보를 구함.
        total_music = music * (total_minute // music_size) + music[:(total_minute % music_size) ] 
        
        # 해당 문자열이 포함되있는지 여부 확인
        if m in total_music:
            answer.append([title, total_minute])
    
    # 일치 하는 것이 없을 경우
    if answer == []:
        return '(None)'
    # 1개만 일치한 경우
    if len(answer) == 1:
        return answer[0][0]
    # 나머지는 분이 긴 순으로 내림차순 정렬 후, 첫 번째 요소 반환
    answer.sort(key=lambda x:x[1], reverse=True)
    return answer[0][0]