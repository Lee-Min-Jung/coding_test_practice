import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[100001];

        for(int i = 0; i<=100000; i++){
            time[i] = -1;
        }

        time[N] = 0;

        bfs(N);

        System.out.println(time[K]);
    }
    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        int[] dx = {1, -1, 2};

        q.offer(x);

        while(time[K] == -1){
            int cur = q.poll();
            for(int i = 0; i<3; i++){
                int next = cur + dx[i];
                if(dx[i] == 2){
                    next = cur * 2;
                }
                if(next > 100000 || next < 0) continue;
                if(time[next] >= 0) continue;
                q.offer(next);
                time[next] = time[cur] + 1;
            }
        }


    }
}