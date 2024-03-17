import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static int[][] plan;
    static int[][] map = new int[1001][366];
    static int[] height = new int[366]; // 각 열별 스티커 붙여야 할 최고 높이를 담고 있는 배열
    static int answer = 0;
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    plan = new int[N][2];

    // 일정 입력
    for(int i = 0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        plan[i][0] = Integer.parseInt(st.nextToken());
        plan[i][1] = Integer.parseInt(st.nextToken());
    }

    // 일정 정렬
    Arrays.sort(plan, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] == o2[0]) {
                int period1 = o1[1] - o1[0];
                int period2 = o2[1] - o2[1];
                return period2 - period1;
            }
            return o1[0] - o2[0];
        }
    });



    // 달력에 일정 채우기
    for(int i = 0; i<plan.length; i++){
        int start = plan[i][0];
        int end = plan[i][1];
        for(int j = 1; j<=1000; j++){
            if(map[j][start] == 0){
                for(int k = start; k<=end; k++){
                    map[j][k] = 1;
                }
                break;
            }
        }
    }

    // 코팅지 면적 구하기
    // 각 열 별로 높이를 구해서 저장한다
    for(int i = 1; i<=365; i++){
        int max = 0;
        for(int j = 1; j<=1000; j++){
            if(map[j][i] != 0) max = Math.max(j, max);
        }
        height[i] = max;
    }

    int w = 0;
    int h = 0;
    // 열을 돌면서 높이와 너비를 구한다
    for(int i = 1; i<=365; i++){
        if(height[i] != 0){
            w++;
            h = Math.max(h, height[i]);
        }
        // 높이가 0이라는 건 연속된 게 끝났다는 것이니 지금까지의 면적을 더하고 높이와 너비 리셋이 필요하다
        else if(height[i] == 0){
            answer += w*h;
            w = 0;
            h = 0;
        }
    }
    if(height[365] != 0){
        answer += w*h;
    }
    
    System.out.println(answer);


    }





















}



