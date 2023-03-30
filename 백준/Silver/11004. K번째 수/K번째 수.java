import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(nums, 0, N-1);
        System.out.println(nums[K-1]);

    }
    private static void quickSort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int pivot = partition(nums, l, r);
        quickSort(nums, l, pivot);
        quickSort(nums, pivot + 1, r);
    }

    private static int partition(int[] nums, int l, int r){
        int left = l-1;
        int right = r+1;
        int pivot = nums[(l+r)/2];

        while(true){
            do{
                left++;
            }while(nums[left] < pivot);
            
            do{
                right--;
            }while(nums[right] > pivot && left <= right);
            
            if(left >= right){
                return right;
            }
            
            swap(nums, left, right);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

