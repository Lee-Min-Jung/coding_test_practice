import java.io.*;
import java.util.*;

// D[i]는 i인덱스까지의 연속 합 중 가장 큰 수. 근데 연속 합에는 i가 들어가 있다.
// D[i]는 지금까지의 연속 합에 본인을 더한 값과 그냥 본인의 값을 비교하여 더 큰 수를 저장한다.
// D배열에 본인보다 이전배열값 + 본인의 합과 그냥 본인을 비교하여 더 큰 수를 저장한다
        // D[i] = Max(D[i-1]+arr[i], arr[i])
        // 근데 이건 특정 수를 제거하지 않은 경우만 구하는 것이다

// L(왼쪽부터 시작)과 R(오른쪽부터 시작)을 D로써 구한다
    //L은 왼쪽부터 시작해서 i인덱스까지의 연속 합 중 가장 큰 수. 근데 연속 합에는 i가 들어가 있다.
    //R은 오른쪽부터 시작해서 i인덱스까지의 연속 합 중 가장 큰 수. 근데 연속 합에는 i가 들어가 있다.
    // 근데 L[2]는 처음부터 인덱스 2까지의 합인거고, R[2]는 끝부터 인덱스 2까지의 합인것.
// 만약 특정 인덱스 i의 값을 제거한 경우 최대합을 구하고 싶으면 L[i-1] + R[i+1]을 구하면 된다. 이건 arr 배열, L배열, R배열을 쭉 그려놓고 보면 딱 이해가 간다
// 위에서 구한 값이랑 현재 최댓값으로 설정해 놓은 값을 비교해서 더 큰 값을 answer로 변경한다.


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        // 개수 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 배열 입력 받기
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // L배열(왼쪽부터 시작) 구하기
        int[] L = new int[N];
        L[0] = arr[0];
        answer = L[0];

        for(int i = 1; i<N; i++){
            L[i] = Math.max(L[i-1]+arr[i], arr[i]);
            answer = Math.max(L[i], answer);
        }

        // R배열(오른쪽부터 시작) 구하기
        int[] R = new int[N];
        R[N-1] = arr[N-1];
        for(int i = N-2; i>=0; i--){
            R[i] = Math.max(R[i+1]+arr[i], arr[i]);
        }

        // i 번째 수 제거한 경우와 아닌 경우 비교
        for(int i = 1; i<N-1; i++){
            answer = Math.max(answer, L[i-1] + R[i+1]);
        }

        // 정답 출력
        System.out.println(answer);

    }
}




