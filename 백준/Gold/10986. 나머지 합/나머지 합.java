import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;
        
        st = new StringTokenizer(bufferedReader.readLine());
        S[0] = Long.parseLong(st.nextToken());
        
        for(int i = 1; i<N; i++){
            S[i] = S[i-1] + Long.parseLong(st.nextToken());
        }
        for(int i = 0; i<N; i++){
            int remainder = (int)(S[i] % M);
            if(remainder == 0){
                answer++;
            }
            C[remainder]++;
        }
        for(int i = 0; i<M; i++){
            if(C[i] > 1){
                answer += (C[i] * (C[i]-1)) / 2;
            }
        }
        System.out.println(answer);
    }
}