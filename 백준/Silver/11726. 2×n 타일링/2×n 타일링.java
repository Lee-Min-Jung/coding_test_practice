import java.io.*;
import java.util.*;

// 그림 그려보면 dp라는 것이 딱 보인다
// n-1까지 타일이 채워져 있다고 하면 가능한 경우의 수는 1가지이다.(세로로 긴 것) 그러니 n-1까지 타일 채운 경우의 수와 같다
// n-2까지 타일이 채워져 있다고 하면 가능한 경우의 수는 1가지이다.(가로 2개)(세로 2개는 위에서 구한 거라 빼야 하니까) 그러니 n-2까지 타일 채운 경우의 수와 같다
// 그래서 점화식: D[i] = D[i-1] + D[i-2]

public class Main {



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 개수 입력
        int N = sc.nextInt();

        // D배열
        int[] D = new int[N+2];
        D[1] = 1;
        D[2] = 2;
        for(int i = 3; i<=N; i++){
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }

        // 정답 출력
        System.out.println(D[N]);
    }




}




