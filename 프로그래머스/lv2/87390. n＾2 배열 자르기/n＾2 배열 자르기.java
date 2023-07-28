// 생각
    // 구현
// 구현
    // 


class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right-left)+1;
        int[] answer = new int[size];
        
        // 배열 생성
        int index = 0;
        for(long i = left; i<right+1; i++){
            answer[index++] = Math.max((int)(i/n), (int)(i%n))+1;
        }
        
        return answer;
        
        
    }
}