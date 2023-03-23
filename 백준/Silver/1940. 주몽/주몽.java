import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        int complete = Integer.parseInt(bf.readLine());
        int[] nums = new int[count];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<count; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int answer = 0;
        int start = 0;
        int end = count-1;
        
        while(start < end){
            if((nums[start] + nums[end]) < complete){
                start++;
            }else if((nums[start] + nums[end]) > complete){
                end--;
            }else{
                answer++;
                start++;
                end--;
            }    
        }
        
        
        System.out.println(answer);
        
    }
}