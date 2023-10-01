import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static HashMap<Integer, Integer[]> hm = new HashMap<>();
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        // 학생별 좋아하는 학생 저장
        for(int i = 0; i<N*N; i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            int s4 = Integer.parseInt(st.nextToken());
            int s5 = Integer.parseInt(st.nextToken());
            hm.put(s1, new Integer[]{s2, s3, s4, s5});

            // 현재 학생의 자리 구하기
            getSeat(s1);
        }

        
        // 만족도 구하기
        getScore();

        System.out.println(answer);

    }
    // 만족도 구하기
    public static void getScore(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                int count = 0;
                int s = map[i][j];
                int f1 = hm.get(s)[0];
                int f2 = hm.get(s)[1];
                int f3 = hm.get(s)[2];
                int f4 = hm.get(s)[3];
                for(int k = 0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    int nf = map[nx][ny];
                    if(nf == f1 || nf == f2 || nf == f3 || nf == f4){
                        count++;
                    }
                }
                if(count == 1) answer += 1;
                if(count == 2) answer += 10;
                if(count == 3) answer += 100;
                if(count == 4) answer += 1000;
            }
        }
    }

    // 자리 구하기
    public static void getSeat(int s){

        int s1 = hm.get(s)[0];
        int s2 = hm.get(s)[1];
        int s3 = hm.get(s)[2];
        int s4 = hm.get(s)[3];

        ArrayList<Integer[]> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                int empty = 0;
                int likeFriend = 0;
                for(int k = 0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    int now = map[nx][ny];
                    if(now == 0) empty++;
                    if(now == s1 || now == s2 || now == s3 || now == s4) likeFriend++;
                }
                list.add(new Integer[] {likeFriend, empty, i, j});
            }
        }

        Collections.sort(list, new Comparator<>(){
           @Override
           public int compare(Integer n1[], Integer n2[]){
               if(n1[0] < n2[0]) return 1;
               else if(n1[0] == n2[0]){
                   if(n1[1] < n2[1]) return 1;
                   else if(n1[1] == n2[1]){
                       if(n1[2] > n2[2]) return 1;
                       else if(n1[2] == n2[2]){
                           if(n1[3] > n2[3]) return 1;
                       }
                   }
               }
               return -1;
           }
        });

        for(int i = 0; i<list.size(); i++){
            int x = list.get(i)[2];
            int y = list.get(i)[3];
            if(map[x][y] == 0){
                map[x][y] = s;
                return;
            }
        }
    }

}