import sys
from collections import deque

ENABLE = 1
UNENABLE = 0
VISITED = -1
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

N, M = map(int, input().split())
maze = [list(map(int, input())) for _ in range(N)]
distance = [[0]*M for _ in range(N)]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    maze[x][y] = VISITED
    distance[x][y] += 1

    while(q):
        cur = q.popleft()
        cx = cur[0]
        cy = cur[1]
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if(nx < 0 or nx >= N or ny < 0 or ny >= M): continue
            if(maze[nx][ny] == VISITED or maze[nx][ny] == UNENABLE): continue
            q.append((nx, ny))
            maze[nx][ny] = VISITED
            distance[nx][ny] = distance[cx][cy] + 1
    return

bfs(0, 0)
print(distance[N-1][M-1])


