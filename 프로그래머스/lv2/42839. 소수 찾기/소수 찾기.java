// 생각
    // numbers를 쪼갠 후 만들 수 있는 모든 경우의 수 만들어 보면서 소수인 경우 세기
    // 재귀 dfs
// 구현
    // numbers를 쪼개서 배열로 만든 후 맨 첫 원소부터 넣어서 재귀 돌리기
    // dfs(String arr, )
    // checkSosu(int num)
import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer = 0;
    static HashSet<Integer> set = new HashSet<Integer>();
    
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        visited = new boolean[arr.length];
        
        // 재귀
        recur(arr, "");
        
        return set.size();
    }
    
    public void recur(String[] arr, String numStr){
        if(numStr.length() == arr.length){
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(!visited[i]){
                if(checkSosu(Integer.parseInt(numStr+arr[i]))){
                    set.add(Integer.parseInt(numStr+arr[i]));
                }
                visited[i] = true;
                recur(arr, numStr+arr[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean checkSosu(int num){
        if(num == 0 || num == 1){
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