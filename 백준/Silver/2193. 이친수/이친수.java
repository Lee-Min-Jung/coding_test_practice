import java.io.*;
import java.util.*;

// 6자리 중 1번째 1, 2번째는 0으로 확정 된다
// 이걸 바탕으로 n=1일 때부터 개수를 세어보면 피보나치 수열과 같다.
// D 배열의 의미는 해당 자릿수 중 이친수의 개수
// 점화식: D[i] = D[i-1] + D[i-2];

public class Main {



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();

        // D 배열
        long[] D = new long[N+2];
        D[1] = 1;
        D[2] = 1;
        for(int i = 3; i<=N; i++){
            D[i] = D[i-1] + D[i-2];
        }

        System.out.println(D[N]);
    }




}




