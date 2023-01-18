class Solution {
    public int[][] solution(int[] num_list, int n) {
        // 새로운 배열을 선언 (n * num_list.length / n) 배열
        // 새로운 배열 이중 for로 돌면서 값 채우기
        int row = num_list.length/n;
        int[][] answer = new int[row][n];
        int cnt = 0;

        for(int i = 0; i<row; i++){
            for(int j = 0; j<n; j++){
                answer[i][j] = num_list[cnt];
                cnt++;
            }
        }
        return answer;

    }
}