import java.io.*;
import java.util.*;

// 3일까지 벌 수 있는 최대 수익 = 1일까지 벌 수 있는 최대 수익 + 2일까지 벌 수 있는 최대 수익
// 이런 식으로 큰 문제를 작은 문제로 나눌 수 있고, 작은 문제들이 반복되고, 작은 문제의 값은 변하지 않아서 DP 가능

// D[i]는 i일부터 퇴사날까지 벌 수 있는 최대 수익
// 입력받은 값을 거꾸로부터 계산해 나가면서 D 배열을 채운다
    // 만약 오늘 시작되는 상담이 퇴사일까지 끝나지 않을 경우에는 지금까지의 최대 수입을 그대로 유지한다
    // 만약 오늘 시작되는 상담이 퇴사일까지 끝날 경우에는 지금까지의 최대 수입, 오늘 시작되는 상담의 수익+오늘 시작되는 상담이 끝나고 난 이후에 있는 상담의 수익 중 더 큰 값을 고른다


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N =Integer.parseInt(br.readLine());
        int[][] schedule = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        // 거꾸로 살피면서 D 배열 만들기
        int[] D = new int[N+2];
        for(int i = N; i>0; i--){
            if(schedule[i][0] + i > N+1){ // 현재 일정 상담 불가능
                D[i] = D[i+1];
            }else{ // 현재 일정 상담 가능
                D[i] = Math.max(D[i+1], schedule[i][1]+D[i+schedule[i][0]]);
            }
        }

        System.out.println(D[1]);

    }




}




