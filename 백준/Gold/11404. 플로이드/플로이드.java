


import java.io.*;
import java.util.*;

// 인접 행렬을 만들기
// 플로이드 위셜 알고리즘 수행

public class Main {
    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 세팅
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 인접 행렬
        adj = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(i==j){
                    adj[i][j] = 0;
                }else{
                    adj[i][j] = 10000001;
                }
            }
        }
        for(int i = 1; i<=M; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                if(adj[s][e] > p){
                    adj[s][e] = p;
                }
        }

        // 플로이드 위셜 수행
        floyd();

        // 정답 출력
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(adj[i][j] == 10000001){
                    System.out.print("0 ");
                }else{
                    System.out.print(adj[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    public static void floyd(){
        for(int k = 1; k<=N; k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    if(adj[i][k]+adj[k][j] < adj[i][j]){
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }
    }



}











