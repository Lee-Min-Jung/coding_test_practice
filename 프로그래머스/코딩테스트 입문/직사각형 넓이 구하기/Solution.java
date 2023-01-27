class Solution {
    public int solution(int[][] dots) {
        // dots를 for문 돌면서 x 두 개 끼리 차이 구한 후 가장 차이 큰 값 구하기
        int maxWidth = Math.abs(dots[0][0] - dots[1][0]);
        int maxHeight = Math.abs(dots[0][1] - dots[1][1]);
        for(int i = 1; i<=3; i++){
            if(Math.abs(dots[0][0] - dots[i][0]) > maxWidth){
                maxWidth = Math.abs(dots[0][0] - dots[i][0]);
            }
            if(Math.abs(dots[0][1] - dots[i][1]) > maxHeight){
                maxHeight = Math.abs(dots[0][1] - dots[i][1]);
            }
        }

        return maxWidth * maxHeight;


    }
}