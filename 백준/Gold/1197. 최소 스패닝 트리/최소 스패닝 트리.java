


import java.io.*;
import java.util.*;



public class Main {
    static int N, M;
    static int usedEdge, result;
    static PriorityQueue<Edge> pq;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 에지 저장
        pq = new PriorityQueue<>();
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new Edge(s, e, v));
        }

        // 유니온 파인드를 위한 설정
        parent = new int[N+1];
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }


        // 최소신장트리
        usedEdge = 0;
        result = 0;
        mst();

        // 정답 출력
        System.out.println(result);

    }

    public static void mst(){
        while(usedEdge < N-1){
            Edge edge = pq.poll();
            if(find(edge.s) != find(edge.e)){
                union(edge.s, edge.e);
                result += edge.v;
                usedEdge++;
            }
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }


}

class Edge implements Comparable<Edge>{
    int s;
    int e;
    int v;

    Edge(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge o){
        return this.v - o.v;
    }
}











