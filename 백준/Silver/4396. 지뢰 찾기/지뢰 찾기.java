import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<int[]> landmine = new ArrayList<int[]>();
    static String[][] map;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new String[N][N];

        // 지뢰 위치 저장
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for(int j = 0; j<str.length; j++){
                String target = str[j];
                if(target.equals("*")){
                    landmine.add(new int[]{i, j});
                }
            }
        }

        // 현황 저장
        boolean isLandmineFinal = false;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for(int j = 0; j<str.length; j++){
                String target = str[j];
                // 누른 곳
                if(target.equals("x")){
                    boolean isLandmine = false;
                    for(int k = 0; k<landmine.size(); k++){
                        int[] cur = landmine.get(k);
                        int x = cur[0];
                        int y = cur[1];
                        // 지뢰 누름
                        if(x == i && y == j){
                            map[i][j] = "*";
                            isLandmine = true;
                            isLandmineFinal = true;
                            break;
                        }
                    }
                    if(!isLandmine){
                        int count = 0;
                        for(int p = 0; p<8; p++){
                            int nx = i + dx[p];
                            int ny = j + dy[p];
                            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            for(int a = 0; a<landmine.size(); a++){
                                int[] cur2 = landmine.get(a);
                                int tx = cur2[0];
                                int ty = cur2[1];
                                if(nx == tx && ny == ty){
                                    count++;
                                }
                            }
                        }
                        map[i][j] = String.valueOf(count);
                    }
                }
                // 안 누른 곳
                else if(target.equals(".")){
                    map[i][j] = ".";
                }
            }
        }
        // 지뢰 누른 적 있는지 확인
        if(isLandmineFinal){
            for(int i = 0; i<landmine.size(); i++){
                int[] cur = landmine.get(i);
                int x = cur[0];
                int y = cur[1];
                map[x][y] = "*";
            }
        }

        // 정답 출력
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


}