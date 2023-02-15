import java.util.*;

class Solution {
    public int solution(String dartResult) {
        // dartResult을 문자열 배열로 만들어서 하나씩 살펴보기
            // 숫자인지, 보너스인지(영문숫자), 옵션(특수문자)인지 확인
                // 숫자면 해당 숫자를 기억해놔야 함
                // 보너스이면 이전에 기억했던 숫자를 계산하고 계산 결과를 기억해야 함
                // 옵션이면 이전에 기억했던 결과를 계산하고 계산 결과를 기억해야 함
  
        String[] dartResultArr = dartResult.split("");
        int num = 0;
        String numbers = "012345678910";
        String bonus = "SDT";
        String option = "*#";
        Stack<Integer> resultStack = new Stack<Integer>();
        int answer = 0;
        
        for(int i = 0; i<dartResultArr.length; i++){
            String str = dartResultArr[i];
            if(numbers.contains(str)){
                num = Integer.parseInt(str);
                if(dartResultArr[i+1].equals("0")){
                    num = 10;
                    i++;
                }
            }
            System.out.println(num);
            
            
            if(bonus.contains(str)){
                int result = 0;
                switch(str){
                    case "S":
                        result = (int)Math.pow(num, 1);
                        break;
                    case "D":
                        result = (int)Math.pow(num, 2);
                        break;
                    case "T":
                        result = (int)Math.pow(num, 3);
                        break;
                }
                resultStack.push(result);
            }
            
            if(option.contains(str)){ 
                // pop 할 때 첫 번째는 1개 pop 후 바로 다시 넣기
                // 두 번째와 세 번째는 2개 pop 후 나중에 pop한 걸 먼저 넣고, 나머지를 뒤에 넣기
                if(resultStack.size() == 1){
                    switch(str){
                        case "*":
                            resultStack.push(resultStack.pop()*2);
                            break;
                        case "#":
                            resultStack.push(resultStack.pop()*(-1));
                            break;
                    }
                }else{
                    switch(str){
                        case "*":
                            int first = 0;
                            int second = 0;
                            first = resultStack.pop() * 2;
                            second = resultStack.pop() * 2;
                            resultStack.push(second);
                            resultStack.push(first);   
                            break;
                        case "#":
                            resultStack.push(resultStack.pop()*(-1));
                            break;
                    }
                    
                }
            }
           
        }
        
        //스택에 있는 거 다 더하기
        while(resultStack.size() != 0){
            answer += resultStack.pop();
        }
        
        return answer;
    }
}