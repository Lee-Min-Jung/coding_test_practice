import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] output;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        output = new int[M];
        visited = new boolean[N];
        arr = new int[N];
        st = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        bt(0);

        System.out.println(sb);
    }

    public static void bt(int depth){
        if(depth == M){
            for(int i = 0; i<output.length; i++){
                sb.append(output[i] + " ");
            }
            sb.append('\n');
            return;
        }
        for(int i = 0; i<N; i++){
            output[depth] = arr[i];
            bt(depth+1);
        }


    }
}
