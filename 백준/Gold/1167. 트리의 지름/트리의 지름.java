import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] A;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            A[i] = new ArrayList<Edge>();
        }
        for(int i = 1; i<=N; i++){
            int nodeIndex = sc.nextInt();
            while(true){
                int edgeIndex = sc.nextInt();
                if(edgeIndex == -1){
                    break;
                }
                int edgeValue = sc.nextInt();
                A[nodeIndex].add(new Edge(edgeIndex, edgeValue));
            }
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(1);
        int max = 1;
        for(int i = 2; i<=N; i++){
            if(distance[max] < distance[i]){
                max = i;
            }
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    public static void BFS(int index){
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        visited[index] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(Edge i : A[now]){
                int e = i.e;
                int v = i.value;
                if(!visited[e]){
                    visited[e] = true;
                    q.offer(e);
                    distance[e] = distance[now] + v;
                }
            }
        }
    }
}

class Edge{
    int e;
    int value;
    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}