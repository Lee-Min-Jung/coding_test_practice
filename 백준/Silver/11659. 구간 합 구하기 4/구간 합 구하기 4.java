import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static int start, end;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 및 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        d = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // d 만들어 놓기
        d[1] = nums[1];
        for(int i = 2; i<=N; i++){
            d[i] = d[i-1] + nums[i];
        }
        // 진행
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            System.out.println(d[end] - d[start-1]);
        }





    }









}

