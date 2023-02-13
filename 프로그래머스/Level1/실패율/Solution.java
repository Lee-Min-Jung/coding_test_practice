class Solution {
    public int[] solution(int N, int[] stages) {
        // 각 스테이지의 실패율을 구한다
        // 분자: 해당 스테이지와 같은 수
        // 분모: 해당 스테이지와 같거나 해당 스테이지보다 큰 수들의 개수
        // 마지막 스테이지는 n+1임을 기억하자
        // 실패율 높은 순으로 정렬한다
        // 답을 리턴한다
        int[] stageCount = new int[N];
        double[] failRatioArr = new double[N];
        int[] answer = new int[N];

        for(int i = 1; i<=N; i++){
            int bunmo = 0;
            int bunja = 0;
            double failRatio = 0.0;

            for(int j = 0; j<stages.length; j++){
                if(stages[j] == i){
                    bunja++;
                }
                if(stages[j] >= i){
                    bunmo++;
                }
            }

            failRatio = (double)bunja / bunmo;
            failRatioArr[i-1] = failRatio;
        }

        for(int i = 0; i<answer.length; i++){
            answer[i] = i+1;
        }

        for(int i = 1; i<failRatioArr.length; i++){
            double temp = failRatioArr[i];
            int temp2 = answer[i];
            int j = i - 1;
            while(j>=0 && failRatioArr[j] < temp) {
                failRatioArr[j+1] = failRatioArr[j];
                answer[j+1] = answer[j];
                j--;
            }
            failRatioArr[j+1] = temp;
            answer[j+1] = temp2;
        }

        for(int i = 0; i<answer.length; i++){
            System.out.println(failRatioArr[i]);
        }




        return answer;
    }
}