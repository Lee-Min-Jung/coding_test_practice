
class Solution {
    public int[] solution(int[][] score) {
        // 들어온 2차원 배열 돌면서 평균 구한 후 평균 담은 배열 만들기
        // 위 배열 이용해서 등수 배열 구하기
        int[] answer = new int[score.length];
        double[] avgArr = new double[score.length];

        for(int i = 0; i<score.length; i++){
            double avg = (score[i][0] + score[i][1]) / (double)2;
            avgArr[i] = avg;
            System.out.println(avgArr[i]);
        }

        for(int i = 0; i<avgArr.length; i++){
            for(int j = 0; j<avgArr.length; j++){
                if(avgArr[i] < avgArr[j]){
                    answer[i] += 1;
                }
            }
            answer[i] += 1;
        }

        return answer;
    }
}