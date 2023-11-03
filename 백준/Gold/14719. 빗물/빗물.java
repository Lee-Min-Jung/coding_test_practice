import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int H, W;
    static int[][] block;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 및 초기화
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        block = new int[H][W];

        // 블록 상태 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<W; i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j = H-1; j>=H-num; j--){
                block[j][i] = 1;
            }
        }

        // 빗물 양 구하기
        for(int i = 0; i<H; i++){
            for(int j = 0; j<W; j++){
                if(block[i][j] != 1){
                    check(i, j);
                }
            }
        }

        // 정답 출력
        System.out.println(answer);

        // test
//        for(int i = 0; i<H; i++){
//            for(int j = 0; j<W; j++){
//                System.out.print(block[i][j] + " ");
//            }
//            System.out.println();
//
//
//        }

    }
    static void check(int r, int c){
        // 왼쪽 확인
        boolean leftHas = false;
        for(int i = 0; i<c; i++){
            if(block[r][i] == 1) {
                leftHas = true;
                break;
            }
        }
        // 오른쪽 확인
        boolean rightHas = false;
        for(int i = c; i<W; i++){
            if(block[r][i] == 1){
                rightHas = true;
                break;
            }
        }
        // 양쪽에 존재하면 카운트 증가
        if(leftHas && rightHas) answer++;
    }


}
