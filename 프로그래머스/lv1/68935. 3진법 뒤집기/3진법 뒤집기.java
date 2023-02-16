class Solution {
    public int solution(int n) {
        StringBuilder threeMethod = new StringBuilder();
        int answer = 0;
        // 3진법으로
        while(n != 0){
            threeMethod.append(n % 3);
            n = n / 3;
        }
        System.out.println(threeMethod.reverse().toString());
        //10진법으로
        answer = Integer.parseInt(threeMethod.reverse().toString(), 3);
        
        
        return answer;
    }
}