import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        // 시작점부터 각 위치까지의 거리 저장 배열
        int[][] distance = new int[maps.length][maps[0].length];
        
        // 거리 초기화
        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[i].length; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 1;
        
        // 동서남북 조회 위한 배열
        int[] dx = {1,-1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        // bfs 돌기
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            // 현재 위치에서 동서남북 확인
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // maps 벗어나는 경우
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length){
                    continue;
                }
                
                // 벽 만나는 경우
                if(maps[nx][ny] == 0){
                    continue;
                }
                
                // 다음 위치까지의 거리가 현재 위치까지의 거리 + 1 보다 큰 경우에만 추가 탐색 진행
                if(distance[nx][ny] > distance[x][y] + 1){
                    distance[nx][ny] = distance[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        
        }
        // 도착점까지의 거리를 찾아서 저장
        int answer = distance[maps.length - 1][maps[0].length - 1];
        
        if(answer == Integer.MAX_VALUE){
            return -1;
        }
        
        return answer;
        
    }
}