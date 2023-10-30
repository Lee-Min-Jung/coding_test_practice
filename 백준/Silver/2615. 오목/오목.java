import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int[][] map = new int[20][20];
    static int[][] dir = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 판 입력 받기
        for(int i = 1; i<=19; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 판 돌기
        for(int j = 1; j<=19; j++){
            for(int i = 1; i<=19; i++){
                int target = map[i][j];
                if(target == 1 || target == 2){
                    for(int d = 0; d<4; d++){
                        int count = 1;
                        // 원래 방향 탐색
                        int cx = i;
                        int cy = j;
                        while(true){
                            cx += dir[d][0];
                            cy += dir[d][1];
                            if(cx <= 0 || cx >= 20 || cy <= 0 || cy >= 20) break;
                            if(map[cx][cy] != target) break;
                            count++;
                        }
                        // 반대 방향 탐색
                        cx = i;
                        cy = j;

                        while(true){
                            cx -= dir[d][0];
                            cy -= dir[d][1];
                            if(cx <= 0 || cx >= 20 || cy <= 0 || cy >= 20) break;
                            if(map[cx][cy] != target) break;
                            count++;
                        }
                        if(count == 5){
                            System.out.println(target);
                            System.out.print(i + " ");
                            System.out.print(j);
                            return;
                        }
                    }

                }
            }
        }

        System.out.println(0);



    }

}