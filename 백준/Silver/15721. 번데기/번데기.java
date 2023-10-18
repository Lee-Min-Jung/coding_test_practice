import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int A, T, C;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 입력 및 초기화
        A = sc.nextInt();
        T = sc.nextInt();
        C = sc.nextInt();
        int count = 0;
        int round = 0;
        int[] base = {0,1,0,1};
        int index = 0;

        // 라운드 진행
        while(count != T){
            round++;
            // 뻔데기 배열 생성
            int[] arr = new int[round*2+6];
            for(int i = 0; i<arr.length; i++){
                if(i <= 3){
                    arr[i] = base[i];
                }else if(i >= 4 && i<=(arr.length-4)/2+3){
                    arr[i] = 0;
                }else{
                    arr[i] = 1;
                }
            }
            // 뻔데기 돌기
            for(int i = 0; i<arr.length; i++){
                int target = arr[i];
                if(target == C){
                    count++;
                }
                int person = index % A;
                if(count == T){
                    System.out.println(person);
                    return;
                }
                index++;
            }
        }



    }







}