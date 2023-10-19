import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N, M;
    static Command[] command;
    static boolean[][] train;
    static int seatCount = 20;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 및 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        command = new Command[M];
        train = new boolean[N+1][seatCount+1];

        // 명령 입력
        for(int i = 0; i<M; i++){
            String[] str = br.readLine().split(" ");
            int type = 0;
            int trainIndex = 0;
            int seatIndex = 0;
            // 만약 1번 2번 명령
            if(str.length >= 3){
               type = Integer.parseInt(str[0]);
               trainIndex = Integer.parseInt(str[1]);
               seatIndex = Integer.parseInt(str[2]);
            }
            // 만약 3번 4번 명령
            else{
                type = Integer.parseInt(str[0]);
                trainIndex = Integer.parseInt(str[1]);
            }
            command[i] = new Command(type, trainIndex, seatIndex);

        }

        // 명령 수행
        doCommand();

        // 은하수 건너기
        galaxy();

        // 정답 출력
        System.out.println(set.size());

    }
    // 은하수 건너기
    static void galaxy(){
        // 기차 돌면서 좌석 확인
        for(int i = 1; i<train.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j<train[i].length; j++){
                if(train[i][j]){
                    sb.append("1");
                }else{
                    sb.append("0");
                }
            }
            set.add(sb.toString());
        }
    }
    // 명령 수행
    static void doCommand(){
        for(int i = 0; i<M; i++){
            int type = command[i].type;
            int trainIndex = command[i].trainIndex;
            int seatIndex = command[i].seatIndex;
            if(type == 1){
                command1(trainIndex, seatIndex);
            }else if(type == 2){
                command2(trainIndex, seatIndex);
            }else if(type == 3){
                command3(trainIndex);
            }else if(type == 4){
                command4(trainIndex);
            }
        }
    }
    // 1번 명령
    static void command1(int trainIndex, int seatIndex){
        train[trainIndex][seatIndex] = true;
    }
    // 2번 명령
    static void command2(int trainIndex, int seatIndex){
        train[trainIndex][seatIndex] = false;
    }
    // 3번 명령 - 한 칸씩 뒤로
    static void command3(int trainIndex){
        for(int i = 20; i>=2; i--){
            train[trainIndex][i] = train[trainIndex][i-1];
        }
        train[trainIndex][1] = false;
    }
    // 4번 명령 - 한 칸씩 앞으로
    static void command4(int trainIndex){
        for(int i = 1; i<=19; i++){
            train[trainIndex][i] = train[trainIndex][i+1];
        }
        train[trainIndex][20] = false;
    }
}

class Command{
    int type;
    int trainIndex;
    int seatIndex;
    Command(int type, int trainIndex, int seatIndex){
        this.type = type;
        this.trainIndex = trainIndex;
        this.seatIndex = seatIndex;
    }
}