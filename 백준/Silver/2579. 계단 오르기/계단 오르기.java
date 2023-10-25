import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static int[] score;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 및 초기화
        N = Integer.parseInt(st.nextToken());
        score = new int[N+1];
        d = new int[N+1][3];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
        }

        // 1이면 예외처리
        if(N == 1){
            System.out.println(score[1]);
            return;
        }
        // dp 수행
        d[1][1] = score[1];
        d[1][2] = 0;
        d[2][1] = score[2];
        d[2][2] = score[1]+score[2];
        for(int i = 3; i<=N; i++){
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + score[i];
            d[i][2] = d[i-1][1] + score[i];
        }

        // 정답
        System.out.println(Math.max(d[N][1], d[N][2]));
    }









}

