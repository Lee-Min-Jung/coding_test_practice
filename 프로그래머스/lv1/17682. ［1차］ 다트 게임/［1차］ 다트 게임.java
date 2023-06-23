// S: 1제곱
// D: 2제곱
// T: 3제곱
// *: 이전 점수2배, 이번 점수 2배, 첫번째에 나오면 이번 점수만 2배
// #: 이번 점수 마이너스
// s d t 는 무조건 존재, * # 은 있어도 되고 없어도 되고

// dartResult를 쪼개서 하나씩 살핀다
    // 숫자면 식에 숫자 입력
    // SDT면 숫자에 계산
    // 위 계산 후 스택에 저장
    // * # 면 스택에 있는 거 1개 빼서 연산, 그리고 또 하나 빼서 연산, 그리고 나중 거 먼저 넣고 그 다음 거 넣기
import java.util.*;
class Solution {
    public int solution(String dartResult) {
        String[] dartResultArr = dartResult.split("");
        String numbers = "012345678910";
        // String SDT = "SDT";
        // String option = "*#";
        
        // 돌기
        int result = 0;
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i = 0; i<dartResultArr.length; i++){
            String target = dartResultArr[i];
            // 숫자
            if(numbers.contains(target) && dartResultArr[i+1].equals("0")){
                result = 10;
                i++;
            }else if(numbers.contains(target)){
                result = Integer.parseInt(target);
            }
            
            // SDT
            if(target.equals("S")){
                result = (int)Math.pow(result, 1);
                st.push(result);
            }else if(target.equals("D")){
                result = (int)Math.pow(result, 2);
                st.push(result);
            }else if(target.equals("T")){
                result = (int)Math.pow(result, 3);
                st.push(result);
            }
            
            // * #
            if(target.equals("*")){
                if(st.size() == 1){
                    int num = st.pop();
                    num *= 2;
                    st.push(num);
                }else{
                    int num1 = st.pop();
                    int num2 = st.pop();
                    num1 *= 2;
                    num2 *= 2;
                    st.push(num2);
                    st.push(num1);
                }
                
            }else if(target.equals("#")){
                int num = st.pop();
                num *= (-1);
                st.push(num);
            }
        }
        
        // 스택에 있는 거 몽땅 더하기
        int answer = 0;
        while(!st.isEmpty()){
            answer += st.pop();
        }
        
        
        return answer;
        
      
    }
}
