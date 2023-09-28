import java.io.IOException;
import java.util.*;
public class Main {
    static int T,C,R;
    static String[][] map;
    static int[][] timeF;
    static int[][] timeP;
    static Queue<int[]> qF;
    static Queue<int[]> qP;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();


        for(int i = 0; i<T; i++){
            C = sc.nextInt();
            R = sc.nextInt();
            map = new String[R][C];
            timeF = new int[R][C];
            timeP = new int[R][C];
            // 시간 배열 초기화
            for(int a = 0; a<R; a++){
                for(int b = 0; b<C; b++){
                    timeF[a][b] = -1;
                    timeP[a][b] = -1;
                }
            }
            qF = new LinkedList<>();
            qP = new LinkedList<>();
            // 지도 완성 및 큐에 넣기
            for(int j = 0; j<R; j++){
                String[] target = sc.next().split("");
                for(int k = 0; k<target.length; k++){
                    map[j][k] = target[k];
                    if(target[k].equals("*")){
                        qF.offer(new int[]{j, k});
                        timeF[j][k] = 0;
                    }
                    if(target[k].equals("@")){
                        qP.offer(new int[]{j, k});
                        timeP[j][k] = 0;
                    }
                }
            }
            // 불 bfs
            bfsF();

            // 사람 bfs
            bfsP();
          
        }
    }
    public static void bfsF(){
        while(!qF.isEmpty()){
            int[] cur = qF.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(timeF[nx][ny] >= 0 || map[nx][ny].equals("#")) continue;
                timeF[nx][ny] = timeF[cx][cy] + 1;
                qF.offer(new int[]{nx, ny});
            }
        }
    }
    public static void bfsP(){
        while(!qP.isEmpty()){
            int[] cur = qP.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C){
                    System.out.println(timeP[cx][cy]+1);
                    return;
                }
                if(timeP[nx][ny] >= 0 || map[nx][ny].equals("#")) continue;
                if(timeF[nx][ny] != -1 && timeP[cx][cy]+1 >= timeF[nx][ny]) continue;
                timeP[nx][ny] = timeP[cx][cy] + 1;
                qP.offer(new int[]{nx, ny});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}