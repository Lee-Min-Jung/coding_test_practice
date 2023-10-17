import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static String[] fileArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받고 초기화
        N = Integer.parseInt(st.nextToken());
        fileArr = new String[N];

        // 파일 입력
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            String[] targetArr = target.split("\\.");
            fileArr[i] = targetArr[1];
        }

        // map에 개수 저장
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i<N; i++){
            hm.put(fileArr[i], hm.getOrDefault(fileArr[i], 0) + 1);
        }

        // 사전순 정렬
        Arrays.sort(fileArr);

        // 정답 출력 - 중복은 출력하면 안 됨
        for(int i = 0; i<N; i++){
            String target = fileArr[i];
            int count = hm.get(target);
            if(i == 0){
                System.out.println(target + " " + count);
            }
            if(i >= 1 && !target.equals(fileArr[i-1])){
                System.out.println(target + " " + count);
            }
        }
    }







}