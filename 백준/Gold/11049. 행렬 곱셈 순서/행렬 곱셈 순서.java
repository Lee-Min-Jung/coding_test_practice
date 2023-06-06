import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// D[i][j]: i부터 j까지의 행렬을 곱했을 때의 가장 적은 곱셈 횟수
// D[i][j] = D[1][j-1] + D[j][j] + 앞 두 개 곱할 때 드는 곱셈 횟수(1번째 행렬의 행 개수 * j번째 행렬의 행 개수 * j번째 행렬의 열 개수)
// 행렬이 1개 : 0
// 행렬이 2개 : 앞 행 * 뒤 행 * 뒤 열
// 행렬이 3개 : min(min, D[s][i] + D[i+1][e] + a)





public class Main {
    static int N;
    static Matrix[] M;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 개수 입력 받기
        N = sc.nextInt();

        // M 채우기
        M = new Matrix[N+1];
        for(int i = 1; i<=N; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            M[i] = new Matrix(r, c);
        }

        // D 채우기
        D = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                D[i][j] = -1;
            }
        }

        // 결과 리턴
        System.out.println(excute(1, N));
    }

    // 모든 행렬 곱한 후 최소 연산 횟수 구하는 함수
    static int excute(int s, int e){
        int result = Integer.MAX_VALUE;

        // 메모이제이션을 이용해 이미 알고 있는 값인지 아닌지 확인
        if(D[s][e] != -1){
            return D[s][e];
        }

        // 행렬 1개의 곱셈인 경우
        if(s == e){
            return 0;
        }

        // 행렬 2개의 곱셈인 경우
        if(s+1 == e){
            return M[s].r * M[e].r * M[e].c;
        }

        // 행렬이 3개 이상인 경우
        for(int i = s; i<e; i++){
            result = Math.min(result, excute(s,i) + excute(i+1, e) + M[s].r * M[i].c * M[e].c);
        }

        return D[s][e] = result; // 리턴하면서 동시에 저장(메모이제이션)
    }


    // 행렬 클래스
    static class Matrix{
        private int r;
        private int c;
        Matrix(int r, int c){
            this.r = r;
            this.c = c;
        }
    }


}




