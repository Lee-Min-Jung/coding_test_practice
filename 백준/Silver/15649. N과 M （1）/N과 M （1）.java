import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] output;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        output = new int[M];

        bt(0);

    }
    public static void bt(int depth){
        if(depth == M){
            for(int i = 0; i<M; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = i+1;
                bt(depth+1);
                visited[i] = false;
            }
        }

    }

}