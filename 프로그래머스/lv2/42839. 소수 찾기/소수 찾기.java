import java.util.*;

class Solution {
    static boolean[] visited;
    static HashSet<Integer> hs = new HashSet<Integer>();
    
    public int solution(String numbers) {
        
        // 변수 초기화
        String[] arr = numbers.split("");
        visited = new boolean[arr.length];
        
        // 재귀 시작
        recur(0, arr, "");
        
        return hs.size();
    }
    
    public void recur(int index, String[] arr, String str){
        for(int i = 0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                String targetStr = str + arr[i];
                int targetInt = Integer.parseInt(targetStr);
                if(isSosu(targetInt)){
                    hs.add(targetInt);
                }
                recur(index+1, arr, targetStr);
                visited[i] = false;
            }
        }
    }
    
    public boolean isSosu(int num){
        if(num == 1 || num == 0){
            return false;
        }
        
        for(int i = 2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
}