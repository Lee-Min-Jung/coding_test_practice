
import java.io.*;
import java.nio.Buffer;
import java.util.*;

// max까지의 값을 가지고 있는 배열을 하나 만들기
    // 이 배열에서 2의 제곱수 지우고, 3 제곱수 지우고 반복
// 마치고 난 이후 지워지지 않은 것의 개수를 리턴
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] check = new boolean[(int)(max-min+1)];
        for(long i = 2; i*i <= max; i++){
            long pow = i*i;
            long start_index = min/pow;
            if(min%pow != 0){
                start_index++;
            }
            for(long j = start_index; j*pow<=max; j++){
                check[(int)((j*pow)-min)] = true;
            }
        }
        int answer = 0;
        for(int i = 0; i<check.length; i++){
            if(!check[i]){
                answer++;
            }
        }
        System.out.println(answer);
    }




}

