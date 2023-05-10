import java.io.*;
import java.util.*;




public class Main {
    static int N, M, answer;
    static ArrayList<String> S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        S = new ArrayList<>();

        // 집합 S
        for(int i = 0; i<N; i++){
            S.add(br.readLine());
        }

        // 검사
        for(int i = 0; i<M; i++){
            String str = br.readLine();
            if(S.contains(str)){
                answer++;
            }
        }

        // 정답 출력
        System.out.println(answer);

    }






}

