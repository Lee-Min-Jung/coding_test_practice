class Solution {
    public int solution(int n) {
        StringBuilder threeMethod = new StringBuilder();
        int answer = 0;
        // 앞 뒤 반전
        while(n != 0){
            threeMethod.append(n % 3);
            n = n / 3;
        }
        
        //10진법으로
        String[] threeMethodArr = threeMethod.reverse().toString().split("");
        for(int i = 0; i<threeMethodArr.length; i++){
            answer += Integer.parseInt(threeMethodArr[i]) * Math.pow(3, i);
        }
        
        
        return answer;
    }
}