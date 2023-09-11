import java.util.*;


public class Main {
    static int[] caseOutput;
    static int[][] map;
    static int[][] copyMap;
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<CCTV> cctvList;
    public static void main(String[] args) {
		// 입력 배열 만들면서 CCTV위치와 번호 저장
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        cctvList = new ArrayList<CCTV>();
        for(int i = 0; i<map.length; i++){
            for(int j = 0; j<map[i].length; j++){
                int val = sc.nextInt();
                map[i][j] = val;
                if(val != 0 && val != 6){
                    cctvList.add(new CCTV(i, j, val));
                }
            }
        }
        
        caseOutput = new int[cctvList.size()];
        checkAllCase(0, cctvList.size());
        
        System.out.println(answer);
	}
    
    // CCTV별로 가능한 모든 경우의 수 확인
    public static void checkAllCase(int depth, int r){
        if(depth == r){
            copyMap = new int[N][M];
            for(int i = 0; i<map.length; i++){
                System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
            }
            for(int i = 0; i<caseOutput.length; i++){
                inspection(cctvList.get(i), caseOutput[i]);
            }
            
            getBlindSpot();
            
            return;
        }
        for(int i = 0; i<4; i++){
            caseOutput[depth] = i;
            checkAllCase(depth+1, r);
        }
    }
    
    // 특정 cctv 정보 주어지면 감시가능한 부분 구하기
    public static void inspection(CCTV cctv, int direction){
        int num = cctv.num;
        if(num == 1){
            if(direction == 0){
                watch(cctv, 0);
            }else if(direction == 1){
                watch(cctv, 1);
            }else if(direction == 2){
                watch(cctv, 2);
            }else if(direction == 3){
                watch(cctv, 3);
            }
        }else if(num == 2){
            if(direction == 0 || direction == 2){
                watch(cctv, 0);
                watch(cctv, 2);
            }else if(direction == 1 || direction == 3){
                watch(cctv, 1);
                watch(cctv, 3);
            }
        }else if(num == 3){
            if(direction == 0){
                watch(cctv, 0);
                watch(cctv, 3);
            }else if(direction == 1){
                watch(cctv, 1);
                watch(cctv, 0);
            }else if(direction == 2){
                watch(cctv, 1);
                watch(cctv, 2);
            }else if(direction == 3){
                watch(cctv, 3);
                watch(cctv, 2);
            }
        }else if(num == 4){
            if(direction == 0){
                watch(cctv, 0);
                watch(cctv, 2);
                watch(cctv, 3);
            }else if(direction == 1){
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 3);
            }else if(direction == 2){
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
            }else if(direction == 3){
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
            }
        }else if(num == 5){
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    // cctv 주어지면 방향에 맞게 검사 가능한 부분 구하기
    public static void watch(CCTV cctv, int direction){
        int[] cordX = {1, 0, -1, 0};
        int[] cordY = {0, -1, 0, 1};
        Queue<CCTV> q = new LinkedList<CCTV>();
        
        q.add(cctv);
        
        while(!q.isEmpty()){
            CCTV c = q.poll();
            int nx = c.x + cordX[direction];
            int ny = c.y + cordY[direction];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && copyMap[nx][ny] != 6){
                if(copyMap[nx][ny] == 0){
                    copyMap[nx][ny] = -1;
                    q.add(new CCTV(nx, ny, c.num));
                }else{
                    q.add(new CCTV(nx, ny, c.num));
                }
            }
        }
    }
    
    // 사각지대 구하기
    public static void getBlindSpot(){
        int cnt = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(copyMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        answer = Math.min(answer, cnt);
    }


}
class CCTV{
    int x;
    int y;
    int num;
    CCTV(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}