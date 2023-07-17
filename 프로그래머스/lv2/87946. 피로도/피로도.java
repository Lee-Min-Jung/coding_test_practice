// 생각
    // 던전들을 각기 다른 모든 순서로 돌면서 탐험 가능한 최대 던전 개수를 구해야 한다
    // 예를 들어 3개라면 123 132 213 231 312 321 ... 
    // 각 던전 for문 돌면서 재귀로 완전탐색하면 되지 않을까?
// 구현
    // for문으로 던전을 돈다
        // 각 던전을 시작으로 해서 순차적으로 다른 던전 돌도록 탐색을 해본다
            // 현재 피로도가 최소 필요도보다 크거나 같다
                // 현재 피로도 = 현재 피로도 - 소모 필요도
            // 현재 피로도가 최소 필요도보다 작다
                // 중단
class Solution {
    static int curK;
    static int[][] dungeonsArr;
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        // 초기화
        curK = k;
        dungeonsArr = dungeons;
        visited = new boolean[dungeons.length];
        answer = 0;
        
        // 던전 돌기
        for(int i = 0; i<dungeons.length; i++){
            int count = 0;
            recur(i, dungeons[i][0], dungeons[i][1], count, k);
        }
        

        // 정답 출력
        return answer;
    }
    
    // 재귀로 완전탐색하는 함수
    public void recur(int index, int min, int use, int count, int k){
        if(k >= min){
            k -= use;
            count += 1;
            visited[index] = true;
            for(int i = 0; i<dungeonsArr.length; i++){
                if(!visited[i]){
                    recur(i, dungeonsArr[i][0], dungeonsArr[i][1], count, k);
                }
            }
        }
        visited[index] = false;
        answer = Math.max(answer, count);
        
        
      
    }
}