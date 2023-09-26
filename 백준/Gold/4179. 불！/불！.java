import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static String[][] map;
    static int[][] timeF, timeP;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    static Queue<int[]> qF = new LinkedList<int[]>();
    static Queue<int[]> qP = new LinkedList<int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        timeF = new int[R][C];
        timeP = new int[R][C];

        // 시간 초기화
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                timeF[i][j] = -1;
                timeP[i][j] = -1;
            }
        }
        // 지도 생성
        for(int i = 0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for(int j = 0; j<str.length; j++){
                if(str[j].equals("J")){
                    qP.offer(new int[]{i, j});
                    timeP[i][j] = 0;
                }else if(str[j].equals("F")){
                    qF.offer(new int[]{i, j});
                    timeF[i][j] = 0;
                }
                map[i][j] = str[j];
            }
        }

        // 불 확산
        bfsForFire();

        // 사람 이동
        bfsForPerson();

        if(answer != 0){
            System.out.println(answer);
        }else{
            System.out.println("IMPOSSIBLE");
        }


    }

    public static void bfsForFire(){
        while(!qF.isEmpty()){
            int[] cur = qF.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(map[nx][ny].equals("#") || timeF[nx][ny] >= 0) continue;
                qF.offer(new int[]{nx, ny});
                timeF[nx][ny] = timeF[cx][cy] + 1;
            }
        }
    }

    public static void bfsForPerson(){


        while(!qP.isEmpty()){
            int[] cur = qP.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C){
                    answer = timeP[cx][cy] + 1;
                    return;
                }
                if(map[nx][ny].equals("#") || timeP[nx][ny] >= 0) continue;
                if(timeF[nx][ny] != -1 && timeF[nx][ny] <= timeP[cx][cy]+1) continue;
                qP.offer(new int[]{nx, ny});
                timeP[nx][ny] = timeP[cx][cy] + 1;
            }
        }

    }
}