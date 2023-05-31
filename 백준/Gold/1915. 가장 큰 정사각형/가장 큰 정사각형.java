import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// D[i][j]는 해당 위치를 오른쪽 맨 아래 꼭짓점으로 하고 해당 자리에서 그릴 수 있는 가장 큰 정사각형의 변의 길이
// D[i][j] = i j 위치가 1일 경우 왼, 위, 대각선의 값 중 가장 작은 값에 1 더한 값으로 변경
//  0일 경우 그대로 0으로
// 왜 셋 중 가장 작은 값에 1을 더하는 방식으로 업뎃을 해야 하나?
    // 특정 위치의 왼쪽, 왼쪽 대각선, 위쪽이 모두 1이면서 본인도 1이어야 정사각형이 만들어질 수 있다
    // 그래서 셋 중에 하나라도 0이 있으면 1보다 큰 값으로 업데이트 되기가 힘들다
    // 셋 중 가장 작은 값 보다 1 더 큰 값으로 업데이트를 해 나가면 최소 정사각형이 만들어 질 수 있을 때 비로소 업뎃이 되고 최소값보다 1 더 큰 값으로 업뎃되어야 변의 길이가 같음을 보장할 수 있다
    // 사실 직접 해보면 왜 그런지 이해가 되긴 하는데 어떻게 이걸 내가 생각해낼 수 있지??




public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        // 개수 저장
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 기본 배열 입력받으며 D 저장
        long[][] D = new long[N+1][M+1];
        for(int i = 1; i<=N; i++){
            String str = sc.next();
            for(int j = 1; j<=M; j++){
                D[i][j] = Long.parseLong(String.valueOf(str.charAt(j-1)));
            }
        }

        // D 업뎃
        long max = 0;
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                if(D[i][j] == 0){
                    continue;
                }else{
                    long left = D[i-1][j];
                    long up = D[i][j-1];
                    long cross = D[i-1][j-1];
                    long min = Math.min(left, up);
                    min = Math.min(min, cross);
                    D[i][j] = min+1;
                }
                max = Math.max(D[i][j], max);
            }
        }

        // 답 리턴
        System.out.println(max*max);
    }


}




