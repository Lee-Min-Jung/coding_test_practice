import java.io.*;
import java.util.*;

// 입력받은 문자열을 트라이 구조로 만들기
    // 다음 노드를 가리키면서 리프인지 아닌지를 판단할 수 있는 노드 클래스 정의
    // 현재 노드의 다음 알파벳 위치가 null 이면 거기에 노드 삽입, null 아니면 이동
    //

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 개수 저장 및 변수 선언
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tNode root = new tNode();

        // 트라이 구조 만들기
        while(N > 0){
            String str = br.readLine();
            tNode now = root;
            for(int i = 0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(now.next[ch-'a'] == null){ // 다음 위치가 null 이니 거기에 새로운 노드 생성해서 집어넣기
                    now.next[ch-'a'] = new tNode();
                }
                now = now.next[ch-'a']; // 생성해서 집어 넣었다면 그게 현재 위치가 되는 거고, 집어넣지 않았다면 뭔가 있던 곳이 현재 위치가 되는 것
                if(i == str.length()-1){ // 만약 문자열 맨 마지막이라면 끝이라고 표시하기기
                    now.isEnd = true;
                }
            }
            N--;
        }

        // 트라이 검색
        int count = 0;
        while(M > 0){
            String str = br.readLine();
            tNode now = root;
            for(int i = 0; i<str.length(); i++){
                char c = str.charAt(i);
                if(now.next[c-'a'] == null){ // 다음 노드를 찾는데 내가 찾는게 없으면 그 문자열은 없다는 의미이니 종료
                    break;
                }
                now = now.next[c-'a'];
                if(i == str.length() -1 && now.isEnd){ // 현재 살피는 문자열의 마지막이면서 비교 대상도 마지막이면 같다는 것이니 답 증가
                    count++;
                }
            }
            M--;
        }

        // 정답 출력
        System.out.println(count);

    }






}

class tNode{
    tNode[] next = new tNode[26];
    boolean isEnd;
}

