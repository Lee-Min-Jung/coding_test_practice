class Solution {
    public String solution(int[] numbers, String hand) {
        // numbers를 돌면서 숫자에 맞는 손 저장
            // 1 4 7 이면 왼손 저장, 3 6 9 면 오른손 저장, 다른 숫자는 거리 계산 후 저장 
                // 맨해튼 거리: 각 좌표의 x 차이 절댓값 + y 차이 절댓값
                // 각 숫자별로 좌표를 입력해서 거리 구하기
            // 위의 과정을 거치면서 왼손 위치와 오른손 위치도 저장해야 함
        StringBuilder answer = new StringBuilder();
        int[][] coord = {
            {3,1},
            {0,0},
            {0,1},
            {0,2},
            {1,0},
            {1,1},
            {1,2},
            {2,0},
            {2,1},
            {2,2},
            {3,0}, // 10이 들어오면 *
            {3,2} // 11이 들어오면 #
        };
        int leftPos = 10;
        int rightPos = 11;
        
        for(int i = 0; i<numbers.length; i++){
            switch(numbers[i]){
                case 1, 4, 7:
                    answer.append("L");
                    leftPos = numbers[i];
                    break;
                case 3, 6, 9:
                    answer.append("R");
                    rightPos = numbers[i];
                    break;
                default:
                    int leftDis = Math.abs(coord[leftPos][0]-coord[numbers[i]][0]) + Math.abs(coord[leftPos][1] - coord[numbers[i]][1]);
                    int rightDis = Math.abs(coord[rightPos][0]-coord[numbers[i]][0]) + Math.abs(coord[rightPos][1] - coord[numbers[i]][1]);
                    if(leftDis == rightDis){
                        if(hand.equals("left")){
                            leftPos = numbers[i];
                            answer.append("L");
                        }else{
                            rightPos = numbers[i];
                            answer.append("R");
                        }
                    }else if(leftDis < rightDis){
                        leftPos = numbers[i];
                        answer.append("L");
                    }else{
                        rightPos = numbers[i];
                        answer.append("R");
                    }
                    break;
            }
        }
        
        return answer.toString();
    }
}