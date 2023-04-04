import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] A;
    static boolean[] visited;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        A = new List[N+1];
        for(int i = 1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            A[e].add(s);
            A[s].add(e);
        }
        for(int i = 1; i<=N; i++){
            Collections.sort(A[i]);
        }

        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);

    }

    static void DFS(int nodeIndex){
        System.out.print(nodeIndex + " ");
        visited[nodeIndex] = true;
        for(int n : A[nodeIndex]){
            if(!visited[n]){
                DFS(n);
            }
        }
    }

    static void BFS(int nodeIndex){
        Queue<Integer> q = new LinkedList<>();
        q.offer(nodeIndex);
        visited[nodeIndex] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for(int n : A[node]){
                if(!visited[n]){
                    visited[n] = true;
                    q.offer(n);
                }
            }
        }
    }
}