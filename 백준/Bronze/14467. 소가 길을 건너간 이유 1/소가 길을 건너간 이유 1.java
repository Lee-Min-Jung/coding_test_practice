import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] cowList;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 및 초기화
        N = Integer.parseInt(st.nextToken());
        cowList = new List[11];
        for(int i = 1; i<=10; i++){
            cowList[i] = new ArrayList<>();
        }

        // 소 번호와 위치 입력
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            cowList[cowNum].add(position);
        }

        // 소 리스트 돌면서 위치 변화 카운트
        for(int i = 1; i<=10; i++){
            if(cowList[i].isEmpty()) continue;
            int cur = cowList[i].get(0);
            for(int position : cowList[i]){
                if(cur != position){
                    answer++;
                }
                cur = position;
            }
        }

        System.out.println(answer);
    }







}

