import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int area = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받고 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 그림 상태 입력
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs 진행
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] == 1){
                    count++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(area);

    }
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x,y});
        int areaCount = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int dir = 0; dir<4; dir++){
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                areaCount++;
                map[nx][ny] = -1;
            }
        }
        area = Math.max(areaCount, area);
    }



}

