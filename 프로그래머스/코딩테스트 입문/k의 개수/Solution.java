import java.lang.*;

class Solution {
    public int solution(int i, int j, int k) {
        // i부터 j까지 쭉 돌면서 살펴본다
        // 하나를 살펴볼 때 그걸 string으로 바꾸고, 배열로 바꿔서 또 for 돌면서 k가 있는지 카운트
        int answer = 0;
        for(int index = i; index<=j; index++){
            String[] arr = String.valueOf(index).split("");
            for(int l = 0; l<arr.length; l++){
                if(arr[l].equals(String.valueOf(k))){
                    answer += 1;
                }
            }
        }
        return answer;
    }
}