import java.io.*;
import java.util.*;

// 1번 문제: 순열을 순서대로 놨을 때 K번째 위치한 순열이 무엇인지
    // 맨 앞자리가 특정 숫자로 고정되어 있을 때 뒤의 것들이 나열되는 경우의 수 = (N-1)!
    // 그러니 K번째를 구하고 싶을 때 만약 K가 (N-1)!보다 작다면 K번째의 첫 번째 수는 1이된다
    // 만약 K번째를 구하고 싶을 때 K가 (N-1)! 보다 크다면 첫 번째 수는 2보다 큰 수 중에 있다

public class Main {


    public static void main(String[] args) throws IOException {
        // 자릿수 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 각 자릿수 별 경우의 수 배열
        long[] F = new long[N+1];
        F[0] = 1;
        for(int i = 1; i<=N; i++){
            F[i] = F[i-1]*i;
        }


        // 문제 번호 추출
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        // 1번이나 2번에 사용될 배열
        int[] answer1 = new int[N+1];
        boolean[] visited = new boolean[N+1];

        if(Q == 1){
            long K = Long.parseLong(st.nextToken());
            // 예시 상황: N은 4, K는 3
            // 첫 번째 for문은 4!의 순열 중 우리가 구해야 하는 3번째 순열의 각 숫자 하나하나를 구하기 위해 N만큼 돌아야 함
                // 첫 번째 for문을 1회 돌았다는 것은 한 자리의 숫자를 구했다는 것
            // 두 번째 for문은 각 숫자 하나하나를 실제로 구하기 위해 N만큼 돌아야 함
                // 두 번째 for문을 빠져나와야지 한 자리의 숫자를 구했다는 것
            // i는 구해야 하는 숫자 하나를 구했는지를 판단하는 인덱스 용도
            // j는 구해야 하는 숫자 그 자체를 의미
            // cnt는 한 무더기를 의미. N이 4라면 1로 시작하는 무더기가 있고, 2로 시작하는 무더기가 있는데 그 무더기의 인덱스를 의미.
                // cnt가 1이라면 1로 시작하는 무더기 이런 식
            for(int i = 1; i<=N; i++){
                for(int j = 1, cnt = 1; j<=N; j++){
                    // 만약 방문을 했었다면 다음 j로 넘어가야 한다
                    if(visited[j]){
                        continue;
                    }
                    // i 번째 숫자를 구해야 함. i번째 뒤에 총 가능한 순열 가짓수를 F[N-i]로 구하고
                    // cnt*F[N-i]를 해서 i번 뒤에 총 가능한 순열이 어떤 무더기에 속하는지 판단
                    // 만약 내가 구하고자 하는 K번째가 해당 무더기 안에 속한다면
                    // 정답의 순열을 j로 설정하고 이 for문을 빠져나온다
                    // K -= ((cnt-1) * F[N-i]);를 이용해서 한 무더기의 범위를 바꾸는 것
                        // 맨 처음에는 맨 첫 숫자가 같은 것이 한 무더기였는데 맨 첫 숫자 구하고 난 이후에는 두번째 숫자가 같은 것이 한 무더기가 된다
                   // 만약 내가 구하고자 하는 K번째가 해당 무더기 안에 속하지 않으면 구할 때 까지 내부 for문을 돈다
                    if(K <= cnt * F[N-i]){
                        K -= ((cnt-1) * F[N-i]);
                        answer1[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for(int i = 1; i<=N; i++){
                System.out.print(answer1[i]+" ");
            }
        }else{
            long K = 1;
            // 첫 번째 for문을 통해 입력으로 주어진 배열을 저장함과 동시에 저장한 숫자가 어떤 무더기에 속하는지 구해서 K를 업데이트함
            // i는 주어진 순열의 인덱스를 의미
            // K는 해당 무더기의 맨 첫번째 넘버로 업데이트 됨
            for(int i = 1; i<=N; i++){
                answer1[i] = Integer.parseInt(st.nextToken());
                // cnt는 무더기 넘버를 의미
                long cnt = 0;
                // 맨 첫 입력받은 순열의 값을 이용해서 해당 숫자로 시작하는 무더기가 몇 번째 무더기인지 구함
                for(int j = 1; j< answer1[i]; j++){
                    if(visited[j] == false){
                        cnt++;
                    }
                }
                K += cnt * F[N-i];
                visited[answer1[i]] = true;
            }
            System.out.println(K);
        }




    }


}




