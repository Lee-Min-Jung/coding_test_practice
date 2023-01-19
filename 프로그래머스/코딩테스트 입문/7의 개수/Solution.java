class Solution {
    public int solution(int[] array) {
        // array를 돌면서 하나씩 살펴보기
        // 살펴본 값에서 7개수 세기
        int answer = 0;
        for(int i = 0; i<array.length; i++){
            String[] strArr = String.valueOf(array[i]).split("");
            for(int j = 0; j<strArr.length; j++){
                if(strArr[j].equals("7")){
                    answer += 1;
                }
            }
        }

        return answer;
    }
}