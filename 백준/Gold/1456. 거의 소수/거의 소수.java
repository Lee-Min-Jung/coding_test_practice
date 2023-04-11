
import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        long[] nums = new long[10000001];
        for(int i = 2; i<nums.length; i++){
            nums[i] = i;
        }
        nums[0] = -1;
        nums[1] = -1;
        for(int i = 2; i<=Math.sqrt(nums.length); i++){
            if(nums[i] == -1){
                continue;
            }
            for(int j = i+i; j<nums.length; j=j+i){
                nums[j] = -1;
            }
        }
        int answer = 0;
        for(int i = 2; i<nums.length; i++){
            long temp = nums[i];
            while((double)nums[i] <= (double)end/(double)temp){
                if((double)nums[i] >= (double)start/(double)temp){
                    answer++;
                }
                temp *= nums[i];
            }
        }
        System.out.println(answer);



    }




}

