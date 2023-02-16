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
        int max = 0;
        int min = 0;
        int[] answer = new int[2];
        
        for(int num : lottos){
            if(num == 0){
                zeroCount += 1;
            }else{
                for(int winNum : win_nums){
                    if(num == winNum){
                        winCount += 1;
                    }
                }
            }
        }
        switch(winCount + zeroCount){
            case 6:
                answer[0] = 1;
                break;
            case 5:
                answer[0] = 2;
                break;
            case 4:
                answer[0] = 3;
                break;
            case 3:
                answer[0] = 4;
                break;
            case 2:
                answer[0] = 5;
                break;
            default:
                answer[0] = 6;
                break;
        }
        switch(winCount){
            case 6:
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                break;
            case 4:
                answer[1] = 3;
                break;
            case 3:
                answer[1] = 4;
                break;
            case 2:
                answer[1] = 5;
                break;
            default:
                answer[1] = 6;
                break;
        }
        
        
        return answer;
    }
}