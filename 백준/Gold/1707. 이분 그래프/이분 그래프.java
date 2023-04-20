
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            isEven = true;

            for(int j = 1; j<=V; j++){
                A[j] = new ArrayList<Integer>();
            }

            for(int k = 1; k<=E; k++){
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                A[num1].add(num2);
                A[num2].add(num1);
            }

            for(int l = 1; l<=V; l++){
                if(isEven){
                    dfs(l);
                }else{
                    break;
                }
            }
            if(isEven){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static void dfs(int nodeIndex){
        visited[nodeIndex] = true;
        for(int n : A[nodeIndex]){
            if(!visited[n]){
                check[n] = (check[nodeIndex]+1) % 2;
                dfs(n);
            }else if(check[nodeIndex] == check[n]){
                isEven = false;
            }
        }
    }

}


