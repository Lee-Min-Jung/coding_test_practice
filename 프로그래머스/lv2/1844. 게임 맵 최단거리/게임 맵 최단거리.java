// 생각
    // 시작위치부터 해당 좌표까지의 최단 거리 담고 있는 거리 배열 생성
    // 첫번째 좌표부터 bfs돌면서 거리 갱신
// 구현
    // bfs
import java.util.*;
class Solution {
    static boolean[][] visited;
    public int solution(int[][] maps) {
        // 변수
        visited = new boolean[maps.length][maps[0].length];
        int[][] distance = new int[maps.length][maps[0].length];
        
        
        // bfs
        return bfs(0, 0, maps, distance);
    }
    public int bfs(int x, int y, int[][] maps, int[][] distance){
        int[] cordX = {1,-1,0,0};
        int[] cordY = {0,0,-1,1};
        Queue<int[]> q = new LinkedList<int[]>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            if(curX == maps.length-1 && curY == maps[0].length-1){
                return distance[curX][curY]+1;
            }
            for(int i = 0; i<4; i++){
                int nextX = curX+cordX[i];
                int nextY = curY+cordY[i];
                if(nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length){
                    if(maps[nextX][nextY] != 0 && !visited[nextX][nextY]){
                        distance[nextX][nextY] = distance[curX][curY] + 1;
                        visited[nextX][nextY] = true;
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        
        return -1;
    }
}

