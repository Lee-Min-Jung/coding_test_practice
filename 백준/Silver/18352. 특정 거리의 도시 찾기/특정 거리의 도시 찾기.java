
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static List<Integer>[] A;
    static int[] visited;
    static int N, M, K, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new List[N+1];
        visited = new int[N+1];
        for(int i = 1; i<=N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            A[num1].add(num2);
        }
        for(int i =1; i<=N; i++){
            visited[i] = -1;
        }
        bfs(X);
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i<=N; i++){
            if(visited[i] == K){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(answer);
            for(int n : answer){
                System.out.println(n);
            }
        }


    }

    public static void bfs(int nodeIndex){
        Queue<Integer> q = new LinkedList<>();
        q.offer(nodeIndex);
        visited[nodeIndex]++;
        while(!q.isEmpty()){
            int nowNode = q.poll();
            for(int i : A[nowNode]){
                if(visited[i] == -1){
                    visited[i] = visited[nowNode]+1;
                    q.offer(i);
                }
            }
        }

    }







}


