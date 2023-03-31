import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(nums);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<N; i++){
            bw.write(nums[i] + "\n");
        }
        bw.flush();
        bw.close();
    }



}