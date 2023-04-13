
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long num1 = sc.nextLong();
        long num2 = sc.nextLong();
        int gcdNum = gcd(num1, num2);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(gcdNum > 0){
            bw.write("1");
            gcdNum--;
        }
        bw.flush();
        bw.close();

    }

    public static int gcd(long num1, long num2){
        long big = num1 > num2 ? num1 : num2;
        long small = num1 < num2 ? num1 : num2;
        long temp = 0;
        while(small != 0){
            temp = big % small;
            big = small;
            small = temp;
        }
        return (int)big;

    }






}

