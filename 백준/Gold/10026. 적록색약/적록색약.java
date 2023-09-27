import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[][] painting;
    static int countX, countO = 0;
    static boolean[][] visitedX, visitedO;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        painting = new String[N][N];
        visitedX = new boolean[N][N];
        visitedO = new boolean[N][N];

        // 그림 저장
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for(int j = 0; j<str.length; j++){
                painting[i][j] = str[j];
            }
        }

        // 적록색약 아닌 사람
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(!visitedX[i][j]){
                    bfsX(i, j, painting[i][j]);
                    countX++;
                }
            }
        }
        
        // 적록색약인 사람
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(!visitedO[i][j]){
                    bfsO(i, j, painting[i][j]);
                    countO++;
                }
            }
        }

        System.out.print(countX + " " + countO);
    }

    public static void bfsX(int x, int y, String color){
        Queue<int[]> q = new LinkedList<int[]>();

        q.offer(new int[]{x, y});
        visitedX[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                String ncolor = painting[nx][ny];
                if(visitedX[nx][ny] || !ncolor.equals(color)) continue;
                q.offer(new int[]{nx, ny});
                visitedX[nx][ny] = true;
            }
        }

    }
    
    public static void bfsO(int x, int y, String color){
        Queue<int[]> q = new LinkedList<int[]>();

        q.offer(new int[]{x, y});
        visitedO[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                String ncolor = painting[nx][ny];
                if(visitedO[nx][ny]) continue;
                if(color.equals("R") && ncolor.equals("B")) continue;
                if(color.equals("B") && ncolor.equals("R")) continue;
                if(color.equals("G") && ncolor.equals("B")) continue;
                if(color.equals("B") && ncolor.equals("G")) continue;
                q.offer(new int[]{nx, ny});
                visitedO[nx][ny] = true;
            }
        }

    }


}