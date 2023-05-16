import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException {

        // 배열 만들기
        int[][] D = new int[15][15];
        for(int i = 0; i<15; i++){
            D[0][i] = i;
            D[i][1] = 1;
        }
        for(int i = 1; i<15; i++){
            for(int j = 1; j<15; j++){
                D[i][j] = D[i][j-1] + D[i-1][j];
            }
        }

        // 정답 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(D[k][n]);
        }

    }


}




