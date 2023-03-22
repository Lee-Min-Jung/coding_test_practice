import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long num = 0;
        long sum = 0;
        long answer = 0;
        
        for(long i = 1; i<=N; i++){
            num = i;
            while(sum < N){
                sum += num;
                num++;
            }
            if(sum == N){
                answer++;
            }
            sum = 0;
        }
        
        System.out.println(answer);
        
    }
}