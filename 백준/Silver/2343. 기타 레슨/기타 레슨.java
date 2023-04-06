
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int start = 0;
        int end = 0;
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            if(start < nums[i]){
                start = nums[i];
            }
            end += nums[i];
        }
        BSearch(nums, start, end);



    }

    public static void BSearch(int[] arr, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for(int i = 0; i<N; i++){
                if(sum + arr[i] > mid){
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if(sum != 0){
                count++;
            }
            if(count <= M){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}

