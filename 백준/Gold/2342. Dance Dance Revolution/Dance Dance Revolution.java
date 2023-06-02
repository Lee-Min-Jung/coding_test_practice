import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// 중앙 -> 다른 곳: 2
// 다른 곳 -> 인접: 3
// 다른 곳 -> 반대: 4
// 같은 곳: 1

// D[N][L][R] : N개의 수열을 수행한 후 왼발의 위치가 L, 오른발의 위치가 R일 때 최소 누적 힘
// mp[i][j]: i에서 j로 이동하는 데 드는 힘
// 왼발을 움직여 다음 움직임을 수행할 때: D[N][L][R] = D[N-1][i][R] + mp[i][L]
    // D[N-1][i][R]은 다음 움직임 구하기 전의 움직임에서의 최소 누적 힘, mp는 다음 움직임으로 갈 때 추가되는 힘
    // i는 현재 발의 위치, 왼발만 움직이니 R은 변화 없음, L은 다음 발 위치
// 오른발을 움직여 다음 움직임을 수행할 때: D[N][L][R] = D[N-1][L][i] + mp[i][R]




public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //dp[N][L][R] = N개 수열을 수행하였고 왼쪽이 L 오른쪽이 R자리에 있을때 최소 누적 힘
        int dp[][][] = new int[100001][5][5];
        //한발을 이동할 때 드는 힘을 미리 저장해 두기 mp[1][2] -> 1에서 2로 이동할때 드는 힘
        int mp[][] = {  { 0, 2, 2, 2, 2 },
                { 2, 1, 3, 4, 3 },
                { 2, 3, 1, 3, 4 },
                { 2, 4, 3, 1, 3 },
                { 2, 3, 4, 3, 1 } };
        int n = 0, s = 1;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                for (int k = 0; k < 100001; k++)
                    dp[k][i][j] = 100001 * 4; //충분히 큰수로 초기화
        dp[0][0][0] = 0;
        while (true) {
            n = sc.nextInt();
            if (n == 0)  // 입력의 마지막이면 종료
                break;
            for (int i = 0; i < 5; i++) {
                if (n == i) //두발이 같은 자리에 있을 수 없음
                    continue;
                for (int j = 0; j < 5; j++) {
                    // 오른발을 옮겨서 현재 모습이 되었을 때 최소의 힘 저장
                    dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n], dp[s][i][n]);
                }
            }
            for (int j = 0; j < 5; j++) {
                if (n == j)  //두발이 같은 자리에 있을 수 없음
                    continue;
                for (int i = 0; i < 5; i++) {
                    //왼발을 옮겨서 현재 모습이 되었을 때 최소의 힘 저장
                    dp[s][n][j] = Math.min(dp[s - 1][i][j] + mp[i][n], dp[s][n][j]);
                }
            }
            s++;
        }
        s--;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                min = Math.min(min, dp[s][i][j]);  //모두 수행하였을 때 최소 값 찾기
        System.out.println(min); //최소값 출력

    }





}




