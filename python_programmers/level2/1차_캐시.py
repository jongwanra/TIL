from collections import deque

def solution(cacheSize, cities):
    executionTime = 0
    cache = deque()


    for city in cities:
        lowerCity = city.lower()
        if lowerCity in cache:
            executionTime += 1
            cache.remove(lowerCity)
            cache.append(lowerCity)
        else:
            executionTime += 5
            cache.append(lowerCity)
            if len(cache) > cacheSize:
                cache.popleft()


    return executionTime