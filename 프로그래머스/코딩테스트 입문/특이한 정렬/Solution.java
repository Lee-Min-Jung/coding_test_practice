class Solution {
    public int[] solution(int[] numlist, int n) {
        // 주어진 배열 돌면서 n과의 차이를 저장
        // 작은 게 맨 앞에 오도록 하며 정렬
        // 근데 만약 같은 것이 있으면 주어진 배열 원래 값이 더 큰 걸 앞에 오도록

        for(int i = 0; i<numlist.length; i++){
            for(int j = i+1; j<numlist.length; j++){
                if(Math.abs(numlist[i]-n) > Math.abs(numlist[j]-n)){
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                }else if(Math.abs(numlist[i]-n) == Math.abs(numlist[j]-n)){
                    if(numlist[i]>numlist[j]){
                        continue;
                    }else if(numlist[i] < numlist[j]){
                        int temp = numlist[i];
                        numlist[i] = numlist[j];
                        numlist[j] = temp;
                    }
                }
            }
        }
        return numlist;
    }
}