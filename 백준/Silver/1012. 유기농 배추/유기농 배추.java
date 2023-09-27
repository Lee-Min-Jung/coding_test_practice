import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K;
    static int[][] baechu;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        // 테스트 케이스 별로 입력 받기
        for(int i = 0; i<T; i++){
            answer = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            baechu = new int[K][2];
            visited = new boolean[M][N];
            for(int j = 0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                baechu[j][0] = x;
                baechu[j][1] = y;
                map[x][y] = 1;
            }
            for(int k = 0; k<baechu.length; k++){
                if(!visited[baechu[k][0]][baechu[k][1]]){
                    bfs(baechu[k][0], baechu[k][1]);
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<int[]>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}