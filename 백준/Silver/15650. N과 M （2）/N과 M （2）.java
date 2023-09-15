import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] output;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        output = new int[M];

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
            output[depth] = i+1;
            bt(depth+1, i+1);
        }

    }
}
