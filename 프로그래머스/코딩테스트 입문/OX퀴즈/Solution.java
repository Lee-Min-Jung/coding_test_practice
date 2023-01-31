import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        // quiz 개수만큼 for 돌기
        // 각 식을 공백으로 split
        // 계산
        // 주어진 것과 올바른 것 비교
        String[] result_arr = new String[quiz.length];

        for(int i = 0; i<quiz.length; i++){
            ArrayList<Integer> nums = new ArrayList<Integer>();
            String op = "";
            int right_answer = 0;
            String[] quiz_arr = quiz[i].split(" ");
            for(int j = 0; j<quiz_arr.length; j++){
                if(quiz_arr[j].equals("-") || quiz_arr[j].equals("+")){
                    op = quiz_arr[j];
                }else if(!quiz_arr[j].equals("=")){
                    nums.add(Integer.parseInt(quiz_arr[j]));
                }
            }
            if(op.equals("-")){
                right_answer = nums.get(0) - nums.get(1);
            }else{
                right_answer = nums.get(0) + nums.get(1);
            }
            if(nums.get(2) == right_answer){
                result_arr[i] = "O";
            }else{
                result_arr[i] = "X";
            }
        }

        return result_arr;


    }
}