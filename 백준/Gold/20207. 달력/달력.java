import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int planCount;
    static int[][] plan;
    static int[][] map;
    static int[] height = new int[366];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        planCount = Integer.parseInt(st.nextToken());
        plan = new int[planCount][2];
        map = new int[1001][366];
        for(int i = 0; i<planCount; i++){
            st = new StringTokenizer(br.readLine());
            plan[i][0] = Integer.parseInt(st.nextToken());
            plan[i][1] = Integer.parseInt(st.nextToken());
        }

        // 일정 정렬
        Arrays.sort(plan, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    int period1 = o1[1] - o1[0];
                    int period2 = o2[1] - o2[0];
                    return period2 - period1;
                }
                return o1[0] - o2[0];
            }
        });

        // 달력에 일정 표시
        for(int i = 0; i<planCount; i++){ // 일정 돌기
            int start = plan[i][0];
            int end = plan[i][1];
            for(int j = 1; j<=1000; j++){ // 행 돌기
                if(map[j][start] == 0){
                    for(int k = start; k<=end; k++){ // 열 돌기
                        map[j][k] = 1;
                    }
                    break;
                }
            }
        }

        // 일정 보고 코팅지 면적 계산
        // 각 열 별 높이 구하기
        for(int j = 1; j<=365; j++){ // 열 돌기
            int h = 0;
            for(int i = 1; i<=1000; i++){ // 열 별 행 돌기
                if(map[i][j] == 1){
                    h = i;
                }
            }
            height[j] = h;
        }

        // 면적 구하기
        int w = 0;
        int h = 0;
        for(int i = 1; i<=365; i++){
            // 높이가 0이 아니다(일정 존재)
            if(height[i] != 0){
                w++;
                h = Math.max(h, height[i]);
            }
            // 높이가 0(일정 없음)
            else{
                answer += w*h;
                w = 0;
                h = 0;
            }
        }

        // 마지막 열 처리
        if(height[365] != 0){
            answer += w*h;
        }

        // 정답 출력
        System.out.println(answer);
    }





















}



