import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(0, 0, maps);
    }

    public int bfs(int x, int y, int[][] maps) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Queue<int[]> q = new LinkedList<>();
        int[] startPos = {x, y};
        q.add(startPos);
        visited[x][y] = true;

        int answer = 1; // 거리를 기록하는 변수

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];

                if (curX == maps.length - 1 && curY == maps[0].length - 1) {
                    return answer; // 도착지에 도달한 경우 거리 반환
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];

                    if (nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length) {
                        if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                            visited[nextX][nextY] = true;
                            int[] nextPos = {nextX, nextY};
                            q.add(nextPos);
                        }
                    }
                }
            }
            answer++; // 한 번의 BFS 탐색이 끝날 때마다 거리를 1씩 증가
        }

        return -1;
    }
}
