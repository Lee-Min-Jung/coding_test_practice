// 생각
    // 트리 형태로 연결되어 있다, 그리고 예시 사진을 보니 dfs 혹은 bfs로 돌면서 확인하면 될 것 같다
    // 시작점에서 연결되어 있는 다른 것들을 다 돌면서 count만 하면 된다 dfs, bfs 딱히 상관 없을 것 같다
    // 저번에 재귀 계속 했으니 이번에는 큐로 구현할 수 있는 bfs를 해보자
// 구현
    // wires를 돌면서 연결리스트를 만든다
    // wires를 돈다
        // 해당 원소의 전선을 끊는다
        // answer = Math.min(끊은 전선의 시작에서 bfs한 결과, 끊은 전선의 끝에서 bfs한 결과)
        // 끊었던 전선을 다시 붙인다
    // bfs
        
import java.util.*;

class Solution {
    static int n;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        int answer = Integer.MAX_VALUE;
        
        // 연결리스트
        List<Integer>[] arrList = new List[n+1];
        
        for(int i = 0; i<=n; i++){
            arrList[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            arrList[start].add(end);
            arrList[end].add(start);
        }
        
        
        // wires 돌기
        for(int i = 0; i<wires.length; i++){
            // 해당 전선 끊기
            int start = wires[i][0];
            int end = wires[i][1];
            arrList[start].remove(Integer.valueOf(end));
            arrList[end].remove(Integer.valueOf(start));
            // // bfs 돌기
            int count1 = bfs(start, arrList);
            int count2 = bfs(end, arrList);
            answer = Math.min(answer, Math.abs(count1-count2));

            // // 전선 붙이기
            arrList[start].add(end);
            arrList[end].add(start);
        }

        return answer;
       
        
    }
    
    public int bfs(int nodeIndex, List<Integer>[] arrList){
        
        boolean[] visited = new boolean[n+1];
        int count = 0;
        
        // 방문 표시
        visited[nodeIndex] = true;
        
        
        // 큐
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(nodeIndex);
        while(!q.isEmpty()){
            int cur = q.poll();
            count += 1;
            for(int n : arrList[cur]){
                if(!visited[n]){
                    q.offer(n);
                    visited[n] = true;
                } 
            }
        }
        
        return count;
        
    }
}