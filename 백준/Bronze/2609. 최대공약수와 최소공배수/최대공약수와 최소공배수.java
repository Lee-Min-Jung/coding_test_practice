import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        solution(N, M);


    }
    static void solution(int n, int m){
        int small = Math.min(n, m);
        int max = 0;
        int min = 0;
        // 최대공약수
        for(int i = 1; i<=small; i++){
            if(n % i == 0 && m % i == 0){
                max = i;
            }
        }
        System.out.println(max);
        // 최소공배수
        min = (n/max)*(m/max)*max;
        System.out.println(min);

    }





}

