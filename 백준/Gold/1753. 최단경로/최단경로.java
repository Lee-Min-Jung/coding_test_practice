

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;


public class Main {
    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        distance = new int[V+1];
        visited = new boolean[V+1];
        list = new ArrayList[V+1];

        // 연결리스트 만들기
        for(int i = 1; i<=V; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        // 거리 배열
        for(int i = 1; i<=V; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        // 다익스트라 알고리즘을 통해 최단 거리 배열 구하기
        dij();

        // 거리 배열 출력
        for(int i = 1; i<=V; i++){
            if(visited[i]){
                System.out.println(distance[i]);
            }else{
                System.out.println("INF");
            }
        }



    }

    public static void dij(){
        q.add(new Edge(K, 0));
        distance[K] = 0;

        while(!q.isEmpty()){
            Edge cur = q.poll();
            int c_v = cur.vertex;
            if(visited[c_v]) {
                continue;
            }
            visited[c_v] = true;
            for(int i = 0; i<list[c_v].size(); i++){
                Edge tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                // distance[next]는 출발점에서 next까지 알려진 최단 거리(과거)
                // distance[c_v]+value 는 출발점에서 next까지 새롭게 계산한 최단 거리(새롭게 계산)
                    // 만약 새롭게 계산한 것이 더 짧다면 업데이트를 해야 한다 그리고 해당 노드까지의 가장 짧은 거리가 새로 업뎃되었으니
                        // 해당 노드를 지나는 경로를 다시 재조사해야 한다. 그러니 큐에 넣는다
                    // 만약 새롭게 계산한 것이 더 길다면 업데이트를 안 해도 된다
                        // 이는 기존에 계산한 것이 더 짧다는 것을 의미하니, 그 노드를 지나는 앞으로의 경로를 굳이 재조사하지 않아도 된다
                        // 그러니 큐에 넣지 않는다.
                if(distance[next] > distance[c_v] + value){
                    distance[next] = distance[c_v] + value;
                    q.add(new Edge(next, distance[next]));
                }
            }
        }
    }





}

class Edge implements Comparable<Edge> {
    int vertex, value;

    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge e){
        if(this.value > e.value) return 1;
        else return -1;
    }
}





