
import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] adj = new int[N+1][N+1];
        int[] route = new int[M+1];

        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 1; i<=M; i++){
            route[i] = Integer.parseInt(st2.nextToken());
        }

        parent = new int[N+1];
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(adj[i][j] == 1){
                    union(i,j);
                }
            }
        }

        int index = find(route[1]);
        for(int i = 2; i<route.length; i++){
            if(index != find(route[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }



}



