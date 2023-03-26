import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String[] num = scanner.next().split("");
        int[] nums = new int[num.length];
        for(int i = 0; i<nums.length; i++){
            nums[i] = Integer.parseInt(num[i]);
        }
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] < nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for(int i = 0; i<nums.length; i++){
            System.out.print(nums[i]);
        }
    }
}
