class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[200];
        int answer = 0;

        // 내가 만든 arr이라는 곳에 lines에 있는 선분을 그린다
        for(int i = 0; i<lines.length; i++){
            for(int j = lines[i][0] + 100; j<lines[i][1] + 100; j++){
                arr[j]++;
            }
        }

        //겹치는 곳 확인
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > 1){
                answer += 1;
            }
        }

        return answer;
    }
}