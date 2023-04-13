
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int gcdNum = gcd(num1, num2);
            System.out.println(num1*num2/gcdNum);
        }

    }

    public static int gcd(int num1, int num2){
        int big = num1 > num2 ? num1 : num2;
        int small = num1 < num2 ? num1 : num2;
        int temp = 0;
        while(small != 0){
            temp = big % small;
            big = small;
            small = temp;
        }
        return big;
    }






}

