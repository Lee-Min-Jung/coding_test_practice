import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] output = new int[6];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while(true){
            N = sc.nextInt();
            if(N == 0){
                break;
            }
            arr = new int[N];
            for(int i = 0; i<N; i++){
                arr[i] = sc.nextInt();
            }
            bt(0,0);
            System.out.println();
        }



    }
    public static void bt(int depth, int position){
        if(depth == 6){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<output.length; i++){
                sb.append(output[i] + " ");
            }
            System.out.println(sb);
            return;
        }
        for(int i = position; i<N; i++){
            output[depth] = arr[i];
            bt(depth+1, i+1);
        }
    }
}