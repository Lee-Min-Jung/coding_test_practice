import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 입력 및 초기화
        str = br.readLine();

        // str 돌기
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        boolean isTag = false;
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '<'){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(ch);
                isTag = true;
            }else if(ch == '>'){
                sb.append(ch);
                isTag = false;
            }else if(ch == ' '){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(ch);
            }else{
                if(isTag){
                    sb.append(ch);
                }else{
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);

    }







}