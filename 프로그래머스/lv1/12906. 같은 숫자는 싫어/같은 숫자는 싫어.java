import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 스택 만들어서 arr에 있는 거 집어 넣기
        // 집어 넣을 때 그 전에 거 빼서 집어 넣는 거랑 같으면 안 넣고 다르면 넣기
        // 다 넣은 후에 빼서 배열에 넣기
        
        Stack<Integer> s = new Stack<Integer>();
        for(int num : arr){
            if(s.isEmpty()){
                s.push(num);
            }else if(s.peek() != num){
                s.push(num);
            }
        }
        
        int[] answer = new int[s.size()];
        
        for(int i = answer.length-1; i>=0; i--){
            answer[i] = s.pop();
        }
        
        return answer;
    }
}