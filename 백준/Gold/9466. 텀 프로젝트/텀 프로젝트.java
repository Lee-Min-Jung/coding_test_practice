import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N;
    static int[] arr = new int[100005];
    static int[] state = new int[100005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Arrays.fill(state, 1, N+1, 0);
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 1; j<=N; j++){
                if(state[j] == 0) run(j);
            }
            int answer = 0;
            for(int j = 1; j<=N; j++){
                if(state[j] != -1) answer++;
            }
            System.out.println(answer);
        }
    }

    public static void run(int x){
        int cur = x;
        while(true){
            state[cur] = x;
            cur = arr[cur];
            if(state[cur] == x){
                while(state[cur] != -1){
                    state[cur] = -1;
                    cur = arr[cur];
                }
                return;
            }else if(state[cur] != 0) return;
        }
    }


}
