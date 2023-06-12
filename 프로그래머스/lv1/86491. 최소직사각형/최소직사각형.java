// 가로와 세로 중 큰 거를 가로로, 작은 거를 세로로
// 가로 중 가장 큰 것과 세로 중 가장 큰 거 찾아서 곱하기


class Solution {
    public int solution(int[][] sizes) {
        // sizes 돌면서 가로 세로 설정
        for(int i = 0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }
        
        // 가로 세로 중 가장 큰 값 찾기
        int maxWidth = sizes[0][0];
        int maxHeight = sizes[0][1];
        
        for(int i = 0; i<sizes.length; i++){
            if(sizes[i][0] > maxWidth){
                maxWidth = sizes[i][0];
            }
            if(sizes[i][1] > maxHeight){
                maxHeight = sizes[i][1];
            }
        }
        System.out.println(maxWidth);
        System.out.println(maxHeight);
        return maxWidth * maxHeight;
    }
}