import java.io.*;
import java.util.*;

// 숫자 다음에 그 숫자보다 하나 작은 거, 하나 큰 거 붙이면 계단 수를 2개 만들 수 있다
    // 그런데 그 숫자가 0이거나 9일 때는 1개만 더 붙여서 만들 수 있다.
// D[N][i] 은 N자리 수에서 맨 뒤 수가 i인 수의 개수
    // D[1][2] = 1
    // D[2][0] = 1, D[2][3] = 2
    // D[N][i] = D[N-1][i-1] + D[N-1][i+1]
    // 그런데 i가 0인 경우와 9인 경우에는 다르게 처리 해야 한다
        // D[N][0] = D[N-1][1], D[N][9] =  D[N-1][8]
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 자릿수 저장
        int N = sc.nextInt();

        // 점화식이용해 배열 저장
        long[][] D = new long[N+1][11];
        for(int i = 1; i<=9; i++){
            D[1][i] = 1;
        }
        for(int i = 2; i<=N; i++){
            D[i][0] = D[i-1][1];
            D[i][9] = D[i-1][8];
            for(int j = 1; j<=8; j++){
                D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % 1000000000;
            }
        }

        // 정답
        long answer = 0;
        for(int i = 0; i<=9; i++){
            answer = (answer + D[N][i]) % 1000000000;
        }
        System.out.println(answer);
    }




}




