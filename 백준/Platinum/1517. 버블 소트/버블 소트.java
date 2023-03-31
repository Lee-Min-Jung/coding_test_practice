import java.io.*;
import java.util.StringTokenizer;

public class Main {
        public static int[] temp;
        public static long answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        temp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        mergeSort(nums, 0, N-1);
        System.out.println(answer);

    }

    private static void mergeSort(int[] nums, int left, int right){
        if(left == right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right){
        int l = left;
        int r = mid+1;
        int idx = left;

        while(l <= mid && r <= right){
            if(nums[l] <= nums[r]){
                temp[idx] = nums[l];
                l++;
                idx++;
            }else{
                temp[idx] = nums[r];
                answer = answer + r - idx;
                r++;
                idx++;
            }
        }
        if(l > mid){
            while(r <= right){
                temp[idx] = nums[r];
                r++;
                idx++;
            }
        }else{
            while(l <= mid){
                temp[idx] = nums[l];
                l++;
                idx++;
            }
        }
        for(int i = left; i<= right; i++){
            nums[i] = temp[i];
        }
    }


}