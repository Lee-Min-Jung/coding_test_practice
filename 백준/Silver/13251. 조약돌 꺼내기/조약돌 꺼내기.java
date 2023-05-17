import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException {

        // 변수
        int T = 0; // 총 구슬 개수 합
        int K = 0; // 뽑아야 하는 구슬 개수
        double probability[] = new double[51]; // 구슬 종류 별 확률
        double answer = 0.0;

        // 색상 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        // 색상 별 구슬 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D[] = new int[51];
        for(int i = 0; i<M; i++){
            D[i] = Integer.parseInt(st.nextToken());
            T += D[i];
        }

        // 뽑는 개수
        K = Integer.parseInt(br.readLine());

        // 확률 구하기
        for(int i = 0; i<M; i++){
            if(D[i] >= K){ // 뽑아야 하는 구슬 개수보다 뽑히는 게 더 많다
                probability[i] = 1.0;
                for(int k = 0; k < K; k++){
                    probability[i] *= (double) (D[i]-k) / (T-k);
                }
            }
            answer += probability[i];
        }
        System.out.println(answer);

    }


}




