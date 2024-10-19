from collections import deque

RIPEN = 1
NONRIPEN = 0
NO = -1
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

M, N = map(int, input().split())
tomato = [list(map(int, input().split())) for _ in range(N)]
days = [[0] * M for _ in range(N)]
answer = -100
isNonRipen = False

def bfs():
    while(q):
        cur = q.popleft()
        cx = cur[0]
        cy = cur[1]
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if(nx < 0 or nx >= N or ny < 0 or ny >= M): continue
            if(tomato[nx][ny] == NO or tomato[nx][ny] == RIPEN): continue 
            q.append((nx, ny))
            tomato[nx][ny] = RIPEN
            days[nx][ny] = days[cx][cy] + 1
    return

q = deque()
for i in range(N):
    for j in range(M):
        if(tomato[i][j] == RIPEN):
            q.append((i, j))

bfs()

for i in range(N):
    for j in range(M):
        if(tomato[i][j] == NONRIPEN):
            isNonRipen = True
        cur = days[i][j]
        if(cur > answer): answer = cur

if(isNonRipen): print(-1)
else: print(answer)



