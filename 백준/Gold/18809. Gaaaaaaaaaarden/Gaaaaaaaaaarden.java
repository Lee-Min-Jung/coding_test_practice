import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, G, R;
    static int[][] map;
    static int[] redPosition;
    static int[] greenPosition;
    static boolean[] visited;
    static int answer = 0;
    static ArrayList<int[]> possible = new ArrayList<int[]>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        redPosition = new int[R];
        greenPosition = new int[G];


        // map 만들면서 배양액 뿌릴 수 잇는 땅 위치 저장
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                int target = Integer.parseInt(st.nextToken());
                map[i][j] = target;
                if(target == 2){
                    int[] temp = {i, j};
                    possible.add(temp);
                }
            }
        }

        visited = new boolean[possible.size()];

        selectGreen(0, 0);

        System.out.println(answer);
    }

    public static void selectGreen(int depth, int position){
        if(depth == G){
            selectRed(0, 0);
            return;
        }
        for(int i = position; i<possible.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                greenPosition[depth] = i;
                selectGreen(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    public static void selectRed(int depth, int position){
        if(depth == R){
            spread();
            return;
        }
        for(int i = position; i<possible.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                redPosition[depth] = i;
                selectRed(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    public static void spread(){
        Queue<int[]> q = new LinkedList<int[]>();
        Pair[][] state = new Pair[N][M];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                state[i][j] = new Pair();
            }
        }

        for(int i = 0; i<R; i++){
            int x = possible.get(redPosition[i])[0];
            int y = possible.get(redPosition[i])[1];
            state[x][y] = new Pair(0, 4);
            q.add(new int[]{x, y});
        }

        for(int i = 0; i<G; i++){
            int x = possible.get(greenPosition[i])[0];
            int y = possible.get(greenPosition[i])[1];
            state[x][y] = new Pair(0, 3);
            q.add(new int[]{x, y});
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curTime = state[curX][curY].time;
            int curType = state[curX][curY].type;
            if(curType == 5) continue;
            for(int i = 0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && map[nextX][nextY] != 0){
                    if(state[nextX][nextY].type == 0){
                        state[nextX][nextY] = new Pair(curTime+1, curType);
                        q.offer(new int[]{nextX, nextY});
                    }
                    else if(state[nextX][nextY].type == 4){
                        if(curType == 3 && state[nextX][nextY].time == curTime + 1){
                            count++;
                            state[nextX][nextY].type = 5;
                        }
                    }else if(state[nextX][nextY].type == 3){
                        if(curType == 4 && state[nextX][nextY].time == curTime+1){
                            count++;
                            state[nextX][nextY].type = 5;
                        }
                    }
                }
            }
        }
        answer = Math.max(answer, count);

    }





}

class Pair{
    int time;
    int type;
    Pair(){

    }
    Pair(int time, int type){
        this.time = time;
        this.type = type;
    }
}