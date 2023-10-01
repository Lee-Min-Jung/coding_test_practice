import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int group = 0;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // map만들기
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                int target = Integer.parseInt(st.nextToken());
                map[i][j] = target;
            }
        }

        // 2덩어리 나올 때까지 빙산 수정
        while(true){
            group = 0;
            groupCount();
            if(group >= 2) break;
            if(group == 0){
                answer = 0;
                break;
            }
            bfsRevise();
            answer++;
        }

        System.out.println(answer);


    }
    // 빙산 그룹 세기
    public static void groupCount(){
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    Queue<int[]> q = new LinkedList<int[]>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int cx = cur[0];
                        int cy = cur[1];
                        for(int k = 0; k<4; k++){
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];
                            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if(map[nx][ny] == 0 || visited[nx][ny]) continue;
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                    group++;
                }
            }
        }
    }

    // 빙산 수정 bfs
    public static void bfsRevise(){

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] != 0 || visited[nx][ny]) continue;
                if(map[cx][cy]-1 >= 0) map[cx][cy] -= 1;
                visited[cx][cy] = true;
            }
        }
    }
}