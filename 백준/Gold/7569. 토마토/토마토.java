import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int M,N,H;
    static int[][][] map;
    static Queue<int[]> q = new LinkedList<int[]>();
    static int[][][] days;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][N][M];
        days = new int[H][N][M];

        // 거리 배열 초기화
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<M; k++){
                    days[i][j][k] = -1;
                }
            }
        }
        // map 입력
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<M; k++){
                    int target = sc.nextInt();
                    if(target == 1){
                        q.offer(new int[]{i, j, k});
                        days[i][j][k] = 0;
                    }
                    map[i][j][k] = target;
                }
            }
        }
        bfs();

        // 확인
        boolean isAllRed = true;
        int answer = 0;
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<M; k++){
                    answer = Math.max(answer, days[i][j][k]);
                    if(map[i][j][k] == 0){
                        isAllRed = false;
                    }
                }
            }
        }
        if(isAllRed){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }


    }

    public static void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[2];
            int cy = cur[1];
            int ch = cur[0];
            for(int i = 0; i<6; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nh = ch + dh[i];
                if(nx < 0 || ny < 0 || nh < 0 || nx >= M || ny >= N || nh >= H) continue;
                if(days[nh][ny][nx] >= 0 || map[nh][ny][nx] == -1) continue;
                q.offer(new int[]{nh, ny, nx});
                map[nh][ny][nx] = 1;
                days[nh][ny][nx] = days[ch][cy][cx] + 1;
            }
        }
    }
}