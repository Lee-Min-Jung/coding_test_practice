import java.util.*;

class Solution {
    static int[][] distance;
    static int answer = 0;
    public int solution(int[][] maps) {
        distance = new int[maps.length][maps[0].length];
        for(int i = 0; i<distance.length; i++){
            for(int j = 0; j<distance[i].length; j++){
                distance[i][j] = -1;
            }
        }
        bfs(0, 0, maps);
        return answer;

    }
    
    public void bfs(int x, int y, int[][] maps){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        distance[x][y] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
                if(distance[nx][ny] > 0 || maps[nx][ny] == 0) continue;
                if(nx == maps.length-1 && ny == maps[0].length-1){
                    distance[nx][ny] = distance[cx][cy] + 1;
                    answer = distance[nx][ny];
                    return;
                }
                q.offer(new int[]{nx, ny});
                distance[nx][ny] = distance[cx][cy] + 1;
            }
        }
        answer = -1;
    }
}