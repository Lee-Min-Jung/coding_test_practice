import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] distance;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[2][N][M];



        // 지도 생성 및 거리배열 초기화 및 벽 리스트 저장
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for(int j = 0; j<str.length; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        // bfs
        bfs(0, 0);



    }

    public static void bfs(int x, int y){
        if(N-1 == 0 && M-1 == 0){
            System.out.print(1);
            return;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        distance[x][y] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 도착
                if(nx == N-1 && ny == M-1){
                    distance[nx][ny] = distance[cx][cy] + 1;
                    System.out.println(distance[nx][ny]);
                    return;
                }
                // 범위 벗어남
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 다음이 벽
                if(map[nx][ny] == 1){
                    if(cd == 0 && !visited[1][nx][ny]){
                        visited[cd][nx][ny] = true;
                        distance[nx][ny] = distance[cx][cy] + 1;
                        q.offer(new int[]{nx, ny, 1});
                    }
                }
                // 다음이 벽 아님
                else{
                    if(!visited[cd][nx][ny]){
                        visited[cd][nx][ny] = true;
                        distance[nx][ny] = distance[cx][cy] + 1;
                        q.offer(new int[]{nx, ny, cd});
                    }
                }
            }
        }
        System.out.println(-1);

    }
}

