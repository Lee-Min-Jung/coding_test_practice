import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static Schedule[] sch;
    static int[][] sticker = new int[1001][366];
    static int[] height = new int[366];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 및 초기화
        N = Integer.parseInt(st.nextToken());
        sch = new Schedule[N];

        // 일정 입력 받기
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sch[i] = new Schedule(s, e);
        }

        // 일정 정렬
        Arrays.sort(sch);

        // 일정 보고 스티커 붙이기
        putSticker();

        // test
//        for(int i = 1; i<=1000; i++){
//            for(int j = 1; j<=365; j++){
//                System.out.print(sticker[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 면적 구하기
        getArea();

        System.out.println(answer);



    }
    // 코팅지 면적 구하기
    static void getArea(){
        // 높이 구하기
        for(int i = 1; i<=365; i++){
            int max = 0;
            for(int j = 1; j<=1000; j++){
                if(sticker[j][i] != 0){
                    max = Math.max(j, max);
                }
            }
            height[i] = max;
        }

        // 넓이 구하기
        int w = 0;
        int h = 0;
        for(int i = 1; i<=365; i++){
            if(height[i] != 0){
                w++;
                h = Math.max(h, height[i]);
            }
            else if(height[i] == 0){
                answer += w*h;
                w = 0;
                h = 0;
            }
        }
        if(height[365] != 0){
            answer += w*h;
        }

    }
    // 스티커 붙이기
    static void putSticker(){
        for(int i = 0; i<N; i++){
            int startDay = sch[i].startDay;
            int endDay = sch[i].endDay;
            for(int j = 1; j<=1000; j++){
                // 비어 있다
                if(sticker[j][startDay] == 0){
                    for(int k = startDay; k<=endDay; k++){
                        sticker[j][k] = 1;
                    }
                    break;
                }
            }
        }
    }


}
// 일정
class Schedule implements Comparable<Schedule>{
    int startDay;
    int endDay;
    Schedule(int startDay, int endDay){
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public int compareTo(Schedule sc){
        if(sc.startDay != this.startDay) return this.startDay - sc.startDay;
        if(sc.endDay - sc.startDay != this.endDay - this.startDay) return (sc.endDay - sc.startDay)-(this.endDay - this.startDay);
        return this.startDay - sc.startDay;
    }
}