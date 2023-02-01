class Solution {
    public int solution(int[] common) {
        // 주어진 수열 보고 규칙식 구한다
        // 등차 수열인지 : 두번째 항에서 첫번째 항 빼보기
        // 등비 수열인지 : 두번째 항을 첫번째 항으로 나누기
        // 위에서 구한 식 이용해 다음 값 구한다

        if(common[1] - common[0] == common[2] - common[1]){
            return common[common.length-1] + common[1] - common[0];
        }else{
            return common[common.length-1] * common[1] / common[0];
        }
    }


}