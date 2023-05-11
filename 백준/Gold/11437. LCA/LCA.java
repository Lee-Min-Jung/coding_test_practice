import java.io.*;
import java.util.*;

// 인접리스트로 트리를 만든다

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 저장 및 초기화
        N = Integer.parseInt(br.readLine());
        depth = new int[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        // 트리 인접리스트
        adjList = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            adjList[e].add(s);
        }

        // BFS 진행해서 각 노드의 parent와 depth를 구하기
        BFS(1);

        // 질의 개수
        M = Integer.parseInt(br.readLine());

        // 질의
        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = LCA(a, b);
            System.out.println(LCA);
        }



    }

    public static int LCA(int a, int b){
        if(depth[a] < depth[b]){ // 깊이가 깊은 것을 a로, 깊이가 낮은 것을 b로 설정
            int temp = a;
            a = b;
            b = temp;
        }
        while(depth[a] != depth[b]){ // 둘 깊이 같아질 때까지 깊이 깊은 것을 부모로 올린다
            a = parent[a];
        }

        while(a!=b){ // 둘 조상 같아질 때까지 각자를 부모로 올린다
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    public static void BFS(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = true;
        int level = 1;
        int nowSize = 1;
        int count = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : adjList[now]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    parent[next] = now;
                    depth[next] = level;
                }
            }
            count++;
            if(count == nowSize){ // 이번 높이에 해당하는 모든 노드를 방문했을 때
                count = 0;
                nowSize = q.size();
                level++;
            }
        }

    }


}



