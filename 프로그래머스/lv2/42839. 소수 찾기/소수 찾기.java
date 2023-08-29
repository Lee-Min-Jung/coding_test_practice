import java.util.*;


class Solution {
    static boolean[] visited = new boolean[7];
    static HashSet<Integer> numSet = new HashSet<Integer>();


    
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        recur("", 0, arr);

        
        // 정답 리턴
        return numSet.size();
    }
    
    // 완전탐색 할 함수
    public void recur(String str, int index, String[] arr){
        for(int i = 0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                String targetStr = str+arr[i];
                int targetInt = Integer.parseInt(targetStr);
                if(checkSosu(targetInt)){
                    numSet.add(targetInt);
                }
                recur(targetStr, index+1, arr);
                visited[i] = false;
            }
        }
        
    }
    
    // 소수 확인 함수
    public boolean checkSosu(int num){
        if(num == 0 || num == 1){
            return false;
        }
        for(int i = 2; i<num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}