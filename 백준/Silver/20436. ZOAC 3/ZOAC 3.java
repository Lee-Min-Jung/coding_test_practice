import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] keyboard = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                                {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', '.'},
                                {'z', 'x', 'c', 'v' ,'b', 'n', 'm', '.', '.', '.'}
                                };
    static int[] lposition;
    static int[] rposition;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String lstr = "qwertasdfgzxcv";
        String rstr = "yuiophjklbnm";
        char lstart = st.nextToken().charAt(0);
        char rstart = st.nextToken().charAt(0);
        lposition = new int[2];
        rposition = new int[2];
        st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        // 시작점 좌표 찾기
        for(int i = 0; i<3; i++){
            for(int j = 0; j<10; j++){
                if(lstart == keyboard[i][j]){
                    lposition[0] = i;
                    lposition[1] = j;
                }
                if(rstart == keyboard[i][j]){
                    rposition[0] = i;
                    rposition[1] = j;
                }
            }
        }

        // 문자열 입력하기
        for(int i = 0; i<input.length(); i++){
            char ch = input.charAt(i);
            int x = 0;
            int y = 0;
            // 문자 좌표 찾기
            for(int j = 0; j<3; j++){
                for(int k = 0; k<10; k++){
                    if(ch == keyboard[j][k]){
                        x = j;
                        y = k;
                    }
                }
            }
            // 왼손
            if(lstr.contains(String.valueOf(ch))){
                int curx = lposition[0];
                int cury = lposition[1];
                int dis = Math.abs(curx-x) + Math.abs(cury-y);
                answer += dis;
                answer += 1;
                lposition[0] = x;
                lposition[1] = y;
            }
            // 오른손
            else{
                int curx = rposition[0];
                int cury = rposition[1];
                int dis = Math.abs(curx-x) + Math.abs(cury-y);
                answer += dis;
                answer += 1;
                rposition[0] = x;
                rposition[1] = y;
            }
        }
        System.out.println(answer);
    }
}