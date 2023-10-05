import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N;
    static int target;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        target = sc.nextInt();
        map = new int[N][N];

        int idx = 0;
        int curx = 0;
        int cury = 0;
        map[curx][cury] = N*N;

        while(idx < 4){
            int nx = curx + dx[idx];
            int ny = cury + dy[idx];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 0) {
                map[nx][ny] = map[curx][cury] - 1;
                if(map[nx][ny] == 1) break;
                curx = nx;
                cury = ny;
            }
            else {
                idx++;
            }
            if(idx >= 4) idx = 0;
        }
        int ax = 0;
        int ay = 0;
        int ansX = 0, ansY = 0; // 찾아야 하는 수의 좌표 변수
        // 정답 출력
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                if(map[i][j] == target) {
                    ansX = i + 1;
                    ansY = j + 1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(ansX + " " + ansY);

        System.out.println(sb);

    }

}