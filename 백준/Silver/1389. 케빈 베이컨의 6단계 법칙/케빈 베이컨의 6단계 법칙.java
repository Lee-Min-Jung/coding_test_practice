


import java.io.*;
import java.util.*;

// 입력 받은 정보로 인접 행렬을 만들기
// 플로이드 워셜 진행

public class Main {
    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접행렬
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
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj[s][e] = 1;
            adj[e][s] = 1;;
        }

        // 플로이드 워셜
        floyd();

        // 각 노드별 단계 수 구하기
        int[] kebin = new int[N+1];
        for(int i = 1; i<=N; i++){
            int sum = 0;
            for(int j = 1; j<=N; j++){
                if(adj[i][j] != 10000001){
                    sum += adj[i][j];
                }
            }
            kebin[i] = sum;
        }

        // 답 출력
        int minIndex = 1;
        for(int i = 1; i<=N; i++){
            if(kebin[i] < kebin[minIndex]){
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }

    public static void floyd(){
        for(int k = 1; k<=N; k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    if(adj[i][k] + adj[k][j] < adj[i][j]){
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }
    }







}











