import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static int[][] distance;
    static int[] start = new int[2];
    static int[] finish = new int[2];
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());


        // 입력 받기
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            distance = new int[N][N];
            for(int j = 0; j<N; j++){
                for(int k = 0; k<N; k++){
                    distance[j][k] = -1;
                }
            }
            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            finish[0] = Integer.parseInt(st.nextToken());
            finish[1] = Integer.parseInt(st.nextToken());
            distance[start[0]][start[1]] = 0;
            bfs(start[0], start[1]);
        }




    }

    public static void bfs(int x, int y){
        if(x == finish[0] && y == finish[1]){
            System.out.println(0);
            return;
        }
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<8; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(finish[0] == nx && finish[1] == ny){
                    distance[nx][ny] = distance[cx][cy]+1;
                    System.out.println(distance[nx][ny]);
                    return;
                }
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(distance[nx][ny] >= 0) continue;
                q.offer(new int[]{nx, ny});
                distance[nx][ny] = distance[cx][cy] + 1;
            }
        }

    }

}