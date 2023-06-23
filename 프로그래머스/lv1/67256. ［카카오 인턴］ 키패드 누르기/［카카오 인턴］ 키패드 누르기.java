// 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치
// 상하좌우 4가지 방향으로만 이동
// 1, 4, 7을 입력할 때는 왼손
// 3, 6, 9를 입력할 때는 오른손
// 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락
    //거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락

// 왼손의 위치와 오른손의 위치를 계속 저장해 놔야 한다
// 누르고 나서 누른 손을 답에 계속 저장해야 한다
// 2 5 8 0 일 경우 왼손, 오른손과의 거리를 계산해야 한다
    // 
import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        // 정답
        StringBuilder sb = new StringBuilder();
        
        // 왼손 오른손 저장
        int left = 10;
        int right = 11;
        
        // 2 5 8 0 에서 다른 곳까지의 거리 저장
        HashMap<Integer, int[]> distance = new HashMap<Integer, int[]>();
        int[] twoDistance = {3,1,0,1,2,1,2,3,2,3,4,4};
        int[] fiveDistance = {2,2,1,2,1,0,1,2,1,2,3,3};
        int[] eightDistance = {1,3,2,3,2,1,2,1,0,1,2,2};
        int[] zeroDistance = {0,4,3,4,3,2,3,2,1,2,1,1};
        distance.put(2, twoDistance);
        distance.put(5, fiveDistance);
        distance.put(8, eightDistance);
        distance.put(0, zeroDistance);
        
        
        // numbers를 돌면서 누르는 손 저장
        for(int i = 0; i<numbers.length; i++){
            switch(numbers[i]){
                case 1:
                    sb.append("L");
                    left = 1;
                    break;
                case 4:
                    sb.append("L");
                    left = 4;
                    break;
                case 7:
                    sb.append("L");
                    left = 7;
                    break;
                case 3:
                    sb.append("R");
                    right = 3;
                    break;
                case 6:
                    sb.append("R");
                    right = 6;
                    break;
                case 9:
                    sb.append("R");
                    right = 9;
                    break;
                default:
                    
                    int leftDistance = distance.get(numbers[i])[left];
                    int rightDistance = distance.get(numbers[i])[right];
                   
                    if(leftDistance < rightDistance){
                        sb.append("L");
                        left = numbers[i];
                    }else if(leftDistance == rightDistance){
                        if(hand.equals("right")){
                            sb.append("R");
                            right = numbers[i];
                        }else{
                            sb.append("L");
                            left = numbers[i];
                        }
                    }else{
                        sb.append("R");
                        right = numbers[i];
                    }
            }
        }
        
        return sb.toString();
    }
}