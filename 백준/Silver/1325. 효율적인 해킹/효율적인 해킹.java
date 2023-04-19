
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// 그래프를 구한다
// 구한 그래프를 탐색하면서 탐색이 끝날 때까지 몇 개의 노드를 거쳤는지 저장한다
    // bfs나 dfs나 상관 없다
// 위에서 저장한 걸 돌면서 가장 큰 수를 가진 인덱스를 뽑아서 답으로 리턴한다
public class Main {
    static List<Integer>[] A;
    static boolean[] visited;
    static int[] visitNodeCount;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new List[N+1];
        for(int i = 1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            A[num1].add(num2);
        }
        visitNodeCount = new int[N+1];
        for(int i = 1; i<=N; i++){
            visited = new boolean[N+1];
            bfs(i);
        }
        int max = 0;
        for(int i = 1; i<=N; i++){
            max = Math.max(max, visitNodeCount[i]);
        }
        for(int i = 1; i<=N; i++){
            if(visitNodeCount[i] == max){
                System.out.print(i + " ");
            }
        }



    }

    public static void bfs(int nodeIndex){
        Queue<Integer> q = new LinkedList<>();
        q.offer(nodeIndex);
        visited[nodeIndex] = true;
        while(!q.isEmpty()){
            int nowNode = q.poll();
            for(int n : A[nowNode]){
                int temp = n;
                if(!visited[temp]){
                    visited[temp] = true;
                    visitNodeCount[n]++;
                    q.offer(temp);
                }
            }
        }
    }







}


