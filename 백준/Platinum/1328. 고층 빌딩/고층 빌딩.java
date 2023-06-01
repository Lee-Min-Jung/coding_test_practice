import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// D[N][L][R] 총 N개가 있고 왼쪽에서 L개 오른쪽에서 R개가 보일 때 가능한 경우의 수
// N-1개의 빌딩이 이미 배치되어 있고 모든 경우의 수를 알고 있다고 가정하자
    // 가장 작은 빌딩을 이미 배치되어 있는 곳에 배치한다고 했을 때
        // 맨 왼쪽에 배치하는 경우: L의 개수가 하나 증가
        // 맨 오른쪽에 배치하는 경우: R의 개수가 하나 증가
        // 아무 가운데에 배치하는 경우: L과 R의 개수가 증가하지 않음, 하지만 맨 앞과 맨 끝을 제외한 위치에 배치해서 경우의 수가 늘어남
// D[N][L][R] = D[N-1][L-1][R] + D[N-1][L][R-1] + D[N-1][L][R]*(N-2)




public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 개수 입력
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        // D배열
        long[][][] D = new long[N+1][L+1][R+1];
        D[1][1][1] = 1;
        for(int i = 2; i<=N; i++){
            for(int j = 1; j<=L; j++){
                for(int k = 1; k<=R; k++){
                    D[i][j][k] = (D[i-1][j-1][k] + D[i-1][j][k-1] + D[i-1][j][k]*(i-2)) % 1000000007;
                }
            }
        }

        // 정답 출력
        System.out.println(D[N][L][R]);
    }


}




