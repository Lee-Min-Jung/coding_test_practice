// 조건
    // 가로는 세로와 같거나 세로보다 더 길다
// 생각
    // yellow의 약수를 구해서 약수 짝끼리 yellow 모양이라고 가정하고 가로, 세로, brwon을 구해본다
    // yellow의 약수를 모두 구해서 약수 짝끼리 살펴 봐야 하니 완전탐색이 아닐까

// yellow보다 작은 수를 돌면서 약수를 구한다
    // 약수가 1이다
        // 가로 = yellow + 2, 세로 = 3
        // 해당 가로세로의 넓이에서 yellow를 뺀 후 brown을 구한다
        // 구한 brown이 주어진 brown과 같으면
            // 더 긴 걸 가로로 하고 작은 걸 세로로 한 후 종료한다
    // 약수가 1이 아니다
        // 첫 번째 약수 + 2, 두 번째 약수 + 2 중 더 긴 것이 가로, 짧은 것이 세로
        // 해당 가로세로 넓이에서 yellow를 뺀 후 brown을 구한다
        // 구한 brown이 주어진 brown과 같으면
            // 더 긴 걸 가로로 하고 작은 걸 세로로 한 후 종료한다



class Solution {
    public int[] solution(int brown, int yellow) {
        // 정답 배열
        int[] answer = new int[2];
        
        // yellow 돌면서 약수 구하기
        for(int i = 1; i<=yellow; i++){
            if(yellow % i == 0){ // i가 약수다
                if(i == 1){ // 약수가 1이다
                    int width = yellow + 2;
                    int height = 3;
                    int tempBrown = width*height - yellow;
                    if(tempBrown == brown){
                        answer[0] = width;
                        answer[1] = height;
                        break;
                    }
                }else{ // 약수가 1이 아니다
                    int width = yellow / i + 2;
                    int height = i+2;
                    int tempBrown = width*height - yellow;
                    if(tempBrown == brown){
                        answer[0] = width;
                        answer[1] = height;
                        break;
                    }
                }
            }else{ // i가 약수가 아니다
                continue;
            }
        }
        
        return answer;
    }
}