import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N, K;
    static int[] D;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 및 초기화
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = new int[N+1];
        result = new int[N+1];
        // 결과 배열 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            result[i] = Integer.parseInt(st.nextToken());
        }
        // D 배열 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            D[i] = Integer.parseInt(st.nextToken());
        }
        // k번 만큼 역으로 셔플하기
        int[] original = new int[N+1];
        for(int i = 0; i<K; i++){
            // 결과 원소 돌기
            for(int j = 1; j<=N; j++){
                int di = D[j];
                original[di] = result[j];
            }
            // 만들어진 결과를 result로 바꾸기
            for(int j = 1; j<=N; j++){
                result[j] = original[j];
            }
        }
        // 정답
        for(int i = 1; i<=N; i++){
            System.out.print(original[i] + " ");
        }
    }







}