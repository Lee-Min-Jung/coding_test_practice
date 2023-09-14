import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        arr = new int[N];
        
        backTracking(0);
        
        System.out.println(answer);
        
        
    }
    public static void backTracking(int depth){
        if(depth == N){
            answer++;
            return;
        }
        
        for(int i = 0; i<N; i++){
            arr[depth] = i;
            if(possible(depth)){
                backTracking(depth+1);
            }
        }
    }
    
    public static boolean possible(int row){
        for(int i = 0; i<row; i++){
            if(arr[i] == arr[row]){
                return false;
            }else if(Math.abs(row-i) == Math.abs(arr[row]-arr[i])){
                return false;
            }
        }
        return true;
    }
}
    