import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 값 저장
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 조합 결과 배열
        int[][] D = new int[N+1][N+1];
        for(int i = 0; i<=N; i++){
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }
        for(int i = 2; i<=N; i++){
            for(int j = 1; j<i; j++){
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        // 정답 출력
        System.out.println(D[N][K]);

    }


}




