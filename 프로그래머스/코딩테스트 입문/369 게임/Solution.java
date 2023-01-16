class Solution {
    public int solution(int order) {
        // order 에서 3,6,9의 개수를 세기
        // order을 string으로 바꾼 후 3,6,9 찾기
        // 위에서 구한 값을 return

        String[] orderStr = Integer.toString(order).split("");
        int answer = 0;

        for(int i = 0; i<orderStr.length; i++){
            if(orderStr[i].equals("3") || orderStr[i].equals("6") || orderStr[i].equals("9")){
                answer += 1;
            }
        }

        return answer;
    }
}