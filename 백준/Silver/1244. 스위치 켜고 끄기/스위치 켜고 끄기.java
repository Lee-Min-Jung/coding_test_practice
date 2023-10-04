import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] switches;
    static int[][] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        switches = new int[N+1];

        // 스위치 상태 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 정보 저장
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        students = new int[S][2];
        for(int i = 0; i<S; i++){
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
        }

        // 학생 돌면서 확인
        for(int i = 0; i<S; i++){
            int sex = students[i][0];
            int num = students[i][1];
            // 남자
            if(sex == 1){
                for(int j = 1; j<=N; j++){
                    // 배수면 바꾸기
                    if(j % num == 0){
                        if(switches[j] == 0){
                            switches[j] = 1;
                        }else{
                            switches[j] = 0;
                        }
                    }
                }
            }
            // 여자
            else if(sex == 2){
                // 뽑은 숫자 인덱스 찾기
                int index = 0;
                for(int j = 1; j<=N; j++){
                    if(j == num) index = j;
                }
                // 해당 인덱스 좌우 살피기
                int nl = index;
                int nr = index;
                int start = 0;
                int end = 0;
                while(true){
                    nl = nl-1;
                    nr = nr+1;
                    if(nl < 1 || nr < 1 || nl >= N+1 || nr >= N+1){
                        start = nl+1;
                        end = nr-1;
                        break;
                    }
                    int lv = switches[nl];
                    int rv = switches[nr];
                    if(lv != rv){
                        start = nl+1;
                        end = nr-1;
                        break;
                    }
                    if(lv == rv) continue;

                }
                for(int j = start; j<=end; j++){
                    if(switches[j] == 0){
                        switches[j] = 1;
                    }else{
                        switches[j] = 0;
                    }
                }
            }
        }

        // 정답 출력
        for(int i = 1; i<=N; i++){
            
            System.out.print(switches[i] + " ");
            if(i % 20 == 0){
                System.out.println();
            }
        }
    }
}