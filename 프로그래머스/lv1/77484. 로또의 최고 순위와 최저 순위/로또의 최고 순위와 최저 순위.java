class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // lottos를 돌면서 win_nums에 있는지, 0 아닌데 없는지, 0 인지 확인
            // 있으면 개수 증가
            // 0아닌데 없으면 패스
            // 0이면 0 개수 증가
        // 최고 순위는 0 개수랑 맞힌 개수의 합으로 결정
        // 최저 순위는 맞힌 개수로만 결정
        
        int winCount = 0;
        int zeroCount = 0;
        int[] answer = new int[2];
        
        for(int num : lottos){
            if(num == 0){
                zeroCount += 1;
                continue;
            }
            
            for(int winNum : win_nums){
                if(num == winNum){
                    winCount += 1;
                }
            }
        }
        
        answer[0] = getGrade(winCount + zeroCount);
        answer[1] = getGrade(winCount);
        
        
        return answer;
    }
    
    public int getGrade(int num){
        switch(num){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}