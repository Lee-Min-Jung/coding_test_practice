import java.io.*;
import java.util.*;



public class Main {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] depth;
    static int[][] parent;
    static int kmax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 및 초기화
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        depth = new int[N+1];

        // 최대 가능 depth 구해서 k 구하고 parent 초기화 ?
        int temp = 1;
        kmax = 0;
        while(temp<=N){
            temp <<=1;
            kmax++;
        }
        parent = new int[kmax+1][N+1];

        // 트리
        tree = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        // BFS 돌려서 parent 배열 일부(k=0 일 때)와 depth 배열 구하기
        BFS(1);

        // parent 나머지 배열 구하기
        for(int k = 1; k<=kmax; k++){
            for(int n = 1; n<=N; n++){
                parent[k][n] = parent[k-1][parent[k-1][n]];
            }
        }

        // 질의 개수
        M = Integer.parseInt(br.readLine());

        // 질의
        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = excuteLCA(a, b);
            System.out.println(LCA);
        }



    }

    public static int excuteLCA(int a, int b){
        if(depth[a] > depth[b]){ // 더 깊은 게 b
            int temp = a;
            a = b;
            b = temp;
        }

        // 깊이 맞추기 ?
        for(int k = kmax; k >= 0; k--){
            if(Math.pow(2, k) <= depth[b] - depth[a]){
                if(depth[a] <= depth[parent[k][b]]){
                    b = parent[k][b];
                }
            }
        }

        // 조상 찾기 ?
        for(int k = kmax; k >= 0 && a != b; k--){
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        // ?
        int LCA = a;
        if(a!=b){
            LCA = parent[0][LCA];
        }

        return LCA;
    }

    public static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        int level = 1; // 트리의 레벨 표시
        int nowSize = 1; // 현재 레벨에 있는 노드의 개수
        int count = 0; // 현재 살펴본 노드의 개수

        while(!q.isEmpty()){
            int nowNode = q.poll();
            for(int next : tree[nowNode]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    parent[0][next] = nowNode;
                    depth[next] = level;
                }
            }
            count++;
            if(count == nowSize){
                count = 0;
                nowSize = q.size();
                level++;
            }
        }

    }



}




