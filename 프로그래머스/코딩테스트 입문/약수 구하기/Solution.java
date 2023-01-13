import java.util.*;

class Solution {
    public int[] solution(int n) {
        // 들어온 수를 들어온 수 보다 작은 수로 나누며 나머지 없으면 나눈 수를 약수로 판정

        ArrayList<Integer> answerArrayList = new ArrayList<Integer>();

        for(int i = 1; i<=n; i++){
            if(n%i == 0){
                answerArrayList.add(i);
            }
        }

        int[] answer = answerArrayList.stream().mapToInt(x -> x).toArray();


        return answer;
    }
}