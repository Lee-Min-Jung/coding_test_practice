import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static String str;
    static int answer = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        str = st.nextToken();

        // 답 구하기
        if(str.length()%5 !=0 || str.charAt(0)!='q') {
            System.out.println(-1);
            return;
        }
        getAnswer();

        System.out.println(answer);


    }
    static void getAnswer(){
        char[] chars = {'q','u','a','c','k'};
        visited = new boolean[str.length()];
        int index = 0;
        while(true){
            // 전체 문자열 돌기
            for(int i = 0; i<str.length(); i++){
                // 이미 방문했으면 패스
                if(visited[i]) continue;
                // 찾아야 할 다음 문자
                char next = chars[index % 5];
                // 현재 문자
                char target = str.charAt(i);
                // 현재 문자가 내가 찾아야 할 다음 문자와 같음
                if(target == next){
                    // 찾아야 할 다음 문자 재설정
                    index++;
                    // 찾은 문자는 방문표시
                    visited[i] = true;
                }
            }
            // 다음에 살펴야 할 게 q인 올바른 경우
            if(index%5 == 0) {
                answer++;
            }else{ // 틀린 경우
                answer = -1;
                return;
            }
            // 모두 방문했는지 확인
            if(checkVisited()){
               return;
            }
        }
    }
    static boolean checkVisited(){
        for(int i = 0; i<visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }





}