


import java.io.*;
import java.util.*;

// 주어진 인접행렬 저장
// 플로이드 워셜을 이용해서 경로가 존재하는지 확인
    // [출발-중간]과 [중간-도착] 모두 1이면 출발-도착 경로가 있는 것

public class Main {
    static int N;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 저장
        N = Integer.parseInt(br.readLine());

        // 인접 행렬
        adj = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 워셜 수행
        floyd();

        // 정답 출력
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void floyd(){
        for(int k = 1; k<=N; k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    if(adj[i][k] == 1 && adj[k][j] == 1){
                        adj[i][j] = 1;
                    }
                }
            }
        }
    }





}











