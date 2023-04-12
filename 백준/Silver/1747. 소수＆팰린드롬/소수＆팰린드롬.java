
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[10000001];
        for(int i = 2; i<nums.length; i++){
            nums[i] = i;
        }
        for(int i = 2; i<Math.sqrt(nums.length); i++){
            if(nums[i] == 0){
                continue;
            }
            for(int j = i+i; j<nums.length; j+=i){
                nums[j] = 0;
            }
        }
        int index = N;
        while(true){
            if(nums[index] != 0){
                if(isPalindrome(nums[index])){
                    System.out.println(nums[index]);
                    break;
                }
            }
            index++;
        }


    }

    public static boolean isPalindrome(int target){

        String targetStr = Integer.toString(target);
        StringBuilder sb = new StringBuilder(targetStr);
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }



}

