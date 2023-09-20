import java.util.*;
import java.io.*;
public class Main {
    static int N, S;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        answer = 0;
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bt(0,0);
        if(S == 0){
            System.out.println(answer-1);

        }else{
            System.out.println(answer);

        }
        
    }
    
    public static void bt(int position, int sum){
        if(position == N){
            if(sum == S){
                answer++;
            }
            return;
        }
        bt(position+1, sum);
        bt(position+1, sum+arr[position]);
        
    }
}