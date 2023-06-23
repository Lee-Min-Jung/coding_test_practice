// 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// N: 전체 스테이지의 개수
// stages: 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호
// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return
// 실패율이 같으면 작은 스테이지 번호가 먼저

// 각 스테이지별 실패율을 구해야 한다
// stage 개수만큼 for를 돈다
    // stages를 돈다
        // 각 스테이지에 도달한 플레이어 수의 합과 각 스테이지에 머물러 있는 사람 수를 구해 실패율 구한다
class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지별 실패율 담을 배열
        double[] failRatio = new double[N];
        
        // 총 스테이지 개수만큼 돌기
        for(int i = 1; i<=N; i++){
            int bunmo = 0;
            int bunja = 0;
            
            for(int j = 0; j<stages.length; j++){
                if(stages[j] >= i){
                    bunmo++;
                }
                if(stages[j] == i){
                    bunja++;
                }
            }
            failRatio[i-1] = (double)bunja / bunmo;
            
        }

        // failRatio 보고 실패율 높은 스테이지부터 출력하는 배열 만들어야 함
        int[] answer = new int[N];
        
        for(int i = 0; i<N; i++){
            answer[i] = i+1;
        }
        
        for(int i = 0; i<failRatio.length; i++){
            for(int j = i+1; j<failRatio.length; j++){
                if(failRatio[i] < failRatio[j] || (failRatio[i] == failRatio[j] && answer[i] > answer[j])){
                    double temp = failRatio[i];
                    failRatio[i] = failRatio[j];
                    failRatio[j] = temp;
                    int temp2 = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp2;
                }
            }
        }
        
        
        
        return answer;
        
        
    }
}