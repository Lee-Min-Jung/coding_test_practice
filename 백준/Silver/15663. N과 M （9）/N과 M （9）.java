import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<String>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        output = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bt(0);
    }

    public static void bt(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<output.length; i++){
                sb.append(String.valueOf(output[i]) + " ");
            }
            if(!set.contains(sb.toString())){
                System.out.println(sb);
            }
            set.add(sb.toString());
            return;
        }
        for(int i = 0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                bt(depth+1);
                visited[i] = false;
            }
        }

    }
}