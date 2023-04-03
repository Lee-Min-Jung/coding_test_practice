import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        A = new List[N+1];
        for(int i = 1; i<=N; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int answer = 0;
        for(int i = 1; i<=N; i++){
            if(!visited[i]){
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);

    }

    private static void DFS(int nodeIndex){
        if(visited[nodeIndex]){
            return;
        }
        visited[nodeIndex] = true;
        for(int node : A[nodeIndex]){
            if(!visited[node]){
                DFS(node);
            }
        }
    }



}