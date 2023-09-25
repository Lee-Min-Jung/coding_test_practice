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
    static int answer = -1;
    static Queue<int[]> q = new LinkedList<int[]>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 토마토 상태 저장
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                int target = Integer.parseInt(st.nextToken());
                if(target == 1){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
                map[i][j] = target;
            }
        }
        // bfs 진행
        bfs();

        // 토마토 상태 확인
        boolean isZero = false;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(map[i][j] == -1){
                    continue;
                }else if(map[i][j] != 0){
                    answer = Math.max(answer, map[i][j]);
                }else if(map[i][j] == 0){
                    isZero = true;
                }
            }
        }


        // 정답 출력
        if(isZero){
            System.out.println(-1);
        }else{
            System.out.println(answer-1);
        }



    }

    public static void bfs(){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == -1 || visited[nx][ny]) continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                map[nx][ny] = map[cx][cy] + 1;
            }
        }
    }










}