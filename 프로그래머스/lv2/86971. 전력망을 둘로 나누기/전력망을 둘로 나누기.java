// 생각
    // 일단 하나의 그래프를 만들고, 특정 연결 끊어서 그래프 2개로 만든 다음 bfs나 dfs돌면서 총 순회 개수 구해서 차이 구하기
// 구현
    // for(wires) : 그래프 만들기
    // for(wires) 
        // 해당 원소 연결 끊고 각각으로부터 bfs 돌면서 개수 세기
        // answer = Math.min(|첫번째 원소 결과 - 두번째 원소 결과|, answer);
        // 연결 다시 복구
    // bfs(int target)
        
    
import java.util.*;

class Solution {
    static List<Integer>[] adj;
    static int N;
    public int solution(int n, int[][] wires) {
        // 변수
        adj = new List[n+1];
        int answer = Integer.MAX_VALUE;
        N = n;
        // 연결리스트 만들기
        for(int i = 1; i<=n; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            adj[start].add(end);
            adj[end].add(start);
        }
        
        // wire 끊어보기
        for(int i = 0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            // 끊기
            adj[start].remove(Integer.valueOf(end));
            adj[end].remove(Integer.valueOf(start));
            answer = Math.min(answer, Math.abs(bfs(start) - bfs(end)));
            // 다시 연결
            adj[start].add(end);
            adj[end].add(start);
        }
        
       return answer;
        
        
    }
    
    public int bfs(int target){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        
        q.offer(target);
        
        while(!q.isEmpty()){
            int val = q.poll();
            visited[val] = true;
            count++;
            for(int num : adj[val]){
                if(!visited[num]){
                    q.offer(num);
                }
            }
        }
        
        return count;
    }
}