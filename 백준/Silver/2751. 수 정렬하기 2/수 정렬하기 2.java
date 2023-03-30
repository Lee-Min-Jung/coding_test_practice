import java.io.*;


public class Main {
    private static int[] sorted;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        sorted = new int[N];
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(nums, 0, N-1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int n : nums){
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
    }


    private static void mergeSort(int[] nums, int left, int right){
        if(left == right) return;

        int mid = (left + right) / 2;

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
                sorted[idx] = nums[l];
                idx++;
                l++;
            }else{
                sorted[idx] = nums[r];
                idx++;
                r++;
            }

        }
        if(l > mid){
            while(r <= right){
                sorted[idx] = nums[r];
                idx++;
                r++;
            }
        }else{
            while(l <= mid){
                sorted[idx] = nums[l];
                idx++;
                l++;
            }
        }
        for(int i = left; i<= right; i++){
            nums[i] = sorted[i];
        }
    }

}

