// 생각
    // 던전을 돌 수 있는 모든 경우의 수를 돌면서 총 몇 개를 방문할 수 있는지 세어야 함
    // 완전탐색, 재귀로 구현 가능
// 구현
    // 방문배열 초기화
    // 재귀 함수에 매개변수로 주어야 할 것들
        // 던전 배열, 현재 피로도, 현재까지 방문한 개수 
    // 재귀 함수
        // 던전 돌기
            // 현재 던전 방문 안 함 && 현재 피로도 >= 현재 방문한 던전의 최소 필요 피로도
                // 현재 피로도 -= 사용 피로도
                // 방문 표시
                // count 증가
                // 재귀함수 다시 방문
                // 방문 취소
            // 현재 던전 방문 || 현재 피로도 < 현재 방문한 던전의 최소 필요 피로도    
                // 그냥 패스
        // for문 돌면서 얻은 count와 현재 answer중 최댓값으로 answer 갱신

class Solution {
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        // 초기화
        visited = new boolean[dungeons.length];
        answer = 0;
        
        // 재귀함수에 보내기
        recur(k, dungeons, 0);
        
        // 정답
        return answer;
    }
    
    public void recur(int nowK, int[][] dungeons, int count){
        for(int i = 0; i<dungeons.length; i++){
            if(!visited[i] && nowK >= dungeons[i][0]){
                visited[i] = true;
                recur(nowK-dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}



