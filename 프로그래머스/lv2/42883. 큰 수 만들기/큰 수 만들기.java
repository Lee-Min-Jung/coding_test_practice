// number를 돈다(리턴해야 하는 결과 길이만큼 돌기)
    // 처음 혹은 고른 수 다음부터 남은 결과-1개까지 돈다
        // 돌면서 최댓값을 구한다
        // 결과에 최댓값을 붙인다
        // 최댓값 구하면 다음 돌 시작 인덱스를 최댓값 인덱스 +1로 설정한다
        // 남은 결과를 1 뺀다


class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        // number 돌기
        for(int i = 0; i<number.length() - k; i++){
            int max = 0;
            
            for(int j = index; j<=k+i; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    index = j+1;
                }
            }
            sb.append(String.valueOf(max));
        }
        
        return sb.toString();
    }
}