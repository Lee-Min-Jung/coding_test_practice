import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;







public class Main {
    static int N, M;
    static int[] output;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        output = new int[M];
        visited = new boolean[N];

        backTracking(0);

    }

    public static void backTracking(int depth){
        if(depth == M){
            for(int i = 0; i<output.length; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = i+1;
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }






}




