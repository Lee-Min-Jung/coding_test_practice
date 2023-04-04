import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DFS(1, 2);
        DFS(1, 3);
        DFS(1, 5);
        DFS(1, 7);

    }

    static void DFS(int jarisu, int num){
        if(jarisu == N){
            if(sosu(num)){
                System.out.println(num);
            }
            return;
        }
        int[] postNum = {1,3,5,7,9};

        for(int n : postNum){
            if(sosu(num*10+n)){
                DFS(jarisu+1,num*10+n);
            }
        }
    }

    static boolean sosu(int num){
        for(int i = 2; i<= num/2; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

}