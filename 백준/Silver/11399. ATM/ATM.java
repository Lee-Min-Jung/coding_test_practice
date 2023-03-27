import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int sum = 0;

        for(int i = 1; i<N; i++){
            int target = nums[i];
            int j = i-1;
            while(j >= 0 && target < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = target;
        }
        for(int num : nums){
            sum += num;
            answer += sum;
        }

        System.out.println(answer);

    }
}
