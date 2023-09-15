import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] output;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N];
        output = new int[M];

        bt(0);
    }

    public static void bt(int depth){
        if(depth == M){
            for(int i = 0; i<output.length; i++){
                System.out.print(output[i] +" ");
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
