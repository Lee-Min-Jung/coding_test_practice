import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // map 만들기
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs 실행
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);


    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<int[]>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int temp = 1;

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(!visited[nextX][nextY] && map[nextX][nextY] == 1){
                    q.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    temp++;
                }
            }
        }
        max = Math.max(max, temp);
        count++;

    }






}