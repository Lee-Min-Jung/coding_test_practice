ROW = 1002
COL = 367

N = int(input())
plan = [list(map(int, input().split())) for _ in range(N)]
calander = [[0]*(COL+1) for _ in range(ROW+1)]

plan.sort(key=lambda x: (x[0], -x[1]))
answer = 0

for i in range(N):
    start = plan[i][0]
    end = plan[i][1]
    row = 1
    while(calander[row][start] != 0):
        row += 1
    for j in range(start, end+1):
        calander[row][j] = 1

maxHeight = 0
maxWidth = 0
for i in range(1, COL+1):
    count = 0
    for j in range(1, ROW+1):
        if(calander[j][i] != 0): count += 1 
    if(count == 0): 
        answer += maxHeight * maxWidth
        maxHeight = 0
        maxWidth = 0
        continue
    else:
        maxWidth += 1
    if(count > maxHeight): maxHeight = count
    


print(answer)