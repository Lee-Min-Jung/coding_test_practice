// 가로가 더 길거나 같다
// 생각
    // yellow를 어떻게 배치하냐에 따라 brown의 개수가 달라진다
    // 주어진 yellow를 배치할 수 있는 각 방법에 따라 brown 개수를 구한 후 주어진 거라 비교해본다
// 구현
    // yellow를 돌면서 yellow의 약수를 구한다
    // 약수와 약수로 나눈 수 중 큰 수를 가로로 놓고, 작은 수를 세로로 놓는다
    // 해당 가로와 세로에 따른 brown의 개수를 구한다
        // 가로*2 + 세로 *2 + 4
    // 위에서 구한 거와 주어진 brown을 비교해서 같으면 
        // 가로 = 위에서 구한 yellow 가로 + 2, 세로 = 위에서 구한 yellow 세로 + 2

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // yellow 돌기
        for(int i = 1; i<=yellow; i++){
            if(yellow % i == 0){
                int width = yellow / i;
                int height = i;
                int tempBrown = width * 2 + height * 2 + 4;
                if(tempBrown == brown){
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}