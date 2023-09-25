import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int tempAnswer;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        // 체스 좌표 저장
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 칸부터 시작
        tempAnswer = 0;
        dfs(0, 0);
        answer += tempAnswer;

        // 두 번째칸부터 시작
        tempAnswer = 0;
        dfs(1, 0);
        answer += tempAnswer;

        // 정답
        System.out.println(answer);


    }
    // 백트래킹으로 비숍 가능한 곳 고르기
    public static void dfs(int index, int count){
        if(index >= N*N){
            tempAnswer = Math.max(tempAnswer, count);
            return;
        }

        int x = index / N;
        int y = index % N;
        int increment = calIncrement(index);

        if(map[x][y] == 0){
            dfs(index+increment, count);
            return;
        }

        if(isValid(x, y)){
            map[x][y] = 2;
            dfs(index+increment, count+1);
            map[x][y] = 1;
        }

        dfs(index+increment, count);
    }

    // 좌표 증가 값 구하기
    public static int calIncrement(int index){
        if(N % 2 == 1) return 2;
        if(index % N == N-1) return 1;
        else if(index % N == N-2) return 3;
        else return 2;
    }
    // 대각선끼리 안 겹치는지 고르기
    public static boolean isValid(int x, int y){
        int[] dx = {1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1};

        for(int i = 0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            for(int j = 1; j<=N; j++){
                if(nx >= 0 && ny >= 0 && nx <N && ny < N){
                    if(map[nx][ny] == 2) return false;
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        return true;
    }
}