class Solution {
    public String solution(int a, int b) {
        String[] dayStr = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] monthDay = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sumDays = 0;
        
        for(int i = 0; i<a-1; i++){
            sumDays += monthDay[i];
        }
        sumDays += b-1;
        
        return dayStr[sumDays % 7];
    }
    
    
}