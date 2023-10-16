import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static String N;
    static int B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        int answer = 0;

        // 알파벳 숫자
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W','X','Y','Z'};
        int count = 10;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i<chars.length; i++){
            hm.put(chars[i], count);
            count++;
        }
        // N을 10진수로
        int n = N.length()-1;
        for(int i = 0; i<N.length(); i++){
            char target = N.charAt(i);
            if(hm.containsKey(target)){
                answer += hm.get(target) * Math.pow(B, n);
            }else{
                answer += Integer.parseInt(Character.toString(target)) * Math.pow(B, n);
            }
            n--;
        }

        System.out.println(answer);
    }






}