// 생각
    // 행렬의 곱은 한 행렬의 행과 다른 행렬의 열을 각각 곱한 값
// 구현
    // 주어진 arr1과 arr2의 길이를 바탕으로 정답 배열을 선언한다
    // 첫 번째 for문에서 arr1의 열만큼 돈다
        // 두 번째 for문에서 arr2의 행만큼 돈다

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 정답 배열 선언
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        // 정답 구하기
        for(int i = 0; i<arr1.length; i++){
            for(int j = 0; j<arr1[0].length; j++){
                for(int k = 0; k<arr2[0].length; k++){
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                    
                }
            }
        }
        
        return answer;
    }
}