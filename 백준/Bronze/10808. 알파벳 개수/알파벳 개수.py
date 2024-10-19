S = input()

arr = [0] * 26

for char in S:
    arr[ord(char) - 97] += 1

for i in arr:
    print(i, end=' ')