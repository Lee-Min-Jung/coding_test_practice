
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());
            System.out.println(BSearch(nums, target));
        }


    }

    public static int BSearch(int[] arr, int target){
        int start = 0;
        int mid;
        int end = arr.length -1;

        while(start <= end){
            mid = (start + end) / 2;
            if(target < arr[mid]){
                end = mid - 1;
            }else if(target > arr[mid]){
                start = mid + 1;
            }else{
                return 1;
            }
        }
        return 0;
    }




}

