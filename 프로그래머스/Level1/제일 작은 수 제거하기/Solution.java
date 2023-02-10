import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length == 1 ? 1 : arr.length-1;
        int min_val = arr[0];
        int min_index = 0;
        int[] answer = new int[len];
        ArrayList<Integer> temp = new ArrayList<Integer>();

        for(int i = 0; i<arr.length; i++){
            if(arr[i] < min_val){
                min_val = arr[i];
                min_index = i;
            }
            temp.add(arr[i]);
        }

        for(int i = 0; i<temp.size(); i++){
            if(temp.get(i) == min_val){
                temp.remove(i);
            }
        }

        for(int i = 0; i<answer.length; i++){
            if(answer.length == 1){
                answer[i] = -1;
                break;
            }else{
                answer[i] = temp.get(i);
            }
        }





        return answer;
    }
}