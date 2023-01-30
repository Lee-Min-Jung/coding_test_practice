class Solution {
    public int solution(String A, String B) {
        // 문자열 개수만큼 for문 돌려서 밀기
        // 민 결과와 주어진 문자 비교해서 같은지 확인
        // 같은 거 있으면 바로 return
        String[] beforeArr = A.split("");
        int count = 1;
        if(A.equals(B)){
            return 0;
        }
        while(count <= A.length()){
            String[] afterArr = new String[A.length()];
            for(int i = 0; i<beforeArr.length; i++){
                if(i == beforeArr.length - 1){
                    afterArr[0] = beforeArr[i];
                }else{
                    afterArr[i+1] = beforeArr[i];
                }
            }
            beforeArr = afterArr;
            String result = String.join("", afterArr);
            if(result.equals(B)){
                return count;
            }
            count++;
        }
        return -1;
    }
}