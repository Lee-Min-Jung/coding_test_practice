import java.io.*;
import java.util.*;


// M개 중 N개를 조합으로 선택하면 된다
// M의 최댓값이 30이니 그걸 가지고 조합 배열을 만들어 놓는다

public class Main {


    public static void main(String[] args) throws IOException {
        // 조합 배열
        long[][] D = new long[31][31];
        for(int i = 0; i<=30; i++){
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }
        for(int i = 2; i<=30; i++){
            for(int j = 1; j<i; j++){
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }

        // 질의 개수 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 정답 출력
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(D[m][n]);
        }


    }


}




