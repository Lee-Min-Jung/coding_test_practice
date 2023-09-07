import java.util.*;

class Solution {
    static int[][] map;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        int answer = 0;
        
        for(int[] el : rectangle){
            fill(el[0]*2, el[1]*2, el[2]*2, el[3]*2);
        }
        
        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer/2;
    }
    
    // 사각형 좌표 가지고 사각형 내부는 2, 테두리는 1로 만든 배열 구하기
    public void fill(int lx, int ly, int rx, int ry){
        for(int i = lx; i<=rx; i++){
            for(int j = ly; j<=ry; j++){
                if(map[i][j] == 2){
                    continue;
                }
                map[i][j] = 2;
                if(i == lx || i == rx || j == ly || j == ry){
                    map[i][j] = 1;
                }
            }
        }
    }
    
    // 시작위치로부터 동서남북 돌면서 아이템위치와 만날때까지 탐색하는 bfs
    public int bfs(int x, int y, int itemX, int itemY){
        int[] x_cord = {1,-1,0,0};
        int[] y_cord = {0,0,-1,1};
        int[][] distance = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            visited[curX][curY] = true;
            if(curX == itemX && curY == itemY){
                return distance[itemX][itemY];
            }
            for(int i = 0; i<4; i++){
                int nextX = curX + x_cord[i];
                int nextY = curY + y_cord[i];
                if(nextX > 0 && nextX < 101 && nextY > 0 && nextY < 101){
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 1){
                        distance[nextX][nextY] = distance[curX][curY] + 1;
                        q.add(new int[]{nextX, nextY});
                    }
                }
                
            }
        }
        return -1;
    }

}
