

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;




public class Main {
    static int N;
    static int M;
    static Edge edges[];
    static long distance[];
    static boolean mCycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 개수 저장
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 에지 리스트 생성
        edges = new Edge[M];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        // 최단 거리 배열 생성
        distance = new long[N+1];
        for(int i = 1; i<=N; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        // 출발 노드의 최단 경로 수정
        distance[1] = 0;

        // 벨만 포드 진행
        bellFord();

        // 음수 사이클 확인
        for(int i = 0; i<M; i++){
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time){
                mCycle = true;
            }
        }

        if(!mCycle){ // 음수 사이클이 없으면 출발노드로부터 해당 노드까지의 최단 경로가 있으면 최단 경로 값을 출력
            for(int i = 2; i<=N; i++){
                if(distance[i] == Integer.MAX_VALUE){ // 최단 경로 없음
                    System.out.println("-1");
                }else{
                    System.out.println(distance[i]); // 최단 경로 있음
                }
            }
        }else{ // 음수 사이클이 있음
            System.out.println("-1");
        }

    }

    public static void bellFord(){
        for(int i = 1; i<N; i++){
            for(int j = 0; j<M; j++){
                Edge edge = edges[j];
                if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time){
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
    }




}

class Edge{
    int start, end, time;
    public Edge(int start, int end, int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}









