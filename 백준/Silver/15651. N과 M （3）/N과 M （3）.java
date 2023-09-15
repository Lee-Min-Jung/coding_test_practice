import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] output;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        output = new int[M];

        bt(0);

        System.out.print(sb);
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
            output[depth] = i+1;
            bt(depth+1);
        }


    }
}
