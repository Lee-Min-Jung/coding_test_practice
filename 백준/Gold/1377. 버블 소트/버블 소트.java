import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        HashMap<Integer, Integer> before = new HashMap<>();
        HashMap<Integer, Integer> after = new HashMap<>();
        for(int i = 0; i<n; i++){
            int su = Integer.parseInt(br.readLine());
            nums[i] = su;
            before.put(su, i);
        }
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            after.put(nums[i], i);
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            if(max < (before.get(nums[i]) - after.get(nums[i]))){
                max = before.get(nums[i]) - after.get(nums[i]);
            }
        }
        System.out.println(max+1);




    }
}
