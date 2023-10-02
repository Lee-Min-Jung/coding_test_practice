import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,R;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 입력받기
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전하기
        for(int i = 0; i<R; i++){
            rotate();
        }

        // 출력하기
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }




    }

    // 회전하기
    public static void rotate(){
        for(int i = 0; i<Math.min(N, M)/2; i++){
            int x = i;
            int y = i;
            int temp = map[x][y];
            int index = 0;
            while(index < 4){
                int nx = x + dx[index];
                int ny = y + dy[index];
                if(nx < N-i && ny < M-i && nx >= i && ny >= i){
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }else{
                    index++;
                }
            }
            map[i+1][i] = temp;
        }
    }
}