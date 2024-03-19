import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        // 괄호 입력 받기
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            check(str);
        }
    }
    static void check(String str){
        Stack<String> stack = new Stack<>();
        String[] strArr = str.split("");
        for(int i = 0; i<strArr.length; i++){
            String s = strArr[i];
            // 여는 괄호일 경우
            if(s.equals("(")){
                stack.push(s);
            }
            // 닫는 괄호일 경우
            else if(s.equals(")")){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    System.out.println("NO");
                    return;
                }

            }
        }
        // 모두 확인 후 스택에 값 있으면 틀림
        if(!stack.isEmpty()){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }

    }






















}



