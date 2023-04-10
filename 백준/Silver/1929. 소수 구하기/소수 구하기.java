
import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] nums = new int[end+1];
        nums[0] = -1;
        nums[1] = -1;
        for(int i = 2; i<=end; i++){
            nums[i] = i;
        }
        for(int i = 2; i<=end; i++){
            if(nums[i] == -1){
                continue;
            }
            for(int j = i+i; j<=end; j=j+i){
                nums[j] = -1;
            }
        }
        for(int i = start; i<=end; i++){
            if(nums[i] != -1){
                System.out.println(nums[i]);
            }
        }
    }


}

