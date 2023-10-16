import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 소인수분해 진행
        int i = 2;
        while(i <= N){
            if(N % i == 0){
                System.out.println(i);
                N = N / i;
            }else{
                i++;
            }
        }

    }






}