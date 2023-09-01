// 생각
    // 좌표를 나타내는 배열을 만들어서 캐릭터 시작부터 그 지점까지 가는 최소 거리 저장
    // 방문 여부 나타내는 배열을 만들어서 방문 여부 저장
    // bfs
// 구현
    // bfs(캐릭터 좌표)
        // q.add(캐릭터 좌표)
        // while(!q.isEmty())
            // q.poll()
            // visited[현재] = true;
            // for(현재 위치부터 다음위치 동서남북)
                // if(다음위치가 둘레 위&&방문안함)
                    // q.add(다음위치)
                    // 거리 = 현재위치거리 + 1
import java.util.*;

class Solution {
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        
        
        for(int[] el : rectangle){
            fill(el[0]*2, el[1]*2, el[2]*2, el[3]*2);
        }
        
        bfs(new Position(characterX*2, characterY*2), new Position(itemX*2, itemY*2));
        
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
    public void bfs(Position pos, Position itemPos){
        int[] x_cord = {0, 0, -1, 1};
        int[] y_cord = {1, -1, 0, 0};
        int[][] distance = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        
        Queue<Position> q = new LinkedList<Position>();
        q.add(pos);
        
        while(!q.isEmpty()){
            Position cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            visited[curX][curY] = true;
            if(curX == itemPos.x && curY == itemPos.y){
                answer = Math.min(answer, distance[curX][curY]);
            }
            for(int i = 0; i<4; i++){
                int nextX = curX + x_cord[i];
                int nextY = curY + y_cord[i];
                // 좌표 벗어난 경우
                if(nextX < 0 || nextX > 100 || nextY < 0 || nextY > 100){
                    continue;
                }
                // 테두리 아닌 경우
                if(map[nextX][nextY] != 1 || visited[nextX][nextY]){
                    continue;
                }
                distance[nextX][nextY] = distance[curX][curY] + 1;
                q.add(new Position(nextX, nextY));
            }
        }
    }

}
    
class Position{
    int x;
    int y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}