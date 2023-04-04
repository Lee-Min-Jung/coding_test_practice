import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] A;
    static boolean[] visited;
    static int N;
    static int M;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new List[N];
        visited = new boolean[N];
        for(int i = 0; i<N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            A[e].add(s);
            A[s].add(e);
        }
        arrive = false;
        for(int i = 0; i<N; i++){
            DFS(i, 1);
            if(arrive){
                break;
            }
        }
        if(arrive){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    static void DFS(int num, int depth){
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }
        visited[num] = true;
        for(int n : A[num]){
            if(!visited[n]){
                DFS(n, depth+1);
            }
        }
        visited[num] = false;
    }



}