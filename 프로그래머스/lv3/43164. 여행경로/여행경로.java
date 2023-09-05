import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> paths = new ArrayList<String>();
    
    public String[] solution(String[][] tickets) {
        // 변수
        visited = new boolean[tickets.length];
        
        // dfs 실행
        dfs(0, tickets, "ICN", "ICN");
        
        // paths 정렬해서 결과 여러개일 경우 알파벳 순 경로 선택
        Collections.sort(paths);
        
        // 정답
        return paths.get(0).split(" ");
        
    }
    
    public void dfs(int count, String[][] tickets, String now, String path){
        if(count == tickets.length){
            paths.add(path);
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            if(!visited[i] && now.equals(tickets[i][0])){
                visited[i] = true;
                dfs(count+1, tickets, tickets[i][1], path + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
        
    }
}