import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

// 가로로 문자열 행을 쭉 쓰고, 세로로 문자열 열을 쭉 써서 해당 행 열에 해당하는 문자열끼리 비교해서 LCS의 길이를 표에 적는다
// D[i][j] : 한 문자열의 i까지의 길이와 다른 문자열의 j까지의 길이 중 LCS의 길이
    // 만약 D[i][j]위치에 있는 문자를 비교했을 때 같다면 왼쪽 대각선의 값에 1을 더한 값을 저장
        // 같다는 것의 의미는 해당 위치까지의 문자열들을 비교했을 때 부분 수열에 추가 될 요소가 하나 늘었다는 것
        // 왼쪽 대각선의 값의 의미는 해당 문자 비교하기 전까지 비교 완료했던 부분 수열의 길이를 의미
        // 그러니 문자 비교했을 때 같으면 이전 비교 한 것보다 부분 수열 값이 1 더 늘어난 것이 1 증가해주는 것이라고 보면 된다!!!
    // 만약 문자가 같지 않다면 왼쪽과 위에 있는 값중 더 큰 값을 저장
        // 문자가 같지 않다는 것의 의미는 부분 수열로 추가 할 요소가 없다는 것을 의미
        // 왼쪽에 있는 값의 의미는 해당 문자 비교하기 전 검사했던 문자열 중 1개, 위쪽에 있는 것도. 그러니 둘 중 큰 값으로 업데이트하면 된다
// D배열을 모두 구하고 난 후 D배열에 있는 값 중 가장 큰 값이 정답이다, 근데 그 가장 큰 값은 배열 맨 뒤에 있는 값이 된다


public class Main {
    private static long[][] D;
    private static ArrayList<Character> Path;
    private static char[] A;
    private static char[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력 받기
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        // D배열 정의
        D = new long[A.length+1][B.length+1];

        // 문자열 돌면서 D배열 채우기
        for(int i = 1; i<=A.length; i++){
            for(int j = 1; j<=B.length; j++){
                if(A[i-1] == B[j-1]){
                    D[i][j] = D[i-1][j-1] + 1;
                }else{
                    D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
                }
            }
        }

        // 길이 먼저 출력
        System.out.println(D[A.length][B.length]);

        // 문자열 출력
        Path = new ArrayList<Character>();
        getText(A.length, B.length);
        for(int i = Path.size() - 1; i>=0; i--){
            System.out.print(Path.get(i));
        }

    }

    private static void getText(int r, int c){
        if(r == 0 || c == 0) return; // 재귀 함수 계속 호출하다 보면 r이나 c가 0이 될 수가 있다. 하지만 둘 중 하나라도 0인 경우 우리가 만든 표 D에서 찾을 수 없는 인덱스이기 때문에 종료해줘야 한다

        if(A[r-1] == B[c-1]){
            Path.add(A[r-1]);
            getText(r-1, c-1);
        }else{
            if(D[r-1][c] > D[r][c-1])
                getText(r-1, c);
            else
                getText(r, c-1);
        }
    }
}




