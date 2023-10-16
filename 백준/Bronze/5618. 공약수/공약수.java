import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 공약수 구하기
        getGongyacksu();
    }
    static void getGongyacksu(){
        Arrays.sort(nums);
        for(int i = 1; i<=nums[0]; i++){
            boolean isAllDivide = true;
            for(int j = 0; j<nums.length; j++){
                if(nums[j] % i != 0){
                    isAllDivide = false;
                }
            }
            if(isAllDivide){
                System.out.println(i);
            }
        }
    }





}