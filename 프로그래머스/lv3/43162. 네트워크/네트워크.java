import java.util.*;
class Solution {
    static boolean[] visited;
    static List<Integer>[] adj;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        adj = new List[n];
        
        for(int i = 0; i<n; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<computers.length; i++){
            for(int j = 0; j<computers.length; j++){
                if(i != j){
                    if(computers[i][j] == 1){
                        adj[i].add(j);
                    }
                }
            }
        }
        
        bfs(0);
        
        int answer = 1;
        
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int num){
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.add(num);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int next : adj[cur]){
                if(!visited[next]){
                    q.add(next);
                }
            }
        }
    }
}