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
        int answer = 0;
        
        for(int i = 0; i<count; i++){
            for(int j = i+1; j<count; j++){
                if((nums[i] + nums[j]) == complete){
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
        
    }
}