

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

// k번째 최단 경로를 찾아야 하기 때문에 일반 distance 배열을 사용할 수 없다.
// 대신, 출발 노드에서 각 노드로 가는 최단 경로만 저장하는 것이 아니라 모든 경로의 거리를 저장하도록 배열 안에 우선순위 큐를 사용한다
// 우선 순위 큐인 이유는 경로가 작은 순으로 저장되어야 하는데 우선순위 큐는 그걸 자동으로 해주기 때문에




public class Main {
    static int N, M, K;
    static ArrayList<Edge>[] arr;
    static PriorityQueue<Integer>[] distQueue;
    static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 개수 받아오기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 우선순위 거리 배열 초기화
        distQueue = new PriorityQueue[N+1];
        for(int i = 1; i<=N; i++){
            distQueue[i] = new PriorityQueue<>(K, Collections.reverseOrder());
        }

        // 인접 리스트 초기화
        arr = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[s].add(new Edge(e, v));
        }

        // 다익스트라 실행
        dij();

        // k번째 경로 출력
        for(int i = 1; i<=N; i++){
            if(distQueue[i].size() == K){
                System.out.println(distQueue[i].peek());
            }else{
                System.out.println("-1");
            }
        }


    }

    // 다익스트라 알고리즘
    public static void dij(){
        q.offer(new Edge(1, 0));
        distQueue[1].add(0);

        while(!q.isEmpty()){
            Edge curr = q.poll();
            int curVertex = curr.vertex;
            int curValue = curr.value;
            for(int i = 0; i<arr[curVertex].size(); i++){
                int nextVertex = arr[curVertex].get(i).vertex;
                int nextValue = arr[curVertex].get(i).value;
                if(distQueue[nextVertex].size() < K){
                    distQueue[nextVertex].add(curValue + nextValue);
                    q.offer(new Edge(nextVertex, curValue + nextValue));
                }else if(distQueue[nextVertex].peek() > curValue + nextValue){
                    distQueue[nextVertex].poll();
                    distQueue[nextVertex].offer(curValue+nextValue);
                    q.offer(new Edge(nextVertex, curValue + nextValue));
                }
            }
        }


    }


}

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







