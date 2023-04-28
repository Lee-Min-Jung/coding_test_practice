

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

// 다익스트라 알고리즘으로 출발노드부터 출발해서 각 노드까지의 최소비용 구해서 도착노드의 최소비용 리턴하기

public class Main {
    static int N, M;
    static ArrayList<Edge>[] arr;
    static int[] minCost;
    static boolean[] visited;
    static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        minCost = new int[N+1];
        visited = new boolean[N+1];

        // 인접 리스트 생성
        for(int i = 1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Edge(e, v));
        }

        // 비용 배열 초기화
        for(int i = 1; i<=N; i++){
            minCost[i] = Integer.MAX_VALUE;
        }

        // 출발과 도착 노드 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 최소 비용 배열 구하기
        dij(start);

        // 정답 출력
        System.out.println(minCost[end]);

    }

    // 다익스트라 알고리즘
    public static void dij(int start){
        q.offer(new Edge(start, 0));
        minCost[start] = 0;

        while(!q.isEmpty()){
            Edge cur = q.poll();
            int curVertex = cur.vertex;

            if(visited[curVertex]){
                continue;
            }
            visited[curVertex] = true;

            for(int i = 0; i<arr[curVertex].size(); i++){
                int nextVertex = arr[curVertex].get(i).vertex;
                int nextValue = arr[curVertex].get(i).value;
                if(minCost[nextVertex] > minCost[curVertex] + nextValue){
                    minCost[nextVertex] = minCost[curVertex] + nextValue;
                    q.offer(new Edge(nextVertex, minCost[nextVertex]));
                }
            }
        }

    }

}


// 에지
class Edge implements Comparable<Edge>{
    int vertex;
    int value;

    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge e){
        return this.value - e.value;
    }
}





