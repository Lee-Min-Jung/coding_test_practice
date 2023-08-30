// 생각
    // yellow의 개수에 따라 모양이 빠귀고 가로 세로가 결정된다
// 구현
    // while을 돈다
        // if(yellow % num == 0)
            // yellow width = num, yellow height = yellow / num
            // brown width = yellow width + 2, brown height = yellow height + 2
            // brown count = brown width * brown height - yellow width * yellow height
            // if(brown count == brown)
                // brown width와 brown height 리턴
        // num 1 증가

class Solution {
    public int[] solution(int brown, int yellow) {
        int num = 1;
        int[] answer = new int[2];
        
        // while로 yellow 약수 돌기
        while(num <= yellow){
            if(yellow % num == 0){
                int yellowWidth = num;
                int yellowHeight = yellow / num;
                int brownWidth = yellowWidth + 2;
                int brownHeight = yellowHeight + 2;
                int brownCount = brownWidth * brownHeight - yellowWidth * yellowHeight;
                if(brownCount == brown){
                    answer[0] = brownWidth;
                    answer[1] = brownHeight;
                }
            }
            num++;
        }
        
        return answer;
    }
}