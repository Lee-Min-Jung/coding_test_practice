import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bingo = new int[5][5];
    static int[] nums = new int[25];
    static StringTokenizer st;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 빙고판
        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 부르는 수
        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                nums[5*i+j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙고 게임
        for(int i = 0; i<nums.length; i++){
            int target = nums[i];
            // 부르는 수 찾기
            for(int j = 0; j<bingo.length; j++){
                for(int k = 0; k<bingo[j].length; k++){
                    if(target == bingo[j][k]){
                        bingo[j][k] = 0;
                    }
                }
            }
            // 가로
            garoBingo();
            // 세로
            seroBingo();
            // 대각1
            daegak1();
            // 대각2
            daegak2();

            if(count >= 3){
                System.out.println(i+1);
                break;
            }
            count = 0;

        }
    }

    // 가로
    public static void garoBingo(){
        for(int i = 0; i<5; i++){
            int zeroCount = 0;
            for(int j = 0; j<5; j++){
                if(bingo[i][j] == 0){
                    zeroCount++;
                }
            }
            if(zeroCount == 5){
                count++;
            }
        }
    }

    // 세로
    public static void seroBingo(){
        for(int i = 0; i<5; i++){
            int zeroCount = 0;
            for(int j = 0; j<5; j++){
                if(bingo[j][i] == 0){
                    zeroCount++;
                }
            }
            if(zeroCount == 5){
                count++;
            }
        }
    }

    // 대각선 1
    public static void daegak1(){
        int zeroCount = 0;
        for(int i = 0; i<5; i++){
            if(bingo[i][i] == 0){
                zeroCount++;
            }
        }
        if(zeroCount == 5){
            count++;
        }
    }

    // 대각선 2
    public static void daegak2(){
        int zeroCount = 0;
        for(int i = 0; i<5; i++){
            if(bingo[i][4-i] == 0){
                zeroCount++;
            }
        }
        if(zeroCount == 5){
            count++;
        }
    }

}