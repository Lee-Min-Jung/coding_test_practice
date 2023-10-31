import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 입력
        N = sc.nextInt();


        // 진행
        recur(N, getOddCount(N));

        // 정답
        System.out.print(min + " " + max);



    }
    // 재귀
    static void recur(int num, int oddCount){
        if(num < 10){
            min = Math.min(oddCount, min);
            max = Math.max(oddCount, max);
        }
        else if(num < 100){
            int sum = (num / 10) + (num % 10);
            recur(sum, oddCount + getOddCount(sum));
        }
        else{
            String str = Integer.toString(num);
            for(int i = 0; i<str.length()-2; i++){
                for(int j = i+1; j<str.length()-1; j++){
                    String s1 = str.substring(0, i+1);
                    String s2 = str.substring(i+1, j+1);
                    String s3 = str.substring(j+1, str.length());
                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    recur(sum, oddCount + getOddCount(sum));
                }
            }
        }
    }

    // 홀수 개수 찾기
    static int getOddCount(int num){
        int count = 0;
        while(num > 0){
            int cur = num % 10;
            if((cur % 2) == 1) count++;
            num /= 10;
        }
        return count;
    }

}