// 노랑 개수가 홀수이면 노랑은 일자로 쭉
    // 가로는 노랑개수 + 2, 세로는 3
// 노랑 개수가 짝수이면 갈색 개수따라 노랑 모양이 달라짐
    // 가로: 노랑 가로 + 2, 세로: 노랑 세로 + 2
    // 갈색 개수는 (노랑 가로 + 2)*2 + (노랑 세로*2)
    // 노랑 경우의 수: 1 24, 2 12, 3 8, 4 6
    // 노랑의 각 경우의 수에 따른 갈색 개수 구해서 맞는지 비교

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 노란 타일 모양 찾아서 갈색 개수랑 맞는지 확인
        for(int i = 1; i<=yellow; i++){
            if(yellow % i == 0){
                int width = Math.max(i, yellow / i);
                int height = Math.min(i, yellow / i);
                if((width + 2)*(height + 2) == (brown+yellow)){
                    answer[0] = width+2;
                    answer[1] = height+2;
                    break;
                }
            }
        }
        
        
        
        return answer;
    }
}