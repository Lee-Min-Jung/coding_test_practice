import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[] arr;
    static int[] output;
    static HashSet<String> set = new HashSet<>();
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        output = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bt(0, 0);
        System.out.println(answer);

    }

    public static void bt(int depth, int position){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<output.length; i++){
                sb.append(output[i]);
                sb.append(" ");
            }
            if(!set.contains(sb.toString())){
                answer.append(sb.toString());
                answer.append('\n');
                set.add(sb.toString());
            }
            return;
        }
        for(int i = position; i<N; i++){
            output[depth] = arr[i];
            bt(depth+1, i);
        }

    }
}