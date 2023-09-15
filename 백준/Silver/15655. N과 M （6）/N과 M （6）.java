import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] output;
    static boolean[] visited;
    static int[] arr;
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
        bt(0, 0);


    }

    public static void bt(int depth, int position){
        if(depth == M){
            for(int i = 0; i<output.length; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = position; i<N; i++){
            output[depth] = arr[i];
            bt(depth+1, i+1);
        }


    }
}
