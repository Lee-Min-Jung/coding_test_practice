import java.io.*;
import java.util.*;

// 어떤 수가 주어졌을 때
// D[i] 의 값은 i가 1이 되기 위한 연산의 최소 횟수를 의미
    // D[1] 은 0으로 초기화됨



public class Main {



    public static void main(String[] args) throws IOException {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // D 배열 초기화
        int[] D = new int[N+1];
        D[1] = 0;

        // D배열 채우기
        for(int i = 2; i<=N; i++){
            // 가능한 연산은 1빼기, 2로 나누기, 3으로 나누기가 있다.
            // 현재 i가 1일때부터 i-1까지 쭉 올라오는 연산의 과정이 있을 것이다. 그 과정의 마지막 과정이 D[i-1], D[i/2], D[i/3] 중 하나이다(각 연산을 의미)
            // 그리고 D[i-1], D[i/2], D[i/3] 에 1을 더하면 현재 i가 1일 때부터 i가 될 때까지의 모든 연산 횟수를 구한 것이 된다
            // 1빼기한 경우는 모든 수에 적용 가능하니 해당 값을 구한다
            // 2로 나누기나 3으로 나누기는 각 배수만 가능하니 배수인지 판단 후 구한다. 구한 후 1빼기한 경우와 비교해서 더 작은 값으로 D[i]를 업뎃하면 된다
            D[i] = D[i-1] + 1;
            if(i%2==0) D[i] = Math.min(D[i], D[i/2]+1);
            if(i%3==0) D[i] = Math.min(D[i], D[i/3]+1);
            
        }
        
        System.out.println(D[N]);




    }




}




