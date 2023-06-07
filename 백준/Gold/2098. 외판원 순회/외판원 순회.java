import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

// D[c][v] : 현재 c를 방문했고, 지금까지 방문한 곳들이 v일 때, 앞으로 남은 모든 도시를 경유하는 데 필요한 최소 비용
// D[c][v] = Math.min(D[c][v], D[i][v(여기에는 i가 포함되어야 함)] + W[c][i])
    //여기서 i는 아직 방문하지 않은 도시를 의미
    // i는 아직 방문하지 않은 모든 도시에 대해 반복해서 수행된 후 그 중 가장 작은 값을 구해야 함
// v는 지금까지 방문한 곳들을 의미, 근데 방문한 곳들은 리스트인데 변수 하나에 방문한 곳들 리스트를 어떻게 표현할 수 있을까?
    // 이를 위해 이진수를 사용한다.
        // 지금까지 방문한 총 도시 수만큼 이진수를 만들어 놓고 방문한 곳의 번호를 1로 만든다
        // 그리고 해당 이진수 값을 10진수로 변환하여 배열 인덱스 값으로 사용해서 v를 표현한다
    // 비트끼리 or 연산 하면 원소를 추가할 수 있다
    // 비트끼리 and 연산 하면 원소를 조회할 수 있다





public class Main {
    private static int N;
    private static int[][] W;
    private static int[][] d;
    private static final int INF = 1000000*16+1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine().trim());
        W = new int[16][16];
        d = new int[16][1 << 16];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));



    }

    private static int tsp(int c, int v) { //모든 경우의 수에 대한 완전 탐색, 재귀 구현
        if (v == (1 << N) - 1) {    // 모든 노드를 방문한 경우
            return W[c][0] == 0 ? INF : W[c][0];
        }
        if (d[c][v] != 0) {  //이미 방문한 노드인 경우 -> 이미 계산한 경우 바로 리턴 (메모이제이션)
            return d[c][v];
        }
        int min_val = INF;
        for (int i = 0; i < N; i++) {
            if ((v & (1 << i)) == 0 && W[c][i] != 0) {   //방문한적이 없고 갈 수 있는 도시인 경우
                min_val = Math.min(min_val, tsp(i, (v | (1 << i))) + W[c][i]);
            }
        }
        d[c][v] = min_val;
        return d[c][v];
    }



}




