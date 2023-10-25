import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static int[] R,G,B;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 및 초기화
        N = Integer.parseInt(st.nextToken());
        d = new int[N+1][3];
        R = new int[N];
        G = new int[N];
        B = new int[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                if(j == 0) R[i] = Integer.parseInt(st.nextToken());
                if(j == 1) G[i] = Integer.parseInt(st.nextToken());
                if(j == 2) B[i] = Integer.parseInt(st.nextToken());
            }
        }

        // dp
        d[1][0] = R[0];
        d[1][1] = G[0];
        d[1][2] = B[0];
        for(int i = 2; i<=N; i++){
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + R[i-1];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + G[i-1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + B[i-1];
        }

        // 정답
        if(d[N][0] < d[N][1]){
            if(d[N][0]<d[N][2]){
                System.out.println(d[N][0]);
            }else{
                System.out.println(d[N][2]);
            }
        }else{
            if(d[N][1]<d[N][2]){
                System.out.println(d[N][1]);
            }else{
                System.out.println(d[N][2]);
            }
        }



    }









}

