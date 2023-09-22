import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static char[][] map;
    static int[][] output;
    static int[][] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        output = new int[7][2];
        map = new char[5][5];
        arr = new int[25][2];
        // 각 좌표별로 S인지 Y인지 담기
        for(int i = 0; i<5; i++){
            map[i] = sc.next().toCharArray();
        }
        // 모든 좌표 담기
        int index = 0;
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                arr[index][0] = i;
                arr[index][1] = j;
                index++;
            }
        }
        bt(0, 0);

        System.out.println(answer);


    }
    // 백트래킹
    public static void bt(int depth, int position){
        if(depth == 7){
            if(isAdj(output) && isOver4(output)){
                answer++;
            }


            return;
        }
        for(int i = position; i<25; i++){
            output[depth][0] = arr[i][0];
            output[depth][1] = arr[i][1];
            bt(depth+1, i+1);
        }
    }

    // 조건1 : S 4개 이상인지
    public static boolean isOver4(int[][] output){
        int count = 0;
        for(int i = 0; i<output.length; i++){
            int x = output[i][0];
            int y = output[i][1];
            if(map[x][y] == 'S'){
                count++;
            }
        }
        if(count >= 4){
            return true;
        }
        return false;
    }

    // 조건2: 동서남북 인접인지
    public static boolean isAdj(int[][] output){
        Queue<int[]> q = new LinkedList<int[]>();
        boolean[][] visited = new boolean[5][5];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[] position = {output[0][0], output[0][1]};
        int count = 1;
        q.add(position);
        visited[position[0]][position[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length){
                    if(!visited[nextX][nextY]){
                        for(int j = 0; j<output.length; j++){
                            if(output[j][0] == nextX && output[j][1] == nextY){
                                count++;
                                visited[nextX][nextY] = true;
                                q.add(new int[]{nextX, nextY});
                                break;
                            }
                        }
                    }
                }
            }
        }

        if(count == 7){
            return true;
        }
        return false;




    }

}