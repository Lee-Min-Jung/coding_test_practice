import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String star = "";
        for(int i=1; i<=a; i++){
            star += "*";
        }
        for(int i=1; i<=b; i++){
            System.out.println(star);
        }
    }
}