from collections import deque

WALL = '#'
ROAD = '.'
PERSON = 'J'
FIRE = 'F'
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

R, C = map(int, input().split())
maze = [list(input()) for _ in range(R)]
timePerson = [[-1]*C for _ in range(R)]
timeFire = [[-1]*C for _ in range(R)]
isOut = False
outTime = 0

fireQ = deque()
personQ = deque()

def fireBfs():
    while(fireQ):
        cur = fireQ.popleft()
        cx = cur[0]
        cy = cur[1]
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if(nx < 0 or nx >= R or ny < 0 or ny >= C): continue
            if(maze[nx][ny] == WALL): continue
            if(timeFire[nx][ny] >= 0): continue
            fireQ.append((nx, ny))
            timeFire[nx][ny] = timeFire[cx][cy] + 1
    return

def personBfs():
    while(personQ):
        cur = personQ.popleft()
        cx = cur[0]
        cy = cur[1]
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if(nx < 0 or nx >= R or ny < 0 or ny >= C):
                global isOut
                global outTime
                isOut = True
                outTime = timePerson[cx][cy] + 1
                return
            if(maze[nx][ny] == WALL): continue
            if(timePerson[nx][ny] >= 0): continue
            if(timeFire[nx][ny] != -1 and timePerson[cx][cy]+1 >= timeFire[nx][ny]): continue
            personQ.append((nx, ny))
            timePerson[nx][ny] = timePerson[cx][cy] + 1

for i in range(R):
    for j in range(C):
        if(maze[i][j] == FIRE): 
            fireQ.append((i, j))
            timeFire[i][j] = 0
        if(maze[i][j] == PERSON): 
            personQ.append((i, j))
            timePerson[i][j] = 0

fireBfs()
personBfs()

if(isOut):
    print(outTime)
else:
    print('IMPOSSIBLE')

