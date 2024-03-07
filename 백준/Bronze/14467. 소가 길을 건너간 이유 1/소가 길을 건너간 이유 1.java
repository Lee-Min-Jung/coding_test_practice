import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 관찰 횟수
        int N = Integer.parseInt(st.nextToken());

        // 소 번호별 위치 저장
        List<Integer>[] cowNumList = new List[11];
        for(int i = 1; i<=10; i++){
            cowNumList[i] = new ArrayList<>();
        }
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            cowNumList[cowNum].add(position);
        }

        // 소 번호별 위치 돌면서 위치 변화 카운트
        int answer = 0;
        for(int i = 1; i<=10; i++){
            if(cowNumList[i].isEmpty()) continue;
            int cur = cowNumList[i].get(0);
            for(int position : cowNumList[i]){
                if(cur != position) answer++;
                cur = position;
            }
        }

        System.out.println(answer);




    }



}



