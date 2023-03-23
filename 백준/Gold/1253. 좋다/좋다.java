import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long[] nums = new long[count];
        for(int i = 0; i<count; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);
        
        for(int i = 0; i<count; i++){
            int start = 0;
            int end = count-1;
            long num = nums[i];
            while(start < end){
                if((nums[start] + nums[end]) < num){
                    start++;
                }else if((nums[start] + nums[end]) == num){
                    if(start != i && end != i){
                        answer++;
                        break;
                    }else if(start == i){
                        start++;
                    }else if(end == i){
                        end--;
                    }
                }else if((nums[start] + nums[end]) > num){
                    end--;
                }
            }
        }
        System.out.println(answer);
    }
}