import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int T, N;
    static String function, arrStr;
    static boolean isError;
    static ArrayDeque<String> deque;
    static boolean isReverse;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        T = Integer.parseInt(st.nextToken());

        // 테케 수만큼 진행
        for(int test = 0; test<T; test++){
            deque = new ArrayDeque<>();
            isError = false;
            isReverse = false;
            function = br.readLine();
            N = Integer.parseInt(br.readLine());
            arrStr = br.readLine();

            // 입력받은 배열로 리스트 만들기
            makeDeque();
            // 함수실행
            doFunction();
            // 결과 리턴
            if(isError){
                System.out.println("error");
            }else{
                printResult();
            }

        }



    }
    // 결과 출력 함수
    static void printResult(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int len = deque.size();
        for(int i = 0; i<len; i++){
            if(isReverse){
                sb.append(deque.removeLast());
            }else{
                sb.append(deque.removeFirst());
            }
            if(i != len-1){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    // 함수 실행
    static void doFunction(){
        for(int i = 0; i<function.length(); i++){
            char ch = function.charAt(i);
            // 뒤집기 함수
            if(ch == 'R'){
                isReverse = !isReverse;
            }
            // 지우기 함수
            else if(ch == 'D'){
                if(deque.isEmpty()){
                    isError = true;
                    return;
                }else{
                    if(isReverse){
                        deque.removeLast();
                    }else{
                        deque.removeFirst();
                    }
                }
            }
        }
    }
    // 배열 만들기
    static void makeDeque(){
        if(N == 0){
            return;
        }else if(N == 1){
            deque.add(arrStr.substring(1, arrStr.length()-1));
            return;
        }
        String[] tempArr = arrStr.split(",");
        for(int i = 0; i<tempArr.length; i++){
            // 첫, 막이면 [] 제거
            if(i == 0){
                tempArr[i] = tempArr[i].substring(1,tempArr[i].length());
            }else if(i == tempArr.length-1){
                tempArr[i] = tempArr[i].substring(0,tempArr[i].length()-1);
            }
            deque.add(tempArr[i]);
        }

    }

}

