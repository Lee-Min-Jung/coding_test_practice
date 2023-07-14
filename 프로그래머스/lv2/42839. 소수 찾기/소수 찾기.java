import java.util.*;


class Solution {
    static boolean[] visited = new boolean[7];
    static HashSet<Integer> numSet = new HashSet<Integer>();
    static String[] arr;

    
    public int solution(String numbers) {
        arr = numbers.split("");
        
        // arr 돌기
        for(int i = 0; i<arr.length; i++){
            recur("", i);
        }
        
        // 정답 리턴
        return numSet.size();
    }
    
    // 완전탐색 할 함수
    public void recur(String str, int index){
        visited[index] = true;
        String targetStr = str+arr[index];
        int targetInt = Integer.parseInt(targetStr);
        
        // set에 있는지 확인 및 소수 확인
        if(!numSet.contains(targetInt) && checkSosu(targetInt)){
            numSet.add(targetInt);
        }
        
        for(int i = 0; i<arr.length; i++){
            if(!visited[i]){
                recur(targetStr, i);
            }
        }
        
        visited[index] = false;
        
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