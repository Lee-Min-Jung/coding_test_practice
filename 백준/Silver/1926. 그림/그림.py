import sys
from collections import deque
COLORED = 1
UNCOLORED = 0
VISITED = -1
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    picture[x][y] = VISITED
    area = 1
    while(q):
        cur = q.popleft()
        cx = cur[0]
        cy = cur[1]
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if(nx < 0 or nx >= n or ny < 0 or ny >= m): continue
            if(picture[nx][ny] == VISITED or picture[nx][ny] == UNCOLORED): continue
            picture[nx][ny] = VISITED
            q.append((nx, ny))
            area += 1



    return area

n, m = map(int, input().split())
picture = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
count = 0
max = 0

for i in range(n):
    for j in range(m):
        if(picture[i][j] == COLORED): 
            count += 1
            result = bfs(i, j)
            if(result > max): max = result

print(count)
print(max)




