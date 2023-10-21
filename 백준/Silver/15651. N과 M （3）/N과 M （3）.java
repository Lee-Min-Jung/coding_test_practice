import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        output = new int[M];

        bt(0);

        System.out.println(sb);

    }
    static void bt(int depth){
        if(depth == M){
            for(int i = 0; i<M; i++){
                sb.append(output[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i<N; i++){
            output[depth] = i+1;
            bt(depth+1);
        }
    }




}

