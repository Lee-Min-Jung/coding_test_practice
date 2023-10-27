import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 입력
        N = Integer.parseInt(sc.next());
        dp = new int[N+1];
        // dp
        dp[1]=0;

        for(int i = 2; i<=N; i++){
            dp[i] = dp[i-1]+1;
            if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }

        System.out.println(dp[N]);





    }







}

