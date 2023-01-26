import java.util.*;

class Solution {
    public int solution(String my_string) {
        String[] str_arr = my_string.split(" ");
        int answer = Integer.parseInt(str_arr[0]);

        for(int i = 1; i<str_arr.length; i++){
            if(str_arr[i].equals("+")){
                answer += Integer.parseInt(str_arr[i+1]);
            }else if(str_arr[i].equals("-")){
                answer -= Integer.parseInt(str_arr[i+1]);
            }
        }

        return answer;


    }
}


// 스택 이용한 풀이

import java.util.*;

class Solution {
    public int solution(String my_string) {
        String[] my_string_arr  = my_string.split(" ");
        Solution s = new Solution();
        ArrayList<String> postfixResult = s.infixToPostfix(my_string_arr);
        int answer = s.postfixCal(postfixResult);

        return answer;


    }

    public ArrayList<String> infixToPostfix(String[] str){
        ArrayList<String> result = new ArrayList<String>();
        Stack<String> stack = new Stack<>();
        String op = "+-";

        for(String c : str){
            if(op.contains(c)){
                if(stack.empty()){
                    stack.push(c);
                }else{
                    result.add(stack.pop());
                    stack.push(c);
                }
            }else{
                result.add(c);
            }
        }

        while(!stack.empty()){
            result.add(stack.pop());
        }

        return result;

    }

    public int postfixCal(ArrayList<String> postfix){
        Stack<String> stack = new Stack<String>();
        Solution s = new Solution();
        for(String c : postfix){
            if(s.isNumber(c)){
                stack.push(c);
            }else if(c.equals("+")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num1+num2));
            }else if(c.equals("-")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num2-num1));
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public boolean isNumber(String number){
        try{
            Integer.parseInt(number);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }


}