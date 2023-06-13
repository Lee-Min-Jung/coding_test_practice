// 문자열을 분해해서 하나씩 담기
// 해당 문자열로 만들 수 있는 모든 숫자 경우의 수 구하기
    // dfs 돌면서 dfs에 딱 들어왔을 때 소수인지 확인을 한다
// 위에서 구한 모든 경우의 수가 소수인지 확인하기
import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    static String[] str;
    static HashSet<Integer> numSet = new HashSet<Integer>();

    
    public int solution(String numbers) {
        // 세팅
        visited = new boolean[numbers.length()];
        answer = 0;
        
        // 문자열 분해
        str = numbers.split("");
        
        // 모든 경우의 수 
        for(int i = 0; i<str.length; i++){
            dfs(i, "", numSet);
        }
        
        return answer;
        
    }
    static void dfs(int nodeIndex, String beforeStr, HashSet<Integer> numSet){
        visited[nodeIndex] = true;
        String numStr = beforeStr + str[nodeIndex];
        int num = Integer.parseInt(numStr);
        
        if(!numSet.contains(num)){
            numSet.add(num);
            if(isSosu(num)){
                System.out.println(num);
                answer++;
            }
        }
        
        
        
        for(int i = 0; i<str.length; i++){
            if(!visited[i]){
                dfs(i, numStr, numSet);
            }
        }
        
        visited[nodeIndex] = false;
    }
    
    static boolean isSosu(int num){
        if(num == 1 | num == 0){
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