// 생각
    // 시작점부터 각 점까지 걸리는 최단거리를 배열로 저장한 후 나중에 마지막점에 저장된 값을 확인
// 구현
    // 시작점부터 각 점까지의 최단거리를 저장할 배열 선언
    // for(maps) : 각 점의 동서남북을 bfs 돌면서 거리배열 업뎃
    // bfs(좌표)

import java.util.*;
class Solution {
    static int[][] distance;
    public int solution(int[][] maps) {
        // 변수
        distance = new int[maps.length][maps[0].length];
        // bfs
        distance[0][0] = 1;
        Position position = new Position(0,0);
        int answer = bfs(position, maps);
        

        
        return answer;
        
    }
    
    public int bfs(Position position, int[][] maps){
        Queue<Position> q = new LinkedList<Position>();
        int[] x_cord = {0, 0, -1, 1};
        int[] y_cord = {1, -1, 0, 0};
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        visited[position.x][position.y] = true;
        q.offer(position);
        
        while(!q.isEmpty()){
            Position pos = q.poll();
            int curX = pos.x;
            int curY = pos.y;
            if (curX == maps.length - 1 && curY == maps[0].length - 1) {
                return distance[curX][curY];
            }
            for(int i = 0; i<4; i++){
                int nextX = curX+x_cord[i];
                int nextY = curY+y_cord[i];
                if(nextX >= 0 && nextY >= 0 && nextX < maps.length && nextY < maps[0].length){
                    if(maps[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        Position nextPos = new Position(nextX, nextY);
                        q.offer(nextPos);
                        visited[nextX][nextY] = true;
                        distance[nextX][nextY] = distance[curX][curY] + 1;
                    }
                }
            }
        }
        return -1;
        
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