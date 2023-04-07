
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long ans;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        long start = 1, end = k;
        BSearch(start, end);

    }

    public static void BSearch(long start, long end){
        while(start <= end){
            long mid = (start + end) / 2;
            long cnt = 0;
            for(int i = 1; i<=n; i++){
                cnt += Math.min(mid / i, n);
            }
            if(cnt < k){
                start = mid + 1;
            }else{
                ans = mid;
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }

}

