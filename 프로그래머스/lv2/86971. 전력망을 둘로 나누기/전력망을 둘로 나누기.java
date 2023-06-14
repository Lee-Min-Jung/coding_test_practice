import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 연결리스트 만들기
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            adj[start].add(end);
            adj[end].add(start);
        }
        
        // wire 돌면서 하나씩 빼보기
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            adj[start].remove(Integer.valueOf(end));
            adj[end].remove(Integer.valueOf(start));
            
            int first = dfs(start, adj);
            int second = dfs(end, adj);
            
            int diff = Math.abs(first - second);
            answer = Math.min(answer, diff);
            
            adj[start].add(end);
            adj[end].add(start);
        }
        
        return answer;
    }
    
    static int dfs(int nodeIndex, ArrayList<Integer>[] adj) {
        boolean[] visited = new boolean[adj.length];
        return dfsHelper(nodeIndex, adj, visited);
    }
    
    static int dfsHelper(int nodeIndex, ArrayList<Integer>[] adj, boolean[] visited) {
        visited[nodeIndex] = true;
        int count = 1;
        
        for (int n : adj[nodeIndex]) {
            if (!visited[n]) {
                count += dfsHelper(n, adj, visited);
            }
        }
        
        return count;
    }
}
