// 0: 벽, 1: 벽 아님
// 생각   
    // 시작점부터 시작해서 상하좌우를 살피면서 1이면 거기로 가고 0이면 안 가고
    // 근데 최단 경로로 가야 하니까 bfs
// 구현
    // 시작점을 bfs에 넣기
    // bfs
        // 시작점과 maps를 매개변수로 받기
        // bfs 위한 큐 생성
        // 시작점을 큐에 넣기
        // 큐가 비어있지 않을 때까지 반복
            // 큐에서 하나 빼고 방문했다고 표시하고 길이 1 증가
            // 큐에서 뺀 거 기준으로 상하좌우 돌기 위해 for문으로 4번 돌기
                // 시작점 기준 상하좌우가 maps 안에 있으면서 1이면 해당 위치를 큐에 넣기
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
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            if (curX == maps.length - 1 && curY == maps[0].length - 1) {
                return maps[curX][curY];
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        maps[nextX][nextY] = maps[curX][curY] + 1;
                        visited[nextX][nextY] = true;
                        int[] nextPos = {nextX, nextY};
                        q.add(nextPos);
                    }
                }
            }
        }
        
        return -1;
    }
}


